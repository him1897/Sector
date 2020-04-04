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
 * Servlet implementation class DocStatusUpdateServlet
 */
@WebServlet("/dsus")
public class DocStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocStatusUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int docId = Integer.parseInt(request.getParameter("docid"));
		
		
		DocService dservice = new DocService();
		LineService lservice = new LineService();
		
		//문서 상태 변경 
		int result1 = dservice.updateStatus(docId);
		

		
		
		if(result1 <= 0 ) {
			System.out.println("update Status error");
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
