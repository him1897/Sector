package emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.service.EmpService;
import emp.model.vo.Emp;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/eds")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empId = Integer.parseInt(request.getParameter("empid"));
	      
		System.out.println("1 : "+ empId);
	      EmpService eservice = new EmpService();

	      
	      Emp emp = eservice.selectOne(empId);
	      System.out.println("2 : " + emp.getEmpId());
	      
	      response.setContentType("text/html; charset=utf-8");
	      RequestDispatcher view = null;
	      
	      
	      if (emp != null) {
	         view = request.getRequestDispatcher("views/emp/empDetailView.jsp");
	         
	         request.setAttribute("emp", emp);
	         
	         
	         view.forward(request, response);
	         
	         
	      } else {
	         System.out.println("detailview error");
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
