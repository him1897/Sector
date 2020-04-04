<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="suser.model.vo.Suser"
    %>

	<%
		String result = (String)session.getAttribute("result");
	%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/loginstyle.css">
    <title>Insert title here</title>
    <script type="text/javascript">
    	<% if (result != null ? result == "실패" : false) { %>
    		alert("아이디 혹은 비밀번호가 틀렸습니다!");
    		<% session.removeAttribute("result");  %>
    	<% } %>
    </script>
</head>
    <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">SECTOR LOGIN</h2>
		</div>
		
		<div class="card-body">
      <form class="form-signin" method="POST" action="/sector/lius">
        <h5 class="form-signin-heading">우리팀 파이팅!!!</h5>
        <label for="inputId" class="sr-only">아이디</label>
        <input type="text" id="uid" class="form-control" placeholder="아이디" name="userID" id="userID" maxlength="20" required autofocus><BR>
        <label for="inputPassword" class="sr-only">비밀번호</label>
        <input type="password" id="upw" class="form-control" placeholder="비밀번호" name="userPassword" id="userPwd" required><br>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 기억하기
          </label>
            <a text-align="right" href="/sector/views/InsertUserPage/InsertUser.jsp">회원가입</a>
        </div>
        
        <input type="submit" class="btn btn-lg btn-primary btn-block" id="btn-Yes" value="로그인" href="/sector/ams">
        
      </form>
        </div>
        </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>