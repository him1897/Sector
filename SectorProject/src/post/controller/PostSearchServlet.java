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
 * Servlet implementation class PostSearchServlet
 */
@WebServlet("/bsearch")
public class PostSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 조회 제목 또는 작성자 
		request.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		PostService pService = new PostService();

		int count = pService.listCount();
		
		
		int currentpage = 1;
		int limit = 10;
		if (request.getParameter("page") != null) {
			currentpage = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (currentpage * limit) - (limit - 1);
		int endRow = currentpage * limit;
		
		ArrayList<Post> list = new PostService().searchPost(category, keyword, startRow, endRow);
		
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		
		
		for(Post post : list) {
			JSONObject job = new JSONObject();
			job.put("title", URLEncoder.encode(post.getPostTitle(), "UTF-8"));
			job.put("writer", URLEncoder.encode(post.getWriter(), "UTF-8"));
			job.put("boardName", URLEncoder.encode(post.getBoardName(), "UTF-8"));
			job.put("date", new SimpleDateFormat("yyyy-MM-dd").format(post.getPostDate()));
			job.put("id", post.getPostId());
			
			jarr.add(job);
			
			System.out.println(post.toString());
			
		}
		
		sendJson.put("list", jarr);
		
		int maxpage = count / limit;
		int mod = count % limit;
		if(mod > 0) {
			maxpage++;
		}
		int startpage = 1;
		
		
		int begin = currentpage / 5 + 1;
		int end = begin + 4;
		if(end > maxpage) {
			end = maxpage;
		}

		sendJson.put("startpage", startpage);
		sendJson.put("maxpage", maxpage);
		sendJson.put("begin", begin);
		sendJson.put("end", end);
		sendJson.put("limit", limit);
		sendJson.put("currentpage", currentpage);

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
