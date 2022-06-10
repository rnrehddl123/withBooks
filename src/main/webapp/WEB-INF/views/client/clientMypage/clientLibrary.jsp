<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- clientLibrary.jsp -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
	<title>내 서재</title>
	<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<table class="outline">
	<tr height="30" align="center">
		<td colspan="3"><hr class="hrLine"></td>
	</tr>
	<tr height="30" align="center">
		<th colspan="3">내 서재</th>
	</tr>
	<tr height="30" align="center">
		<td colspan="3"><hr class="hrLine"></td>
	</tr>
	<tr height="30" align="center">
		<th>이미지</th>
		<th>소설(시리즈) 제목</th>
		<th>작가명</th>
	</tr>
	<!-- if -->
		<tr>
			<td colspan="3" align="center">구매한 소설이 없습니다.</td>
		</tr>
	<!-- if끝 -->
	<!-- for -->
		<tr align="center">
			<td><!-- 이미지 --></td>
			<td><!-- 제목 --><a href="">제목클릭하면 해당소설로 이동</a></td>
			<td><!-- 작가명 --></td>
		</tr>	
	<!-- for끝 -->
	</table>
	<hr class="hrLine">
</div>
</body>
<jsp:include page="../../main/footer.jsp"/>