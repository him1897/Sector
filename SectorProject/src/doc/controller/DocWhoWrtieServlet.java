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
import doc.model.vo.Paging;

/**
 * Servlet implementation class DocWhoWrtieServlet
 */
@WebServlet("/dwws")
public class DocWhoWrtieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocWhoWrtieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paging paging = new Paging();
		
		//paging Block 만들기 
		
		int curPage = Integer.parseInt(request.getParameter("page"));
		int empId = Integer.parseInt(request.getParameter("empId"));
	
		
		
		paging.makeBlock(curPage);
		paging.makeLastPageNumByEmpId(empId);
		
		//블록의 처음과 마지막 그리고 마지막 페이지 구하기 
		Integer blockStartNum = paging.getBlockStartNum();
		Integer blockLastNum = paging.getBlockLastNum();
		Integer lastPageNum = paging.getLastPageNum();
		
		/*System.out.println("blockStartNum : " + blockStartNum);
		System.out.println("blockLastNum : " + blockLastNum);
		System.out.println("lastPageNum : " + lastPageNum);*/
		
		DocService dservice = new DocService();

		ArrayList<Doc> list = dservice.docWhoWrite(curPage, empId);

		
		//사번으로 직급 가져오기 
		String jobId = dservice.selectjobId(empId);
				
			
		
		
		JSONObject sendJSON = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		
		

		for (Doc doc : list) {

			JSONObject job = new JSONObject();
			job.put("id", doc.getDocId());
			job.put("title", URLEncoder.encode(doc.getDocTitle(), "UTF-8"));
			job.put("date", doc.getDocStart().toString());
			job.put("writer", URLEncoder.encode(doc.getEmpName(), "UTF-8"));
			job.put("type",  URLEncoder.encode(doc.getDocType(),"UTF-8"));
			job.put("status", URLEncoder.encode(doc.getDocStatus(),"UTF-8"));
			job.put("level", doc.getDocLevel());
			
			//페이징처리 값 전송 
			job.put("blockStartNum", blockStartNum);
			job.put("blockLastNum", blockLastNum);
			job.put("lastPageNum", lastPageNum);
			
			
				//로그인 유저의 직급
			
			job.put("jobId", jobId);
			
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
