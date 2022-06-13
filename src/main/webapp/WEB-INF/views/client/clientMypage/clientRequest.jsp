<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientRequest -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>clientRequest</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<table width="600">
		<tr>
			<td><font size="10">작가 신청 문의</font><p></td>
		</tr>
		<tr>
			<td>문의 제목</td>
		</tr>
		<tr>
			<td><textarea cols="80" rows="1"></textarea><p></td>
		</tr>
		<tr>
			<td>문의 내용</td>
		</tr>
		<tr>
			<td><textarea cols="80" rows="5"></textarea></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="제출"></td>
		</tr>
	</table>
</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>