package suser.model.vo;

import java.io.Serializable;

public class Suser implements Serializable{

	
	private static final long SerialUID = 1500L;
	
	   private String userId;
	   public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	private String userPwd;
	   private String userName;
	   private String ident;
	   private int userComNo;
	   private String userMaster;
	   private int EmpId;
	   private String userSign;
	   private String jobId;
	   
	   
	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public Suser() {}

	   public Suser(String userId, String userPwd, String userName, String ident, int userComNo, String userMaster, int EmpId, String userSign) {
	      super();
	      this.userId = userId;
	      this.userPwd = userPwd;
	      this.userName = userName;
	      this.ident = ident;
	      this.userComNo = userComNo;
	      this.userMaster = userMaster;
	      this.EmpId = EmpId;
	      this.userSign = userSign;
	   }

	   public String getUserId() {
	      return userId;
	   }

	   public void setUserId(String userId) {
	      this.userId = userId;
	   }

	   public String getUserPwd() {
	      return userPwd;
	   }

	   public void setUserPwd(String userPwd) {
	      this.userPwd = userPwd;
	   }

	   public String getUserName() {
	      return userName;
	   }

	   public void setUserName(String userName) {
	      this.userName = userName;
	   }

	   public String getIdent() {
	      return ident;
	   }

	   public void setIdent(String ident) {
	      this.ident = ident;
	   }

	   public int getUserComNo() {
	      return userComNo;
	   }

	   public void setUserComNo(int userComNo) {
	      this.userComNo = userComNo;
	   }

	   public String getUserMaster() {
		   return userMaster;
	   }
	   
	   public void setUserMaster(String userMaster) {
		   this.userMaster = userMaster;
	   }
	   public int getEmpId() {
		   return EmpId;
	   }
	   
	   public void setEmpId(int empId) {
		   EmpId = empId;
	   }
	   
	   @Override
	   public String toString() {
	      return "Suser [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", ident=" + ident
	            + ", userComNo=" + userComNo + "userMaster" + userMaster + "EmpId" + EmpId + "userSign" + userSign +"]";
	   }
	   
	   

}
