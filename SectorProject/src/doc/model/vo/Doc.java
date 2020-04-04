package doc.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Doc implements Serializable {

	private static final long SerialUID = 600L;
	
	private int docId;
	   private String docType;
	   private String docTitle;
	   private String docContent;
	   private String docLevel;
	   private Date docSaveStart;
	   private Date docSaveEnd;
	   private Date docStart;
	   private Date docEnd;
	   private String docStatus;
	   private int docBoxId;
	   private int docWriter; //작성자 사번 
	   private int lineNo;
	  
	   
	   private String lineEmp;
	   private int docYear; // 몇년후까지 보존할지 년수 
	   
	   
	   private String empName; //작성자 사원이름 
	   private String jobName; //작성자 직급이름 
	   private String deptName; //작성자 부서이름 
	   private int empId; //작성자 사번
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	public String getDocContent() {
		return docContent;
	}
	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}
	public String getDocLevel() {
		return docLevel;
	}
	public void setDocLevel(String docLevel) {
		this.docLevel = docLevel;
	}
	public Date getDocSaveStart() {
		return docSaveStart;
	}
	public void setDocSaveStart(Date docSaveStart) {
		this.docSaveStart = docSaveStart;
	}
	public Date getDocSaveEnd() {
		return docSaveEnd;
	}
	public void setDocSaveEnd(Date docSaveEnd) {
		this.docSaveEnd = docSaveEnd;
	}
	public Date getDocStart() {
		return docStart;
	}
	public void setDocStart(Date docStart) {
		this.docStart = docStart;
	}
	public Date getDocEnd() {
		return docEnd;
	}
	public void setDocEnd(Date docEnd) {
		this.docEnd = docEnd;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	public int getDocBoxId() {
		return docBoxId;
	}
	public void setDocBoxId(int docBoxId) {
		this.docBoxId = docBoxId;
	}
	public int getDocWriter() {
		return docWriter;
	}
	public void setDocWriter(int docWriter) {
		this.docWriter = docWriter;
	}
	public int getLineNo() {
		return lineNo;
	}
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	public String getLineEmp() {
		return lineEmp;
	}
	public void setLineEmp(String lineEmp) {
		this.lineEmp = lineEmp;
	}
	public int getDocYear() {
		return docYear;
	}
	public void setDocYear(int docYear) {
		this.docYear = docYear;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Doc [docId=" + docId + ", docType=" + docType + ", docTitle=" + docTitle + ", docContent=" + docContent
				+ ", docLevel=" + docLevel + ", docSaveStart=" + docSaveStart + ", docSaveEnd=" + docSaveEnd
				+ ", docStart=" + docStart + ", docEnd=" + docEnd + ", docStatus=" + docStatus + ", docBoxId="
				+ docBoxId + ", docWriter=" + docWriter + ", lineNo=" + lineNo + ", lineEmp=" + lineEmp + ", docYear="
				+ docYear + ", empName=" + empName + ", jobName=" + jobName + ", deptName=" + deptName + ", empId="
				+ empId + "]";
	}
	   
	   
	


	
	   

}
