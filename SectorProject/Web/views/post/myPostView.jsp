<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="emp.model.vo.Emp, post.model.vo.Post, java.util.ArrayList, java.sql.Date, suser.model.vo.Suser" %>
<%
	Suser loginMember = (Suser)session.getAttribute("loginMember");
	ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>    
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/style1.css" type="text/css">
    
    <title id="special">Insert title here</title>

<script type="text/javascript">




/* $("#allpost").on(clickfunction ajax(){
	$.ajax({
		url: "saps",
		type: "get",
		dataType: "json",
		success: function(data){
			console.log("saps request success : " 
					+ data);
			//객체를 문자열로 변환 처리함
			var jsonStr = JSON.stringify(data);
			//문자열을 배열 객체로 바꿈
			var json = JSON.parse(jsonStr);
			
			var values = "";
			for(var i in json.list){				
				values += "<tr><td>" + json.list[i].title + 
						"</td><td><a href='ndetail?noticeno=" 
						+ json.list[i].title + "'>" + 
						decodeURIComponent(json.list[i].writer).replace(/\+/gi, " ")
						+ "</a></td><td>" + json.list[i].boardName
						+ "</td></tr><td>" + json.list[i].date;
			}  //for in
			
			//테이블에 추가
			jQuery("#newPost").html(jQuery("#newPost").html() + values);
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + 
					textStatus + ", " + errorThrown);
		}
	}); 
};*/
</script>
</head>

<body>
   
   <%@ include file="../common/index.jsp" %>
   
   
   
   
    
           
<br>
<div id="tableform">
        <table id="newPost" class="table table-hover">
       <thead>
  	  <tr>
      <th scope="col" style="text-align: center">제목</th>
      <th scope="col" style="text-align: center">작성자</th>
      <th scope="col" style="text-align: center">게시판종류</th>
      <th scope="col" style="text-align: center">작성날짜</th>
        </tr>
        </thead>
        <% for(Post post : list){ 
        	if(post.getEmpId() == loginMember.getEmpId())%>
   		
        <tbody>
        <tr>
      <td align="center"><%= post.getPostTitle() %></td>
	  <td align="center"><%= post.getWriter() %></td>
      <td align="center"><%= post.getBoardName() %></td>
      <td align="center"><%= post.getPostDate() %></td>
       </tr>
        </tbody>
        <% } %>
</table>
 </div>
 
  <div id="serch1">
      <form class="form-inline my-2 my-lg-0" id="ser1">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
  </div>
 
 
 
    <!-- enter끝 --!>
   

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
  
  
  
  
  

    <!--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑mid bar bottom↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
    <footer>
        
    </footer>






    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
</body>

</html>