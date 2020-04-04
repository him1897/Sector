<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="post.model.vo.Post, java.util.ArrayList, java.sql.Date, suser.model.vo.Suser" %> 
<%
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
                <a href="/sector/index.jsp"><img src="resources/images/sectorlogo.png" alt="" id="logo"></a>
                <div id="top-content" style="width: 300px;">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black; font-size: 20px;">게시판&nbsp; <img src="resources/images/arrow.png" style="height: 25px; width: 25px;" id="arrow"></a>
                            <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu">

                                <table id="topmenu">
                                    <tr>
                                        <td><a href="/sector/views/erp/erpmain/erpmain.jsp"><img src="resources/images/check.png" id="top-arrow-items"></a></td>
                                        <td><a href="#"><img src="resources/images/human.png" id="top-arrow-items"></a></td>
                                       
                                        <td><a href="/sector/ams"><img src="resources/images/call.png" id="top-arrow-items"></a></td>

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
                <div id="insert-button" style="margin-left: 15%;">
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
    <div id="enter2" style="width: 70%; float: left;">
    <div id="enter" style="width: 100%; float: left;">
<!--        <div style="width: 10%; height: 10%;">-->
        <ul class="nav nav-pills">
        <li class="nav-item dropdown" id="boki">
    <a class="nav-link dropdown-toggle" role="button" aria-expanded="false" aria-haspopup="true" href="#" data-toggle="dropdown">보기 : 모두</a>
    <div class="dropdown-menu" style="left: 0px; top: 0px; position: fixed; transform: translate3d(0px, 38px, 0px);">
      <a class="dropdown-item" href="#" onclick="mainPost('all')" id="allP">모두</a>
      <a class="dropdown-item" href="#" onclick="myPost()" id="myP">내가 쓴 글</a>
      

    </div>
      </li>
    </ul>
<!--       </div>-->
        

<br>

<div id="tableform">
        <table class="table table-hover" id="newPost">
        <colgroup>
            <col width="25%" />
            <col width="25%" />
            <col width="25%" />
            <col width="25%" />
        </colgroup>
       <thead>
  	  <tr>
      <th scope="col" style="text-align: center">제목</th>
      <th scope="col" style="text-align: center">작성자</th>
      <th scope="col" style="text-align: center">게시판종류</th>
      <th scope="col" style="text-align: center">작성날짜</th>
        </tr>
        </thead>
		</table>
 </div>
 
 		
 
 
 
 
  </div>  <!-- enter끝  -->
   
	<div id="searchbox" align="center" style="margin-left: 10px;">
 		
 		
 		<p><select name="category" id="category">
 		<option value="title" selected>제목
 		<option value="writer">작성자
 		</select>&nbsp;
 		<input type="search" name="keyword" id="keyword">
 		<input type="button" value="검색" onclick="searchfunction();"></p>
 		</div>
 		
 		<div align="center" id="pagebox">
 		</div>
 		
 	</div>	
 		
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
    
    var jb = jQuery.noConflict();
        
          var table = 
  	  "<tr>" +
      "<th scope='col' style='text-align: center'>제목</th>" +
      "<th scope='col' style='text-align: center'>작성자</th>" +
      "<th scope='col' style='text-align: center'>게시판종류</th>" +
      "<th scope='col' style='text-align: center'>작성날짜</th>" +
        "</tr>";
    	
        var currentpage;
        var maxpage;
        var startpage;
        var begin;
        var end;
        var limit;
        
        function showPage(data){
        	currentpage = data.currentpage;
			maxpage = data.maxpage;
			startpage = data.startpage;
			begin = data.begin;
			end = data.end;
			limit = data.limit;
			
			console.log("maxpage : " + maxpage + "," + currentpage + "," + startpage);
			var output = "<button id='startbtn'>|◀</button> &nbsp;<button id='beginbtn'>◀◀</button> &nbsp;";
			
			for(var p = begin; p <= end; p++){
				console.log("p : " + p);
				if(p == currentpage){
					output += "&nbsp;<a href='#' id='p" + p + "' onclick='movepage(" + p + ")'><b><font color = 'blue'> " + p + "</font></b></a>&nbsp;";
				}else{
					output += "&nbsp;<a href='#' id='p" + p + "' onclick='movepage(" + p + ")'> " + p + "</a>&nbsp;";
				}
				
			}
			output += "<button id='endbtn'>▶▶</button> &nbsp;<button id='maxbtn'>▶|</button>";
			jb("#pagebox").html(output);
			
			
			
			jb("#startbtn").click(function(){
				mainPost('all',startpage);
				return false;
				});
			jb("#beginbtn").click(function(){
				if((begin - 5) < startpage){
				mainPost('all',startpage);
				}else{
					mainPost('all',begin-5);
				}
				return false;
				});
			
  			
  			if((end + 5) > maxpage){
  				jb("#endbtn").click(function(){
  					mainPost('all',maxpage);
				return false;
				});
  			}else{
  				jb("#endbtn").click(function(){
  					mainPost('all',endpage+5);
				return false;
				});
  			}
  			jb("#maxbtn").click(function(){
  				mainPost('all',maxpage);
				return false;
			});
			
        }
         
        function movepage(page){
        	
        	
				
					console.log("#p" + page + "clicked");
	  				mainPost('all',page);
	  			
					return false;
				
			
        }
  			
         
         
         function mainPost(option, page){
        	 console.log("page : " + page);
	
	    jb.ajax({
		url: "/sector/saps",
		type: "get",
        data:{
          genre : option,
          page : page
        },
		dataType: "json",
		success: function(data){
			console.log("saps request success : ");
			//페이징 처리
			showPage(data);
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
			jb("#newPost").html(table + values);
			
			
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + 
					textStatus + ", " + errorThrown);
		}
	});
        
             
        
        
}; //게시글 전체 출력
        
         jb(function(){
        	 
 			
        jb.ajax({
		url: "/sector/saps",
		type: "get",
        data:{
          genre : 'all'  
        },
		dataType: "json",
		success: function(data){
			console.log("saps request success : ");
			showPage(data);
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
			jb("#newPost").html(table + values);
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + 
					textStatus + ", " + errorThrown);
		}
	});    //메인화면 실행시 전체 게시글 자동 출력  
            
		
		
		
		
	
	
        }); //document Ready 
        
        
        function searchfunction(){
        	
        	jb.ajax({
        		url: "/sector/bsearch",
        		type: "get",
        		data:{
        			category : jb("#category").val(),
        			keyword : jb("#keyword").val(),
        			page : currentpage
        		},
        		dataType: "json",
        		success: function(data){
        			console.log("bsearch request success : ");
        			showPage(data);
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
        			jb("#newPost").html(table + values);
        		},
        		error: function(jqXHR, textStatus, errorThrown){
        			console.log("error : " + jqXHR + ", " + 
        					textStatus + ", " + errorThrown);
        		}
        	});
        	
        	
        	
        	
        }
        
       
        
        function myPost() {
       	 
        	
    	    jb.ajax({
    		url: "/sector/mps",
    		type: "get",
    		data:{
    			empid : <%= loginMember.getEmpId() %>
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
    			jb("#newPost").html(table + values);
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
            jb.ajax({
                url: "/sector/views/post/postWriteForm.jsp",
                type: 'GET',
                dataType: "text",
                success: function(data) {
                    console.log(data);
                    jb('#enter').html(data);
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