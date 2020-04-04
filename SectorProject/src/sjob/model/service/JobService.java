package sjob.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import dept.model.vo.Dept;
import sjob.model.dao.JobDao;
import sjob.model.vo.Sjob;

public class JobService {

	private JobDao jdao;
	
	
	public Sjob selectOne(String jobId) {
		
		Connection conn = getConnection();
		Sjob sjob = jdao.selectOne(conn, jobId);
		
		return sjob;
		
	}
	
	public ArrayList<Sjob> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Sjob>list = jdao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertJob(Sjob sjob) {
		
		Connection conn = getConnection();
		int result = jdao.insertJob(conn, sjob);
		
		return result;
	}
	
	public int deleteDept(int jobId) {
		
		Connection conn = getConnection();
		int result = jdao.deleteJob(conn, jobId);
		
		return result;
	}
	
	public int updateDept(int jobId) {
		
		Connection conn = getConnection();
		int result = jdao.updateJob(conn, jobId);
		
		return result;
	}
	
}
