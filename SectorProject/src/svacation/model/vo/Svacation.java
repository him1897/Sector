package svacation.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Svacation implements Serializable {

	
	private static final long SerialUID = 1600L;
	
	 private int vacId;
	   private String vacType;
	   private Date vacStart;
	   private Date vacEnd;
	   private int vacWriter;
	   private int varPermit;
	   
	   public Svacation() {}

	   
	  /* public Svacation(int vacId, String vacType, Date vacStart, Date vacEnd, int vacWriter, int varPermit) {
	      super();
	      this.vacId = vacId;
	      this.vacType = vacType;
	      this.vacStart = vacStart;
	      this.vacEnd = vacEnd;
	      this.vacWriter = vacWriter;
	      this.varPermit = varPermit;
	   }

	   public int getVacId() {
	      return vacId;
	   }

	   public void setVacId(int vacId) {
	      this.vacId = vacId;
	   }

	   public String getVacType() {
	      return vacType;
	   }

	   public void setVacType(String vacType) {
	      this.vacType = vacType;
	   }

	   public Date getVacStart() {
	      return vacStart;
	   }

	   public void setVacStart(Date vacStart) {
	      this.vacStart = vacStart;
	   }

	   public Date getVacEnd() {
	      return vacEnd;
	   }

	   public void setVacEnd(Date vacEnd) {
	      this.vacEnd = vacEnd;
	   }

	   public int getVacWriter() {
	      return vacWriter;
	   }

	   public void setVacWriter(int vacWriter) {
	      this.vacWriter = vacWriter;
	   }

	   public int getVarPermit() {
	      return varPermit;
	   }

	   public void setVarPermit(int varPermit) {
	      this.varPermit = varPermit;
	   }

	   @Override
	   public String toString() {
	      return "svacation [vacId=" + vacId + ", vacType=" + vacType + ", vacStart=" + vacStart + ", vacEnd=" + vacEnd
	            + ", vacWriter=" + vacWriter + ", varPermit=" + varPermit + "]";
	   }*/
	
}
