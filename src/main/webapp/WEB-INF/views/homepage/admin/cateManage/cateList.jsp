<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="cateList">
	<b><h3>카테고리 목록</h3></b>
	<table border="1">
		<tr>
			<th>카테고리 번호</th>
			<th>카테고리 이름</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<tr>
			<td>001</td>
			<td>호러</td>
			<td><input type="button" value="삭제"></td>
			<td><input type="button" value="수정" onclick="window.location='cateUpdate'"></td>
		</tr>
		<tr>
			<td>002</td>
			<td>로맨스</td>
			<td><input type="button" value="삭제"></td>
			<td><input type="button" value="수정" onclick="window.location='cateUpdate'"></td>
		</tr>
		<tr>
			<td>003</td>
			<td>판타지</td>
			<td><input type="button" value="삭제"></td>
			<td><input type="button" value="수정" onclick="window.location='cateUpdate'"></td>
		</tr>
		<tr>
			<td>004</td>
			<td>추리</td>
			<td><input type="button" value="삭제"></td>
			<td><input type="button" value="수정" onclick="window.location='cateUpdate'"></td>
		</tr>
	</table>
		<input type="button" value="카테고리 추가" onclick="window.location='cateInsert'">
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>