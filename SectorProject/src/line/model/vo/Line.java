package line.model.vo;

import java.io.Serializable;

public class Line implements Serializable {

	private static final long SerialUID = 800L;
	
	
	
	 private int lineNo;
	   private String lineName;
	  
	   private String first;
	   private String second;
	   private String third;
	   private String fourth;
	   private String fifth;
	   private String sixth;
	   private String seventh;
	   
	   
	 

	@Override
	public String toString() {
		return "Line [lineNo=" + lineNo + ", lineName=" + lineName + ", first=" + first + ", second=" + second
				+ ", third=" + third + ", fourth=" + fourth + ", fifth=" + fifth + ", sixth=" + sixth + ", seventh="
				+ seventh + "]";
	}




	public int getLineNo() {
		return lineNo;
	}




	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}




	public String getLineName() {
		return lineName;
	}




	public void setLineName(String lineName) {
		this.lineName = lineName;
	}




	public String getFirst() {
		return first;
	}




	public void setFirst(String first) {
		this.first = first;
	}




	public String getSecond() {
		return second;
	}




	public void setSecond(String second) {
		this.second = second;
	}




	public String getThird() {
		return third;
	}




	public void setThird(String third) {
		this.third = third;
	}




	public String getFourth() {
		return fourth;
	}




	public void setFourth(String fourth) {
		this.fourth = fourth;
	}




	public String getFifth() {
		return fifth;
	}




	public void setFifth(String fifth) {
		this.fifth = fifth;
	}




	public String getSixth() {
		return sixth;
	}




	public void setSixth(String sixth) {
		this.sixth = sixth;
	}




	public String getSeventh() {
		return seventh;
	}




	public void setSeventh(String seventh) {
		this.seventh = seventh;
	}




	public Line() {}

	   
	   
	   

}
