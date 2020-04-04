<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="suser.model.vo.Suser, emp.model.vo.Emp, java.util.ArrayList, java.sql.Date" %>  
<%
    Suser loginMember = (Suser)session.getAttribute("loginMember");
%> 
<!-- ArrayList<Emp> emplist = (ArrayList<Emp>)request.getAttribute("list"); -->
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/sector/resources/css/style.css">
<title>Insert title here</title>
<style type="text/css">
	#userList td{
		text-align:center;
		}
</style>
</head>
<body>
<h2><a style="margin: 5%;" href="" id="userAll" onclick="list();">전체 사원 조회</a>
</h2>
<div id="tableform">
        <table class="table table-hover" id="userList">
       <thead>
       <tr>
      <th scope="col" style="text-align: center">사번</th>
      <th scope="col" style="text-align: center">이름</th>
      <th scope="col" style="text-align: center">부서코드</th>
      <th scope="col" style="text-align: center">직급코드</th>
      <th scope="col" style="text-align: center">전화번호</th>
      <th scope="col" style="text-align: center">이메일</th>
      <th scope="col" style="text-align: center">주소</th>
      <th scope="col" style="text-align: center">인증여부</th>
        </tr>
        </thead>
      </table>
 </div>
<h2>
<!-- <a style="float:left; margin-left: 40%;" href="#" id="btn-No" onclick="history.back(-1);">수정완료</a> -->
<a style="float:right; margin-right: 50%;" href="#" id="btn-No" onclick="history.back(-1)">돌아가기</a>
</h2>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous" type="text/javascript">
    </script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      
    <script type="text/javascript">
        var table = "<tr>" +
       "<th scope='col' style='text-align: center'>사번</th>" +
       "<th scope='col' style='text-align: center'>이름</th>" +
       "<th scope='col' style='text-align: center'>부서코드</th>" +
       "<th scope='col' style='text-align: center'>직급코드</th>" +
       "<th scope='col' style='text-align: center'>전화번호</th>" +
       "<th scope='col' style='text-align: center'>이메일</th>" +
       "<th scope='col' style='text-align: center'>주소</th>" +
       "<th scope='col' style='text-align: center'>인증여부</th>" +
        "</tr>";
        
    	var nana;
        function list() {
			$.ajax({
				//function 실행시 실행할 servlet
				url: "/sector/saeas",
				//get방식 post방식
				type: "get",
				
				
				//데이터 타입 json
				dataType: "json",
				//에러없이 성공할 때 실행 될 function
				success: function(data){
					console.log("saeas request success : ");
					//객체를 문자열로 변환 처리함
					var jsonStr = JSON.stringify(data);
					//문자열을 배열 객체로 바꿈
					var json = JSON.parse(jsonStr);
					var values = "";
					for(var i in json.list){
						values += "<tr><td>" + json.list[i].empId + "</td><td><a href='/sector/eds?empid=" 
						+ json.list[i].empId + "'>" 
						+ decodeURIComponent(json.list[i].empName).replace(/\+/gi, " ")
						+ "</a></td><td>" + json.list[i].deptId
						+ "</td><td>" + json.list[i].jobId
						+ "</td><td>" + json.list[i].empPhone
						+ "</td><td>" + json.list[i].empEmail
						+ "</td><td>" + decodeURIComponent(json.list[i].empAddress).replace(/\+/gi, " ") + "</td><td>" + json.list[i].ident + "</td></tr>";
					}  //for in
					//테이블에 추가
					$("#userList").html(table + values);
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
				}
   			});
		}// list() 끝 
        
        $(function(){
        	// 페이지가 로딩되면 자동으로 실행됨 
        	console.log("레디")
        	
         list(); //list() 실행하세여 
        	
        });//도큐멘트 레디 끝 
        
        /* function list() {
			$.ajax({
				//function 실행시 실행할 servlet
				url: "/sector/매핑값 입력",
				//get방식 post방식
				type: "get",
				//데이터 타입 json
				dataType: "json",
				//에러없이 성공할 때 실행 될 function
				success: function(data){
					//웹페이지 콘솔창
					console.log("saeas request success : ");
					//객체를 문자열로 변환 처리함
					var jsonStr = JSON.stringify(data);
					//문자열을 배열 객체로 바꿈
					var json = JSON.parse(jsonStr);
					//변수를 만들어 공객을 줌
					var values = "";
					for(var i in json.list){
						values += "<tr><td>" + json.list[i].empId + "</td><td><a href='ndetail?noticeno=" 
						+ json.list[i].empId + "'>" 
						+ decodeURIComponent(json.list[i].empName).replace(/\+/gi, " ")
						+ "</a></td><td>" + json.list[i].deptId
						+ "</td><td>" + json.list[i].jobId
						+ "</td><td>" + json.list[i].empPhone
						+ "</td><td>" + json.list[i].empEmail
						+ "</td><td>" + decodeURIComponent(json.list[i].empAddress).replace(/\+/gi, " ") + "</td><td>" + json.list[i].ident + "</td></tr>";
					}  //for in
					//테이블에 추가
					$("#userList").html(table + values);
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
				}
   			});
		}// list() 끝 
        
        $(function(){
        	// 페이지가 로딩되면 자동으로 실행됨 
        	console.log("레디")
        	
         list(); //list() 실행하세여 
        	
        });//도큐멘트 레디 끝  */
        
    </script>
</body>
</html>