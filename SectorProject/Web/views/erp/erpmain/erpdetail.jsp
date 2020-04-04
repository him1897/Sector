<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="doc.model.vo.Doc, java.util.ArrayList, sfile.model.vo.Sfile, line.model.vo.Line, suser.model.vo.Suser"%>
<%

 Suser loginMember = (Suser)session.getAttribute("loginMember");

 Doc doc = (Doc)request.getAttribute("doc");
 Doc docEmp = (Doc)request.getAttribute("docEmp");
 
 Sfile sfile = (Sfile)request.getAttribute("sfile");
 
 Line line = (Line)request.getAttribute("line");
 
 Doc line1 = (Doc)request.getAttribute("line1");
 Doc line2 = (Doc)request.getAttribute("line2");
 Doc line3 = (Doc)request.getAttribute("line3");
 Doc line4 = (Doc)request.getAttribute("line4");
 Doc line5 = (Doc)request.getAttribute("line5");
 Doc line6 = (Doc)request.getAttribute("line6");
 Doc line7 = (Doc)request.getAttribute("line7");
 
 String a1 = (String)request.getAttribute("a1");
 String a2 = (String)request.getAttribute("a2");
 String a3 = (String)request.getAttribute("a3");
 String a4 = (String)request.getAttribute("a4");
 String a5 = (String)request.getAttribute("a5");
 String a6 = (String)request.getAttribute("a6");
 String a7 = (String)request.getAttribute("a7");
 

 
 
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
            width: 340px;
            height: 280px;
            padding-bottom: 10px;
        }

        #submenu2 {
            position: absolute;
            width: 300px;
            height: 300px;
        }

        #submenu3 {
            position: absolute;
            width: 300px;
            height: 300px;
        }


        #topmenu img {
            width: 80px;

        }


        #content {
            float: left;
            margin: 40px;
        }
        
        #genre a {
            color: black;
            text-decoration: none;
        }

    

        
    </style>
    <!-- Custom styles for this template -->
    
    <link rel="stylesheet" href="/sector/resources/css/erpdetail.css">
    
</head>

<body>
   
   <script type="text/javascript">
    
    <% if(loginMember == null){ %>
             alert("보안을 위해 다시 로그인 해주시길 바랍니다.");
             location.href="/sector/mainLogin.jsp";
            <% } %>
    </script>
   
    <nav class="navbar navbar-expand-md navbar-dark fixed-top" style="background-color: white;">
        <a class="navbar-brand" href="#"><a href="/sector/views/erp/erpmain/erpmain.jsp"><img src="/sector/resources/images/sector%20logo.png" style="width: 230px; padding: 3px;"></a></a>
        <nav id="nav_three">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">


            </button>
        </nav>



        <div class="collapse navbar-collapse" id="navbarsExampleDefault">

            <ul class="navbar-nav mr-auto">

                <li class="nav-item dropdown">
                    <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;">전자결재&nbsp; <img src="/sector/resources/images/arrow.png" style="width:16px;"></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu">

                        <table id="topmenu" cellpadding="14">
                            <tr>
                                <td><a href="#"><img src="/sector/resources/images/check.png"></a></td>
                                <td><a href="#"><img src="/sector/resources/images/human.png"></a></td>
                                <td><a href="#"><img src="/sector/resources/images/call.png"></a></td>

                            </tr>

                            <tr>
                                <td><a href="#"><img src="/sector/resources/images/mail.png"></a></td>
                                <td><a href="#"><img src="/sector/resources/images/cal.png"></a></td>
                                <td><a href="#"><img src="/sector/resources/images/board.png"></a></td>

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

                    <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;"><img src="/sector/resources/images/bell.png" style="width:16px;"></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu2">



                        &nbsp; 알림 <br>
                        <hr style="margin:0">


                    </div>
                </li>

            </ul>


            <ul class="navbar-nav mr-auto">


                <li class="nav-item dropdown">

                    <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;"><img src="/sector/resources/images/profile.png" style="width:35px;"></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu3">

                         <p id="name"></p>
                        <button type="button" id="logOut" onclick="logOut()">로그아웃</button>

                    </div>
                </li>

            </ul>


            <form class="form-inline my-2 my-lg-0">
                <span style=" border: 1px solid #ced5da; border-radius: 10px; padding: 3px; float:  ">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" style="border: 0px solid black;">
                    <button class="btn btn-secondary my-2 my-sm-0" id="searching" type="submit"><img src="/sector/resources/images/search.png" style="width: 30px;"></button>
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
    <hr style="border: 1px normal black; margin: 0px;">
    <div id="side">
       
        <br>
        <br>
        &nbsp; &nbsp; &nbsp;<button id="write" onclick="location.href='/sector/views/erp/erpmain/erpInsert.jsp'">작성하기</button>

        <br><br><br>
        <div id="genre">
            &nbsp; &nbsp; &nbsp; 진행중인 문서
            <img src="/sector/resources/images/arrow.png" style="width:15px; margin-bottom: 3px"> <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="/sector/views/erp/erpmain/erpmain.jsp" id="all">전체</a>
            &nbsp; &nbsp; &nbsp; <a href="/sector/views/erp/erpmain/erpmain.jsp" id="complete">완료</a> &nbsp; &nbsp; &nbsp; <a href="/sector/views/erp/erpmain/erpmain.jsp" id="progress">진행</a> <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="/sector/views/erp/erpmain/erpmain.jsp" id="standby">대기</a> &nbsp; &nbsp; &nbsp;  <a href="/sector/views/erp/erpmain/erpmain.jsp" id="reject">반려</a>
            <br>
            <br>
            &nbsp; &nbsp; &nbsp; 내 문서함 <img src="/sector/resources/images/arrow.png" style="width:15px; margin-bottom: 3px"> <br><br>
            &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; <a href="/sector/views/erp/erpmain/erpmain.jsp">결재 대기중인 문서</a> &nbsp; &nbsp; &nbsp; <br><br> &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; <a href="/sector/views/erp/erpmain/erpmain.jsp">결재 완료된 문서</a> &nbsp; &nbsp; &nbsp; 
            &nbsp; &nbsp; &nbsp;  &nbsp; 
            <hr> <br> &nbsp; &nbsp; &nbsp;
            <img src="/sector/resources/images/cal_icon.png" style="width: 25px; margin-bottom: 4px; padding: 0;">&nbsp; &nbsp; 날짜로 보기 <br>
            <br>
            &nbsp;
            <input id="date1" type="date" style="width: 140px; border: 1px solid black;"> <input id="date2" type="date" style="width: 140px; border: 1px solid black"> <br><br>

            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="/sector/views/erp/erpmain/erpmain.jsp" style="font-weight: bold">조회하기</a>
            <hr>
            &nbsp; &nbsp; &nbsp;<a href="#"><img src="/sector/resources/images/KakaoTalk_20190902_174656733.png" width="20px" style="margin-bottom: 4px;"> &nbsp; 설정</a> <br><br>


        </div>

    </div>

    <div id="content">
        <div>
        	<% if(doc.getDocWriter() == loginMember.getEmpId()) { %>
            <a href='#' id="modify" onclick=" modifyCheck()">내용수정
             &nbsp; &nbsp; &nbsp; <a href="#" id="delete" onclick="deleteDoc();">삭제</a> 
            <% } %>
            
            &nbsp; &nbsp; &nbsp; <a href="#" id="print" onclick="printOut();">인쇄하기</a> 
            
        </div> <br>
        
        <div>
           
           <table id="setting" border="1">
           
            <tr>
                <td>기안부서</td>
                <td><%= docEmp.getDeptName() %></td>
                <td>작성자 </td>
                <td><%= docEmp.getEmpName() %></td>
            </tr>
            <tr>
                <td>보존연한</td>
                <td><%= doc.getDocSaveEnd() %></td>
                <td>보안등급</td>
                <td>
                    <%= doc.getDocLevel() %> 등급
                    <a href="#"><img src="/sector/resources/images/Qmark.PNG" id="Qmark"></a>
                </td>
            

        </table>
          
          <br>
          
          <table id="lineTable" border="1">
              <tr>
                  <td rowspan="3">결재</td>
                  <td><%= line1.getJobName() %></td>
                  <td><%= line2.getJobName() %></td>
                  <td><%= line3.getJobName() %></td>
                  <td><%= line4.getJobName() %></td>
                  <td><%= line5.getJobName() %></td>
                  <td><%= line6.getJobName() %></td>
                  <td><%= line7.getJobName() %></td>
              </tr>
              
              <tr>
              		<!-- 서명 버튼 들어가는 곳  -->
                  <td>
                       <% if(!line1.getJobName().equals(""))  { %>
                       
                       <% if(a1.equals("N") && line1.getEmpId() == loginMember.getEmpId()) { %>
                  <button type="button" class="sign" id="sign1" onclick="sign(1,<%= doc.getDocId() %>)">서명하기</button> 
                  <br><br><button type="button" class="reject" id="reject1" onclick="reject(1, <%= doc.getDocId() %>)">반려하기</button> 	
                  		<% } %>
                  
                  		<% if(a1.equals("Y")){ %>
                  		
                   <img src="/sector/resources/images/sign.png"  class="check" id="check1"> <br><br> <p class="checkp">결재완료</p>
                  		<% } %>
                  		
                  		<% if(a1.equals("R")){ %>
                  		
                   <img src="/sector/resources/images/reject.png"  class="X"> <br><br> <p class="checkp">반려</p>
                  		<% } %>
                  		
                  
                  <% } %>
                      
                  </td>
                  <td style="height: 145px;">
                 
                     <% if(!line2.getJobName().equals("") )  { %>
                       
                       <% if(a2.equals("N") && a1.equals("Y") && line2.getEmpId() == loginMember.getEmpId()) { %>
                  <button type="button" class="sign" id="sign2" onclick="sign(2, <%= doc.getDocId() %>)">서명하기</button>		
                 <br><br><button type="button" class="reject" id="reject2" onclick="reject(2, <%= doc.getDocId() %>)">반려하기</button>
                  		<% } %>
                  
                  		<% if(a2.equals("Y")){ %>
                   <img src="/sector/resources/images/sign.png"  class="check" id="check2"> <br><br> <p class="checkp">결재완료</p>
                  		<% } %>
                  		
                  		
                  		<% if(a2.equals("R")){ %>
                  		
                   <img src="/sector/resources/images/reject.png"  class="X"> <br><br> <p class="checkp">반려</p>
                  		<% } %>
                  
                  <% } %>
                  
              
                  
                  </td>
                  
                  
                  
                  <td>
                          <% if(!line3.getJobName().equals(""))  { %>
                       
                       <% if(a3.equals("N") && a2.equals("Y") && line3.getEmpId() == loginMember.getEmpId()) { %>
                  <button type="button" class="sign" id="sign3" onclick="sign(3, <%= doc.getDocId() %>)">서명하기</button>
                  <br><br><button type="button" class="reject" id="reject3" onclick="reject(3, <%= doc.getDocId() %>)">반려하기</button>         	
                  		<% } %>
                  
                  		<% if(a3.equals("Y")){ %>
                   <img src="/sector/resources/images/sign.png"  class="check" id="check3"> <br><br> <p class="checkp">결재완료</p>
                  		<% } %>
                  		
                  		<% if(a3.equals("R")){ %>
                  		
                   <img src="/sector/resources/images/reject.png"  class="X"> <br><br> <p class="checkp">반려</p>
                  		<% } %>
                  
                  <% } %>
                      
                      
                  </td>
                  <td>
                          <% if(!line4.getJobName().equals(""))  { %>
                       
                       <% if(a4.equals("N")&& a3.equals("Y") && line4.getEmpId() == loginMember.getEmpId()) { %>
                  <button type="button" class="sign" id="sign4" onclick="sign(4, <%= doc.getDocId() %>)">서명하기</button>
                <br><br><button type="button" class="reject" id="reject4" onclick="reject(4, <%= doc.getDocId() %>)">반려하기</button>         		
                  		<% } %>
                  
                  		<% if(a4.equals("Y")){ %>
                   <img src="/sector/resources/images/sign.png"  class="check" id="check4"> <br><br> <p class="checkp">결재완료</p>
                  		<% } %>
                  		
                  		<% if(a4.equals("R")){ %>
                  		
                   <img src="/sector/resources/images/reject.png"  class="X"> <br><br> <p class="checkp">반려</p>
                  		<% } %>
                  
                  <% } %>
                      
                  </td>
                  <td>
                          <% if(!line5.getJobName().equals(""))  { %>
                       
                       <% if(a5.equals("N") && a4.equals("Y") && line5.getEmpId() == loginMember.getEmpId()) { %>
                  <button type="button" class="sign" id="sign5" onclick="sign(5, <%= doc.getDocId() %>)">서명하기</button>	
                  <br><br><button type="button" class="reject" id="reject5" onclick="reject(5, <%= doc.getDocId() %>)">반려하기</button>         	
                  		<% } %>
                  
                  		<% if(a5.equals("Y")){ %>
                   <img src="/sector/resources/images/sign.png"  class="check" id="check5"> <br><br> <p class="checkp">결재완료</p>
                  		<% } %>
                  		
                  		<% if(a5.equals("R")){ %>
                  		
                   <img src="/sector/resources/images/reject.png"  class="X"> <br><br> <p class="checkp">반려</p>
                  		<% } %>
                  
                  <% } %>
                      
                      
                  </td>
                  <td>
                          <% if(!line6.getJobName().equals(""))  { %>
                       
                       <% if(a6.equals("N") && a5.equals("Y") && line6.getEmpId() == loginMember.getEmpId()) { %>
                  <button type="button" class="sign" id="sign6" onclick="sign(6, <%= doc.getDocId() %>)">서명하기</button>	
                <br><br><button type="button" class="reject" id="reject6" onclick="reject(6, <%= doc.getDocId() %>)">반려하기</button>         	
                  		<% } %>
                  
                  		<% if(a6.equals("Y")){ %>
                   <img src="/sector/resources/images/sign.png"  class="check" id="check6"> <br><br> <p class="checkp">결재완료</p>
                  		<% } %>
                  		
                  		<% if(a6.equals("R")){ %>
                  		
                   <img src="/sector/resources/images/reject.png"  class="X"> <br><br> <p class="checkp">반려</p>
                  		<% } %>
                  
                  <% } %>
                      
                      
                  </td>
                  <td>
                           <% if(!line7.getJobName().equals(""))  { %>
                       
                       <% if(a7.equals("N") && a6.equals("Y") && line7.getEmpId() == loginMember.getEmpId() ) { %>
                  <button type="button" class="sign" id="sign7" onclick="sign(7, <%= doc.getDocId() %>)">서명하기</button> <p class="checkp">결재완료</p>
                <br><br><button type="button" class="reject" id="reject7" onclick="reject(7, <%= doc.getDocId() %>)">반려하기</button>		 
                  		<% } %>
                  
                  		<% if(a7.equals("Y")){ %>
                   <img src="/sector/resources/images/sign.png"  class="check" id="check7"> <br><br> <p class="checkp">결재완료</p>
                  		<% } %>
                  		
                  		<% if(a7.equals("R")){ %>
                  		
                   <img src="/sector/resources/images/reject.png"  class="X"> <br><br> <p class="checkp">반려</p>
                  		<% } %>
                  
                  <% } %>
                      
                      
                      
                  </td>
              </tr>
              
                <tr>
                  <td><%= line1.getEmpName() %></td>
                  <td><%= line2.getEmpName() %></td>
                  <td><%= line3.getEmpName() %></td>
                  <td><%= line4.getEmpName() %></td>
                  <td><%= line5.getEmpName() %></td>
                  <td><%= line6.getEmpName() %></td>
                  <td><%= line7.getEmpName() %></td>
               
                  
              </tr>
              
          </table>
           
           <div id="manual">
            A등급 : 직급이 사장등급 이상부터 결재 및 열람할 수 있음. <br><br>
            B등급 : 직급이 부장등급 이상부터 결재 및 열람할 수 있음. <br><br>
            C등급 : 직급이 차장등급 이상부터 결재 및 열람할 수 있음. <br><br>
            D등급 : 모든직급이 열람할 수 있음. 결재는 과장등급 이상부터 가능


        </div>
            
            
        </div>
        
        <br><br>
        
        <h2><%= doc.getDocTitle() %></h2>
        <br>
        <h5><%= doc.getDocContent() %></h4>
        
        <br>
        <br>
      
       <hr style="border: 0.5px solid gray;"> 
       
       
       
        <div id="attatch">
            첨부파일 
            
         <% if(sfile.getOriginalFileName() != null){ %>   
            <a href="/sector/dfdsd?ofile=<%= sfile.getOriginalFileName() %>&rfile=<%= sfile.getRenameFileName() %>"><%= sfile.getOriginalFileName() %></a>
          <% } else { %>
              없음 
             <% } %>  
            
        </div>
   
    </div>


    <br><br><br><br><br><br>





    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script type="text/javascript" src="/sector/resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/sector/resources/js/print.min.js"></script>
    <script type="text/javascript">
        
           function printOut(){
               
               var sw = screen.width;
               var sh = screen.height;
               var w = 800; // 팝업창 가로길이 
               var h = 600; // 세로길이 
               var xpos = (sw-w)/2; // 화면에 띄울 위치 
               var ypos = (sh-h)/2; // 중앙에 뛰웁니다 
               
               var pHeader="<html><head><link rel='stylesheet' type='text/css'  href='/sector/resources/css/erpdetail.css'><link rel='stylesheet'  href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T'  crossorigin='anonymous'><title>결재문서</title></head><body>";
               var pGetContent = $("#content").html() +"<br>";
               //인쇄할 내용 
               
               var pfooter="</body></html>";
               var pContent = pHeader + pGetContent + pfooter;
               
               var pWin = window.open("", "print","width=" + w + ", height =" + h + ", top=" + ypos + ", left=" + xpos + ", status=yes, scrollbar=yes"); //팝업창을 뛰움 
               
               pWin.document.open(); // 팝업창 오픈 
               pWin.document.write(pContent); //새롭게 만든 html 소스 첨부 
               pWin.document.close(); 
               pWin.print(); //인쇄 창 띄우기 
               pWin.close(); //팝업창 닫기 
               
               
           } //인쇄 기능 
        
            function deleteDoc() {
            var Del = confirm("삭제 하시겠습니까?");
            if (Del == true)
            {
            location.href="/sector/ddds?docid=<%= doc.getDocId() %>"
            alert("삭제 되었습니다.")
            
            } else {
            alert("취소 되었습니다.")
                }
            } //문서 삭제 기능 
        
        
            function sign(answer, docId){
                
                 $.ajax({
                    
                    url: "/sector/luas",
                    data:{
                        answerNo : answer,
                        docid : docId
                    },
                    success: function(){
                        location.href= "/sector/ddvs?docid=" + docId;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                    }


                    
                });
                
            } //사인버튼 눌렀을때 
        
            function reject(answer, docId){
                $.ajax({
                    
                    url: "/sector/dsrs",
                    data:{
                        answerNo : answer,
                        docid : docId
                    },
                    success: function(){
                        location.href= "/sector/ddvs?docid=" + docId;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                    }


                    
                });
            } //반려버튼 눌렀을때 
        
            function logOut(){
            var commit = confirm("로그아웃 하시겠습니까?");
            if (commit == true)
            {
            alert("메인페이지로 돌아갑니다.");
            location.href="/sector/dlos";
           
            }
             
         }    //로그아웃 
        
            function modifyCheck(){
                 if('<%= doc.getDocStatus() %>' == "진행" || '<%= doc.getDocStatus() %>' == "완료"){
                   
                    alert("진행중이거나 완료된 문서는 수정할 수 없습니다.");
                    
                    
                   }else{
                       location.href="/sector/duvsdd?docid=<%= doc.getDocId() %>";
                   }
                
                
                
            
            }
        
       //script Area 
        $(function() {

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
                
                
            
            
                        <% if(!line1.getJobName().equals(""))  { %>
                       
                       <% if(a1.equals("N")) { %>
                        $("#sign1").css("display", "inline");	
                  		<% } %>
                  
                  		<% if(a1.equals("Y")){ %>
                  		
                        $("#check1").css("display","inline");
                  		<% } %>
                  
                  <% } %>
                      
                      
                      
                      <% if(!line2.getJobName().equals(""))  { %>
                       
                       <% if(a2.equals("N")) { %>
                        $("#sign2").css("display", "inline");	
                  		<% } %>
                  
                  		<% if(a2.equals("Y")){ %>
                  		
                        $("#check2").css("display","inline");
                  		<% } %>
                  
                  <% } %>
                      
                      
                      <% if(!line3.getJobName().equals(""))  { %>
                       
                       <% if(a3.equals("N")) { %>
                        $("#sign3").css("display", "inline");	
                  		<% } %>
                  
                  		<% if(a3.equals("Y")){ %>
                  		
                        $("#check3").css("display","inline");
                  		<% } %>
                  
                  <% } %>
                      
                      <% if(!line4.getJobName().equals(""))  { %>
                       
                       <% if(a4.equals("N")) { %>
                        $("#sign4").css("display", "inline");	
                  		<% } %>
                  
                  		<% if(a4.equals("Y")){ %>
                  		
                        $("#check4").css("display","inline");
                  		<% } %>
                  
                  <% } %>
                      
                      
                      <% if(!line5.getJobName().equals(""))  { %>
                       
                       <% if(a5.equals("N")) { %>
                        $("#sign5").css("display", "inline");	
                  		<% } %>
                  
                  		<% if(a5.equals("Y")){ %>
                  		
                        $("#check5").css("display","inline");
                  		<% } %>
                  
                  <% } %>
            
            
                      
                      <% if(!line6.getJobName().equals(""))  { %>
                       
                       <% if(a6.equals("N")) { %>
                        $("#sign6").css("display", "inline");	
                  		<% } %>
                  
                  		<% if(a6.equals("Y")){ %>
                  		
                        $("#check6").css("display","inline");
                  		<% } %>
                  
                  <% } %>
                      
                      
                      <% if(!line7.getJobName().equals(""))  { %>
                       
                       <% if(a7.equals("N")) { %>
                        $("#sign7").css("display", "inline");	
                  		<% } %>
                  
                  		<% if(a7.equals("Y")){ %>
                  		
                        $("#check7").css("display","inline");
                  		<% } %>
                  
                  <% } %>
            
            
            
            var table = "<tr id='t1'>" +
                "<td>문서번호</td>" +
                "<td>제목</td>" +
                "<td>기안자</td>" +
                "<td>기안일</td>" +
                "<td>문서 종류</td>" + "<td>상태</td>" +
                "</tr>";

           $("#Qmark").click(function() {
                $("#manual").toggle(400);
            }); //물음표 클릭하면 설명서나옴

            
            $("#sign1").click(function(){
                 
                 $.ajax({
                     
                     url:"/sector/dsus",
                     data: {
                       docid : <%= doc.getDocId() %>  
                     }
                     
                 });
                 
             }); //첫번째 서명버튼이 눌리면 문서상태가 진행으로 바뀜 
            
        
            
            
                
                
             /* $("#sign1").click(function(){
                
                $.ajax({
                    
                    url: "/sector/luas",
                    data:{
                        answerNo : 1,
                        docid : <%= doc.getDocId()  %>
                    },
                    success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                    }


                    
                });
                
                
            }); */   
            //서명버튼이 눌리면 해당 라인에 결재유무가 N에서 Y로 바뀜     
            
                 
                  
             /* $("#sign3").click(function(){
                
                 $.ajax({
                    
                    url: "/sector/luas",
                    data:{
                        answerNo : 3,
                        docid : <%= doc.getDocId()  %>
                    }, success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        }    
                    
                });
                
                
            }); //서명버튼이 눌리면 해당 라인에 결재유무가 N에서 Y로 바뀜 
            
              $("#sign4").click(function(){
                
                 $.ajax({
                    
                    url: "/sector/luas",
                    data:{
                        answerNo : 4,
                        docid : <%= doc.getDocId()  %>
                    }, success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        }    
                    
                });
                
                
            }); //4번째 서명버튼 클릭하면 체크표시 나옴 
            
              $("#sign5").click(function(){
                
                 $.ajax({
                    
                    url: "/sector/luas",
                    data:{
                        answerNo : 5,
                        docid : <%= doc.getDocId()  %>
                    }, success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        }    
                    
                });
                
                
            }); //5번째 서명버튼 클릭하면 체크표시 나옴 
            
              $("#sign6").click(function(){
                
                 $.ajax({
                    
                    url: "/sector/luas",
                    data:{
                        answerNo : 6,
                        docid : <%= doc.getDocId()  %>
                    }, success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        }    
                    
                });
                
                
            }); //6번째 서명버튼 클릭하면 체크표시 나옴 
            
              $("#sign7").click(function(){
                
                $.ajax({
                    
                    url: "/sector/luas",
                    data:{
                        answerNo : 7,
                        docid : <%= doc.getDocId()  %>
                    }, success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        }    
                    
                });
                
                
            }); //7번째 서명버튼 클릭하면 체크표시 나옴 */
            
            
              
              for(var i = 2; i <= 6; i++ ){
                  
              if($("#lineTable td").eq(i+1).text() == ""){
                  
              $("#lineTable td").eq(i+7).children(".sign").click(function(){
                
                  $.ajax({
                    
                    url: "/sector/dsfs",
                    data:{
                        docid : <%= doc.getDocId()  %>
                        
                    }, success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        }    
                    
                });
                
                });
                  
                }
                                                                 
              if($("lineTable td").eq(8).val() != ""){
                  
                        
              $("#lineTable td").eq(8+7).children(".sign").click(function(){
                
                  $.ajax({
                    
                    url: "/sector/dsfs",
                    data:{
                        docid : <%= doc.getDocId()  %>
                        
                    }, success: function(){
                        location.href= "/sector/ddvs?docid=" + <%= doc.getDocId() %>;
                    },error:function(request,status,error){
                        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                        }    
                    
                });
                
                });
                  
              }
                  
              }//마지막 서명버튼을 클릭하면 문서가 완료상태로 수정됨 
            
            



        }); //document ready
    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body></html>
