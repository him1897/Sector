package suser.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import suser.model.service.SuserService;
import suser.model.vo.Suser;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/icss")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 아이디 중복확인
		String userId = request.getParameter("userID");
		System.out.println("1차 서버에서 입력한 값은 " + userId);
		
		//모델로 값 또는 객체 전달하고 결과 받는 과정.
		Boolean IdCheck = new SuserService().IdCheck(userId);
		System.out.println("2차 IdCheck 통과!");
		
		response.setContentType("text/html; charset=utf-8");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
