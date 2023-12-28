<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>등록화면</h3>
    <form action="addMember.do">
        <table class="table">
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="pw"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="등록">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>