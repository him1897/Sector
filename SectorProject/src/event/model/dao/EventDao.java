package event.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import emp.model.vo.Emp;
import event.model.vo.Event;

public class EventDao {

	public Event selectOne(Connection conn, int eventId) {
		
		Event event = null;
		
		return event;
	}

	public ArrayList<Event> searchEvent(Connection conn, String eventName) {
		
		ArrayList<Event> list = null;
		
		
		return list;
		
		
	}

	public int insertEvent(Connection conn, Event event) {
		
		int result = 0;
		
		
		return result;
	}

	public int deleteEvent(Connection conn, int eventNo) {
		int result = 0;
		
		
		return result;
	}

	public int updateEvent(Connection conn, Event event) {
		int result = 0;
		
		
		return result;
	}

	

	
}
