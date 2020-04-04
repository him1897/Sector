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
 * Servlet implementation class UpdateByEmpServlet
 */
@WebServlet("/ubes")
public class UpdateByEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateByEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 마스터권한 수정
		request.setCharacterEncoding("utf-8");
		Emp emp = new Emp();
		int empId = Integer.parseInt(request.getParameter("empid"));
		System.out.println(empId);
		
		emp.setEmpId(empId);
		emp.setEmpName(request.getParameter("username"));
		emp.setUserId(request.getParameter("userid"));
		emp.setDeptId(request.getParameter("deptid"));
		emp.setJobId(request.getParameter("jobid"));
		emp.setEmpPhone(request.getParameter("phone"));
		emp.setEmpEmail(request.getParameter("email"));
		emp.setEmpNo(request.getParameter("empno"));
		emp.setEmpAddress(request.getParameter("address"));
		emp.setSalary(Integer.parseInt(request.getParameter("salary")));
		emp.setBonusPct(Double.parseDouble(request.getParameter("bonuspct")));
//		emp.setHireDate(request.getParameter("date"));
		emp.setVacation(Integer.parseInt(request.getParameter("vacation")));
		emp.setMarriage(request.getParameter("marriage"));
		emp.setIdent(request.getParameter("ident"));
		
		System.out.println(emp.getEmpName());
		System.out.println(emp.getUserId());
		System.out.println(emp.getDeptId());
		System.out.println(emp.getJobId());
		System.out.println(emp.getEmpPhone());
		System.out.println(emp.getEmpEmail());
		System.out.println(emp.getEmpNo());
		System.out.println(emp.getEmpAddress());
		System.out.println(emp.getSalary());
		System.out.println(emp.getBonusPct());
//		System.out.println(emp.getHireDate());
		System.out.println(emp.getVacation());
		System.out.println(emp.getMarriage());
		System.out.println(emp.getIdent());
		
		EmpService eservice = new EmpService();
		int result = eservice.updateEmp(emp);
		System.out.println(result);
		if(result > 0) {
			
			Suser suser = new Suser();
			suser.setUserId(request.getParameter("userid"));
			suser.setIdent(request.getParameter("ident"));
			
			int result2 = eservice.updateSuser(suser);
			System.out.println(result2);
			
			if(result2 > 0) {
				response.sendRedirect("views/ab/userUpdate.jsp");
			}
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
