<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/sector/resources/css/loginstyle.css">
<title>Insert title here</title>
<script language="javascript">
	


	/*fuction validate(){
		var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
		var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// 이메일 적합한지 검사할 정규식
		
		var id = document.getElementById("userId");
		var id = document.getElementById("userPwd");
		var id = document.getElementById("userEmail");
		var id = document.getElementById();
		
		//아이디가 공백일 경우
		if(userId.value == ""){
			alert("아이디를 입력해 주세요.");
			userId.focus();
			return false;
		}
		//비밀번호가 공백일 경우
		if(userPwd.value == ""){
			alert("비밀번호를 입력해 주세요.");
			userPwd.focus();
			return false;
		}
		//이름이 공백일 경우
		if(userName.value == ""){
			alert("이름을 입력해 주세요.");
			userName.focus();
			return false;
		}		
		//주민번호가 공백일 경우
		if(userNo.value == ""){
			alert("주민번호를 입력해 주세요.");
			userNo.focus();
			return false;
		}
		//이메일이 공백일 경우
		if(userEmail.value == ""){
			alert("이메일을 입력해 주세요.");
			userEmail.focus();
			return false;
		}
		//주소가 공백일 경우
		if(userAddress.value == ""){
			alert("주소를 입력해 주세요.");
			userAddress.focus();
			return false;
		}
		//전화번호가 공백일 경우
		if(userPhone.value == ""){
			alert("전화번호를 입력해 주세요.");
			return false;
		}
		//비밀번호가 틀립니다.
		if(join.userPwd.value != join.userPwd2.value){
			alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
			join.userPwd2.value = "";
			join.userPwd2.focus();
			return false;
		}
		
		
		
		
	} */

</script>


</head>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:30rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">SECTOR JOIN!</h2>
		</div>
		
		<div class="card-body">
      <form class="form-signin" method="POST" action="/sector/ieus">
        <h5 class="form-signin-heading" align="center">아래 내용을 입력해주세요.</h5>
        
        <label for="inputId" class="sr-only">회원사번호</label>
        <input type="text" id="uid" class="form-control" placeholder="회원사번호" name="usercomno" id="usercomno" maxlength="20" required autofocus><BR>
        
        <label for="inputId" class="sr-only">아이디</label>
        <input type="text" id="uid" class="form-control" placeholder="아이디" name="userId" id="userID" maxlength="20" required autofocus><BR>
         
        <label for="inputPassword" class="sr-only">비밀번호</label>
        <input type="password" id="upw" class="form-control" placeholder="비밀번호" name="userPwd" id="userPwd" required><br>
        
        <label for="inputPassword" class="sr-only">비밀번호 확인</label>
        <input type="password" id="upw" class="form-control" placeholder="비밀번호 확인" name="userPwd2" id="userPwd2" required><br>
        
        <label for="inputName" class="sr-only">이름</label>
        <input type="text" id="uname" class="form-control" placeholder="이름" name="userName" id="userName" required><br>
        
        <label for="inputPhone" class="sr-only">주민번호</label>
        <input type="text" id="uno" class="form-control" placeholder="주민번호" name="userNo" id="userNo" required><br>
        
        <label for="inputEmail" class="sr-only">이메일</label>
        <input type="text" id="uemail" class="form-control" placeholder="이메일" name="userEmail" id="userEmail" required><br>
        
        <label for="inputAddress" class="sr-only">주소</label>
        <input type="text" id="uad" class="form-control" placeholder="주소" name="userAddress" id="userAddress" required><br>
        
        <label for="inputPhone" class="sr-only">전화번호</label>
        <input type="text" id="uphone" class="form-control" placeholder="전화번호 ex) 010-0000-0000" name="userPhone" id="userPhone" maxlength="13" required><br>
        
        <!--<div class="checkbox">
          <label>
          <input type="checkbox" value="remember-me"> 기억하기
          </label>
            <a text-align="center" href="/sector/views/InsertUserPage/InsertUser.jsp">회원가입</a>
        </div>-->

        
        <input type="submit" class="btn btn-lg btn-primary btn-block" id="btn-Yes" value="가입하기" href="mainLogin.jsp">
        <input type="back" class="btn btn-lg btn-primary btn-block" id="btn-No" onclick="history.back(-1);" value="돌아가기">
        <!--   <input type="submit" class="btn btn-lg btn-primary btn-block" id="btn-Yes" value="로그인" onclick='return loginCheck()'">-->
      </form>
        </div>
        </div>
        </body>
</html>