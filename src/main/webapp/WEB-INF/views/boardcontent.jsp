<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
</head>
<body>
<table>
<c:forEach var="l" items="${list}">
	<tr>
		<td><b>비밀번호:${l.pass }</b></td>
		<td colspan="2" style="text-align: right;">
			<a href="replyins?num=${l.num }">댓글달기</a>
			<a href="editup?num=${l.num }">편집 </a>
			<a href="del?num=${l.num}&pass=${l.pass}">삭제</a>
			<a href="boardlist">목록보기</a>
		</td>
	</tr>
	<tr>
		<td>
		작성자 : <a href="mailto:${l.mail }">${l.name }</a> (ip : ${l.bip })
		</td>
		<td>작성일 : ${l.bdate }</td>
		<td>조회수 : ${l.readcnt}</td>
	</tr>
	<tr>
		<td colspan="3" style="background-color: cyan">제목 : ${l.title }</td>
	</tr>
	<tr>
		<td colspan="3">
			<textarea rows="10" style="width: 99%" readonly="readonly">${l.cont }</textarea>
		</td>
	</tr>	
	
	</c:forEach>
</table>

</body>
</html>











