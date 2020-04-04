package suser.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.vo.Emp;
import suser.model.service.SuserService;

/**
 * Servlet implementation class ListViewUserServlet
 */
@WebServlet("/lvus")
public class ListViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListViewUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//목록 페이지 기본값 지정
		int currentPage = 1;
		//전송온 페이지값이 있다면 페이지 추출
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		//한 페이지에 출력할 목록 갯수 지정
		int limit = 10;
		//연결할 서비스 객체 생성
		SuserService bservice = new SuserService();
		//총 목록 갯수 조회
		int listCount = bservice.getListCount();
		//System.out.println("listCount : " + listCount);
		//현재 페이지에 출력할 게시글 목록 조회
		ArrayList<Emp> list = bservice.selectList(currentPage, limit);
		
		//출력될 총 페이지수 계산
		/*int maxPage = listCount / limit;
		maxPage += (listCount % limit > 0)? 1: 0;*/
		int maxPage = (int)((double)listCount / limit + 0.9);
		
		//현재 페이지가 속할 페이지 그룹(10개로 할 경우)의 시작페이지 지정
		//현재 페이지가 12이면 11 ~20 이 페이지 그룹이 됨
		//시작 페이지는 11임
		int startPage = (((int)((double)currentPage / limit + 0.9))
				- 1) * limit + 1;
		int endPage = startPage + limit - 1;
				
		if(maxPage < endPage) {
			endPage = maxPage;
		}
				
		RequestDispatcher view = null;
		response.setContentType("text/html; charset=utf-8");
		if(list.size() > 0) {
		view = request.getRequestDispatcher("views/ab/userUpdate.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/Error.jsp");
			request.setAttribute("message", "게시글 페이지별 조회 실패!");
			view.forward(request, response);
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
