package dev.model.vo;

import java.io.Serializable;

public class Dev implements Serializable{

	private static final long SerialUID = 500L;
	
	private String devId;
	private String devPwd;

	public Dev() {}

	/*public Dev(String devId, String devPwd) {
		super();
		this.devId = devId;
		this.devPwd = devPwd;
	}*/

/*	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getDevPwd() {
		return devPwd;
	}

	public void setDevPwd(String devPwd) {
		this.devPwd = devPwd;
	}

	@Override
	public String toString() {
		return "dev [devId=" + devId + ", devPwd=" + devPwd + "]";
	}*/
}
