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

import ab.model.dao.AbDao;
import ab.model.service.AbService;
import ab.model.vo.Ab;
import emp.model.vo.Emp;

/**
 * Servlet implementation class AbSearchServlet
 */
@WebServlet("/ass")
public class AbSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchval = request.getParameter("searchselectval");
		String searchkeyword = request.getParameter("searchselectkeyword");
		String name = request.getParameter("name");
		
		JSONObject jobj = new JSONObject();
		JSONArray jarray = new JSONArray();
		AbDao abDao = new AbDao();
			
			
		if(name.equals("emp")) {
			
			ArrayList<Emp> list = new AbService().searchEmp(searchval, searchkeyword);
			for(Emp e : list) {
			
				JSONObject jsonlist = new JSONObject();
				
				jsonlist.put("deptname", URLEncoder.encode(e.getDeptId(), "utf-8"));
				jsonlist.put("name", URLEncoder.encode(e.getEmpName(), "utf-8"));
				jsonlist.put("phone", abDao.phone(e.getEmpPhone()));
				jsonlist.put("jobname", URLEncoder.encode(e.getJobId(), "utf-8"));
				jsonlist.put("email", e.getEmpEmail());
				jsonlist.put("address", URLEncoder.encode(e.getEmpAddress(), "utf-8"));
				
				jarray.add(jsonlist);
						
				}
				jobj.put("list", jarray);
				
				PrintWriter out = response.getWriter();
				out.print(jobj.toJSONString());
				out.flush();
				out.close();
		}else {
			
			ArrayList<Ab> list = new AbService().searchAb(searchval, searchkeyword);
			for(Ab a : list) {
				
				JSONObject jsonlist = new JSONObject();
				
				jsonlist.put("com", URLEncoder.encode(a.getAbCom(), "utf-8"));
				jsonlist.put("name", URLEncoder.encode(a.getAbName(), "utf-8"));
				jsonlist.put("phone", a.getAbPhone());
				jsonlist.put("jobname", URLEncoder.encode(a.getAbJobName(), "utf-8"));
				jsonlist.put("email", a.getAbEmail());
				jsonlist.put("address", URLEncoder.encode(a.getAbAddress(), "utf-8"));
				
				jarray.add(jsonlist);
						
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
