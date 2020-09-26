<%@page import="pack.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript">
function check(){
	if(frm.pass.value == ""){
		frm.pass.focus();
		alert("비밀번호를 입력하세요");
		return;
	}
	if(confirm("정말 수정할까요?")){
		frm.submit();
	}
}
</script>
</head>
<body>
<h2 style="text-align: center;">** 글 수정 **</h2>
<c:forEach var="e" items="${ edit}">
<form action="editup" name="frm" method="post">
<input type="hidden" name="num" value="${e.num }">
<table border="1">
  <tr>
  	<td>이름</td>
  	<td>
  		<input type="text" name="name" value="${e.name }">
  	</td>
  </tr>
  <tr>
  	<td>암호</td>
  	<td><input type="text" name="pass"></td>
  </tr>
  <tr>
  	<td>메일</td>
  	<td>
  		<input type="text" name="mail" value="${e.mail}">
  	</td>
  </tr>
   <tr>
  	<td>제목</td>
  	<td>
  		<input type="text" name="title" value="${e.title }">
  	</td>
  </tr>
  <tr>
  	<td>내용</td>
  	<td>
  		<textarea rows="10" style="width: 97%" name="cont">${e.cont}</textarea>
  	</td>
  </tr>
  <tr>
    <td colspan="2" style="text-align: center;">
    	<input type="button" value="수정완료" onclick="check()">&nbsp;
    	<input type="button" value="목록보기" 
    		onclick="location.href='boardlist'">
    </td>
  </tr>
  </c:forEach>
</table>
</form>
</body>
</html>