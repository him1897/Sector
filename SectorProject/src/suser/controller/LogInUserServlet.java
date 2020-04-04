package suser.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import suser.model.dao.SuserDao;
import suser.model.service.SuserService;
import suser.model.vo.Suser;
/**
 * Servlet implementation class LogInUserServlet
 */
@WebServlet("/lius")
public class LogInUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogInUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//뷰 에서 전송 온 값 꺼내서 변수 또는 객체에 저장 처리 과정.
		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPassword");
		System.out.println("1차 서버에서 입력한 값은 " + userId + ", " + userPw);
		
		//모델로 값 또는 객체 전달하고 결과 받는 과정.
		Suser loginMember = new SuserService().loginCheck(userId, userPw);
		
		
		System.out.println("2차 loginMember 통과!" + loginMember);
		//System.out.println(loginMember.getUserMaster()); 
		
		//받은 결과를 뷰 페이지로 선택해서 보내는 과정
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		//로그인 성공 및 실패 과정
		if(loginMember != null) {
			//로그인 성공시
			//(HttpSession 인포트 필요)
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect("/sector/ams");
		}else{
			//실패했을 경우
			session.setAttribute("result", "실패");
			response.sendRedirect("/sector/mainLogin.jsp");
			//view.forward(request, response);
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












