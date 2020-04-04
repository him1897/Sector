package ab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ab.model.service.AbService;
import ab.model.vo.Ab;
import emp.model.vo.Emp;

/**
 * Servlet implementation class AbInsertServlet
 */
@WebServlet("/ais")
public class AbInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Emp emp = new AbService().empInfo(request.getParameter("userId"), Integer.parseInt(request.getParameter("userComNo")));
		String deptId = emp.getDeptId();
		Ab ab = new Ab();
		
		ab.setAbName(request.getParameter("username"));
		ab.setAbCom(request.getParameter("com"));
        ab.setAbPhone(request.getParameter("phone"));
        ab.setAbJobName(request.getParameter("jobname"));
        ab.setAbEmail(request.getParameter("email"));
        ab.setAbAddress(request.getParameter("address"));
        ab.setAbAnniName(request.getParameter("anniname"));
        ab.setAbAnniDate(java.sql.Date.valueOf(request.getParameter("annidate")));
        ab.setAbGroup(request.getParameter("abgroup"));
        ab.setAbEmpId(Integer.parseInt(request.getParameter("empId")));
        ab.setAbWriterCom(Integer.parseInt(request.getParameter("userComNo")));
        ab.setAbDeptId(deptId);
        int result = new AbService().insertAb(ab);
       
        
        if(result>0) {
        	response.sendRedirect("/sector/ams");
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
