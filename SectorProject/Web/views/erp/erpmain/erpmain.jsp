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
            width: 20em;
            height: 54em;
            background: #f5f5f5;

        }

		hr {
		border: 1pt inset black;
		}

        #submenu {
            position: absolute;
            width: 330px;
            height: 250px;
            padding-bottom: 10px;
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
            width: 80px !important;

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
            border-bottom-color: gray !improtant;
            position: absolute;


        }

        #contentTable #t1 td {
            background: #f7f7f7;
            padding: 7px;
            font-size: 13pt;
            padding: 5px;
        }

        #contentTable td {
            text-align: center;
            height: 40px;
            border-bottom-color: gray;

        }

        #contentTable td:nth-child(1) {
            width: 150px;
            border-right: none !important;

        }

        #contentTable td:nth-child(2) {
            width: 430px;
            border-left: none;
            border-right: none;

        }

        #contentTable td:nth-child(3) {
            width: 150px;
              border-left: none;
            border-right: none;

        }

        #contentTable td:nth-child(4) {
            width: 150px;
              border-left: none;
            border-right: none;
        }

        #contentTable td:nth-child(5) {
            width: 150px;
              border-left: none;
            border-right: none;
        }

        #contentTable td:nth-child(6) {
            width: 110px;
              border-left: none;
            border-right: none;
            
        }
        
        #contentTable td:nth-child(7){
            width: 80px;
            border-left: none;
            border-right: hidden;
        }
        
        li {
         list-style: none;
         float: left;
         margin-right: 20px;
        }
        
        #topSearchDiv {
            border: black 1px solid;
            background: #f5f5f5;
            position: absolute;
            right: 60px;
            top: 60px;
            width: 300px;
            display: none;
            padding: 5px;
            text-align: center;
            
        }
        
        .topA{
            color: black;
            text-decoration: none !important; 
        }
        
    </style>
    <!-- Custom styles for this template -->
</head>

<body>
   
   <script type="text/javascript">
    
    <% if(loginMember == null){ %>
             alert("보안을 위해 다시 로그인 해주시길 바랍니다.");
             location.href="/sector/mainLogin.jsp";
            <% } %>
    </script>
    
   
   
   
    <nav class="navbar navbar-expand-md navbar-dark fixed-top" style="background-color: white;">
        <a class="navbar-brand" href="#"><a href="/sector/views/erp/erpmain/erpmain.jsp"><img src="../../../resources/images/sector%20logo.png" style="width: 230px; padding: 3px;"></a></a>
        
        <div id="topSearchDiv">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere repellendus ipsum porro ut fugiat ducimus pariatur! Quos fuga, sapiente, alias rem placeat consectetur provident corporis laboriosam nam, impedit nihil omnis.</div>
        
        <nav id="nav_three">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">


            </button>
        </nav>



        <div class="collapse navbar-collapse" id="navbarsExampleDefault">

            <ul class="navbar-nav mr-auto">

                <li class="nav-item dropdown">
                    <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;">전자결재&nbsp; <img src="../../../resources/images/arrow.png" style="width:16px;"></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu">

                        <table id="topmenu" cellpadding="14">
                            <tr>
                                <td><a href="#"><img src="../../../resources/images/check.png"></a></td>
                                <td><a href="#"><img src="../../../resources/images/human.png"></a></td>
                                <td><a href="/sector/ams"><img src="../../../resources/images/call.png"></a></td>

                            </tr>

                            <tr>
                                <td><a href="#"><img src="../../../resources/images/mail.png"></a></td>
                                <td><a href="#"><img src="../../../resources/images/cal.png"></a></td>
                                <td><a href="#"><img src="../../../resources/images/board.png"></a></td>

                            </tr>

                        </table>

                    </div>
                </li>

            </ul>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <ul class="navbar-nav mr-auto" style="">

                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <li class="nav-item dropdown">

                    <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;"><img src="../../../resources/images/bell.png" style="width:16px;"></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu2">



                        &nbsp; 알림 <br>
                        <hr style="margin:0">


                    </div>
                </li>

            </ul>


            <ul class="navbar-nav mr-auto">


                <li class="nav-item dropdown">

                    <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;"><img src="../../../resources/images/profile.png" style="width:35px;"></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu3">
                    
                        <p id="name"></p>
                        <button type="button" id="logOut" onclick="logOut()">로그아웃</button>
                    

                    </div>
                </li>

            </ul>


            <form class="form-inline my-2 my-lg-0">
                <span style=" border: 1px solid #ced5da; border-radius: 10px; padding: 3px; float:  ">
                    <input class="form-control mr-sm-2" id="topSearchBar" type="text" placeholder="Search" aria-label="Search" style="border: 0px solid black;">
                    <button class="btn btn-secondary my-2 my-sm-0" id="searching" type="submit"><img src="../../../resources/images/search.png" style="width: 30px;"></button>
                </span>
            </form>
        </div>
    </nav>

    <hr>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span2">
            </div>
            <div class="span10">

            </div>
        </div>


    </div>
   
    <br><br>
    <hr style="margin: 0px;"> 
    
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
            
             &nbsp; &nbsp;    &nbsp; &nbsp; &nbsp; &nbsp; <a href="#" onclick="docWhoWrite(1)"> 내가 쓴 문서 </a> <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#" class="standby" onclick="optionBox(1,'standby');"> 결재 대기중인 문서</a> &nbsp; &nbsp; &nbsp;<br><br>  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; <a href="#" class="complete" onclick="optionBox(1,'complete');">결재 완료된 문서</a>  &nbsp; &nbsp; &nbsp; 
           
            <hr> <br> &nbsp; &nbsp; &nbsp;
            <img src="../../../resources/images/cal_icon.png" style="width: 25px; margin-bottom: 4px; padding: 0; ">&nbsp; &nbsp; 날짜로 보기 <br>
            <br>
            &nbsp;
            <input id="date1" type="date" style="border: 1px solid black; width: 140px;"> <input id="date2" type="date" style="border: 1px solid black; width: 140px;"> <br><br>

            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
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
        
        <div id="paging" style="padding-left: 550px; padding-top: 400px;">
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
        
        
        
        function docWhoWrite(curPage){
            
            
            
            $.ajax({
                url: "/sector/dwws",
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
                    
                    
                    
               if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=docWhoWrite("+ (Number(blockStartNum)-1) + ")> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=docWhoWrite("+ i +")>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=docWhoWrite("+ i +")>" + i +"</a></li>";  
                    }
                }
                  
                    
                
                  
               
                    
                  $("#paging ul").html(values2);
                  $(".paging").eq(curPage-1).css("color", "red");    
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
            }); 
            
            
            
            
        } //내가 쓴 문서 기능  
        
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
                    
                    
                if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=mainDoc("+ (Number(blockStartNum)-1) + ")> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=mainDoc("+ i +")>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=mainDoc("+ i +")>" + i +"</a></li>";  
                    }
                }
                    
                
                    
                    
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
                  
                    
                
                  
               
                    
                  $("#paging ul").html(values2);
                    
                
                  
                  $(".paging").eq((curPage-1) % 5).css("color", "red");         
                    
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
                 
                      
                if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=optionDoc("+ (Number(blockStartNum)-1) + ",'standby')> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'standby')>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'standby')>" + i +"</a></li>";  
                    }
                }
                    
                    
                }
                        
                        
                        
                        
                if(search == "progress"){
                   if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=optionDoc("+ (Number(blockStartNum)-1) + ",'progress')> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'progress')>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'progress')>" + i +"</a></li>";  
                    }
                }
                    
                    
                }
                
                if(search == "reject"){
                    
                    
                 if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=optionDoc("+ (Number(blockStartNum)-1) + ",'reject')> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'reject')>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'reject')>" + i +"</a></li>";  
                    }
                }
                    
                    
                }
                        
                if(search == "complete"){
                    
                 if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=optionDoc("+ (Number(blockStartNum)-1) + ",'complete')> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'complete')>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'complete')>" + i +"</a></li>";  
                    }
                }
                    
                }   
                
                    
                if(search == "all"){
                  if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=optionDoc("+ (Number(blockStartNum)-1) + ",'all')> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'all')>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=optionDoc("+ i +",'all')>" + i +"</a></li>";  
                    }
                }
                    
                }     
                    
                  for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }  
                    
                    
                    
                  $("#paging ul").html(values2);
                  $(".paging").eq((curPage-1) % 5).css("color", "red");
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
                  if(blockStartNum >= 6){
                      
                    values2 += "<li><a href=# onclick=optionBox("+ (Number(blockStartNum)-1) + ",'standby')> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=optionBox("+ i +",'standby')>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=optionBox("+ i +",'standby')>" + i +"</a></li>";  
                    }
                     
                     
                }     
                     
                 }
                        
                if(search == "complete"){
                if(blockStartNum >= 6){
                     values2 += "<li><a href=# onclick=optionBox("+ (Number(blockStartNum)-1) + ",'complete')> ← </a></li>"; 
                       for(var i = blockStartNum; i <= lastPageNum; i++){      
                    values2 += "<li><a href=# class='paging' onclick=optionBox("+ i +",'complete')>" + i +"</a></li>";   
                       }
                }else{
                   for(var i = blockStartNum; i <= lastPageNum; i++){
                    values2 += "<li><a href=# class='paging' onclick=optionBox("+ i +",'complete')>" + i +"</a></li>";  
                    }
                    
                    
                }           
                }
                    for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }        
                    
                
                  
                 console.log(values2);
                    
                  $("#paging ul").html(values2);
                  $(".paging").eq((curPage-1) % 5).css("color","red");
                    
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
                     values2 += "<li><a href='#' class='paging' onclick='searchByDate("+ i +")'>"+ i +"</a></li>"; 
                 }   
                    
                
                    
                  $("#paging ul").html(values2);
                  $(".paging").eq((curPage-1) % 5).css("color", "red");        
                    
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
                     values2 += "<li><a href='#' class='paging' onclick='mainDoc("+ i +")'>"+ i +"</a></li>"; 
                 }   
                 for(var i = lastPageNum+1; i <= blockLastNum; i++){
                     values2 += "<li>"+ i +"</li>"; 
                 }
               
               
                  
                    
                  $("#paging ul").html(values2);
                
                  $(".paging").eq(0).css("color", "red");    
                    
                },
                error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
            });  //페이지 실행시 메인화면 목록    

            
            $("#topSearchBar").keyup(function(){
                
                
            if($("#topSearchBar").val() != ""){
                 $.ajax({
                   url: "/sector/dtsbs",
                type: "get",
                data:{
                    docName : $("#topSearchBar").val()
                },
                dataType: "json",
                success: function(data) {
                
                var jsonStr = JSON.stringify(data);
                var json = JSON.parse(jsonStr);
                    
                var values = "";    
                    
                $("#topSearchDiv").css("display", "inline");
                
                
                for(var i in json.list){
                
                    var title = decodeURIComponent(json.list[i].title).replace(/\+/gi, " ");
                    
                    if(title.length > 9 ){
                        
                    title = title.substr(0, 9);  
                        
                    values += "<a href=# class=topA onclick=detailDoc("+ json.list[i].id +",'" +  json.list[i].level +"')>"+ title +  "...  (" + json.list[i].level + ") " + " 작성자 : " + decodeURIComponent(json.list[i].writer) +  "<br>"
                        
                    }else{
                        
                    values += "<a href=# class=topA onclick=detailDoc("+ json.list[i].id +",'" +  json.list[i].level +"')>"+ title +  "  (" + json.list[i].level + ")" + " 작성자 : " + decodeURIComponent(json.list[i].writer) +  "<br>"
                        
                    }
                    
                   /* values += "<a href=# class=topA onclick=detailDoc("+ json.list[i].id +",'" +  json.list[i].level +"')>"+ decodeURIComponent(json.list[i].title).replace(/\+/gi," ") + "   작성자 : " + decodeURIComponent(json.list[i].writer) + "(" + json.list[i].level + ")" + "<br>"*/
                    
                    
                }
                    
                $("#topSearchDiv").html(values);    
                    
                },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        } 
                
            });
            
            }
                
            });
            
           //상단 검색창으로 문서 제목 검색 
           
            
            
            $(document).click(function(e){
                if(!$(e.target).is('#topSearchBar')){
                     $("#topSearchDiv").css("display", "none");
                }
            }); //다른곳을 눌렀을때 상단 검색값 사라짐 


            





        }); //document ready
    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body></html>
