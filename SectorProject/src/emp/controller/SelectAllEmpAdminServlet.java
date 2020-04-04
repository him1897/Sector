package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import emp.model.service.EmpService;
import emp.model.vo.Emp;
import suser.model.vo.Suser;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/saeas")
public class SelectAllEmpAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllEmpAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Emp> list = new EmpService().selectAll();
	      
	      JSONObject sendJson = new JSONObject();
	      JSONArray jarr = new JSONArray();
	      Suser suser = new Suser();
	      //list �� ��ü���� �ϳ��� json �迭�� �Ű� ���� ó��
	      
	      for(Emp emp : list) {
	         //board �� json ��ü�� �� �Ű� ����
	         JSONObject job = new JSONObject();
	         job.put("empId", emp.getEmpId());
	         //json ���� �ѱ� ���� ��������, 
	         //java.net.URLEncoder �� encode() �� ���ڵ���
	         job.put("empName", URLEncoder.encode(emp.getEmpName(), "UTF-8"));
	         job.put("deptId", emp.getDeptId());
	         job.put("jobId", emp.getJobId());
	         job.put("empPhone", emp.getEmpPhone());
	         job.put("empEmail", emp.getEmpEmail());
	         job.put("empAddress", emp.getEmpAddress());
	         job.put("ident", emp.getIdent());
	         
	         jarr.add(job);
	         
	         System.out.println(emp.toString());
	         
	      }
	      
	      //���ۿ� ��ü�� �迭 ����
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
