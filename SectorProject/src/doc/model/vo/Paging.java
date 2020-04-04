package doc.model.vo;

import java.sql.Date;

import doc.model.dao.DocDao;

public class Paging {

	private final static int pageCount = 5 ; //한 그룹은 5개씩임 
	private int blockStartNum = 0; //1~5페이지가 한그룹이라면 1임 
	private int blockLastNum = 0; //1~5페이지가 한그룹이라면 5임 
	private int lastPageNum = 0;  // 통틀어서 6페이지까지 있다면 6임 
	
	
	public int getBlockStartNum() {
		return blockStartNum;
	}
	public void setBlockStartNum(int bolckStartNum) {
		this.blockStartNum = bolckStartNum;
	}
	public int getBlockLastNum() {
		return blockLastNum;
	}
	public void setBlockLastNum(int blockLastNum) {
		this.blockLastNum = blockLastNum;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	public static int getPagecount() {
		return pageCount;
	}
	
	
	//block을 생성 
	//현재 페이지가 속한 block의 시작번호, 끝번호를 계산 
	//여기서 block이란 1~5page가 속해있는 그룹을 의미함 
	
	public void makeBlock(int curPage) {
		int blockNum = 0;
		
		blockNum = (int)Math.floor((curPage-1)/ pageCount);
		 
		blockStartNum = (pageCount * blockNum) + 1;
	    blockLastNum = blockStartNum + (pageCount-1);
	}
	
	
	// 총 페이지의 마지막 번호
    public void makeLastPageNum(String option) {
    	
        DocDao dao = new DocDao();
        
        
        int total = dao.getCount(option);

        
        
        if( total % (pageCount*2) == 0 ) {
            lastPageNum = (int)Math.floor(total/(pageCount*2));
        }
        else {
            lastPageNum = (int)Math.floor(total/(pageCount*2)) + 1;
        }
      
    }
    
    public void makeLastPageNum(int empId, String option) {
    	

        DocDao dao = new DocDao();
        
        
        int total = dao.getCount(empId, option);

        
        
        if( total % (pageCount*2) == 0 ) {
            lastPageNum = (int)Math.floor(total/(pageCount*2));
        }
        else {
            lastPageNum = (int)Math.floor(total/(pageCount*2)) + 1;
        }
    }
    
    
   //총 페이지의 마지막 번호 날짜 검색용 
	public void makeLastPageNum(Date startDate, Date endDate) {
		
		DocDao dao = new DocDao();

        int total = dao.getCountByDate(startDate, endDate);
        
        if( total % (pageCount*2) == 0 ) {
            lastPageNum = (int)Math.floor(total/(pageCount*2));
        }
        else {
            lastPageNum = (int)Math.floor(total/(pageCount*2)) + 1;
        }

		
	}
	public void makeLastPageNumByEmpId(int empId) {
		DocDao dao = new DocDao();

        int total = dao.getCountByEmpId(empId);
        
        
        
        if( total % (pageCount*2) == 0 ) {
            lastPageNum = (int)Math.floor(total/(pageCount*2));
        }
        else {
            lastPageNum = (int)Math.floor(total/(pageCount*2)) + 1;
        }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
