<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientNovelSubject -->
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
<title>clientNovelSubject</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<table>
		<tr>
			<td rowspan="4">(이미지)</td>
			<td>(소설 제목)</td>
		</tr>
		<tr>
			<td>(별점),(별점준 회원수)</td>
		</tr>
		<tr>
			<td>(작가명)</td>
		</tr>
		<tr>
			<td>(총 에피소드 수),(완결or미완결 여부)</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="clientNovelEpi">에피소드보기</a></td>
		</tr>
	</table>
</div>
</body>
</html>
<jsp:include page="../../../main/footer.jsp"/>