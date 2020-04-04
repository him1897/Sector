<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="emp.model.vo.Emp, suser.model.vo.Suser, post.model.vo.Post" %>
<%
	
    Suser loginMember = (Suser)session.getAttribute("loginMember");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/sector/ips" method="post" 
enctype="multipart/form-data">
 <div>
   <fieldset>
   
    <div class="form-group row" style="margin-left: 0; margin-top: 25px; width: 20%;" >
     <p class="lh"><input type="submit" value="글올리기" style="width: 180px; height: 40px;"></p> 
      </div>
    <div class="form-group" style="width: 30%; height: 60px;">
        <label for="exampleSelect1" style="font-size: 20px; margin-top: 5%; float: left;">게시판 종류</label>
      <select class="form-control" id="exampleSelect1" name="genre" style="width: 50%; height: 35px; margin-left: 20px; margin-top: 20px; float: left;">
        <option value="재무부서">재무부서</option>
        <option value="인사부서">인사부서</option>
        <option value="행정부서">행정부서</option>
        <option value="기획부서">기획부서</option>
        <option value="자유게시판">자유게시판</option>
        <option value="공지사항">공지사항</option> 
      </select>
    </div>
    
     <div class="form-group" style="width: 80%; height: 60px;"><p class="lh">
      <label for="exampleInputTitle" style="font-size: 20px; margin-top: 22px; float: left;">제목</label>
      <input class="form-control" id="exampleInputTitle" name="title" type="text" style="width: 500px; height: 4%; margin-left: 5%; margin-top: 14px; float: left;">
      <input type="hidden" value="<%= loginMember.getEmpId() %>" name="empId">
          
    </p></div>

    
     <div class="form-group textarea">
      <textarea class="form-control" id="exampleTextarea" name="content" cols="100%" rows="15px;" style="font-size: 17px;"></textarea>
    </div>
  </fieldset>
  </div>
</form>

</body>
</html>