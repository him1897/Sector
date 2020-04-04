package emp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.service.EmpService;
import emp.model.vo.Emp;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/saes")
public class SelectAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Emp> elist = new EmpService().selectAll();
		
		RequestDispatcher view = null;
		response.setContentType("text/html; charset=utf-8"); 
		if(elist.size()>0) {
			view =request.getRequestDispatcher("/views/ab/abEmpMemberAll");
			request.setAttribute("list", elist);
			view.forward(request, response);
			
		}else {
			view =request.getRequestDispatcher("/views/common/Error.jsp");
			request.setAttribute("message", "응안돼~");
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
