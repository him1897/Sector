package post.controller;

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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import post.model.service.PostService;
import post.model.vo.Post;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/ips")
public class InsertPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/Error.jsp");
			request.setAttribute("message", "form 의 enctype 속성 누락됨.");
			view.forward(request, response);
		}

		// 1. 업로드할 파일의 용량 제한 : 10Mbyte 로 제한한다면
		int maxSize = 1024 * 1024 * 10;
		// 2. 업로드되는 파일의 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("/resources/post_upfiles");
		// System.out.println(savePath);

		// request 를 MultipartRequest 로 변환함
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		// 전송온 값 꺼내서 변수 또는 객체에 저장하기
		Post post = new Post();
		
		response.setContentType("UTF-8");

		post.setPostTitle(mrequest.getParameter("title"));
		post.setPostContent(mrequest.getParameter("content"));
		post.setEmpId(Integer.parseInt(mrequest.getParameter("empId")));
		post.setBoardName(mrequest.getParameter("genre"));
		
		System.out.println(post.getPostContent());
		// 업로드된 원래 파일명 추출
		String originalFileName = mrequest.getFilesystemName("upfile");
		// System.out.println(originalFileName);
		post.setPostOriginalFileName(originalFileName);

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

			post.setPostRenameFileName(renameFileName);
		} // 첨부파일이 있다면

		// System.out.println(notice);

		int result = new PostService().insertPost(post);

		if (result > 0) {
			response.sendRedirect("/sector/index.jsp");
		} else {
			view = request.getRequestDispatcher("views/common/Error.jsp");
			request.setAttribute("message", "게시글 등록 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
