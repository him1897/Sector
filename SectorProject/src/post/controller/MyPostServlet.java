package post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import post.model.service.PostService;
import post.model.vo.Post;

/**
 * Servlet implementation class MyPostServlet
 */
@WebServlet("/mps")
public class MyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empId = Integer.parseInt(request.getParameter("empid"));
		
		ArrayList<Post> list = new PostService().writeName(empId);
		
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		//list 의 객체들을 하나씩 json 배열에 옮겨 저장 처리
		
		for(Post post : list) {
			//board 를 json 객체로 값 옮겨 저장
			JSONObject job = new JSONObject();
			job.put("title", URLEncoder.encode(post.getPostTitle(), "UTF-8"));
			//json 에서 한글 깨짐 막으려면, 
			//java.net.URLEncoder 의 encode() 로 인코딩함
			job.put("writer", URLEncoder.encode(post.getWriter(), "UTF-8"));
			job.put("boardName", URLEncoder.encode(post.getBoardName(), "UTF-8"));
			job.put("date", new SimpleDateFormat("yyyy-MM-dd").format(post.getPostDate()));
			job.put("id", post.getPostId());
			
			jarr.add(job);
			
			System.out.println(post.toString());
			
		}
		
		//전송용 객체에 배열 저장
		sendJson.put("list", jarr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(sendJson.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
