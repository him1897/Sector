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
 * Servlet implementation class UpdatePostServlet
 */
@WebServlet("/ups")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Post post = new Post();

		int postId = Integer.parseInt(request.getParameter("postid"));
		 
		post.setPostId(postId);
		post.setPostTitle(request.getParameter("title"));
		post.setBoardName(request.getParameter("genre"));
		post.setPostContent(request.getParameter("content"));
		post.setWriter(request.getParameter("writer"));
		
		
		int result = new PostService().updatePost(post);
		
		
		 response.setContentType("text/html; charset=utf-8");
		 RequestDispatcher view = null;
		 if(post != null) {
			 view = request.getRequestDispatcher("/index.jsp");
			 request.setAttribute("post", post);
			 view.forward(request, response);
		 }else {
			 System.out.println("error");
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
