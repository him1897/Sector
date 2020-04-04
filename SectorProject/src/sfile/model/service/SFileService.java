package sfile.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import dept.model.vo.Dept;
import sfile.model.dao.SFileDao;
import sfile.model.vo.Sfile;

public class SFileService {

	private SFileDao fdao = new SFileDao();
	
	public Sfile selectOneByDoc(int docId) {
		Connection conn = getConnection();
		
		Sfile sfile = fdao.selectOneByDoc(conn,docId);
		
		return sfile;
		
	}
	
	public Sfile selectOne(int fileId) {
		
		Connection conn = getConnection();
		Sfile sfile = fdao.selectOne(conn, fileId);
		
		return sfile;
		
	}
	
	public ArrayList<Sfile> selectAll(){
		
		Connection conn = getConnection();
		ArrayList<Sfile>list = fdao.selectAll(conn);
		
		return list;
		
	}
	
	public int insertSfile(Sfile sfile) {
		
		Connection conn = getConnection();
		int result = fdao.insertSfile(conn, sfile);
		
		
		if(result > 0) {
			
			commit(conn);
			
		}else {
			rollback(conn);
		}
		
		
		return result;
	}
	
	public int deleteSfile(int fileId) {
		
		Connection conn = getConnection();
		int result = fdao.deleteSfile(conn, fileId);
		
		return result;
	}
	
	public int updateSfile(int fileId) {
		
		Connection conn = getConnection();
		int result = fdao.updateSfile(conn, fileId);
		
		return result;
	}
	
}
