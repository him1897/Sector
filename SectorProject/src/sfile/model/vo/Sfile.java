package sfile.model.vo;

import java.io.Serializable;

public class Sfile implements Serializable{

	
	private static final long SerialUID = 1300L;
	
	private int fileSize;
	   private String originalFileName;
	   private String RenameFileName;
	   private String docId;
	   private String mailId;
	   private String postId;
	   
	   public Sfile() {}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenameFileName() {
		return RenameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		RenameFileName = renameFileName;
	}

	@Override
	public String toString() {
		return "Sfile [fileSize=" + fileSize + ", originalfileName=" + originalFileName + ", RenameFilePath="
				+ RenameFileName + ", docId=" + docId + ", mailId=" + mailId + ", postId=" + postId + "]";
	}

	   
	   
	   
	
	   

	
}
