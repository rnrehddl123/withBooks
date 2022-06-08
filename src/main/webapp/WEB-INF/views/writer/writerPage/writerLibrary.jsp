<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- myLibrary.jsp -->
<html>
<head>
	<title>내가 구매한 소설 목록</title>
</head>
<body>
	<table border = "1" width = "95%" align = "center">
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
	
	<td colspan = "1" align = "center">
			<a href = "#">[새로운 소설 구매]</a>
	</td>
	</table>
</body>
</html>
	