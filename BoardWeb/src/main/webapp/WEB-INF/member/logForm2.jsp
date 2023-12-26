<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <style>


/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
.logbtn {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  font-weight: bold;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
  border: none;
  color: white;
  cursor: pointer;
  font-weight: bold;
}

.container {
  padding: 20px;
}

</style>
    </head>
    <body>
    <%
    	String logId = (String) session.getAttribute("logId");
    	String logName = (String) session.getAttribute("logName");
    %>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
            	<%if(logName == null) { %>
                <div class="sidebar-heading border-bottom bg-light">Bootstrap(Guest)</div>
                <% } else { %>
                <div class="sidebar-heading border-bottom bg-light">Bootstrap(<%=logName %>)</div>
                <% } %>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">글목록</a>
                    <%if(logId == null) { %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
                    <% } else { %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
                    <% } %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardForm.do">글등록</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Events</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link" href="#!">Home</a></li>
                                <li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#!">Action</a>
                                        <a class="dropdown-item" href="#!">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#!">Something else here</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">
	<%
		String msg = (String)request.getAttribute("message");
	%>
	
	<% if (msg != null) { %>	
	<p><%= msg %></p>
	<% } %>

<form action="login.do">
	<div class="container">
      <label for="uname"><b>아이디</b></label>
      <input type="text" placeholder="아이디 입력" name="id" required>

      <label for="psw"><b>비밀번호</b></label>
      <input type="password" placeholder="비밀번호 입력" name="pw" required>
        
      <button type="submit" class="logbtn">로그인</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="reset" class="cancelbtn">초기화</button>
    </div>
</form>
<%@ include file="../layout/foot.jsp"%>