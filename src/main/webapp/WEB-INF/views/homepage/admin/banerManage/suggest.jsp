<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%@ include file="../../adminHeader.jsp"%>
<body>
<div class="suggest">
	<b><h1>추천작 관리</h1></b><p>
	<table border="1" width="1000" height="300">
		<tr height="50">
			<td>추천 작품 리스트</td>
			<td>선택</td>
		</tr>
		<tr>
			<td>추리소설 aaa</td>
			<td><input type="button" value="선택"></td>
		</tr>	
	</table>
	검색 : <input type="text"><input type="button" value="검색"><p>
	<table border="1" width="1000" height="300">
		<tr>
			<td>선택 리스트</td>
			<td>삭제</td>
		</tr>
		<tr>
			<td>추리소설 aaa</td>
			<td><input type="button" value="삭제"></td>
		</tr>	
	</table>
	<input type="button" value="등록">
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>