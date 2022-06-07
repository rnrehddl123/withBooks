<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>소설목록</title>
</head>
<body>
<div align="center">
	<table width="600">
		<caption>소설목록</caption>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작가</th>
			<th>사진</th>
			<th>카테고리</th>
			<th>줄거리</th>
		</tr>
	<c:if test="${empty novelList}">
		<tr>
			<td colspan="6">소설이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${novelList}" var="nL">
		<tr>		
			<td>${nL.nnum}</td>
			<td>${nL.novel_subject}</td>
			<td>${nL.novel_writername}</td>
			<td><img src="" width="" height=""></td>
			<td>${nL.novel_cate}</td>
			<td>${nL.novel_summary}</td>
		</tr>				
	</c:forEach>
	</table>
</div>
</body>
</html>