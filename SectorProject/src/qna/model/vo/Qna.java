package qna.model.vo;

import java.io.Serializable;

public class Qna implements Serializable {

	private static final long SerialUID = 1200L;
	
	private int qnaId;
	   private String qnaTitle;
	   private String qnaContent;
	   private String qnaWriter;
	   
	   public Qna() {}
	   
	   /*public Qna(int qnaId, String qnaTitle, String qnaContent, String qnaWriter) {
	      super();
	      this.qnaId = qnaId;
	      this.qnaTitle = qnaTitle;
	      this.qnaContent = qnaContent;
	      this.qnaWriter = qnaWriter;
	   }

	   public int getQnaId() {
	      return qnaId;
	   }

	   public void setQnaId(int qnaId) {
	      this.qnaId = qnaId;
	   }

	   public String getQnaTitle() {
	      return qnaTitle;
	   }

	   public void setQnaTitle(String qnaTitle) {
	      this.qnaTitle = qnaTitle;
	   }

	   public String getQnaContent() {
	      return qnaContent;
	   }

	   public void setQnaContent(String qnaContent) {
	      this.qnaContent = qnaContent;
	   }

	   public String getQnaWriter() {
	      return qnaWriter;
	   }

	   public void setQnaWriter(String qnaWriter) {
	      this.qnaWriter = qnaWriter;
	   }

	   @Override
	   public String toString() {
	      return "Qna [qnaId=" + qnaId + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaWriter="
	            + qnaWriter + "]";
	   }
	   
	   */
	
}
