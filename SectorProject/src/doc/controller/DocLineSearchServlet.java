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

/**
 * Servlet implementation class DocLineSearchServlet
 */
@WebServlet("/dlssd")
public class DocLineSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocLineSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//결재라인에서 사원검색하는 서블릿 
		
		DocService dservice = new DocService();
		
		String name = request.getParameter("name");
		
		ArrayList<Doc> list = dservice.searchLineEmp(name);
		
		JSONObject sendJSON = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		
		for(Doc doc : list) {
			
			
			JSONObject job = new JSONObject();
			
			job.put("name", URLEncoder.encode(doc.getEmpName(),"UTF-8"));
			job.put("job", URLEncoder.encode(doc.getJobName(), "UTF-8"));
			
			
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
