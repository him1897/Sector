package doc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc.model.service.DocService;
import line.model.service.LineService;

/**
 * Servlet implementation class DocDeleteServlet
 */
@WebServlet("/ddds")
public class DocDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int docId = Integer.parseInt(request.getParameter("docid"));
		
		//line 삭제 
		
		int result2 = new LineService().deleteLine(docId);
		
		
		
		//doc 삭제 
		
		
		int result1 = new DocService().deleteDoc(docId);
		
		
		
		RequestDispatcher view = null;
		
		if(result1 > 0 && result2 > 0) {
			response.sendRedirect("/sector/views/erp/erpmain/erpmain.jsp");
		}else {
			System.out.println("Delete Error");
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
