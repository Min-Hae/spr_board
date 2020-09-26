<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript">
function check(){
	if(frm.pass.value === ""){
		frm.pass.focus();
		alert("비밀번호를 입력하시오");
		return;
	}
	
	if(confirm("정말 삭제할까요")){
		frm.submit();
	}
}
</script>
</head>
<body>
<h2>** 글삭제 **</h2>
<c:forEach var="d" items="${delete}">
<form name="frm" action="del" method="post">
<input type="hidden" name="num" value="${d.num }">
비밀번호 입력 : 
<input type="text" name="pass"><p/>
<input type="button" onclick="check()" value="삭제확인">
<input type="button" value="목록보기"
					onclick="location.href='boardlist'">
</form>
</c:forEach>
</body>
</html>