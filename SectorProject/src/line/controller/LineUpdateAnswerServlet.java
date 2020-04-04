package line.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import line.model.service.LineService;

/**
 * Servlet implementation class LineUpdateAnswerServlet
 */
@WebServlet("/luas")
public class LineUpdateAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LineUpdateAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("AnswerUpdate 연결됨");
		
		int answerNo = Integer.parseInt(request.getParameter("answerNo"));
		int lineNo = Integer.parseInt(request.getParameter("docid"));
		
		System.out.println("answerNo : " + answerNo);
		
		int result = new LineService().updateAnswer(answerNo, lineNo);
		
		
		if(result <= 0) {
			System.out.println("LineUpdateAnswerServlet Error");
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
