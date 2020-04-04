<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="emp.model.vo.Emp, suser.model.vo.Suser" %>
   
 <%
 	Emp emp = (Emp)request.getAttribute("emp");
 	Suser loginMember = (Suser)session.getAttribute("loginMember");
 %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
  <form class="form-signin" method="POST" action="/sector/ubes">
        

    <div class="container-fluid">
       
       
        <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">이름</label>
                <input type="text" class="form-control" name="username" value="<%= emp.getEmpName() %>"/>
                  <input type="text" name="empid" value="<%= emp.getEmpId() %>"/>
            </div>
        <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">아이디</label>
                <input type="text" class="form-control" name="userid" value="<%= emp.getUserId() %>"/>
            </div>
        <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">부서코드</label>
                <input type="text" class="form-control" name="deptid" value="<%= emp.getDeptId() %>"/>
            </div>
        <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">직급코드</label>
                <input type="text" class="form-control" name="jobid" value="<%= emp.getJobId() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">전화번호</label>
                <input type="text" class="form-control" name="phone" value="<%= emp.getEmpPhone() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">이메일</label>
                <input type="text" class="form-control" name="email" value="<%= emp.getEmpEmail() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">주민번호</label>
                <input type="text" class="form-control" name="empno" value="<%= emp.getEmpNo() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">주소</label>
                <input type="text" class="form-control" name="address" value="<%= emp.getEmpAddress() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">연봉</label>
                <input type="text" class="form-control" name="salary" value="<%= emp.getSalary() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">보너스</label>
                <input type="text" class="form-control" name="bonuspct" value="<%= emp.getBonusPct() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">입사일</label>
                <input type="text" class="form-control" name="hiredate" value="<%= emp.getHireDate() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">잔여연차</label>
                <input type="text" class="form-control" name="vacation" value="<%= emp.getVacation() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">결혼유무</label>
                <input type="text" class="form-control" name="marriage" value="<%= emp.getMarriage() %>"/>
            </div>
            <div class="form-inline" style="margin-bottom:5px">
                <label style="width:100px">인증유무</label>
                <input type="text" class="form-control" name="ident" value="<%= emp.getIdent() %>"/>
            </div>
    </div>
    <div align="center">
                <input type="submit" class="btn btn-primary" value="수정완료" href="/sector/views/ab/userUpdate.jsp"/>    
                <input type="back" class="btn btn-primary" onclick="history.back(-1);" value="돌아가기"/>
            </div>
           <!--  <div align="center">
            </div> -->
    </form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>