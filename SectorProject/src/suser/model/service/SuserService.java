package suser.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import emp.model.vo.Emp;
import suser.model.dao.SuserDao;
import suser.model.vo.Suser;

public class SuserService {

	private SuserDao sdao = new SuserDao();
	
	public SuserService() {}
	
	public Suser loginCheck(String userId, String userPwd) {
		
		Connection conn = getConnection();
		Suser loginMember = sdao.loginCheck(conn, userId, userPwd);
		close(conn);
		return loginMember;
	}
	
	//회원가입 중복확인 체크기능
	public Boolean IdCheck(String userId) {
		
		Connection conn = getConnection();
		Boolean IdCheck = sdao.IdCheck(conn, userId);
		close(conn);
		return IdCheck;
	}
	
	/*public Suser selectOne(String userId) {
		
		Connection conn = getConnection();
		Suser suser = sdao.selectOne(conn, userId);
		
		return suser;
		
	}*/
	
		//사원 목록 출력
		public ArrayList<Emp> selectList(
			int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Emp> list = sdao.selectList(conn, currentPage, limit);
		close(conn);
		return list;
	}
		
		
		
	public ArrayList<Suser> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Suser>list = sdao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertSuser(Suser suser) {
		
		Connection conn = getConnection();
		int result = sdao.insertSuser(conn, suser);
		
		return result;
	}
	
	public int deleteSuser(String userId) {
		
		Connection conn = getConnection();
		int result = sdao.deleteSuser(conn, userId);
		
		return result;
	}
	
	public int updateSuser(String userId) {
		
		Connection conn = getConnection();
		int result = sdao.updateSuser(conn, userId);
		
		return result;
	}

	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Suser IdSearch(String ID, String PWD) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Suser answer = sdao.IdSearch(conn, ID, PWD);
		close(conn);
		return answer;
	}
	
}
