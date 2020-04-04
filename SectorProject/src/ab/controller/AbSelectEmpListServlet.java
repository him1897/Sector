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
import emp.model.vo.Emp;

/**
 * Servlet implementation class AbSelectEmpListServlet
 */
@WebServlet("/asels")
public class AbSelectEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbSelectEmpListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//한글
		request.setCharacterEncoding("utf-8");
		//보낸값저장
		String empsort = request.getParameter("empsort");
		
		ArrayList<Emp> elist = new AbService().selectAllEmp(empsort);
		
		response.setContentType("text/html; charset=utf-8");
		
		
		if(elist.size()>0) {
			JSONObject jobj = new JSONObject();
			JSONArray jarray = new JSONArray();
			
			for(Emp e : elist) {
				JSONObject json = new JSONObject();
				json.put("name", URLEncoder.encode(e.getEmpName(),"utf-8"));
				json.put("phone", e.getEmpPhone());
				json.put("deptname", URLEncoder.encode(e.getDeptId(),"utf-8"));
				json.put("jobname", URLEncoder.encode(e.getJobId(),"utf-8"));
				json.put("email", e.getEmpEmail());
				json.put("address", URLEncoder.encode(e.getEmpAddress(), "utf-8"));
				json.put("rownum", e.getRowNum());
				
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
