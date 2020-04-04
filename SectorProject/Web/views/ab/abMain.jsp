<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="emp.model.vo.Emp, java.util.ArrayList, ab.model.vo.Ab, suser.model.vo.Suser" %>
<%
	//forwarding 된 request 객체에 저장한 정보 꺼내기
	ArrayList<Emp> emplist = (ArrayList<Emp>)request.getAttribute("emplist");
	ArrayList<Ab> ablist = (ArrayList<Ab>)request.getAttribute("ablist");
	Suser loginMember = (Suser)session.getAttribute("loginMember");
	
%>


<!DOCTYPE html>
<html>

<head>
    <link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/yjstyle.css">

    <title id="special">SECTOR : 주소록</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous" type="text/javascript"></script>
    <script type="text/javascript">
<% if(loginMember.getIdent().equals("Y")){ %>
        //////////jquery가능///////////
        var jb = jQuery.noConflict();
        function uncheck() {
            jb('.personalcheckboss').prop("checked", false);
            jb('.sharecheckboss').prop("checked", false);
            jb('.deletecheckboss').prop("checked", false);
            jb('#share-delete-move').css("display", "none");
            jb('#personal-delete-move').css("display", "none");
           jb('#delete-delete-move').css("display", "none");
        }
        function insertAb() {
            jb.ajax({
                url: '/sector/views/ab/insertAb.jsp',
                type: 'GET',
                dataType: "text",
                success: function(data) {
                    jb('#main-table').html(data);
                },
                fail: function(error) {
                    console.log(error);
                },
                always: function(response) {

                }
            });
        }

        function selectAllShare(selectval) {
            uncheck();
            var empid = "<%= loginMember.getEmpId() %>";
            var userid = "<%= loginMember.getUserId() %>";
            var usercomno ="<%= loginMember.getUserComNo() %>";
            jb('.table-boss').each(function() {
                jb('.alltable').css('display', 'none');
            });
            jb.ajax({
                url: '/sector/assl',
                type: 'GET',
                data: {
                	userid: userid,
                    empid: empid,
                    sharesort: selectval,
                    usercomno: usercomno
                },
                dataType: "JSON",
                success: function(data) {

                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var str = "";

                    for (var i in json.list) {
                        str += "<tr>" +
                            "<td><input type='checkbox' class='sharecheck' name='sharecheck' value='"+json.list[i].phone+"' onclick='shareCheckHidden();'></td>" +
                            "<td>" + decodeURIComponent(json.list[i].com) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].name) + "</td>" +
                            "<td>" + json.list[i].phone + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].jobname) + "</td>" +
                            "<td>" + json.list[i].email + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].address).replace(/\+/gi, " ") + "</td></tr>"
                    };

                    jb('#share-table-body').html(str);

                },
                error: function(textStatus) {
                    console.log(textStatus);
                }

            });
            jb('#share-table').css('display', 'block');
        }



        function selectAllPersonal(selectval) {
            uncheck();
            var userid = "<%= loginMember.getUserId() %>";
            jb('.table-boss').each(function() {
                jb('.alltable').css('display', 'none');
            });
            jb.ajax({

                url: '/sector/aspls',
                type: 'GET',
                data: {
                    userid: userid,
                    personalsort: selectval
                },
                dataType: "JSON",
                success: function(data) {


                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var str = "";

                    for (var i in json.list) {
                        str += "<tr>" +
                            "<td><input type='checkbox' class='personalcheck' name='personalcheck' value='"+json.list[i].phone+"' onclick='personalCheckHidden();'></td>" +
                            "<td>" + decodeURIComponent(json.list[i].com) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].name) + "</td>" +
                            "<td>" + json.list[i].phone + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].jobname) + "</td>" +
                            "<td>" + json.list[i].email + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].address).replace(/\+/gi, " ") + "</td	></tr>"

                    }

                    jb('#personal-table-body').html(str);



                },
                error: function(request, status, error) {
                    /* alert("code = " + request.status + " message = " + request.responseText + " error = " + error);
 */
                }

            });
            jb('#personal-table').css('display', 'block');
        }
        
        function selectAllDelete(selectval) {
            uncheck();
            var userid = "<%= loginMember.getUserId() %>";
            jb('.table-boss').each(function() {
                jb('.alltable').css('display', 'none');
            });
            jb.ajax({

                url: '/sector/asdls',
                type: 'GET',
                data: {
                    userid: userid,
                    deletesort: selectval
                },
                dataType: "JSON",
                success: function(data) {


                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var str = "";

                    for (var i in json.list) {
                        str += "<tr>" +
                            "<td><input type='checkbox' class='deletecheck' name='deletecheck' value='"+json.list[i].phone+"' onclick='deleteCheckHidden();'></td>" +
                            "<td>" + decodeURIComponent(json.list[i].com) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].name) + "</td>" +
                            "<td>" + json.list[i].phone + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].jobname) + "</td>" +
                            "<td>" + json.list[i].email + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].address).replace(/\+/gi, " ") + "</td></tr>"

                    }

                    jb('#delete-table-body').html(str);



                },
                error: function(request, status, error) {
                    /* alert("code = " + request.status + " message = " + request.responseText + " error = " + error); */

                }

            });
            jb('#delete-table').css('display', 'block');
        }



        function selectAllEmp(selectval) {
            uncheck();
            jb('.table-boss').each(function() {
                jb('.alltable').css('display', 'none');
            });
            jb.ajax({
                url: '/sector/asels',
                type: 'GET',
                data: {
                    empsort: selectval
                },
                dataType: "JSON",
                success: function(data) {

                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var str = "";


                    for (var i in json.list) {
                        str += "<tr class='testno"+ json.list[i].rownum +"'>" +
                            "<td></td>" +
                            "<td>" + decodeURIComponent(json.list[i].deptname) + "</td>" +
                            "<td>" + decodeURIComponent(json.list[i].name) + "</td>" +
                            "<td name='phoneuniq' value='"+json.list[i].phone+"'>" + json.list[i].phone + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].jobname) + "</td>" +
                            "<td>" + json.list[i].email + "</td>" +
                            "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].address).replace(/\+/gi, " ") + "</td	></tr>"
                    }



                    jb('#emp-table-body').html(str)


                },
                error: function(request, status, error) {
                   /*  alert("code = " + request.status + " message = " + request.responseText + " error = " + error); */
                }

            });
            jb('#emp-table').css('display', 'block');
        }

        function sendData(data) {
            var selectval;

            if (data == "emp") {
                selectval = jb("#empsortselect").val();
                selectAllEmp(selectval);
            } else if (data == "personal") {
                selectval = jb("#personalsortselect").val();
                selectAllPersonal(selectval);
            } else if (data == "share"){
                selectval = jb("#sharesortselect").val();
                selectAllShare(selectval);
            } else {
                selectval = jb("#deletesortselect").val();
                selectAllDelete(selectval);
            }

        }



        function sendSelectData(data) {
            var searchselectval;
            var searchselectkeyword;
            var name;
            if (data == "emp") {
                searchselectval = jb('#empsearchselect').val();
                searchselectkeyword = jb('#empsearchkeyword').val();
                name = data;
            } else if (data == "personal") {
                searchselectval = jb('#personalsearchselect').val();
                searchselectkeyword = jb('#personalsearchkeyword').val();
                name = data;
            } else if (data == "share") {
                searchselectval = jb('#sharesearchselect').val();
                searchselectkeyword = jb('#sharesearchkeyword').val();
                name = data;
            } else {
            	searchselectval = jb('#deletesearchselect').val();
            	searchselectkeyword = jb('#deletesearchkeyword').val();
            	name = data;
            }


            selectSearch(searchselectval, searchselectkeyword, name);


        }


        function selectSearch(searchselectval, searchselectkeyword, name) {
            uncheck();
            jb('.table-boss').each(function() {
                jb('.alltable').css('display', 'none');
            });
            jb.ajax({
                url: '/sector/ass',
                type: 'GET',
                data: {
                    searchselectval: searchselectval,
                    searchselectkeyword: searchselectkeyword,
                    name: name
                },
                dataType: "JSON",
                success: function(data) {

                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    var str = "";

                    if (name == "emp") {

                        for (var i in json.list) {
                            str += "<tr>" +
                                "<td></td>" +
                                "<td>" + decodeURIComponent(json.list[i].deptname) + "</td>" +
                                "<td>" + decodeURIComponent(json.list[i].name) + "</td>" +
                                "<td name='phoneuniq' value='"+json.list[i].phone+"'>" + json.list[i].phone + "</td>" +
                                "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].jobname) + "</td>" +
                                "<td>" + json.list[i].email + "</td>" +
                                "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].address).replace(/\+/gi, " ") + "</td	></tr>"
                        }
                    } else {

                        for (var i in json.list) {
                            str += "<tr>" +
                                "<td><input type='checkbox' class='" + name + "'check name='" + name + " value='"+json.list[i].phone+"' check' onclick='" + name + "CheckHidden'></td>" +
                                "<td>" + decodeURIComponent(json.list[i].com) + "</td>" +
                                "<td>" + decodeURIComponent(json.list[i].name) + "</td>" +
                                "<td name='phoneuniq' value='"+json.list[i].phone+"'>" + json.list[i].phone + "</td>" +
                                "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].jobname) + "</td>" +
                                "<td>" + json.list[i].email + "</td>" +
                                "<td class='d-none d-xl-table-cell'>" + decodeURIComponent(json.list[i].address).replace(/\+/gi, " ") + "</td	></tr>"

                        }

                    }

                    if (name == "emp") {
                        jb('#emp-table-body').html(str)
                    } else if (name == "personal") {
                        jb('#personal-table-body').html(str)
                    } else if (name == "share"){
                        jb('#share-table-body').html(str)
                    } else {
                    	jb('#delete-table-body').html(str)
                    }


                },
                error: function(request, status, error) {
                   /*  alert("code = " + request.status + " message = " + request.responseText + " error = " + error); */
                }

            });

            if (name == "emp") {
                jb('#emp-table').css('display', 'block');
            } else if (name == "personal") {
                jb('#personal-table').css('display', 'block');
            } else if (name == "share"){
                jb('#share-table').css('display', 'block');
            } else {
            	jb('#delete-table').css('display', 'block');
            }
        }

        function shareCheckHidden() {

            var flag = false;

            jb(".sharecheck").each(function(index, item) {

                if (jb(this).is(":checked")) {
                    flag = true;
                }

            });

            if (flag) {
                jb("#share-delete-move").css('display', 'block');
            } else {
                jb("#share-delete-move").css('display', 'none');
            }

        }


        function personalCheckHidden() {

            var flag = false;

            jb(".personalcheck").each(function(index, item) {

                if (jb(this).is(":checked")) {
                    flag = true;
                }

            });

            if (flag) {
                jb("#personal-delete-move").css('display', 'block');
            } else {
                jb("#personal-delete-move").css('display', 'none');
            }
        }
        
        function deleteCheckHidden() {

            var flag = false;

            jb(".deletecheck").each(function(index, item) {

                if (jb(this).is(":checked")) {
                    flag = true;
                }

            });

            if (flag) {
                jb("#delete-delete-move").css('display', 'block');
            } else {
                jb("#delete-delete-move").css('display', 'none');
            }
        }

        jb(document).ready(function() {
            jb(".personalcheckboss").click(function() {
                if (jb(".personalcheckboss").prop("checked")) {
                    jb("input[name=personalcheck]").prop("checked", true);
                } else {
                    jb("input[name=personalcheck]").prop("checked", false);
                }
                personalCheckHidden();
            });

            jb(".sharecheckboss").click(function() {
                if (jb(".sharecheckboss").prop("checked")) {
                    jb("input[name=sharecheck]").prop("checked", true);
                } else {
                    jb("input[name=sharecheck]").prop("checked", false);
                }
                shareCheckHidden();
            });
            
            jb(".deletecheckboss").click(function() {
                if (jb(".deletecheckboss").prop("checked")) {
                    jb("input[name=deletecheck]").prop("checked", true);
                } else {
                    jb("input[name=deletecheck]").prop("checked", false);
                }
                deleteCheckHidden();
            });

        });
        
        var array = new Array();
        
        
  	    function todelete(){
  	    	
  	    	var values = "";
  	    	
  	    	jb(".personalcheck:checked").each(function(){
  	    		values += jb(this).val().trim() + ","; 
  	    		
  	    	});
			location.href="/sector/atds?values=" + values;  	    
			
  	    }
  	    
  	    function deletetopersonal(){
  	    	
  	    	var values = "";
  	    	
  	    	jb(".deletecheck:checked").each(function(){
  	    		values += jb(this).val().trim() + ","; 
  	    		
  	    	});
			location.href="/sector/adtps?values=" + values;  	    
			
  	    }
  	    
	  	function sharetopersonal(){
		    	
	    	var values = "";
	    	
	    	jb(".sharecheck:checked").each(function(){
	    		values += jb(this).val().trim() + ","; 
	    		
	    	});
			location.href="/sector/astps?values=" + values;  	    
				
	    }
  	  
	  	function deleteAb(){
	    	
	    	var values = "";
	    	
	    	jb(".deletecheck:checked").each(function(){
	    		values += jb(this).val().trim() + ","; 
	    		
	    	});
			location.href="/sector/adas?values=" + values;  	    
			
	    }
	  	
		function toshare(){
	    	
	    	var values = "";
	    	
	    	jb(".personalcheck:checked").each(function(){
	    		values += jb(this).val().trim() + ","; 
	    		
	    	});
			location.href="/sector/aptss?values=" + values;  	    
			
	    }
  	    
        
        
    </script>




</head>

<body>






    <header>
        <div class="container-fluid d-flex" id="top-bar">

            <img src="/sector/resources/images/sectorlogo.png" class="align-self-center" id="logo">
            <li class="nav-item dropdown align-self-center mr-auto">
                <!--                        <div class="nav-link" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">주소록<img src="/sector/resources/images/arrow.png" alt="" id="top-arrow"></div>-->
                <a class=" nav-link d-none d-md-block" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">주소록&nbsp; <img src="/sector/resources/images/arrow.png" id="top-arrow"></a>
                <div class="dropdown-menu" aria-labelledby="dropdown01" id="submenu">

                    <div id="drop-menu">
                        <tr>
                            <td><a href="#"><img src="/sector/resources/images/check.png" class="drop-menu"></a></td>
                            <td><a href="#"><img src="/sector/resources/images/human.png" class="drop-menu"></a></td>
                            <td><a href="#"><img src="/sector/resources/images/call.png" class="drop-menu"></a></td>

                        </tr>

                        <tr>
                            <td><a href="#"><img src="/sector/resources/images/mail.png" class="drop-menu"></a></td>
                            <td><a href="#"><img src="/sector/resources/images/cal.png" class="drop-menu"></a></td>
                            <td><a href="#"><img src="/sector/resources/images/board.png" class="drop-menu"></a></td>
                        </tr>
                    </div>
                </div>
            </li>

            <button class="btn d-none d-md-block" id="bell-badge">
                <span class="badge badge-danger  " id="badge-pos">2</span>
                <img src="/sector/resources/images/bell.png" id="bell-icon" class="align-self-center " alt="">
                <!--                <span class="badge badge-danger  " id="badge-poss">112344</span>-->
            </button>
            <button class="btn d-none d-md-block">
                <img src="/sector/resources/images/profile.png" alt="" class="align-self-center" id="profile-icon">
            </button>
            <nav class="navbar navbar-expand-lg navbar-light ">
                <input class="form-control mr-sm" type="search" placeholder="Search" aria-label="Search">
            </nav>
            <button class="btn btn-outline" type="submit"><img src="/sector/resources/images/search.png" class="" alt="" id="search-icon"></button>
        </div>


    </header>
    <!--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑top bar mid↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
    <div class="" id="mid-body">
        <nav id="side-menu" class="d-none d-md-block">
            <div id="sidemenu">
                <div id="insert-button">
                    <button id="insert-address" onclick="insertAb();"><strong>주소 추가</strong></button>

                </div>


                <div id="genre">
                    <ul id="sidemenu-content">
                    <% if(loginMember.getUserMaster().equals("Y")) { %>
								<li><a href="/sector/views/ab/userUpdate.jsp" class="type-color" id="searchUser"><strong>사원 관리</strong></a>
                                </li>
                                <% } %>
                        <li><a href="#" onclick="selectAllEmp('이름');" class="type-color"><strong>사원 주소록</strong></a></li>
                        <li><a href="#" onclick="selectAllPersonal('이름');" class="type-color"><strong>개인 주소록</strong></a></li>
                        <li><a href="#" onclick="selectAllShare('이름');" class="type-color"><strong>공유 주소록</strong></a></li>
                        <li><a href="#" onclick="selectAllDelete('이름');" class="type-color"><strong>휴지통</strong></a></li>
                    </ul>
                    <ul id="sidemenu-dropdown">
                        <div class="accordion" id="accordionExample">
                            <a data-toggle="collapse" href="#edit-menu-dropdown" aria-expanded="false" aria-controls="collapseExample" class="type-color"><strong>환경설정&nbsp;</strong><img src="/sector/resources/images/arrow.png" id="arrow-side" alt=""></a>
                            <div id="edit-menu-dropdown" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">

                                <li><a href="" class="type-color"><strong>기본정보 설정</strong></a>
                                </li>
                                <li><a href="" class="type-color"><strong>주소록 가져오기</strong></a>
                                </li>
                                <li><a href="" class="type-color"><strong>주소록 내보내기</strong></a>
                                </li>
                                <li><a href="" class="type-color"><strong>인쇄하기</strong></a>
                                </li>
                            </div>

                        </div>
                    </ul>
                </div>
            </div>


        </nav>






    </div>
    <div class="row text-nowrap " id="main-table">
        <div class="container-fluid table-boss">
            <div class="alltable row" id="emp-table">
                <div class="col row" id="table-top">
                    <div class="d-flex pb-2 ">
                        <div class="align-self-end">
                            <span class="h4 mr-2">사원주소록</span>
                        </div>
                        <span class=" align-self-end" id="emp-delete-move">
                            <a href="#" class="delete-move-text mr-2" >삭제</a>
                            <a href="#" class="delete-move-text">이동</a>
                        </span>

                    </div>
                    <div class="ml-auto d-flex">
                        <select class="mb-2 form-control select-box" id="empsortselect" onchange="sendData('emp');">
                            <option value="이름">이름</option>
                            <option value="부서">부서</option>
                        </select>
                    </div>
                </div>


                <table class="table border-bottom flex container-fluid">
                    <thead>
                        <tr id="table-center">
                            <th></th>
                            <th>부서</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th class="d-none d-xl-table-cell">직급</th>
                            <th>이메일</th>
                            <th class="d-none d-xl-table-cell">주소</th>
                        </tr>
                    </thead>
                    <tbody id="emp-table-body">
                        <% for(Emp e : emplist){ %>
                        <tr>
                            <td></td>
                            <td><%= e.getDeptId() %></td>
                            <td><%= e.getEmpName() %></td>
                            <td><%= e.getEmpPhone() %></td>
                            <td class="d-none d-xl-table-cell"><%= e.getJobId() %></td>
                            <td><%= e.getEmpEmail() %></td>
                            <td class="d-none d-xl-table-cell"><%= e.getEmpAddress() %></td>

                        </tr>

                        <% } %>
                    </tbody>
                </table>
                <div class="container-fluid">
                    <p class="col" id="table-num-center"><a href="" class="col">1</a></p>
                </div>
                <div class="container-fluid text-center">
                    <div class="row" id="select-box-center">
                        <div class="mr-2">
                            <select class="col mb-2 form-control select-box" id="empsearchselect">
                                <option>이름</option>
                                <option>부서</option>
                            </select>
                        </div>
                        <div class="mr-2">
                            <div class="">
                                <input type="text" class="form-control" id="empsearchkeyword">
                            </div>
                        </div>
                        <button type="button" id="select-btn" class="text-center btn btn-block">
                            <div class="search-button" id="search-text" href="#" onclick="sendSelectData('emp')">검색</div>
                        </button>
                    </div>
                </div>
            </div>





            <!--1111111111111111111111111111///////////////////////////////////////////////////////////////////////////////////////////////////////////////-->




            <div class="alltable row" id="personal-table">
                <div class="col row">
                    <div class="d-flex pb-2 ">
                        <div class="align-self-end">
                            <span class="h4 mr-2">개인주소록</span>
                        </div>
                        <span class=" align-self-end" id="personal-delete-move">
                            <a href="#" class="delete-move-text mr-2" onclick="todelete();">삭제</a>
                            <a href="#" class="delete-move-text" onclick="toshare();">공유</a>
                        </span>
                    </div>
                    <div class="ml-auto d-flex">
                        <select class="mb-2 form-control select-box" id="personalsortselect" onchange="sendData('personal');">
                            <option value="이름">이름</option>
                            <option value="회사">회사</option>
                        </select>
                    </div>
                </div>


                <table class="table border-bottom flex container-fluid">
                    <thead>
                        <tr id="table-center">
                            <th><input type='checkbox' class="personalcheckboss" name="personalcheckboss"></th>
                            <th>회사</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th class="d-none d-xl-table-cell">직급</th>
                            <th>이메일</th>
                            <th class="d-none d-xl-table-cell">주소</th>
                        </tr>
                    </thead>
                    <tbody id="personal-table-body">

                    </tbody>
                </table>
                <div class="container-fluid">
                    <p class="col" id="table-num-center"><a href="" class="col">1</a></p>
                </div>
                <div class="container-fluid text-center">
                    <div class="row" id="select-box-center">
                        <div class="mr-2">
                            <select class="col mb-2 form-control select-box" id="personalsearchselect">
                                <option>이름</option>
                                <option>회사</option>
                            </select>
                        </div>
                        <div class="mr-2">
                            <div class="">
                                <input type="text" class="form-control" id="personalsearchkeyword">
                            </div>
                        </div>
                        <button type="button" id="select-btn" class="text-center btn btn-block">
                            <div class="search-button" id="search-text" href="#" onclick="sendSelectData('personal')">검색</div>
                        </button>
                    </div>
                </div>
            </div>


            <!-- 33333333333333333333333333333/////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->






            <div class="alltable row" id="share-table">
                <div class="col row">
                    <div class="d-flex pb-2 ">
                        <div class="align-self-end">
                            <span class="h4 mr-2">공유주소록</span>
                        </div>
                        <span class=" align-self-end" id="share-delete-move">
                            <a href="#" class="delete-move-text mr-2" onclick="sharetopersonal();">삭제</a>
                        </span>
                    </div>
                    <div class="ml-auto d-flex">
                        <select class="mb-2 form-control select-box" id="sharesortselect" onchange="sendData('share');">
                            <option value="이름">이름</option>
                            <option value="회사">회사</option>
                        </select>
                    </div>
                </div>


                <table class="table border-bottom flex container-fluid">
                    <thead>
                        <tr id="table-center">
                            <th><input type='checkbox' class="sharecheckboss" name="sharecheckboss"></th>
                            <th>회사</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th class="d-none d-xl-table-cell">직급</th>
                            <th>이메일</th>
                            <th class="d-none d-xl-table-cell">주소</th>
                        </tr>
                    </thead>
                    <tbody id="share-table-body">

                    </tbody>
                </table>
                <div class="container-fluid">
                    <p class="col" id="table-num-center"><a href="" class="col">1</a></p>
                </div>
                <div class="container-fluid text-center">
                    <div class="row" id="select-box-center">
                        <div class="mr-2">
                            <select class="col mb-2 form-control select-box" id="sharesearchselect" >
                                <option>이름</option>
                                <option>회사</option>
                            </select>
                        </div>
                        <div class="mr-2">
                            <div class="">
                                <input type="text" class="form-control" id="sharesearchkeyword">
                            </div>
                        </div>
                        <button type="button" id="select-btn" class="text-center btn btn-block">
                            <div class="search-button" id="search-text" href="#" onclick="sendSelectData('share')">검색</div>
                        </button>
                    </div>
                </div>
            </div>
            
           


            <!-- 44444444444444444444444444444444/////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->



			<div class="alltable row" id="delete-table">
                <div class="col row">
                    <div class="d-flex pb-2 ">
                        <div class="align-self-end">
                            <span class="h4 mr-2">휴지통</span>
                        </div>
                        <span class=" align-self-end" id="delete-delete-move">
                        	<a href="#" class="delete-move-text mr-2" onclick="deletetopersonal();">복구</a>
                            <a href="#" class="delete-move-text mr-2" onclick="deleteAb();">완전삭제</a>
                        </span>
                    </div>
                    <div class="ml-auto d-flex">
                        <select class="mb-2 form-control select-box" id="deletesortselect" onchange="sendData('delete');">
                            <option value="이름">이름</option>
                            <option value="회사">회사</option>
                        </select>
                    </div>
                </div>


                <table class="table border-bottom flex container-fluid">
                    <thead>
                        <tr id="table-center">
                            <th><input type='checkbox' class="deletecheckboss" name="deletecheckboss"></th>
                            <th>회사</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th class="d-none d-xl-table-cell">직급</th>
                            <th>이메일</th>
                            <th class="d-none d-xl-table-cell">주소</th>
                        </tr>
                    </thead>
                    <tbody id="delete-table-body">

                    </tbody>
                </table>
                <div class="container-fluid">
                    <p class="col" id="table-num-center"><a href="" class="col">1</a></p>
                </div>
                <div class="container-fluid text-center">
                    <div class="row" id="select-box-center">
                        <div class="mr-2">
                            <select class="col mb-2 form-control select-box" id="deleteearchselect">
                                <option>이름</option>
                                <option>회사</option>
                            </select>
                        </div>
                        <div class="mr-2">
                            <div class="">
                                <input type="text" class="form-control" id="deletesearchkeyword">
                            </div>
                        </div>
                        <button type="button" id="select-btn" class="text-center btn btn-block">
                            <div class="search-button" id="search-text" href="#" onclick="sendSelectData('delete')">검색</div>
                        </button>
                    </div>
                </div>
            </div>
            
            
            
            
            
            
            
            
            <!-- //////////////////////////////////////////////////////////////////////////////////////////////// -->
            <!-- <div class="modal modal-center fade" id="my80sizeCenterModal" tabindex="-1" role="dialog" aria-labelledby="my80sizeCenterModalLabel">
                <div class="modal-dialog modal-80size modal-center" role="document">
                    <div class="modal-content modal-80size">
                        <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">
                            	대충이름들어감
                            </h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                            <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                        	<div class="container-fluid">
                        	    <div class="row">
                        	        <a href="" class="col-2 align-middle">이름</a>
                        	        <input type="text" class="form-control col-6 bg-light" id="mordal-border" placeholder="허태규" readonly>
                        	    </div>
                        	</div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        </div>
                    </div>
                </div>
            </div>
			<button type="button" data-toggle="modal" data-target="#my80sizeCenterModal">Open Modal</button> -->









        </div>
    </div>
    </div>




    <!--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑mid bar bottom↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
    <footer>

    </footer>






    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <% }else{ %>
    alert("인증되지 않은 회원 입니다.\n인증 후 다시 시도해 주십시오.");
   	location.href = "/sector/";
    <% } %>
    </script>
</body>

</html>