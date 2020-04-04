package event.model.service;

import event.model.dao.EventDao;
import event.model.vo.Event;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import emp.model.vo.Emp;

public class EventService {

	private EventDao edao;
	
 
	
	
	public Event selectOne(int eventId) {
		
		Connection conn = getConnection();
		Event event = edao.selectOne(conn, eventId);
		
		return event;
		
	}
	
	
	public ArrayList<Event> searchEvent(String eventName){
		//일정이름으로 검색 
		
		Connection conn = getConnection();
		
		ArrayList<Event>list = edao.searchEvent(conn, eventName);
		
		return list;	
	}
	
	public int insertEvent(Event event) {
		Connection conn = getConnection();
		
		int result = edao.insertEvent(conn, event);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int DeleteEvent(int eventId) {
		Connection conn = getConnection();
		
		int result = edao.deleteEvent(conn, eventId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int updateEvent(Event event) {
		
		Connection conn = getConnection();
		
		int result = edao.updateEvent(conn, event);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
	}
	
	
}
