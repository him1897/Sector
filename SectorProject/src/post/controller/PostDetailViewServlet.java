package post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.PostService;
import post.model.vo.Post;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/pdvs")
public class PostDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostDetailViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글 상세보기 처리용 컨트롤러

		int postId = Integer.parseInt(request.getParameter("postid"));
		
		PostService pservice = new PostService();

		
		Post post = pservice.selectOne(postId);

		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		
		
		if (post != null) {
			view = request.getRequestDispatcher("views/post/postDetailView.jsp");
			
			request.setAttribute("post", post);
			
			
			view.forward(request, response);
			
			
		} else {
			System.out.println("detailview error");
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
