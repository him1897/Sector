package ab.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import ab.model.dao.AbDao;
import ab.model.vo.Ab;
import emp.model.vo.Emp;

public class AbService {


	private AbDao abDao = new AbDao();
	
/*	public ArrayList<Ab> selectAll(emp_id받아서 where해야함){
		
		Connection conn = getConnection();
		ArrayList<Ab> list = abDao.selectAll(conn);
		close(conn);
		return list;
	}*/
	
	public ArrayList<Ab> selectAllShareList(String sharesort, String empId, int userComNo, String deptId){
		
		Connection conn = getConnection();
		ArrayList<Ab> list = abDao.selectAllShareList(conn, sharesort, empId, userComNo, deptId);
		close(conn);
		return list;
		
	}
	
	public ArrayList<Emp> selectAllEmp(String empsort){
		
		Connection conn = getConnection();
		ArrayList<Emp> list = abDao.selectAllEmp(conn, empsort);
		close(conn);
		return list;
	}

	public int insertAb(Ab ab) {
		Connection conn = getConnection();
		
		int result = abDao.insertAb(conn, ab);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
	}
	
	public int toDeleteAb(String num) {
		
		Connection conn = getConnection();
		
		int result = abDao.toDeleteAb(conn, num);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
	}
	
	
	public int updateAb(Ab ab) {
		
		Connection conn = getConnection();
		
		int result = abDao.updateAb(conn, ab);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
	}

	public ArrayList<Ab> selectAllPersonalList(String personalsort, String userId) {

		Connection conn = getConnection();
		ArrayList<Ab> list = abDao.selectAllPersonalList(conn, personalsort, userId);
		close(conn);
		return list;
	}

	public ArrayList<Emp> searchEmp(String searchval, String searchkeyword) {
		Connection conn = getConnection();
		ArrayList<Emp> list = abDao.searchEmp(conn, searchval, searchkeyword);
		close(conn);
		return list;
	}

	public ArrayList<Ab> searchAb(String searchval, String searchkeyword) {
		Connection conn = getConnection();
		ArrayList<Ab> list = abDao.searchAb(conn, searchval, searchkeyword);
		close(conn);
		return list;
	}

	public ArrayList<Ab> selectAllDeleteList(String personalsort, String userId) {
		Connection conn = getConnection();
		ArrayList<Ab> list = abDao.selectAllDeleteList(conn, personalsort, userId);
		close(conn);
		return list;
	}

	public int shareToPersonal(String num) {
		Connection conn = getConnection();
		
		int result = abDao.shareToPersonal(conn, num);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
		
	}

	public int deleteAb(String num) {
		Connection conn = getConnection();
		
		int result = abDao.deleteAb(conn, num);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
		
	}

	public int personalToShare(String num) {
		Connection conn = getConnection();
		
		int result = abDao.personalToShare(conn, num);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
		
		
	}

	public Emp empInfo(String userId, int userComNo) {
		
		Connection conn = getConnection();
		
		Emp emp = abDao.empInfo(conn, userId, userComNo);
		close(conn);
		return emp;
		
	}

	public int deleteToPersonalAb(String num) {
		Connection conn = getConnection();
		
		int result = abDao.deleteToPersonalAb(conn, num);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
		
	}

	
	
	
	
	
	
	
	
}
