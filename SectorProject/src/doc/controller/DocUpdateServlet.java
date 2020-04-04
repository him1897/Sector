package doc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import doc.model.service.DocService;
import doc.model.vo.Doc;
import emp.model.vo.Emp;
import line.model.service.LineService;
import line.model.vo.Line;
import sfile.model.service.SFileService;
import sfile.model.vo.Sfile;

/**
 * Servlet implementation class DocInsertServlet
 */
@WebServlet("/dus")
public class DocUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("UTF-8");
		
				RequestDispatcher view = null;
			
				
				// 1. 업로드할 파일의 용량 제한 : 10Mbyte 로 제한한다면
				int maxSize = 1024 * 1024 * 10;
				// 2. 업로드되는 파일의 저장 폴더 지정하기
				String savePath = request.getSession().getServletContext().getRealPath("/resources/doc_upfiles");
				// System.out.println(savePath);

				// request 를 MultipartRequest 로 변환함
				MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

				
				
				
				
				
				
				
				
				// 전송온 값 꺼내서 변수 또는 객체에 저장하기
				
				
				
				//1. line 결재자 정보 받아오기 
				
				LineService lservice = new LineService();
				String lineEmp = mrequest.getParameter("lineemp");
				int lineId = Integer.valueOf(mrequest.getParameter("lineid"));
				
				String[] iarr = new String[7];
				
				for(int i = 0; i < lineEmp.length(); i++) {
					iarr[i] =lineEmp.substring(i, i+1);
				}
				
				//2. 결재라인 update하기 
				
				Line line = new Line();
				
			
			    line.setFirst(iarr[0]);//첫번째 결재자 
				line.setSecond(iarr[1]);//두번째 결재자 
				line.setThird(iarr[2]);//세번째 결재자 
				line.setFourth(iarr[3]);//네번째 결재자 
				line.setFifth(iarr[4]);//다섯번째 결재자 
				line.setSixth(iarr[5]);//여섯번째 결재자 
				line.setSeventh(iarr[6]);//일곱번째 결재자 
				
				
				line.setLineName("이름없음"); //라인이름 
				
				
				
				int docId = Integer.parseInt(mrequest.getParameter("docid"));
				line.setLineNo(docId); //수정할 라인번호 
				
				
				
				
				
				lservice.updateLine(line);
				
				
			
				 
				//2. Doc에 Update 하기  
				Doc doc = new Doc();
				
				
				String content = mrequest.getParameter("editor");
				
				
				
				
				doc.setDocType(mrequest.getParameter("doctype"));  //문서 종류 
				doc.setDocTitle(mrequest.getParameter("title")); //문서 제목 
				doc.setDocContent(content); //문서 내용 
				doc.setDocWriter(Integer.parseInt(mrequest.getParameter("empid"))); //문서 글쓴이 
				doc.setDocLevel(mrequest.getParameter("level")); //문서등급 
				doc.setDocYear(Integer.parseInt(mrequest.getParameter("year"))); // 보존 년수 
				doc.setDocStatus("대기"); //새 문서는 대기상태임 
				
				doc.setDocId(docId); //수정할 문서번호 
				
				
				doc.setDocBoxId(1); //새 문서는 전체 보관함에 들어감 
				
			
				
				int result = 0;
				result = new DocService().updateDoc(doc);
				 
				 
				
				
				
				
				//3. 여기서부터 파일업로드 
				//업로드된 원래 파일명 추출
				String originalFileName = mrequest.getFilesystemName("file");
				
				int result2 = 0;
				
				// 첨부된 파일이 있다면 파일명 바꾸기함
				// 같은 이름의 파일이 있을 경우를 대비하기 위함.
				// "년월일시분초.확장자" 로 변경해 봄
				if (originalFileName != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
							+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

					// 지정 폴더에 업로드된 파일명 바꾸기 : File 클래스 renameTo()
					File originFile = new File(savePath + "\\" + originalFileName);
					File renameFile = new File(savePath + "\\" + renameFileName);

					if (!originFile.renameTo(renameFile)) {
						// 이름바꾸기가 실패한 경우에는 직접 바꾸기함
						int read = -1;
						byte[] buf = new byte[1024];
						// 한번에 읽을 배열 크기 지정

						FileInputStream fin = new FileInputStream(originFile);
						FileOutputStream fout = new FileOutputStream(renameFile);

						while ((read = fin.read(buf, 0, buf.length)) != -1) {
							fout.write(buf, 0, read);
						}
						
					

						fin.close();
						fout.close();
						originFile.delete(); // 원본파일 삭제함
					}

					SFileService sService = new SFileService();
					
					Sfile sfile = new Sfile();
					
					sfile.setOriginalFileName(originalFileName);
					sfile.setRenameFileName(renameFileName);
					sfile.setDocId(String.valueOf(new DocService().maxDocId()));
					
					 result2 = sService.insertSfile(sfile);
					
					
				} 
				
				
				
				
				if(result > 0) {
					
					response.sendRedirect("/sector/views/erp/erpmain/erpmain.jsp");
					
				}else {
					
					System.out.println("에러페이지 출력 ");
				}

				
				

				
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
