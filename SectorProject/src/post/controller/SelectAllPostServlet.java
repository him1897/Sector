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
 * Servlet implementation class postListServlet
 */
@WebServlet("/saps")
public class SelectAllPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectAllPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * System.out.println("서블렛 연결됨"); // 게시글 페이지별 목록 출력 처리용 컨트롤러 //목록 페이지 기본값 지정 int
		 * currentPage = 1;
		 * 
		 * //전송온 페이지값이 있다면 페이지 추출 if(request.getParameter("page") != null) { currentPage
		 * = Integer.parseInt(request.getParameter("page")); }
		 * 
		 * //한 페이지에 출력할 목록 갯수 지정 int limit = 10;
		 * 
		 * //연결할 서비스 객체 생성 PostService bservice = new PostService(); //총 목록 갯수 조회 int
		 * listCount = bservice.getListCount(); //System.out.println("listCount : " +
		 * listCount); //현재 페이지에 출력할 게시글 목록 조회 ArrayList<Post> list =
		 * bservice.selectList(currentPage, limit);
		 * 
		 * //출력될 총 페이지수 계산 int maxPage = listCount / limit; maxPage += (listCount %
		 * limit > 0)? 1: 0;
		 * 
		 * int maxPage = (int)((double)listCount / limit + 0.9);
		 * 
		 * //현재 페이지가 속할 페이지 그룹(10개로 할 경우)의 시작페이지 지정 //현재 페이지가 12이면 11 ~20 이 페이지 그룹이 됨
		 * //시작 페이지는 11임 int startPage = (((int)((double)currentPage / limit + 0.9)) -
		 * 1) * limit + 1; int endPage = startPage + limit - 1;
		 * 
		 * if(maxPage < endPage) { endPage = maxPage; }
		 * 
		 * RequestDispatcher view = null;
		 * response.setContentType("text/html; charset=utf-8"); if(list.size() > 0) {
		 * view = request.getRequestDispatcher("views/post/postListView.jsp");
		 * request.setAttribute("list", list); request.setAttribute("currentPage",
		 * currentPage); request.setAttribute("maxPage", maxPage);
		 * request.setAttribute("startPage", startPage); request.setAttribute("endPage",
		 * endPage); request.setAttribute("listCount", listCount); view.forward(request,
		 * response); }else { view =
		 * request.getRequestDispatcher("views/common/Error.jsp");
		 * request.setAttribute("message", "게시글 페이지별 조회 실패!"); view.forward(request,
		 * response); }
		 */

		String genre = request.getParameter("genre");

		System.out.println(genre);

		PostService pService = new PostService();

		int count = pService.listCount();
		
		
		int currentpage = 1;
		int limit = 10;
		if (request.getParameter("page") != null) {
			currentpage = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (currentpage * limit) - (limit - 1);
		int endRow = currentpage * limit;
		
		ArrayList<Post> list = pService.selectList(genre, startRow, endRow);

		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();

		// list 의 객체들을 하나씩 json 배열에 옮겨 저장 처리

		for (Post post : list) {
			// board 를 json 객체로 값 옮겨 저장
			JSONObject job = new JSONObject();
			job.put("title", URLEncoder.encode(post.getPostTitle(), "UTF-8"));
			// json 에서 한글 깨짐 막으려면,
			// java.net.URLEncoder 의 encode() 로 인코딩함
			job.put("writer", URLEncoder.encode(post.getWriter(), "UTF-8"));
			job.put("boardName", URLEncoder.encode(post.getBoardName(), "UTF-8"));
			job.put("date", new SimpleDateFormat("yyyy-MM-dd").format(post.getPostDate()));
			job.put("id", post.getPostId());

			jarr.add(job);

			System.out.println(post.toString());

		}

		// 전송용 객체에 배열 저장
		sendJson.put("list", jarr);

		// 페이지수 계산
		
		int maxpage = count / limit;
		int mod = count % limit;
		if (mod > 0) {
			maxpage++;
		}
		int startpage = 1;
		
		
		int begin = currentpage / 5 + 1;
		int end = begin + 4;
		if (end > maxpage) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
