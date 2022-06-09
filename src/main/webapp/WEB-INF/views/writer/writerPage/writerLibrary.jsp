<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- myLibrary.jsp -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
	<title>내가 구매한 소설 목록</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<table align="center" class="writer">
		<tr height = "50"><th colspan = "5">내가 구매한 소설 목록</th></tr>
		
		<tr height = "30">
		<th>이미지</th>	
		<th>소설(시리즈) 제목</th>
		<th>책 읽기</th>
		<th>구매 일자</th>
		<th>삭제</th>
	</tr>
	
	<c:if test="">
		<tr>
			<td colspan = "5" align = "center">구매한 소설 목록이 없습니다.</td>
		</tr>
	</c:if>
	
	<td colspan = "5" align = "center">
			<a href = "#">[새로운 소설 구매]</a>
	</td>
	</table>
<jsp:include page="../../main/footer.jsp"/>
	