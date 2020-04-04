package ab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ab.model.service.AbService;

/**
 * Servlet implementation class AbDeleteToPersonalServlet
 */
@WebServlet("/adtps")
public class AbDeleteToPersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbDeleteToPersonalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String values = request.getParameter("values");
		String array[] = values.split(",");
		String num = null;
				
		AbService abService = new AbService();
		for(int i = 0; i< array.length; i++) {
			num = array[i].replace("-", "");
			abService.deleteToPersonalAb(num);
		}
		
		response.sendRedirect("/sector/ams");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
