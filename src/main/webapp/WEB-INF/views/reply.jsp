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
function check(){		//boardwrite.jsp에서 function 그대로 가져오기
	if(frm.name.value==""){
		alert("이름을 입력하세요");
		frm.name.focus();
	}else if(frm.pass.value ==""){
		alert("비밀번호를 입력하세요");
		frm.pass.focus();
	}else if(frm.mail.value ==""){
		alert("이메일을 입력하세요");
		frm.mail.focus();
	}else if(frm.title.value ==""){
		alert("제목을 입력하세요");
		frm.title.focus();
	}else if(frm.cont.value ==""){
		alert("내용을 입력하세요");
		frm.cont.focus();
	}else
		frm.submit();
}
</script>
</head>
<body>
<c:forEach var="r" items="${reply }">
<form action="replyins" name="frm" method="post">	<!-- form태그 사용 시 method="post" 사용하기 -->
<input type="hidden" name="num" value="${r.num}">	<!-- 보이지는 않지만 가져가야 할 것 : hidden -->
<input type="hidden" name="gnum" value="${r.gnum}">
<input type="hidden" name="onum" value="${r.onum}">
<input type="hidden" name="nested" value="${r.nested}">

	<table border="1">
		<tr>
			<td colspan="2"><h2>*** 댓글쓰기 ***</h2></td>
		</tr>
		<tr>
			<td align="center" width="100">이 름</td>
			<td width="430"><input name="name" size="15"></td>
		</tr>
		<tr>
			<td align="center">암 호</td>
			<td><input type="password" name="pass" size="15"></td>
		</tr>
		<tr>
			<td align="center">메 일</td>
			<td><input name="mail" size="25"></td>
		</tr>
		<tr>
			<td align="center">제 목</td>
			<td><input name="title" size="50" value="[Re]:${r.title }"></td>	<!--원 제목 너무길면 substr이용해서 글자수 자를 것 -->
		</tr>
		<tr>
			<td align="center">내 용</td>
			<td><textarea name="cont" rows="10" style="width: 100%"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center" height="30">
				<input type="button" value="작  성" onClick="check()">&nbsp;
				<input type="button" value="목  록"
				  onClick="location.href='boardlist'"></td>
		</tr>
	</table>
</form>
</c:forEach>
</body>
</html>






