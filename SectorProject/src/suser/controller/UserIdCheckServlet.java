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
 * Servlet implementation class UserIdCheckServlet
 */
@WebServlet("/uics")
public class UserIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �α��� ��ư ���� ��, ���̵� Ȥ�� ��й�ȣ Ʋ���� �� �ߵ� ����
		String ID = request.getParameter("userId");
		String PWD = request.getParameter("userPwd");
		
		Suser answer = new SuserService().IdSearch(ID, PWD);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
