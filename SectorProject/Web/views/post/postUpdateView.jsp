<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="post.model.vo.Post, java.util.ArrayList, java.sql.Date, suser.model.vo.Suser" %> 
<%
	Post post = (Post)request.getAttribute("post");
    Suser loginMember = (Suser)session.getAttribute("loginMember");
%>  
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/style1.css" type="text/css">
    
    <title id="special">Insert title here</title>
    
    <style type="text/css">
    
        
        #tableform td {
        text-align: center;    
        }
        
        
    </style>
</head>

<body>
   
   
   
   
   
   
    <header>
        <div class="container-fluid" id="top-bar-container">
            <div style="width: 100%;" class="row" id="top-bar">
                <a href="/sector/index.jsp"><img src="resources/images/sectorlogo.png" height="50px;" alt="" id="logo"></a>
                <div id="top-content" style="width: 300px;">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                           <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black; font-size: 20px;">게시판&nbsp; <img src="resources/images/arrow.png" style="height: 25px; width: 25px;" id="arrow"></a>
                            <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu">

                                <table id="topmenu">
                                    <tr>
                                        <td><a href="#"><img src="resources/images/check.png" id="top-arrow-items"></a></td>
                                        <td><a href="#"><img src="resources/images/human.png" id="top-arrow-items"></a></td>
                                        <td><a href="#"><img src="resources/images/memu.png" id="top-arrow-items"></a></td>
                                        <td><a href="#"><img src="resources/images/call.png" id="top-arrow-items"></a></td>

                                    </tr>

                                    <tr>
                                        <td><a href="#"><img src="resources/images/mail.png" id="top-arrow-items"></a></td>
                                        <td><a href="#"><img src="resources/images/cal.png" id="top-arrow-items"></a></td>
                                        <td><a href="#"><img src="resources/images/board.png" id="top-arrow-items"></a></td>
                                    </tr>
                                </table>
                            </div>
                        </li>
                    </ul>
                </div>
                
                   <div style="width: 20%; height: 54%; float: left; margin-left: 30%;" id="sercan">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" style="width: 360px;">
                    </div>
                    <img src="resources/images/search.png" id="search-icon" alt="" >
                    
                     <img src="resources/images/bell.png" id="bell" alt="" style="width: 35px; height: 35px; float: left; margin-left: 40px; margin-top: 10px;">
                   
                    <img src="resources/images/profile.png" id="profile" alt="" style="width: 50px; height: 50px; margin-left:24px;">
                    
                   
                    
                  <div style="margin-top: 10px; margin-left: 10px;">
                  <h4><%= loginMember.getUserName() %> 님</h4>
                  </div>
                  
                  <form class="form-signin" method="POST" action="/sector/lous">
                  <input type="submit" href="#" style="margin-top: 25px; margin-left: 20px; float: left;" value="로그아웃">
                </form>
                
                
            </div>
        </div>
    </header>
    <!--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑top bar mid↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
    <div class="row" style="width: 100%; height: 100%;">

        <nav id="side-menu">
            <div id="sidemenu">
                <br>
                <div id="insert-button">
                   <button onclick="writeForm();" id="insert-address">글쓰기</button>
                </div>


                <div id="genre" style="width: 100%; margin-top: 10%; line-height: 40px;">

                    <ul id="sidemenu-content" style="margin-top: 15px; line-height: 60px; margin-left: 5%;">
                    <li><a href="#" id="allpost" onclick="mainPost('all')">전체 게시판</a></li>
                    <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" aria-expanded="false" aria-haspopup="true" href="#" data-toggle="dropdown" style="padding: 0;">부서별게시판</a>
                    <div class="dropdown-menu" style="position: absolute; line-height: 10px; margin-bottom: 20px; font-size: 17px;">
                      <a class="dropdown-item" href="#" id="allpost" onclick="mainPost('FN')">재무부서</a>
                     <a class="dropdown-item" href="#" id="allpost" onclick="mainPost('HR')">인사부서</a>
                      <a class="dropdown-item" href="#" id="allpost" onclick="mainPost('AD')">행정부서</a>
                      <a class="dropdown-item" href="#" id="allpost" onclick="mainPost('ST')">기획부서</a>
            		</div>
          			</li>
                        
                        
                        
                        <li><a href="#" id="menu-items" onclick="mainPost('free')">자유게시판</a></li>
                        <li><a href="#" id="menu-items" onclick="mainPost('notice')">공지사항</a>
                        </li>
                    </ul>
                </div>
                
                
                
                
                <br><br>
                
            </div>


        </nav>
        
    <div id="enter">
<form action="/sector/ups" method="get" 
enctype="multipart/form-data">
  <fieldset>
   
    <div class="form-group row">
     <p class="lh"><input type="submit" value="수정하기" style="margin-left: 15px; width: 180px; height : 40px; margin-top: 3%;"></p>
     <input type="hidden" name="postid" value="<%= post.getPostId() %>">
      </div>
    <div class="form-group" style="width: 30%; height: 60px;">
        <label for="exampleSelect1" style="font-size: 20px; margin-top: 5%; float: left;">게시판 종류</label>
      <select class="form-control" id="exampleSelect1" name="genre" style="width: 50%; height: 35px; margin-left: 20px; margin-top: 20px; float: left;" value="<%= post.getBoardName() %>">
        <option value="재무부서">재무부서</option>
        <option value="인사부서">인사부서</option>
        <option value="행정부서">행정부서</option>
        <option value="기획부서">기획부서</option>
        <option value="자유게시판">자유게시판</option>
        <option value="공지사항">공지사항</option> 
      </select>
    </div>
    
     <div class="form-group" style="width: 80%; height: 60px;"><p class="lh">
      <label for="exampleInputTitle" style="font-size: 20px; margin-top: 22px; float: left;">제목 </label>
      <input class="form-control" id="exampleInputTitle" name="title" type="text" style="width: 500px; height: 4%; margin-left: 5%; margin-top: 14px; float: left;" value="<%= post.getPostTitle() %>">
      <input type="hidden" value="3" name="empId">
    </p></div>
    
     <div class="form-group textarea">
      <textarea class="form-control" id="exampleTextarea" name="content" cols="100%" rows="15px;" style="font-size: 17px;"><%= post.getPostContent() %></textarea>
    </div>
  </fieldset>
</form>
 
 
 
  </div>  <!-- enter끝 --!>
   

<!--
  <ul class="pagination" style="width: 0%; height: 36px;">
    <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
    <li class="page-item active">
      <a class="page-link" href="#">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">2</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">3</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">4</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">5</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
    </li>
  </ul>
-->
  
   
<!--
   <div style="width: 320px; height: 60px;" id="serch1">
      <form class="form-inline my-2 my-lg-0" id="ser1" style="width: 310px;">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
  </div>
-->
  
  
  
  
  
</div>
    <!--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑mid bar bottom↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
    <footer>
        
    </footer>


    




    <script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous" type="text/javascript">
    </script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   	
    <script type="text/javascript">
    
        
          var table = 
  	  "<tr>" +
      "<th scope='col' style='text-align: center'>제목</th>" +
      "<th scope='col' style='text-align: center'>작성자</th>" +
      "<th scope='col' style='text-align: center'>게시판종류</th>" +
      "<th scope='col' style='text-align: center'>작성날짜</th>" +
        "</tr>";
        
         function mainPost(option){
        	 
	
	    $.ajax({
		url: "/sector/saps",
		type: "get",
        data:{
          genre : option  
        },
		dataType: "json",
		success: function(data){
			console.log("saps request success : ");
			//객체를 문자열로 변환 처리함
			var jsonStr = JSON.stringify(data);
			//문자열을 배열 객체로 바꿈
			var json = JSON.parse(jsonStr);
			
			var values = "";
			for(var i in json.list){				
				values += "<tr><td><a href='/sector/pdvs?postid="+ json.list[i].id + "'>" +decodeURIComponent(json.list[i].title).replace(/\+/gi, " ")+ "</a>" + 
				"</td><td>" 
				+
				decodeURIComponent(json.list[i].writer).replace(/\+/gi, " ")
				+ "</a></td><td>" + decodeURIComponent(json.list[i].boardName).replace(/\+/gi, " ")
				+ "</td><td>" + json.list[i].date + "</td></tr>";
			}  //for in
			
			//테이블에 추가
			$("#newPost").html(table + values);
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + 
					textStatus + ", " + errorThrown);
		}
	});
        
             
        
        
}; //게시글 전체 출력
        
         $(function(){
        
        $.ajax({
		url: "/sector/saps",
		type: "get",
        data:{
          genre : 'all'  
        },
		dataType: "json",
		success: function(data){
			console.log("saps request success : ");
			//객체를 문자열로 변환 처리함
			var jsonStr = JSON.stringify(data);
			//문자열을 배열 객체로 바꿈
			var json = JSON.parse(jsonStr);
			
			var values = "";
			for(var i in json.list){				
				values += "<tr><td><a href='/sector/pdvs?postid="+ json.list[i].id + "'>" +decodeURIComponent(json.list[i].title).replace(/\+/gi, " ")+ "</a>" + 
						"</td><td>" 
						+
						decodeURIComponent(json.list[i].writer).replace(/\+/gi, " ")
						+ "</a></td><td>" + decodeURIComponent(json.list[i].boardName).replace(/\+/gi, " ")
						+ "</td><td>" + json.list[i].date + "</td></tr>";
			}  //for in
			
			//테이블에 추가
			$("#newPost").html(table + values);
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + 
					textStatus + ", " + errorThrown);
		}
	});    //메인화면 실행시 전체 게시글 자동 출력  
            
        }); //document Ready 
        
        
        function myPost(option) {
       	 
        	
    	    $.ajax({
    		url: "/sector/mps",
    		type: "get",
    		data:{
    			writeName : option
    		},
    		dataType: "json",
    		success: function(data){
    			console.log("mps request success : ");
    			//객체를 문자열로 변환 처리함
    			var jsonStr = JSON.stringify(data);
    			//문자열을 배열 객체로 바꿈
    			var json = JSON.parse(jsonStr);
    			
    			var values = "";
    			for(var i in json.list){				
    				values += "<tr><td><a href='/sector/pdvs?postid="+ json.list[i].id + "'>" +decodeURIComponent(json.list[i].title).replace(/\+/gi, " ")+ "</a>" + 
    				"</td><td>" 
    				+
    				decodeURIComponent(json.list[i].writer).replace(/\+/gi, " ")
    				+ "</a></td><td>" + decodeURIComponent(json.list[i].boardName).replace(/\+/gi, " ")
    				+ "</td><td>" + json.list[i].date + "</td></tr>";
    			}  //for in
    			
    			//테이블에 추가
    			$("#newPost").html(table + values);
    		},
    		error: function(jqXHR, textStatus, errorThrown){
    			console.log("error : " + jqXHR + ", " + 
    					textStatus + ", " + errorThrown);
    		}
    	});
            
                 
            
            
    };
        
        
        
        
    </script>
    
        <script type="text/javascript">
        function writeForm() {
            $.ajax({
                url: "/sector/views/post/postWriteForm.jsp",
                type: 'GET',
                dataType: "text",
                success: function(data) {
                    console.log(data);
                    $('#enter').html(data);
                },
                fail: function(error) {
                    console.log(error);
                },
                always: function(response) {

                }
            });
        }
    </script>
</body>

</html>