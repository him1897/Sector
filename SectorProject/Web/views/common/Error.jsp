<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1</title>
</head>

<body>

<h1>오류 발생</h1>
<% if(exception != null){ //다른 jsp 에서 발생한 예외일 때 %>
<h2>jsp 오류 : <%= exception.getMessage() %></h2>
<% } else { //서블릿에서 포워딩한 오류 메세지일 때  %>
<h2>오류발생 : <%= request.getAttribute("message") %></h2>
<%} %>
<h3><a href="/test1/index.jsp">홈으로</a></h3>
<h3><a href="javascript:history.go(-1);">이전 페이지로 이동</a></h3>


</body>

</html>