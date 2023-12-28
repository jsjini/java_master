<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>상세화면</h3>
	<form name="myForm" action="modifyForm.do">
		<input type="hidden" name="id" value="${vo.id }">
		<table class="table">
			<tbody>
				<tr>
					<td>아이디</td>
					<td colspan="3">${vo.id }</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td colspan="3">${vo.pw }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td colspan="3">${vo.name }</td>
				</tr>
				<tr>
					<td>권한</td>
					<td colspan="3">${vo.responsibility }</td>
				</tr>
			</tbody>
		</table>
	</form>
