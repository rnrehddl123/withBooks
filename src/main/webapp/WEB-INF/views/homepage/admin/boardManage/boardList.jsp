<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<html>
<head>  
	<title>자유 게시판 목록</title>
</head>
<body>
	<div align="center">
		<b>자유 게시판 목록</b>
		<table border="1" width="800">
			<tr bgcolor="green">
				<th>번호</th>
				<th width="30%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>삭제</th>
			</tr>
			<tr>
				<td>1</td>
				<td width="30%">aa</td>
				<td>홍길동</td>
				<td>2022.06.08</td>
				<td>11</td>
				<td><input type="button" value="삭제"></td>
			</tr>					
		</table>
	</div>
</body>
</html>