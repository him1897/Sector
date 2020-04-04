package event.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Event implements Serializable {

	
private static final long SerialUID = 700L;
	
	public Event() {}
	
	
	private int eventId;
	private String eventName;
	private Date eventStart;
	private Date eventEnd;
	private char enentShare;
	private String calName;
	private String calColor;
	private int empId;

	
	
	/*public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventStart() {
		return eventStart;
	}
	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}
	public Date getEventEnd() {
		return eventEnd;
	}
	public void setEventEnd(Date eventEnd) {
		this.eventEnd = eventEnd;
	}
	public char getEnentShare() {
		return enentShare;
	}
	public void setEnentShare(char enentShare) {
		this.enentShare = enentShare;
	}
	public String getCalName() {
		return calName;
	}
	public void setCalName(String calName) {
		this.calName = calName;
	}
	public String getCalColor() {
		return calColor;
	}
	public void setCalColor(String calColor) {
		this.calColor = calColor;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Doc [eventId=" + eventId + ", eventName=" + eventName + ", eventStart=" + eventStart + ", eventEnd="
				+ eventEnd + ", enentShare=" + enentShare + ", calName=" + calName + ", calColor=" + calColor
				+ ", empId=" + empId + "]";
	}*/
}
