package doc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc.model.service.DocService;
import line.model.service.LineService;

/**
 * Servlet implementation class DocStatusRejectServlet
 */
@WebServlet("/dsrs")
public class DocStatusRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocStatusRejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//반려버튼 클릭시 연결되는 서블렛 
		
		System.out.println("reject 서블렛 연결됨 ");
		
		int docId = Integer.parseInt(request.getParameter("docid"));
		int answer = Integer.parseInt(request.getParameter("answerNo"));
		
		DocService dservice = new DocService();
		LineService lservice = new LineService();
		
		int result1 = dservice.statusReject(docId);
		
		
		int result2 = lservice.rejectAnswer(answer, docId);
		
		
		if(result1 <= 0 || result2 <= 0) {
			System.out.println("update Reject error");
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
