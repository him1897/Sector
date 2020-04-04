package comm.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Comm implements Serializable {

	private static final long SerialUID = 300L;
	
	private int commId;
	   private String commContent;
	   private Date commDate;
	   private int postId;
	   
	   
	   
	   public Comm() {}

	   /*public Comm(int commId, String commContent, Date commDate, int postId) {
	      super();
	      this.commId = commId;
	      this.commContent = commContent;
	      this.commDate = commDate;
	      this.postId = postId;
	   }

	   public int getCommId() {
	      return commId;
	   }

	   public void setCommId(int commId) {
	      this.commId = commId;
	   }

	   public String getCommContent() {
	      return commContent;
	   }

	   public void setCommContent(String commContent) {
	      this.commContent = commContent;
	   }

	   public Date getCommDate() {
	      return commDate;
	   }

	   public void setCommDate(Date commDate) {
	      this.commDate = commDate;
	   }

	   public int getPostId() {
	      return postId;
	   }

	   public void setPostId(int postId) {
	      this.postId = postId;
	   }

	   @Override
	   public String toString() {
	      return "Comm [commId=" + commId + ", commContent=" + commContent + ", commDate=" + commDate + ", postId="
	            + postId + "]";
	   }
	   
	   */
}
