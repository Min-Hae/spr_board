<%@page import="pack.model.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	int pageBlock, start, end;	//페이지 블럭처리
int pageSu, spage=1;		//일반페이지
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnSearch").onclick = function(){
		if(frm.sword.value === ""){
			frm.sword.focus();
			alert("검색어를 입력하시오");
			return;
		}
		frm.submit();
	}
}
</script>
</head>
<body>
<table>
  <tr>
    <td>
    	[<a href="boardlist?page=1">최근목록</a>]&nbsp;
		[<a href="boardwrite">새글작성</a>]&nbsp;
		
    </td>
  </tr>
</table>
<table>
  <tr style="background-color: silver;">
  	<th>번호</th><th>제 목</th><th>작성자</th><th>작성일</th><th>조회</th>
  </tr>
 
  <c:forEach var="l" items="${list }">
  <tr>
  <td>${l.num }</td>
  <td><a href="boardcontent?num=${l.num}">${l.title }</a></td>
  <td>${l.name }</td>
  <td>${l.bdate }</td>
  <td>${l.readcnt }</td>
  </tr>
  </c:forEach>

</table>

<table>
  <tr style="text-align: center;">
    <td>

	<br><br>
	<form action="boardlist" name="frm" method="post">
		<select name="stype">		<!--search type -->
		<option value="title" selected="selected">글제목</option>
		<option value="name">작성자</option>
		</select>
		<input type="text" name="sword">	<!-- search word -->
		<input type="button" value="검색" id="btnSearch">
	</form>
    </td>
  </tr>
</table>
</body>
</html>


















