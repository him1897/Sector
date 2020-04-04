package ab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ab.model.service.AbService;
import emp.model.vo.Emp;

/**
 * Servlet implementation class AbListView
 */
@WebServlet("/ams")
public class AbMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//보낸값저장
		//String empsort = request.getParameter("empsort");

		ArrayList<Emp> elist = new AbService().selectAllEmp("이름");
		
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher view = null;
		if(elist.size()>0) {

			view = request.getRequestDispatcher("/views/ab/abMain.jsp");
			request.setAttribute("emplist", elist);
			view.forward(request, response);
			
		}else {
    		view = request.getRequestDispatcher("views/common/Error.jsp");
    		request.setAttribute("message", "페이지연결오류");
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
