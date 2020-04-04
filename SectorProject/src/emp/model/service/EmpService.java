package emp.model.service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

import emp.model.dao.EmpDao;
import emp.model.vo.Emp;
import suser.model.vo.Suser;


public class EmpService {

	private EmpDao edao = new EmpDao();
	
	public ArrayList<Emp> selectAll(){
		
		Connection conn = getConnection();
		
		ArrayList<Emp> list = edao.selectAll(conn);
		
		return list;
	}

	
	
	public Emp selectOne(int empId) {
		
		Connection conn = getConnection();
		Emp emp = edao.selectOne(conn, empId);
		close(conn);
		return emp;
		
	}
	
	
	public ArrayList<Emp> searchEmp(int no){
		Connection conn = getConnection();
		
		ArrayList<Emp>list = edao.searchEmp(conn, no);
		
		return list;	
	}

	
	public int changeStatus(String userId, int no) {
		
		Connection conn = getConnection();
		
		int result = edao.changeStatus(conn, userId, no);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}
	
	public int insertEmp(Emp emp) {
		Connection conn = getConnection();
		
		int result = edao.insertEmp(conn, emp);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	//회원가입
	public int insertSuser(Suser suser) {
		
		Connection conn = getConnection();
		
		int result = edao.insertSuser(conn, suser); 
		System.out.println("service suser" + result);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	public ArrayList<Emp> orderBy(String orderType, String keyword){
	
		Connection conn = getConnection();
		
		ArrayList<Emp> list = edao.orderBy(conn, orderType, keyword);
		
		return list;
		
	}
	
	public int updateByEmp(Emp emp) {
		
		Connection conn = getConnection();
		
		int result = edao.updateByEmp(conn, emp);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
	}
	
	public int updateByMaster(Emp emp) {
		
		Connection conn = getConnection();
		
		int result = edao.updateByMaster(conn, emp);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int useVacaction(String user_id, int day) {
		
		Connection conn = getConnection();
		
		int result = edao.useVacaction(conn, user_id, day);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}



	public int updateEmp(Emp emp) {
		// 마스터권한 일반사원 수정
		Connection conn = getConnection();
		int result = edao.updateEmp(conn, emp);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}



	public int updateSuser(Suser suser) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = edao.updateSuser(conn, suser);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}



	/*public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	
	
	
	
	
	
	
	
	
}
