<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
   
	<%
		String msg = (String)request.getAttribute("message");
	%>
	
	<% if (msg != null) { %>	
	<p style="padding: 20px 20px 0px 15px; font-weight: bold; color: #f7392c;"><%= msg %></p>
	<% } %>

<form action="login.do" method="post">
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
