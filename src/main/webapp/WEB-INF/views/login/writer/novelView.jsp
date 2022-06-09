<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta charset="EUC-KR">
<title>작품내역</title>
</head>
<body>
<!-- 작품의 일러스트, 제목, 줄거리, 회차등을 확인 및 수정을 하는 페이지 -->

<div align="center">

	<h3>수정페이지</h3>
	
	<table border="1" width="600" align="center">
	<tr>
		<td>일러스트</td>
		<td>
			img
			<input type="button" value="사진불러오기">
		</td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="subject">
			<input type="button" value="수정">
		</td>
	</tr>
	
	<tr>
		<td>줄거리</td>
		<td>
			<textarea name="content" rows="11" cols="50"></textarea>
			<input type="button" value="수정">
		</td>
	</tr>
	
	<tr>
		<td>업로드한 회차</td>
		<td>
			회차 List
		</td>
	</tr>
	
	</table>
	
	<p>
	
	<input type="button" value="수정하기">
	
</div>
</body>
</html>