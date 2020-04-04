package alarm.model.service;

import alarm.model.dao.AlarmDao;
import alarm.model.vo.Alarm;
import emp.model.vo.Emp;

import static common.JDBCTemplate.*;

import java.sql.Connection;

public class AlarmService {

	private AlarmDao adao;
	
	
	public int insertAlarm(Alarm alarm) {
		
		Connection conn = getConnection();
		
		int result = adao.insertAlarm(conn, alarm);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	public int updateAlarm(Alarm alarm) {
		
		Connection conn = getConnection();
		
		int result = adao.updateAlarm(conn, alarm);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
	}
	
	
	public int deleteAlarm(int eventNo) {

		Connection conn = getConnection();
		
		int result = adao.deleteAlarm(conn, eventNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
		
	}
	
	
	public Alarm selectOne(int AlarmNo) {
		
		Connection conn = getConnection();
		
		Alarm alarm = adao.selectOne(conn, AlarmNo);
		
		return alarm;
		
	}
	
	
	
	
	
	
	
	
}
