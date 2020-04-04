package doc.controller;

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

import doc.model.service.DocService;
import doc.model.vo.Doc;
import emp.model.vo.Emp;

/**
 * Servlet implementation class DocLineViewServlet
 */
@WebServlet("/dlvsdd")
public class DocLineViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocLineViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//결재라인에 사원 출력하는 서블릿 
		//이름 , 직급 
		
		
		
		DocService dservice = new DocService();
		
		
		ArrayList<Emp> list = dservice.selectLineEmp();
		
		JSONObject sendJSON = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		
		for(Emp emp : list) {
			
			
			JSONObject job = new JSONObject();
			
			job.put("name", URLEncoder.encode(emp.getEmpName(),"UTF-8"));
			job.put("job", URLEncoder.encode(emp.getJobName(), "UTF-8"));
			job.put("empid", emp.getEmpId());
			
			
			jarr.add(job);
			
		}
		
		
		sendJSON.put("list", jarr);
		
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
