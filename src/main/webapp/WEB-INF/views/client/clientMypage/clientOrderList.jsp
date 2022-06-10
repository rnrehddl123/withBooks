<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientOrderList -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>구매내역</title>
</head>
<body>
<div align="center">
	<h4>(id)님의 구매내역</h4> 
	<table class="outline">
<!-- 작품1 -->
		<tr>
			<td rowspan="3" width="200">image</td>
			<th align="left" colspan="2">소설제목</th>
		</tr>
		<tr>
			<td>장르</td>
			<td>작가명</td>
		</tr>
		<tr>
			<td colspan="2">구매날짜</td> <!-- date -->
		</tr>
	</table>
</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>