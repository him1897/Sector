package alarm.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Alarm implements Serializable{

	public Alarm() {}
	
	private static final long SerialUID = 200L;
	
	private int alarmId;
	private Date alarmTime;
	private int eventId;
	
	
	/*public int getAlarmId() {
		return alarmId;
	}
	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}
	public Date getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	@Override
	public String toString() {
		return "Alarm [alarmId=" + alarmId + ", alarmTime=" + alarmTime + ", eventId=" + eventId + "]";
	}*/
	
	
}
