package doc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.StandardSocketOptions;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
import line.model.service.LineService;
import line.model.vo.Line;
import sfile.model.service.SFileService;
import sfile.model.vo.Sfile;

/**
 * Servlet implementation class DocDetailViewServlet
 */
@WebServlet("/ddvs")
public class DocDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		//문서 상세보기 서블릿 
		
		System.out.println(request.getParameter("docid"));
		
		int docid = Integer.parseInt(request.getParameter("docid"));
		
		
		DocService dservice = new DocService();
		LineService lservice = new LineService();
		
		//문서와 문서관련 사원정보 보내기 
		
		Doc doc = dservice.selectOne(docid); //문서정보 
		
		Doc docEmp = dservice.searchEmpById(doc.getDocWriter()); //문서와 관련된 사원정보 
		 
		//결재라인 정보 보내기 
		
		Line line = lservice.selectOne(doc.getDocId());
		
		
		
		//서명 유무 정보 보내기 
		
		String a1 = lservice.lineAnswer(doc.getDocId(), 1);
		
		
		
		String a2 = lservice.lineAnswer(doc.getDocId(), 2);
		String a3 = lservice.lineAnswer(doc.getDocId(), 3);
		String a4 = lservice.lineAnswer(doc.getDocId(), 4);
		String a5 = lservice.lineAnswer(doc.getDocId(), 5);
		String a6 = lservice.lineAnswer(doc.getDocId(), 6);
		String a7 = lservice.lineAnswer(doc.getDocId(), 7);
		
		request.setAttribute("a1", a1);
		request.setAttribute("a2", a2);
		request.setAttribute("a3", a3);
		request.setAttribute("a4", a4);
		request.setAttribute("a5", a5);
		request.setAttribute("a6", a6);
		request.setAttribute("a7", a7);
		
		
		
		
		Doc lineNull = new Doc();
		
		lineNull.setDeptName("");
		lineNull.setJobName("");
		lineNull.setEmpName("");
		
		
		
		
		
		
		
		
		RequestDispatcher view = null;
		
		
		
		if(doc != null) {
		view = request.getRequestDispatcher("views/erp/erpmain/erpdetail.jsp");
		
		//여기부터 문서정보 
		request.setAttribute("docEmp", docEmp);
		request.setAttribute("doc", doc);
		
		request.setAttribute("line", line);
		
		
		
		
		//여기부터 결재라인 정보 (직급, 부서명, 사원이름, 사번)
		if(Integer.parseInt(line.getFirst()) != 0) {
		Doc line1 = dservice.searchEmpById(Integer.parseInt(line.getFirst()));
		request.setAttribute("line1", line1);
		}else {
		Doc line1 = lineNull;
		request.setAttribute("line1", line1);
		}
		
		
		if(Integer.parseInt(line.getSecond()) != 0) {
		Doc line2 = dservice.searchEmpById(Integer.parseInt(line.getSecond()));
		request.setAttribute("line2", line2);
		}else {
		Doc line2 = lineNull;
		request.setAttribute("line2", line2);
		}
		
		
		
		if(Integer.parseInt(line.getThird()) != 0) {
			Doc line3 = dservice.searchEmpById(Integer.parseInt(line.getThird()));
			request.setAttribute("line3", line3);
			
			}else {
			Doc line3 = lineNull;
			request.setAttribute("line3", line3);
			
			}
		
		
		if(Integer.parseInt(line.getFourth()) != 0) {
			Doc line4 = dservice.searchEmpById(Integer.parseInt(line.getFourth()));
			request.setAttribute("line4", line4);
			}else {
				Doc line4 = lineNull;
				request.setAttribute("line4", line4);
			}
		
		
		if(Integer.parseInt(line.getFifth()) != 0) {
			Doc line5 = dservice.searchEmpById(Integer.parseInt(line.getFifth()));
			request.setAttribute("line5", line5);
			}else {
			Doc line5 = lineNull;
			request.setAttribute("line5", line5);
			}
		
		if(Integer.parseInt(line.getSixth()) != 0) {
			Doc line6 = dservice.searchEmpById(Integer.parseInt(line.getSixth()));
			request.setAttribute("line6", line6);
		}else {
			Doc line6 = lineNull;
			request.setAttribute("line6", line6);
		}
		
		if(Integer.parseInt(line.getSeventh()) != 0){
			Doc line7 = dservice.searchEmpById(Integer.parseInt(line.getSeventh()));
			request.setAttribute("line7", line7);
		}else {
			Doc line7 = lineNull;
			request.setAttribute("line7", line7);
		}
		
		
		
		
		
		
		SFileService fservice = new SFileService();
		
		Sfile sfile = fservice.selectOneByDoc(docid);
		
		request.setAttribute("sfile", sfile);
		

		
		view.forward(request, response);
		
		}else {
			
			System.out.println("error");
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
