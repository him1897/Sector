package ab.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Ab implements Serializable{

	private static final long SerialUID = 100L;
	
	private String abCom;
	private String abPhone;
	private String abName;
	private String abJobName;
	private String abEmail;
	private String abAddress;
	private Date abAnniDate;
	private String abAnniName;
	private int abEmpId;
	private String abGroup;
	private int abRowNum;
	private int abWriterCom;
	private String abDeptId;
	
	
	public Ab() {}


	public Ab(String abCom, String abPhone, String abName, String abJobName, String abEmail, String abAddress,
			Date abAnniDate, String abAnniName, int abEmpId, String abGroup, int abRowNum, int abWriterCom,
			String abDeptId) {
		super();
		this.abCom = abCom;
		this.abPhone = abPhone;
		this.abName = abName;
		this.abJobName = abJobName;
		this.abEmail = abEmail;
		this.abAddress = abAddress;
		this.abAnniDate = abAnniDate;
		this.abAnniName = abAnniName;
		this.abEmpId = abEmpId;
		this.abGroup = abGroup;
		this.abRowNum = abRowNum;
		this.abWriterCom = abWriterCom;
		this.abDeptId = abDeptId;
	}


	public String getAbCom() {
		return abCom;
	}


	public void setAbCom(String abCom) {
		this.abCom = abCom;
	}


	public String getAbPhone() {
		return abPhone;
	}


	public void setAbPhone(String abPhone) {
		this.abPhone = abPhone;
	}


	public String getAbName() {
		return abName;
	}


	public void setAbName(String abName) {
		this.abName = abName;
	}


	public String getAbJobName() {
		return abJobName;
	}


	public void setAbJobName(String abJobName) {
		this.abJobName = abJobName;
	}


	public String getAbEmail() {
		return abEmail;
	}


	public void setAbEmail(String abEmail) {
		this.abEmail = abEmail;
	}


	public String getAbAddress() {
		return abAddress;
	}


	public void setAbAddress(String abAddress) {
		this.abAddress = abAddress;
	}


	public Date getAbAnniDate() {
		return abAnniDate;
	}


	public void setAbAnniDate(Date abAnniDate) {
		this.abAnniDate = abAnniDate;
	}


	public String getAbAnniName() {
		return abAnniName;
	}


	public void setAbAnniName(String abAnniName) {
		this.abAnniName = abAnniName;
	}


	public int getAbEmpId() {
		return abEmpId;
	}


	public void setAbEmpId(int abEmpId) {
		this.abEmpId = abEmpId;
	}


	public String getAbGroup() {
		return abGroup;
	}


	public void setAbGroup(String abGroup) {
		this.abGroup = abGroup;
	}


	public int getAbRowNum() {
		return abRowNum;
	}


	public void setAbRowNum(int abRowNum) {
		this.abRowNum = abRowNum;
	}


	public int getAbWriterCom() {
		return abWriterCom;
	}


	public void setAbWriterCom(int abWriterCom) {
		this.abWriterCom = abWriterCom;
	}


	public String getAbDeptId() {
		return abDeptId;
	}


	public void setAbDeptId(String abDeptId) {
		this.abDeptId = abDeptId;
	}


	public static long getSerialuid() {
		return SerialUID;
	}


	@Override
	public String toString() {
		return "Ab [abCom=" + abCom + ", abPhone=" + abPhone + ", abName=" + abName + ", abJobName=" + abJobName
				+ ", abEmail=" + abEmail + ", abAddress=" + abAddress + ", abAnniDate=" + abAnniDate + ", abAnniName="
				+ abAnniName + ", abEmpId=" + abEmpId + ", abGroup=" + abGroup + ", abRowNum=" + abRowNum
				+ ", abWriterCom=" + abWriterCom + ", abDeptId=" + abDeptId + "]";
	}

	
	
	
	
	
	
}
