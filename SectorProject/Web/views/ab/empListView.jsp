<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="emp.model.vo.Emp, java.util.ArrayList, ab.model.vo.Ab" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/style.css">

    <title id="special">Insert title here</title>

</head>
<body>

    <div class="d-flex pb-2">
        <div class="align-self-end">
            <span class="h4">사원주소록</span></div>
    </div>
    <div class="ml-auto d-flex">
        <select class="mb-2 form-control select-box" id="empsortselect" onchange="sendData();">
            <option>정렬</option>
            <option value="이름">이름</option>
            <option value="부서">부서</option>
        </select>
    </div>
    <table class="table border-bottom flex container-fluid">
        <thead>
            <tr id="table-center">
                <th></th>
                <th>부서</th>
                <th>이름</th>
                <th>연락처</th>
                <th>직급</th>
                <th>이메일</th>
                <th>주소</th>
            </tr>
        </thead>
        <tbody>
           
           <!--여기부터------------->
                    <% for(Emp e : emplist){ %>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td><%= e.getDeptId() %></td>
                        <td><%= e.getEmpName() %></td>
                        <td><%= e.getEmpPhone() %></td>
                        <td class="d-none d-xl-table-cell"><%= e.getJobId() %></td>
                        <td><%= e.getEmpEmail() %></td>
                        <td class="d-none d-xl-table-cell"><%= e.getEmpAddress() %></td>

                    </tr>

                    <% } %>
            <!--여까지-->
        </tbody>
    </table>
    <div class="container-fluid">
        <p class="col" id="table-num-center"><a class="col">1</a></p>
    </div>
    <div class="container-fluid text-center">
        <div class="row" id="select-box-center">
            <div class="mr-2">
                <select class="col mb-2 form-control select-box">
                    <option>검색</option>
                    <option>이름</option>
                    <option>부서</option>
                </select>
            </div>
            <div class="pb-2">
                <div><input type="text" class="form-control">
                </div>
            </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- <script src="resources/js/main.jsp"></script> -->
</body>

</html>