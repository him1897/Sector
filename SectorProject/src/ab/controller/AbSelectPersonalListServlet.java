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
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ab.model.service.AbService;
import ab.model.vo.Ab;

/**
 * Servlet implementation class AbSelectPersonalListServlet
 */
@WebServlet("/aspls")
public class AbSelectPersonalListServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbSelectPersonalListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String personalsort = request.getParameter("personalsort");
		
		/*HttpSession session = request.getSession();
		String loginMember = (String)session.getAttribute("loginMember");
		String empId = new AbService().getEmpId(loginMember);*/
		
		String userId = request.getParameter("userid");
		
		
		
		ArrayList<Ab> alist = new AbService().selectAllPersonalList(personalsort, userId);
		response.setContentType("text/html; charset=utf-8");
		
		
		
		
		if(alist.size()>0) {
			JSONObject jobj = new JSONObject();
			JSONArray jarray = new JSONArray();
			
			for(Ab a : alist) {
				JSONObject json = new JSONObject();
				json.put("com", URLEncoder.encode(a.getAbCom(), "utf-8"));
				json.put("name", URLEncoder.encode(a.getAbName(),"utf-8"));
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
