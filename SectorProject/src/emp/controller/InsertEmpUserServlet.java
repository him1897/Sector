package emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.service.EmpService;
import emp.model.vo.Emp;
import suser.model.vo.Suser;

/**
 * Servlet implementation class InsertEmpUserServlet
 */
@WebServlet("/ieus")
public class InsertEmpUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmpUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		Suser suser = new Suser();
		suser.setUserComNo(Integer.parseInt(request.getParameter("usercomno")));
		suser.setUserId(request.getParameter("userId"));
		suser.setUserPwd(request.getParameter("userPwd"));
		suser.setUserName(request.getParameter("userName"));
		
		int result = new EmpService().insertSuser(suser);
		System.out.println("돌아왔니...?" + result);
		
		if(result > 0) {
			Emp emp = new Emp();
			
			emp.setMasterComNo(Integer.parseInt(request.getParameter("usercomno")));
			emp.setUserId(request.getParameter("userId"));
			emp.setEmpName(request.getParameter("userName"));
			emp.setEmpNo(request.getParameter("userNo"));
			emp.setEmpEmail(request.getParameter("userEmail"));
			emp.setEmpAddress(request.getParameter("userAddress"));
			emp.setEmpPhone(request.getParameter("userPhone"));
			
			result = new EmpService().insertEmp(emp);
			System.out.println("너도 왔니...? " + result);
			response.sendRedirect("/sector/mainLogin.jsp");
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
