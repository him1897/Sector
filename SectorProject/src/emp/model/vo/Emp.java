package emp.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Emp implements Serializable {

private static final long SerialUID = 30L;
	
	
	private int empId;
	private String empName;
	private String userId;
	private String deptId;
	private String jobId;
	private String empPhone;
	private String empEmail;
	private String empNo;
	private String empAddress;
	private int salary;
	private double bonusPct;
	private Date hireDate;
	private int vacation;
	private String marriage;
	private int masterComNo;
	private int rowNum;
	private	String ident;
	

	public Emp() {}

	public Emp(int empId, String empName, String userId, String deptId, String jobId, String empPhone, String empEmail,
			String empNo, String empAddress, int salary, double bonusPct, Date hireDate, int vacation, String marriage,
			int masterComNo, int rowNum, String iDent) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.userId = userId;
		this.deptId = deptId;
		this.jobId = jobId;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.empNo = empNo;
		this.empAddress = empAddress;
		this.salary = salary;
		this.bonusPct = bonusPct;
		this.hireDate = hireDate;
		this.vacation = vacation;
		this.marriage = marriage;
		this.masterComNo = masterComNo;
		this.rowNum = rowNum;
		this.ident = iDent; 
	}

	public String getIdent() {
		return ident;
	}
	
	public void setIdent(String ident) {
		this.ident = ident;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonusPct() {
		return bonusPct;
	}

	public void setBonusPct(double bonusPct) {
		this.bonusPct = bonusPct;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getVacation() {
		return vacation;
	}

	public void setVacation(int vacation) {
		this.vacation = vacation;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public int getMasterComNo() {
		return masterComNo;
	}

	public void setMasterComNo(int masterComNo) {
		this.masterComNo = masterComNo;
	}

	public static long getSerialuid() {
		return SerialUID;
	}
	
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	
	public int getRowNum() {
		return rowNum;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", userId=" + userId + ", deptId=" + deptId + ", jobId="
				+ jobId + ", empPhone=" + empPhone + ", empEmail=" + empEmail + ", empNo=" + empNo + ", empAddress="
				+ empAddress + ", salary=" + salary + ", bonusPct=" + bonusPct + ", hireDate=" + hireDate
				+ ", vacation=" + vacation + ", marriage=" + marriage + ", masterComNo=" + masterComNo + ", rowNum="
				+ rowNum + ", ident=" + ident + "]";
	}


	
	
}
