<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="suser.model.vo.Suser" %>
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
<div class="container-fluid table-boss">
    <div class="row" id="insert-ab-border">
    <div class="col col-xl-5 ">
        <h4 class="mb-3">주소록 추가</h4>
        <form class="needs-validation" action="/sector/ais" method="get" enctype="multipart/form-data" novalidate>
            <div class="row col-md-12 mb-3">
                <div class="col-6 custom-control custom-radio">
                    <input id="personal" name="abgroup" type="radio" value="personal" class="" checked required>
                    <label class="" for="personal">개인주소록</label>
                </div>
                <div class="col-6 custom-control custom-radio">
                    <input id="share" name="abgroup" type="radio" value="share" class="" required>
                    <label class="" for="share">공유주소록</label>
                </div>
            </div>
            <div class="row mb-3 col-8">
                <label for="username">이름</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="name" value="" required>
                <div class="invalid-feedback">
                    이름은 반드시 기재하셔야 합니다.
                </div>
            </div>

            <div class="row mb-3 col-8">
                <label for="phone">연락처</label>
                <input type="phone" class="form-control" id="phone" name="phone" placeholder="ex)123456789" required>
                <div class="invalid-feedback">
                    연락처는 반드시 기재하셔야 합니다.
                </div>
            </div>
            <div class="row col-5 mb-3">
                <label for="com">회사</label>
                <input type="text" class="form-control" id="com" name="com" placeholder="">
            </div>
            
            <div class="row col-5 mb-3">
                <label for="jobname">직급</label>
                <input type="text" class="form-control" id="jobname" name="jobname" placeholder="ex)과장, 대리">
            </div>


            <div class="mb-3">
                <label for="email">Email <span class="text-muted"></span></label>
                <input type="email" class="form-control" id="email" name="email" placeholder="id@sector.com">
            </div>

            <div class="mb-3">
                <label for="address">주소</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="ex)서울시 서초구...">
            </div>
            <div class="mb-3">
                <label for="anniversary" class="">기념일</label>
                <div class="row col">

                    <input type="text" class="col-5 form-control mr-3" id="anniname" name="anniname" placeholder="ex)결혼기념일">
                    <input type="date" class="col-6 form-control" id="annidate" name="annidate">
                </div>
            </div>

			<div id="center" class="col">

        		<button class="col" id="insert-clear" type="submit">작성완료</button>
    		</div>
           <input type="hidden" name="empId" value="<%= loginMember.getEmpId() %>">
           <input type="hidden" name="userComNo" value="<%= loginMember.getUserComNo() %>">
           <input type="hidden" name="userId" value="<%= loginMember.getUserId() %>">
           
               
        </form>
        
        
    </div>
    
    
    <div class="col col-md-5 d-none d-lg-block" id="null">
        
    </div>
    
    </div>
   
    </div>
</body>
</html>