package doc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import doc.model.service.DocService;
import doc.model.vo.Doc;

/**
 * Servlet implementation class DocSubMenuServlet
 */
@WebServlet("/dsmsm")
public class DocSubMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocSubMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DocService dservice = new DocService();
		
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		
		Doc doc = dservice.searchEmpById(empId);
		
		System.out.println("서브메뉴 서블렛 Doc : " + doc);
		
		JSONObject sendJSON = new JSONObject();
		
		sendJSON.put("empName", URLEncoder.encode(doc.getEmpName(), "UTF-8"));
		sendJSON.put("deptName", URLEncoder.encode(doc.getDeptName(), "UTF-8"));
		sendJSON.put("jobName", URLEncoder.encode(doc.getJobName(), "UTF-8"));
		
		response.setContentType("application/json, charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.write(sendJSON.toJSONString());
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
