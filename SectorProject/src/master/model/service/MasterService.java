package master.model.service;

import master.model.dao.MasterDao;
import master.model.vo.Master;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import event.model.vo.Event;

public class MasterService {

	
	private MasterDao mdao;
	
	
	//클릭할떄 
	public Master selectOne(int masterComNo) {
		
		Connection conn = getConnection();
		
		Master master = mdao.selectOne(conn, masterComNo);
		
		return master;
		
	}
	
	//검색할떄 
	
	public Master searchMaster(String masterId) {
		
		Connection conn = getConnection();
		
		Master master = mdao.searchMaster(conn, masterId);
		
		return master;
		
	}
	
	public ArrayList<Master> selectAll() {
		
		Connection conn = getConnection();
		
		ArrayList<Master> list = mdao.selectAll(conn);
		
		
		return list;
		
	}
			
	public int insertMaster(Master master) {
		Connection conn = getConnection();
		
		int result = mdao.insertMaster(conn, master);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	public int DeleteMaster(String masterId) {
		Connection conn = getConnection();
		
		int result = mdao.deleteMaster(conn, masterId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	public int updateEvent(Master master) {
		
		Connection conn = getConnection();
		
		int result = mdao.updateEvent(conn, master);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
	}
	
	
	
	
	
	
	
}
