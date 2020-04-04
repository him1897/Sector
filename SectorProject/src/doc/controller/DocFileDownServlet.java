package doc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocFileDownServlet
 */
@WebServlet("/dfdsd")
public class DocFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 파일 다운로드 처리용 컨트롤러

				// WAS(Web Application Server : 웹 애플리케이션을 구동하는 서버 엔진)
				// 에서 구동중인 프로젝트 내에 있는 폴더의 경로정보를 찾아옴
				String savePath = request.getSession().getServletContext().getRealPath("/resources/doc_upfiles");
				
				
				// 파일명에 한글이 포함되어 있을 경우 인코딩 처리함
				request.setCharacterEncoding("utf-8");

				String originalFileName = request.getParameter("ofile");
				String renameFileName = request.getParameter("rfile");

				
				// 저장폴더에 있는 변경된 파일명의 파일 읽기용 스트림 생성
				File readFile = new File(savePath + "/" + renameFileName);
				BufferedInputStream bin = new BufferedInputStream(new FileInputStream(readFile));
				
				
				// 클라이언트로 내보낼 파일 출력 스트림 생성
				ServletOutputStream downOut = response.getOutputStream();

				
				// 파일 다운을 위한 response 설정 처리
				response.setContentType("text/plain; charset=utf-8");
				
				// 한글 파일명을 다운로드되는 시스템 OS 문자셋 맞추기
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
				response.setContentLength((int) readFile.length());

				
				// 파일 읽어서 내보내기
				int read = -1;
				
				while ((read = bin.read()) != -1) {
					downOut.write(read);
					downOut.flush();
				}

				downOut.close();
				bin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
