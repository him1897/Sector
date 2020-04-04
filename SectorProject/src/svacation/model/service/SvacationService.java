package svacation.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import dept.model.vo.Dept;
import svacation.model.dao.SvacationDao;
import svacation.model.vo.Svacation;

public class SvacationService {

	private SvacationDao sdao;
	
	
	public Dept selectOne(String vacId) {
		
		Connection conn = getConnection();
		Dept dept = sdao.selectOne(conn, vacId);
		
		return dept;
		
	}
	
	public ArrayList<Svacation> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Svacation>list = sdao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertDept(Svacation svacation) {
		
		Connection conn = getConnection();
		int result = sdao.insertVac(conn, svacation);
		
		return result;
	}
	
	public int deleteDept(int vacId) {
		
		Connection conn = getConnection();
		int result = sdao.deleteVac(conn, vacId);
		
		return result;
	}
	
	public int updateDept(int vacId) {
		
		Connection conn = getConnection();
		int result = sdao.updateVac(conn, vacId);
		
		return result;
	}
}
