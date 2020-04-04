package dept.model.service;

import dept.model.dao.DeptDao;
import dept.model.vo.Dept;
import qna.model.vo.Qna;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class DeptService {

	private DeptDao ddao;

	
  public Dept selectOne(String deptId) {
		
		Connection conn = getConnection();
		Dept dept = ddao.selectOne(conn, deptId);
		
		return dept;
		
	}
	
	public ArrayList<Dept> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Dept>list = ddao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertDept(Dept dept) {
		
		Connection conn = getConnection();
		int result = ddao.insertDept(conn, dept);
		
		return result;
	}
	
	public int deleteDept(String deptId) {
		
		Connection conn = getConnection();
		int result = ddao.deleteDept(conn, deptId);
		
		return result;
	}
	
	public int updateDept(String deptId) {
		
		Connection conn = getConnection();
		int result = ddao.updateDept(conn, deptId);
		
		return result;
	}
}
