<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<html>
<head>  
	<title>자유 게시판 목록</title>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div align="center">
		<b>자유 게시판 목록</b>
		<table border="1" width="800">
			<tr bgcolor="yellow">
				<td colspan="6" align="right">게시판 글 작성</a></td>			
			</tr>
			<tr bgcolor="green">
				<th>번호</th>
				<th width="30%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>				
		</table>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>