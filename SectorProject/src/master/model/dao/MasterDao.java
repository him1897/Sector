package master.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import event.model.vo.Event;
import master.model.vo.Master;

public class MasterDao {

	public Master selectOne(Connection conn, int masterComNo) {

		Master master = null;
		
		return master;
	}


	public int insertMaster(Connection conn, Master master) {
		
		int result = 0;
		
		
		return result;
	}

	public int deleteMaster(Connection conn, String masterId) {
		int result= 0;
		
		
		return result;
	}

	public int updateEvent(Connection conn, Master master) {
		
		int result = 0;
		
		return result;
	}

	public ArrayList<Master> selectAll(Connection conn) {

		ArrayList<Master> list = null;
		
		return list;
	}


	public Master searchMaster(Connection conn, String masterId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
