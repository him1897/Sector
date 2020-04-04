package post.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Post implements Serializable {

	private static final long SerialUID = 1100L;
	
	   private int postId;
	   private String postTitle;
	   private Date postDate;
	   private String postContent;
	   private String notice;
	   private int boardId;
	   private String boardName;
	   private int empId;
	   private String writer;
	   private String postOriginalFileName;
	   private String postRenameFileName;
	   
	   public Post() {}

	public Post(int postId, String postTitle, Date postDate, String postContent, String notice, int boardId,
			String boardName, int empId, String writer, String postOriginalFileName, String postRenameFileName) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.postContent = postContent;
		this.notice = notice;
		this.boardId = boardId;
		this.boardName = boardName;
		this.empId = empId;
		this.writer = writer;
		this.postOriginalFileName = postOriginalFileName;
		this.postRenameFileName = postRenameFileName;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPostOriginalFileName() {
		return postOriginalFileName;
	}

	public void setPostOriginalFileName(String postOriginalFileName) {
		this.postOriginalFileName = postOriginalFileName;
	}

	public String getPostRenameFileName() {
		return postRenameFileName;
	}

	public void setPostRenameFileName(String postRenameFileName) {
		this.postRenameFileName = postRenameFileName;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postDate=" + postDate + ", postContent="
				+ postContent + ", notice=" + notice + ", boardId=" + boardId + ", boardName=" + boardName + ", empId="
				+ empId + ", writer=" + writer + ", postOriginalFileName=" + postOriginalFileName
				+ ", postRenameFileName=" + postRenameFileName + "]";
	}

	   
	   
}
