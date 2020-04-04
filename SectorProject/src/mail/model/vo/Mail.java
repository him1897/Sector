package mail.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Mail implements Serializable {

	private static final long SerialUID = 900L;
	
	private int mailId;
	private int mailWriter;
	private int mailReceiver;
	private String mailTitle;
	private String mailCon;
	private Date mailDate;
	private char mailImp;
	private int mailBoxNo;
	private String mailBoxName;
	
	public Mail() {}

	/*public Mail(int mailId, int mailWriter, int mailReceiver, String mailTitle, String mailCon, Date mailDate,
			char mailImp, int mailBoxNo, String mailBoxName) {
		super();
		this.mailId = mailId;
		this.mailWriter = mailWriter;
		this.mailReceiver = mailReceiver;
		this.mailTitle = mailTitle;
		this.mailCon = mailCon;
		this.mailDate = mailDate;
		this.mailImp = mailImp;
		this.mailBoxNo = mailBoxNo;
		this.mailBoxName = mailBoxName;
	}*/

/*	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public int getMailWriter() {
		return mailWriter;
	}

	public void setMailWriter(int mailWriter) {
		this.mailWriter = mailWriter;
	}

	public int getMailReceiver() {
		return mailReceiver;
	}

	public void setMailReceiver(int mailReceiver) {
		this.mailReceiver = mailReceiver;
	}

	public String getMailTitle() {
		return mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	public String getMailCon() {
		return mailCon;
	}

	public void setMailCon(String mailCon) {
		this.mailCon = mailCon;
	}

	public Date getMailDate() {
		return mailDate;
	}

	public void setMailDate(Date mailDate) {
		this.mailDate = mailDate;
	}

	public char getMailImp() {
		return mailImp;
	}

	public void setMailImp(char mailImp) {
		this.mailImp = mailImp;
	}

	public int getMailBoxNo() {
		return mailBoxNo;
	}

	public void setMailBoxNo(int mailBoxNo) {
		this.mailBoxNo = mailBoxNo;
	}

	public String getMailBoxName() {
		return mailBoxName;
	}

	public void setMailBoxName(String mailBoxName) {
		this.mailBoxName = mailBoxName;
	}

	@Override
	public String toString() {
		return "Mail [mailId=" + mailId + ", mailWriter=" + mailWriter + ", mailReceiver=" + mailReceiver
				+ ", mailTitle=" + mailTitle + ", mailCon=" + mailCon + ", mailDate=" + mailDate + ", mailImp="
				+ mailImp + ", mailBoxNo=" + mailBoxNo + ", mailBoxName=" + mailBoxName + "]";
	}
	
	*/


}
