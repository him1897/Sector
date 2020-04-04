package doc.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import dept.model.vo.Dept;
import doc.model.dao.DocDao;
import doc.model.vo.Doc;
import emp.model.vo.Emp;

public class DocService {

	private DocDao ddao = new DocDao();
	
	
	//문서번호로 불러오기 
	public Doc selectOne(int docId) {
		
		Connection conn = getConnection();
		Doc doc = ddao.selectOne(conn, docId);
		
		return doc;
		
	}
	
	//전체 문서 불러오기 
	public ArrayList<Doc> selectAll(int curPage){
		
		Connection conn = getConnection();
		ArrayList<Doc> list = ddao.selectAll(conn, curPage);
		
		return list;
		
	}
	
	//새 문서 추가 
	public int insertDoc(Doc doc) {
		
		Connection conn = getConnection();
		int result = ddao.insertDoc(conn, doc);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	//문서 삭제 
	public int deleteDoc(int docId) {
		
		Connection conn = getConnection();
		int result = ddao.deleteDoc(conn, docId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	//문서 수정 
	public int updateDoc(Doc doc) {

		Connection conn = getConnection();
		int result = ddao.updateDoc(conn, doc);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	
	}

	//문서 정렬 옵션 
	public ArrayList<Doc> selectOption(String option, int curPage) {
		Connection conn = getConnection();
		ArrayList<Doc> list = ddao.selectOption(conn, option, curPage);
		
		return list;
	}
	
	//결재선 설정에 사용할 사원 출력 
	public ArrayList<Emp> selectLineEmp(){
		Connection conn = getConnection();
		ArrayList<Emp> list = ddao.selectLineEmp(conn);
		
		return list;
		
	}

	
	public ArrayList<Doc> searchLineEmp(String name) {
		Connection conn = getConnection();
		ArrayList<Doc> list = ddao.searchLineEmp(conn, name);
		
		return list;
	}

	
	//사번으로 사원이름, 부서, 직급이름 사번 리턴 
	public Doc searchEmpById(int empId) {
		
		Connection conn = getConnection();
		Doc doc = ddao.searchEmpById(conn, empId);
		
		return doc;
	}
	
	//file Insert에 쓸 현재 문서번호 불러오기 
	public int maxDocId() {
		int max = 0;
		
		Connection conn= getConnection();
		
		max = ddao.maxDocId(conn);
		
		
		return max;
	}

	//문서 상태 진행으로 변경 
	public int updateStatus(int docId) {

		Connection conn = getConnection();
		int result = ddao.updateStatus(conn, docId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}

	//문서상태 완료로 변경 
	public int statusFinal(int docId) {
		Connection conn = getConnection();
		int result = ddao.stausFinal(conn, docId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	//내 문서함 보기 
	public ArrayList<Doc> selectBox(int empId, String option, int curPage) {
		
		Connection conn = getConnection();
		ArrayList<Doc> list = ddao.selectBox(conn, empId, option, curPage);
		
		return list;
		
	}

	//날짜로 검색 
	public ArrayList<Doc> searchByDate(Date startDate, Date endDate, int curPage) {
		
		Connection conn = getConnection();
		ArrayList<Doc> list = ddao.searchByDate(conn, startDate, endDate, curPage);
		
		return list;
	}

	//문서상태 반려로 변경 
	public int statusReject(int docId) {
		Connection conn = getConnection();
		int result = ddao.stausReject(conn, docId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	
	public String selectjobId(int empId) {
		Connection conn = getConnection();
		String jobId = ddao.searchByDate(conn, empId);
		
		return jobId;
	}

	//내가 쓴 문서 찾기 
	public ArrayList<Doc> docWhoWrite(int curPage, int empId) {
		Connection conn = getConnection();
		ArrayList<Doc> list = ddao.docWhoWrite(conn, curPage, empId);
		
		
		
		return list;
	}

	public ArrayList<Doc> docTopSearchBar(String docName) {
		Connection conn = getConnection();
		ArrayList<Doc> list = ddao.docTopSearchBar(conn, docName);
		
		
		
		return list;
	}

	
	
	
	
}
