<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="doc.model.vo.Doc, java.util.ArrayList, suser.model.vo.Suser"%>
<%
 ArrayList<Doc>list = (ArrayList<Doc>)request.getAttribute("list");
 

 Suser loginMember = (Suser)session.getAttribute("loginMember");


%>

<!doctype html>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/sector/resources/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        #searching {

            background-color: white;
            border: 0px;

        }

        #nav_three {
            padding: 3px;
        }

        .navbar-toggler-icon {
            border-color: black;
        }

        .custom-toggler.navbar-toggler {
            border-color: rgb(255, 102, 203);
        }

        #write {
            width: 17em;
            height: 2.4em;
            background: #6294ce;
            border-style: none;
            color: white;
            font-weight: 200;
        }
        
        #name{
            margin-left: 20px;
            font-weight: bold;
        }
        
        #logOut{
            margin-left: 40px;
             width: 6em;
            height: 2.4em;
            background: #6294ce;
            border-style: none;
            color: white;
            font-weight: 200;
        }

        #side {
            float: left;
            width: 22em;
            height: 61em;
            background: #f5f5f5;

        }

        hr {
            border: 0.5px solid black;
        }

        #submenu {
            position: absolute;
            width: 450px;
            height: 300px;
        }

        #submenu2 {
            position: absolute;
            width: 300px;
            height: 300px;
        }

        #submenu3 {
            position: absolute;
            width: 180px;
            height: 100px;
        }



        #topmenu img {
            width: 80px;

        }

        #content a {
            color: black;
            text-decoration: none;

        }

        #genre a {
            color: black;
            text-decoration: none;
        }

        #content {
            float: left;
            margin: 40px;
        }

        #contentTable {
            margin: 20px;
            margin-left: 30px;
            border-left: hidden;
            font-size: 11pt;
            border-bottom-color: gray;
            position: absolute;


        }

        #contentTable #t1 td {
            background: #f7f7f7;
            padding: 7px;
            font-size: 11pt;
            padding: 5px;
        }

        #contentTable td {
            text-align: center;

        }

        #contentTable td:nth-child(1) {
            width: 150px;

        }

        #contentTable td:nth-child(2) {
            width: 430px;

        }

        #contentTable td:nth-child(3) {
            width: 150px;

        }

        #contentTable td:nth-child(4) {
            width: 150px;

        }

        #contentTable td:nth-child(5) {
            width: 150px;
        }

        #contentTable td:nth-child(6) {
            width: 110px;
            
        }
        
        #contentTable td:nth-child(7){
            width: 80px;
            border-right: hidden;
        }
        
        li {
         list-style: none;
         float: left;
         margin-right: 20px;
        }
        
    </style>
    <!-- Custom styles for this template -->
</head>

<body>
        <header>
        <div class="container-fluid d-flex" id="top-bar">

            <img src="/sector/resources/images/sector%20logo.png" class="align-self-center" id="logo">
            <li class="nav-item dropdown align-self-center mr-auto">
                <!--                        <div class="nav-link" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">주소록<img src="resources/images/arrow.png" alt="" id="top-arrow"></div>-->
                <a class="nav-link d-none d-md-block" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">주소록&nbsp; <img src="/sector/resources/images/arrow.png" id="arrow"></a>
                <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu">

                    <div id="drop-menu">
                        <tr>
                            <td id=""><a href="#"><img src="/sector/resources/images/check.png" class="drop-menu"></a></td>
                            <td id=""><a href="#"><img src="/sector/resources/images/human.png" class="drop-menu"></a></td>
                            <td id=""><a href="#"><img src="/sector/resources/images/call.png" class="drop-menu"></a></td>

                        </tr>

                        <tr>
                            <td id=""><a href="#"><img src="resources/images/mail.png" class="drop-menu"></a></td>
                            <td id=""><a href="#"><img src="resources/images/cal.png" class="drop-menu"></a></td>
                            <td id=""><a href="#"><img src="resources/images/board.png" class="drop-menu"></a></td>
                        </tr>
                    </div>
                </div>
            </li>

            <button class="btn d-none d-md-block">
                <span class="badge badge-danger  " id="badge-pos">134</span>
                <img src="resources/images/bell.png" id="bell-icon" class="align-self-center " alt="">
                <!--                <span class="badge badge-danger  " id="badge-poss">112344</span>-->
            </button>
            <button class="btn d-none d-md-block">
                <img src="resources/images/profile.png" alt="" class="align-self-center" id="profile-icon">
            </button>
            <nav class="navbar navbar-expand-lg navbar-light ">
                <input class="form-control mr-sm" type="search" placeholder="Search" aria-label="Search">
            </nav>
            <button class="btn btn-outline" type="submit"><img src="resources/images/search.png" class="" alt="" id="search-icon"></button>
        </div>


    </header>
    
    

    <hr style="border: 1px normal black; margin: 0px;">
    <div id="side">
        <br>
        <br>
        &nbsp; &nbsp; &nbsp;<button id="write" onclick="location.href='/sector/views/erp/erpmain/erpInsert.jsp'">작성하기</button>

        <br><br><br>
        <div id="genre">
            &nbsp; &nbsp; &nbsp; 진행중인 문서
            <a href="#"><img src="../../../resources/images/arrow.png" style="width:15px; margin-bottom: 3px"></a> <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#" id="all" onclick="optionDoc(1,'all');">전체</a>
            &nbsp; &nbsp; &nbsp; <a href="#" id="complete" onclick="optionDoc(1,'complete');">완료</a> &nbsp; &nbsp; &nbsp; <a href="#" id="progress" onclick="optionDoc(1,'progress');">진행</a> <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#" id="standby" onclick="optionDoc(1,'standby');" >대기</a>  &nbsp; &nbsp; &nbsp; 
            <a href="#" id="reject" onclick="optionDoc(1,'reject');" >반려</a>
            <br>
            <br>
            &nbsp; &nbsp; &nbsp; 내 문서함 <img src="../../../resources/images/arrow.png" style="width:15px; margin-bottom: 3px"> <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#" class="standby" onclick="optionBox(1,'standby');"> 결재 대기중인 문서</a> &nbsp; &nbsp; &nbsp;<br><br>  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; <a href="#" class="complete" onclick="optionBox(1,'complete');">결재 완료된 문서</a>  &nbsp; &nbsp; &nbsp; 
           
            <hr> <br> &nbsp; &nbsp; &nbsp;
            <img src="../../../resources/images/cal_icon.png" style="width: 25px; margin-bottom: 4px; padding: 0; ">&nbsp; &nbsp; 날짜로 보기 <br>
            <br>
            &nbsp;
            <input id="date1" type="date" style="border: 1px solid black;"> &nbsp;<input id="date2" type="date" style="border: 1px solid black;"> <br><br>

            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="#" id="searchByDate" style="font-weight: bold" onclick="searchByDate(1);">조회하기</a>
            <hr>
            &nbsp; &nbsp; &nbsp;<a href="#"><img src="../../../resources/images/KakaoTalk_20190902_174656733.png" width="20px" style="margin-bottom: 4px;"> &nbsp; 설정</a> <br><br>


        </div>

    </div>

    <div id="content">
        <div>
            <table id="contentTable" align="center" border="1">
                <tr id="t1">
                    <td>문서번호</td>
                    <td>제목</td>
                    <td> 기안자 </td>
                    <td> 기안일 </td>
                    <td> 문서 종류 </td>
                    <td>상태</td>
                    <td>보안등급</td>
                </tr>




            </table>

            


        </div>
    
        <br>
        <br>
        <br><br><br>
        
        <div id="paging" style="padding-left: 550px; padding-top: 250px;">
        <ul>
            
            
        </ul>
         
        
        
        </div>
        
    </div>


    <br><br><br><br><br><br><br><br><br>





    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script type="text/javascript" src="../../../resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        
        var table = "<tr id='t1'>" +
                "<td>문서번호</td>" +
                "<td>제목</td>" +
                "<td>기안자</td>" +
                "<td>기안일</td>" +
                "<td>문서 종류</td>" + "<td>상태</td>" + "<td>보안등급</td>" +
                "</tr>";
        
         
        
         function detailDoc(docId, docLevel) {
                      
             var userLevel = '<%= loginMember.getJobId() %>';
             
             
             
            
             console.log(docId +", " + docLevel + ", " + userLevel );
             
            
             //보안등급이 A일때
             if(docLevel == "A" && userLevel == "A"){
                
                 location.href="/sector/ddvs?docid=" + docId;
                
            //보안등급이 B일때      
             }else if((docLevel == "B" && userLevel == "A") || (docLevel == "B" && userLevel == "B") ){
                  
                 location.href="/sector/ddvs?docid=" + docId;
                 
            //보안등급이 C일때      
             }else if((docLevel == "C" && userLevel == "A") || (docLevel == "C" && userLevel == "B") || (docLevel == "C" && userLevel == "C")){
                   
                 location.href="/sector/ddvs?docid=" + docId;
            
            //보안등급이 D일때     
             }else if(docLevel == "D"){
                 location.href="/sector/ddvs?docid=" + docId;
             }else{
                 alert("보안등급으로 인해 문서를 열람할 수 없습니다.");
             }
             
             
                 
           
                 
                 
            } //보안 문서 기능 
        
         function mainDoc(curPage){
             
              
             $.ajax({
                url: "/sector/dlvs",
                type: "get",
                data:{
                    page: curPage,
                    empId : <%= loginMember.getEmpId() %>
                },
                dataType: "json",
                success: function(data) {

                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var values = "";
                    var values2 = "";

                    
                    for (var i in json.list) {
                        
                        //values가 있는행 level 옆에 'D' 는 loginMember의 직급코드로 대체함 
                        
                         values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    } 



                   
                    
                     $("#contentTable").remove("tr");
                    $("#contentTable").html(table + values);
                    
                    
                    //여기서부터 페이징 처리 
                    
                  var blockStartNum = json.list[0].blockStartNum;
                  var blockLastNum = json.list[0].blockLastNum;
                  var lastPageNum = json.list[0].lastPageNum;  
                    
                    console.log("blockStartNum : " + blockStartNum);
                    console.log("blockLastNum : " + blockLastNum);
                    console.log("lastPageNum : " + lastPageNum);
                    
                    
                    
                for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# onclick=optionDoc("+ i +")>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                  
                    
                
                  
               
                    
                  $("#paging ul").html(values2);
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
            }); 
             
             
         } //메인화면 문서 페이징 기능 
         
                
                    
         function optionDoc(curPage, search){
             
         $.ajax({
                url: "/sector/dovd",
                type: "get",
                data:{
                    page: curPage,
                    option: search
                    
                },
                dataType: "json",
                success: function(data) {
                    
                    

                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var values = "";
                    var values2 = "";

                    
                    for (var i in json.list) {
                        
                        //values가 있는행 level 옆에 'D' 는 loginMember의 직급코드로 대체함 
                        
                          values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    } 



                    $("#contentTable").html(table+values);
                    
                    
                    //여기서부터 페이징 처리 
                    
                  
                  var blockLastNum = json.list[0].blockLastNum;
                  var lastPageNum = json.list[0].lastPageNum;  
                 var blockStartNum = json.list[0].blockStartNum; 
                    
                    
                    console.log("blockStartNum : " + blockStartNum);
                    console.log("blockLastNum : " + blockLastNum);
                    console.log("lastPageNum : " + lastPageNum);
                    
                    
                if(search == "standby"){
                 
                    for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href=# onclick=optionDoc("+ i + ",'standby')>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                }
                        
                        
                        
                        
                if(search == "progress"){
                        for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href=# onclick=optionDoc("+ i + ",'progress')>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                }
                
                if(search == "reject"){
                        for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href=# onclick=optionDoc("+ i + ",'reject')>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                }
                        
                if(search == "complete"){
                        for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href=# onclick=optionDoc("+ i + ",'complete')>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                }   
                
                    
                if(search == "all"){
                        for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href=# onclick=optionDoc("+ i + ",'all')>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                }     
                    
                    
                    
                    
                    
                  $("#paging ul").html(values2);
                    
                }
                ,
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
            });     
             
         } //문서 종류별 조회 페이징 기능 
        
         function optionBox(curPage, search){
              $.ajax({
                    url: "/sector/dbov",
                    data:{
                        empId : <%= loginMember.getEmpId() %>,   //사용자 사번을 집어넣으면 됨 
                        option : search,
                        page: curPage
                        
                    },
                    type: "get",
                    dataType: "json",
                    success:function(data){
                        
                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        var values = "";

                          for (var i in json.list) {
                                                                                                                  
                                values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    }




                        $("contentTable").remove("tr");
                        $("#contentTable").html(table + values);
                        
                        
                         var blockStartNum = json.list[0].blockStartNum;
                  var blockLastNum = json.list[0].blockLastNum;
                  var lastPageNum = json.list[0].lastPageNum;  
                    
                  var values2 = "";  
                        
                    console.log("blockStartNum : " + blockStartNum);
                    console.log("blockLastNum : " + blockLastNum);
                    console.log("lastPageNum : " + lastPageNum);
                    
                    
                 if(search == "standby"){
                        for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href=# onclick=optionBox("+ i + ",'standby')>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                }       
                        
                if(search == "complete"){
                        for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href=# onclick=optionBox("+ i + ",'complete')>" + i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                }           
                        
                        
                    
                
                  
                 console.log(values2);
                    
                  $("#paging ul").html(values2);
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
            
                    
                });
             
         } // 내 문서함 결재 대기중 
        
        
         function searchByDate(curPage){
             $.ajax({
                    url:"/sector/dsbds",
                    data:{
                        start: $("#date1").val(),
                        end: $("#date2").val(),
                        page: curPage
                    },
                    success: function(data) {

                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        var values = "";

                          for (var i in json.list) {
                       
                               values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    }



                        $("contentTable").remove("tr");
                        $("#contentTable").html(table + values);
    
                  var blockStartNum = json.list[0].blockStartNum;
                  var blockLastNum = json.list[0].blockLastNum;
                  var lastPageNum = json.list[0].lastPageNum;  
                    
                  var values2 = "";  
                        
                    console.log("blockStartNum : " + blockStartNum);
                    console.log("blockLastNum : " + blockLastNum);
                    console.log("lastPageNum : " + lastPageNum);
                    
                    
                    
                 for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href='#' onclick='searchByDate("+ i +")'>"+ i +"</a></li>"; 
                 }   
                    
                
                    
                  $("#paging ul").html(values2);
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 

                    
                    
                    
                });
         } //날짜로 검색 
        
         function logOut(){
            var commit = confirm("로그아웃 하시겠습니까?");
            if (commit == true)
            {
            alert("메인페이지로 돌아갑니다.");
            location.href="/sector/dlos";
           
            }
             
         }    //로그아웃 
        
        
        
       //DocumentReady
        $(function() {

            var table = "<tr id='t1'>" +
                "<td>문서번호</td>" +
                "<td>제목</td>" +
                "<td>기안자</td>" +
                "<td>기안일</td>" +
                "<td>문서 종류</td>" + "<td>상태</td>" + "<td>보안등급</td>" +
                "</tr>"; //테이블 html 코드 
            
          
               
            <% if(loginMember == null){ %>
             alert("보안을 위해 다시 로그인 해주시길 바랍니다.");
             location.href="/sector/mainLogin.jsp";
            <% } %>
            
            $.ajax({
                   url: "/sector/dsmsm",
                type: "get",
                data:{
                    empId: <%= loginMember.getEmpId() %>
                },
                dataType: "json",
                success: function(data) {

                    
                    
                   $("#name").text( decodeURIComponent(data.empName) + "  " + decodeURIComponent(data.deptName) + "  " + decodeURIComponent(data.jobName));
                   
                }
                
            }); //상단서브메뉴 회원 정보 출력 
            

            
             $.ajax({
                url: "/sector/dlvs",
                type: "get",
                data:{
                    page: 1,
                    empId: <%= loginMember.getEmpId() %>
                },
                dataType: "json",
                success: function(data) {

                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var values = "";
                    var values2 = "";

                    
                    for (var i in json.list) {
                        
                        //values가 있는행 level 옆에 'D' 는 loginMember의 직급코드로 대체함 
                        
                        values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    } 




                    $("#t1").after(values);
                    
                    
                    //여기서부터 페이징 처리 
                    
                  var blockStartNum = json.list[0].blockStartNum;
                  var blockLastNum = json.list[0].blockLastNum;
                  var lastPageNum = json.list[0].lastPageNum;  
                    
                    console.log("blockStartNum : " + blockStartNum);
                    console.log("blockLastNum : " + blockLastNum);
                    console.log("lastPageNum : " + lastPageNum);
                    
                    
                    
                 for(var i = blockStartNum; i <= lastPageNum; i++){
                     values2 += "<li><a href='#' onclick='mainDoc("+ i +")'>"+ i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
               
               
                  
                    
                  $("#paging ul").html(values2);
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
            });  //페이지 실행시 메인화면 목록    



            /*$("#complete").click(function() {
                
                 $.ajax({
                url: "/sector/dovd",
                type: "get",
                data:{
                    page: 1,
                    option:"complete"
                    
                },
                dataType: "json",
                success: function(data) {

                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var values = "";
                    var values2 = "";

                    
                    for (var i in json.list) {
                        
                        //values가 있는행 level 옆에 'D' 는 loginMember의 직급코드로 대체함 
                        
                        values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    } 



                    $("#contentTable").html(table+values);
                    
                    
                    //여기서부터 페이징 처리 
                    
                  var blockStartNum = json.list[0].blockStartNum;
                  var blockLastNum = json.list[0].blockLastNum;
                  var lastPageNum = json.list[0].lastPageNum;  
                    
                    console.log("blockStartNum : " + blockStartNum);
                    console.log("blockLastNum : " + blockLastNum);
                    console.log("lastPageNum : " + lastPageNum);
                    
                    
                    
                 for(var i = blockStartNum; i <= lastPageNum-1; i++){
                     values2 += "<li><a href='#' onclick='completeDoc("+ i +")'>"+ i +"</a></li>"; 
                 }   
                    
                for(var i = lastPageNum; i <= blockLastNum; i++){
                    values2 += "<li>" + i + "</li>"; 
                }    
                  
                    
                  $("#paging ul").html(values2);
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
            });   

            });*/ //완료된 문서만 보기 


            /*$("#progress").click(function() {

                $.ajax({
                    url: "/sector/dovd",
                    data: {
                        option: "progress"
                    },
                    type: "get",
                    dataType: "json",
                    success: function(data) {

                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        
                        var values = "";

                          for (var i in json.list) {
                       
                               values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    }



                        $("contentTable").remove("tr");
                        $("#contentTable").html(table + values);


                    }


                });

            }); *///진행중인 문서만 보기 


           /* $("#standby").click(function() {

                $.ajax({
                    url: "/sector/dovd",
                    data: {
                        option: "standby"
                    },
                    type: "get",
                    dataType: "json",
                    success: function(data) {

                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        var values = "";

                          for (var i in json.list) {
                       
                               values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    }



                        $("contentTable").remove("tr");
                        $("#contentTable").html(table + values);


                    }


                });

            });*/ //대기중인 문서 보기 
            
            
            
           /* $(".standby").click(function(){
                
                $.ajax({
                    url: "/sector/dbov",
                    data:{
                        empId : 3,   //사용자 사번을 집어넣으면 됨 
                        option : "standby"
                        
                    },
                    type: "get",
                    dataType: "json",
                    success:function(data){
                        
                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        var values = "";

                          for (var i in json.list) {
                                                                                                                    //사용자 직급코드를 집어넣으면됨 
                               values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    }




                        $("contentTable").remove("tr");
                        $("#contentTable").html(table + values);
                        
                    }
                    
                });
                
            });*/ //내 결재 대기중 문서함 상자 


            /*$(".complete").click(function(){
                
                $.ajax({
                    url: "/sector/dbov",
                    data:{
                        empId : 3,   //사용자 사번을 집어넣으면 됨 
                        option : "complete"
                        
                    },
                    type: "get",
                    dataType: "json",
                    success:function(data){
                        
                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        var values = "";

                          for (var i in json.list) {
                                                                                                                    //사용자 직급 코드를 집어넣으면됨 
                               values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    }




                        $("contentTable").remove("tr");
                        $("#contentTable").html(table + values);
                        
                    }
                    
                });
                
            });*/ //내 결재 완료 문서함 상자 

            /*$("#searchByDate").click(function(){
                
                $.ajax({
                    url:"/sector/dsbds",
                    data:{
                        start: $("#date1").val(),
                        end: $("#date2").val()
                    },
                    success: function(data) {

                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        var values = "";

                          for (var i in json.list) {
                       
                               values += "<tr><td><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>" + json.list[i].id + "</a></td>" +
                            "<td ><a href='#' onclick=detailDoc(" + json.list[i].id + ",'" + json.list[i].level  + "','B');>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td>" +
                            "<td >" + decodeURIComponent(json.list[i].writer) + "</td>" +
                            "<td >" + json.list[i].date + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].type) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].status) + "</td><td>" +  json.list[i].level + "</td></tr>"
                    }



                        $("contentTable").remove("tr");
                        $("#contentTable").html(table + values);
    
                        var blockStartNum = json.list[0].blockStartNum;
                  var blockLastNum = json.list[0].blockLastNum;
                  var lastPageNum = json.list[0].lastPageNum;  
                    
                  var values2 = "";  
                        
                    console.log("blockStartNum : " + blockStartNum);
                    console.log("blockLastNum : " + blockLastNum);
                    console.log("lastPageNum : " + lastPageNum);
                    
                    
                    
                 for(var i = blockStartNum; i <= lastPageNum-1; i++){
                     values2 += "<li><a href='#' onclick='completeBox("+ i +")'>"+ i +"</a></li>"; 
                 }   
                    
                for(var i = lastPageNum; i <= blockLastNum; i++){
                    values2 += "<li>" + i + "</li>"; 
                }    
                  
                 console.log(values2);
                    
                  $("#paging ul").html(values2);
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 

                    
                    
                    
                });
                
            });*/ //날짜로 검색 





        }); //document ready
    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body></html>
