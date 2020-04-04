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
 

 
%>

<!doctype html>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="/sector/resources/css/erpInsert.css">


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
        
         #genre a {
            color: black;
            text-decoration: none;
        }

    </style>
    <!-- Custom styles for this template -->

    <script src="//cdn.ckeditor.com/4.12.1/basic/ckeditor.js"></script>



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


    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span2">
            </div>
            <div class="span10">

            </div>
        </div>



    </div>
    <br><br><br>
    <hr style=" margin: 0px;">
    <div id="side">
        <br>
        <br>
        &nbsp; &nbsp; &nbsp; <button id="write" onclick="location.href='/sector/views/erp/erpmain/erpInsert.jsp'">작성하기</button>

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
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="/sector/views/erp/erpmain/erpmain.jsp">결재 대기중인 문서</a> <br><br> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;<a href="/sector/views/erp/erpmain/erpmain.jsp">결재 완료된 문서</a> &nbsp; &nbsp; &nbsp;
            
          
            <hr> <br> &nbsp; &nbsp; &nbsp;
            <img src="/sector/resources/images/cal_icon.png" style="width: 25px; margin-bottom: 4px; padding: 0;">&nbsp; &nbsp; 날짜로 보기 <br>
            <br>
            &nbsp;
            <input id="date1" type="date" style="width: 140px;"> <input id="date2" type="date" style="width: 140px;"> <br><br>

            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="/sector/views/erp/erpmain/erpmain.jsp" style="font-weight: bold">조회하기</a>
            <hr>
            &nbsp; &nbsp; &nbsp;<a href="#"><img src="/sector/resources/images/KakaoTalk_20190902_174656733.png" width="20px" style="margin-bottom: 4px;"> &nbsp; 설정</a> <br><br>


        </div>

    </div>

    <div id="content">
        <form action="/sector/dus" method="post" enctype="multipart/form-data">
        <input type="submit" id="button1" value="수정하기"><br><br>
        <p style="font-weight: bold">기본설정</p>
        <table id="setting" border="1">
           
            <tr>
                <td>문서종류</td>
                <td style="text-align: left; padding-left: 20px;">
                <%= doc.getDocType() %> <input type="hidden" name="doctype" value="<%= doc.getDocType() %>">
                <input type="hidden" name="docid" value=<%= doc.getDocId() %>>
                </td>
                <td>작성자 </td>
                <td style="text-align: left; padding-left: 20px;">
                <%= docEmp.getEmpName() %>
                <input type="hidden" name="empid" value="<%= docEmp.getEmpId() %>">
                </td>
            </tr>
            <tr>
                <td>보존연한</td>
                <td>
                    <select id="year" name="year" required>
                        <option value="">보존연한</option>
                        <option value="1">1년</option>
                        <option value="3">3년</option>
                        <option value="5">5년</option>
                        <option value="10">10년</option>
                        <option value="">영구</option>
                    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>보안등급</td>
                <td>
                    <select id="grade" name="level" required>
                        <option value="">보안 등급</option>
                        <option value="A">A등급</option>
                        <option value="B">B등급</option>
                        <option value="C">C등급</option>
                        <option value="D">D등급</option>
                    </select>
                    <a href="#"><img src="/sector/resources/images/Qmark.PNG" id="Qmark"> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>

        </table>
        <br>
        <br>
        <br>

        <div id="manual">
            A등급 : 직급이 사장등급 이상부터 결재 및 열람할 수 있음. <br><br>
            B등급 : 직급이 부장등급 이상부터 결재 및 열람할 수 있음. <br><br>
            C등급 : 직급이 차장등급 이상부터 결재 및 열람할 수 있음. <br><br>
            D등급 : 모든직급이 열람할 수 있음. 결재는 과장등급 이상부터 가능


        </div>

        <p style="font-weight: bold">결재선 &nbsp;&nbsp;&nbsp;<a href="#" style="font-weight: 100" id="lineSetting">결재선 설정</a></p>
        <table id="line">
            <tr>
                <td>회람</td>
                <td>&nbsp;
                    <div id="lineOutput">
                    
                    </div>
                    <input type="hidden" name="lineemp" id="linehidden">
                    <input type="hidden" name="lineid" value="<%= line.getLineNo() %>">

                </td>
            </tr>

        </table>

        <div id="mask"></div>

        <div id="lineDiv">

            <a href="#" id="lineSetting2">결재선 설정</a> <br><br>
            &nbsp; &nbsp;<input type="text" id="lineSearch" placeholder=" 사원검색"><img src="/sector/resources/images/search.png" id="searchImg" style="cursor: pointer">
            <br><br>



            <div id="employee">
                <select multiple="multiple" id="multiple">



                </select>

            </div>

            <select multiple="multiple" id="multiple2">

            </select>

            <p id="lineP">결재</p>
            <p id="lineNumber">0</p>



            <img src="/sector/resources/images/leftarrow.PNG" style="cursor: pointer" id="leftArrow">
            <img src="/sector/resources/images/rightarrow.PNG" style="cursor: pointer" id="rightArrow">


            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button id="ok" type="button">확인</button>
            &nbsp;&nbsp;&nbsp;
            <button id="cancel" type="button">취소</button>


        </div>



        <br><br>
        <p style="font-weight: bold">상세입력</p>
        <p style="font-size: 11pt">&nbsp; 제목 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" id="title" name="title" value="<%= doc.getDocTitle() %>" required></p>
        <div>
            <textarea name="editor" id="text"></textarea>

            <script>
                CKEDITOR.replace('editor');

            </script>

        </div>

        <div id="dropZone">
            <p style="padding-top: 25px; float: left;">&nbsp; &nbsp; 별첨 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                
                <% if(sfile.getOriginalFileName() != null) { %>
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
                <%= sfile.getOriginalFileName() %> <input type="hidden" name="file" id="file" value="<%= sfile.getOriginalFileName() %>">
               
               <% } else{ %>
               	파일 없음
               <% } %>
            </p>
           

        </div>


        </form>
    </div>


    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>





    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script type="text/javascript" src="/sector/resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        //ajax Area 
        $(function() {

            
            
            
            
            <% if(loginMember == null){ %>
             alert("보안을 위해 다시 로그인 해주시길 바랍니다.");
             location.href="/sector/mainLogin.jsp";
            <% } %>
            
                
        
                
            $("#lineOutput").html('<%= line1.getEmpName() %>' +" " + '<%= line1.getJobName() %>' + " "
            + " " + '<%= line2.getEmpName() %>' +" " + '<%= line2.getJobName() %>' + ""
            + " " + '<%= line3.getEmpName() %>' +" " + '<%= line3.getJobName() %>' + ""
            + " " + '<%= line4.getEmpName() %>' +" " + '<%= line4.getJobName() %>' + ""
            + " " + '<%= line5.getEmpName() %>' +" " + '<%= line5.getJobName() %>' + ""
            + " " + '<%= line6.getEmpName() %>' +" " + '<%= line6.getJobName() %>' + ""
            + " " + '<%= line7.getEmpName() %>' +" " + '<%= line7.getJobName() %>' + ""
            
            
            
            ); //결재선 출력 
                     
            
            $("#text").html("<%= doc.getDocContent() %>");

          
            $("#Qmark").click(function() {
                $("#manual").toggle(400);
            }); //물음표 클릭하면 설명서나옴 

           
            $("#lineSetting").click(function() {

                
            	<%if(doc.getDocStatus().equals("진행") || doc.getDocStatus().equals("완료") ) { %>
                
            	alert("진행중인 문서의 결재라인은 수정할 수 없습니다.");
            	
            	<%} else { %>
                
                console.log('<%= doc.getDocStatus() %>');
                    
                $("#mask").css("display", "block");
                $("#lineDiv").css("display", "block");
                
                <% } %>
                
            }); // 결재선 설정창 팝업 띄우기

            $("#lineSetting2").click(function() {

                $("#lineDiv").css("display", "none");
                $("#mask").css("display", "none");
                $("#multiple").html("");

            }); // 결재선 설정창 팝업 닫기

            $("#lineSetting").click(function() {


                $.ajax({
                    url: "/sector/dlvsdd",
                    type: "get",
                    dataType: "json",
                    success: function(data) {



                        var jsonStr = JSON.stringify(data);
                        var json = JSON.parse(jsonStr);

                        var values = "";

                        for (var i in json.list) {

                            values +=
                                "<option value=" + json.list[i].empid +">" +
                                decodeURIComponent(json.list[i].name) + "(" + decodeURIComponent(json.list[i].job) +
                                ")" + " </option>"


                        }


                        $("#multiple").html($("#multiple").html() + values);


                    },
                    error: function(request, error) {
                        alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error: " + error);
                    }

                });



            }); // 결재선 설정창  직원 출력 

            $("#rightArrow").click(function() {


                var values = "";

                for (var i = 0; i < $("#multiple option:selected").length; i++) {

                    values += "<option class='select' value = " +
                        $("#multiple option:selected").eq(i).val() + ">" + $("#multiple option:selected").eq(i).text() + "</option>";


                }




                $("#multiple2").html($("#multiple2").html() + values);



                $("#lineNumber").html($("#multiple2 option").length);








            }); //결재선설정 오른쪽 화살표 눌렀을때 

            $("#leftArrow").click(function() {

                $("#multiple2 option:selected").remove();
                $("#lineNumber").html($("#multiple2 option").length);
            }); //결재선 설정 왼쪽 화살표 눌렀을때 

            $("#searchImg").click(function() {

                if ($("#lineSearch").val() == "") {

                    $("#multiple").html("");

                    $.ajax({
                        url: "/sector/dlvsdd",
                        type: "get",
                        dataType: "json",
                        success: function(data) {



                            var jsonStr = JSON.stringify(data);
                            var json = JSON.parse(jsonStr);

                            var values = "";

                            for (var i in json.list) {

                                values +=
                                    "<option value=" + decodeURIComponent(json.list[i].name) + ">" +
                                    decodeURIComponent(json.list[i].name) + "(" + decodeURIComponent(json.list[i].job) +
                                    ")" + " </option>"


                            }


                            $("#multiple").html($("#multiple").html() + values);



                        },
                        error: function(request, error) {
                            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error: " + error);
                        }

                    });


                } else {

                    $.ajax({
                        url: "/sector/dlssd",
                        type: "get",
                        data: {
                            name: $("#lineSearch").val()
                        },
                        dataType: "json",
                        success: function(data) {



                            var jsonStr = JSON.stringify(data);
                            var json = JSON.parse(jsonStr);

                            var values = "";

                            for (var i in json.list) {

                                values +=
                                    "<option value=" + decodeURIComponent(json.list[i].name) + ">" +
                                    decodeURIComponent(json.list[i].name) + "(" + decodeURIComponent(json.list[i].job) +
                                    ")" + " </option>"


                            }

                            $("#multiple").html("");
                            $("#multiple").html($("#multiple").html() + values);



                        },
                        error: function(request, error) {
                            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error: " + error);
                        }

                    });

                }

            }); //결재선 설정시 사원 검색 

            $("#ok").click(function() {

                var values = "";
                var values2 = "";

                for (var i = 0; i < $("#multiple2 option").length; i++) {

                   
                    
                    values += $("#multiple2 option").eq(i).text() + "   ";
                    values2 += $("#multiple2 option").eq(i).val();

                }







                $("#lineOutput").html(values);
                $("#linehidden").val(values2);
                
                console.log($("#linehidden").val());


                $("#lineDiv").css("display", "none");
                $("#mask").css("display", "none");
                $("#multiple").html("");
                
                
            }); //결재선 설정 확인버튼 눌렀을때 

            $("#cancel").click(function() {

                $("#lineDiv").css("display", "none");
                $("#mask").css("display", "none");
                $("#multiple").html("");

            }); //결재선 설정 취소버튼 눌렀을때 


            
            
             
    


          


        }); //document ready


       
       
            
    

        
        
        
        
        
    

    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>
