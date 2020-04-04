package ab.controller;

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

import ab.model.service.AbService;
import ab.model.vo.Ab;
import emp.model.vo.Emp;

/**
 * Servlet implementation class AbSelectShareList
 */
@WebServlet("/assl")
public class AbSelectShareListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbSelectShareListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sharesort = request.getParameter("sharesort");
		
		String empId = request.getParameter("empid");
		int userComNo = Integer.parseInt(request.getParameter("usercomno"));
		String userId = request.getParameter("userid");
		Emp emp = new AbService().empInfo(userId, userComNo);
		String deptId = emp.getDeptId();
		
		
		ArrayList<Ab> alist = new AbService().selectAllShareList(sharesort, empId, userComNo, deptId);
		
		response.setContentType("text/html; charset=utf-8");
		if(alist.size()>0) {
			JSONObject jobj = new JSONObject();
			JSONArray jarray = new JSONArray();
			
			for(Ab a : alist) {
				JSONObject json = new JSONObject();
				json.put("com", URLEncoder.encode(a.getAbCom(), "utf-8"));
				json.put("name",  URLEncoder.encode(a.getAbName(), "utf-8"));
				json.put("phone", a.getAbPhone());
				json.put("jobname", URLEncoder.encode(a.getAbJobName(),"utf-8"));
				json.put("email", a.getAbEmail());
				json.put("address", URLEncoder.encode(a.getAbAddress(),"utf-8"));
				
				
				jarray.add(json);
			}
			
			jobj.put("list", jarray);
			
			PrintWriter out = response.getWriter();
			out.print(jobj.toJSONString());
			out.flush();
			out.close();
			
			
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
