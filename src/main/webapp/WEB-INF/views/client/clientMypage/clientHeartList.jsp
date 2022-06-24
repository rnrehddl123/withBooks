<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientCart -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>clientCart</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
<form name="f" action="clientHeartAdd" method="post">
	<table width="1000">
		<tr>
			<td colspan="3" align="center">
				<h4>찜 목록</h4>
			</td>
		</tr>		
		<tr>
			<th width="30%">제목</th>
			<th width="10%">작가명</th>
			<th width="30%">사진</th>
		</tr>
			<tr>	
				<td colspan="3">찜 목록이 없습니다.</td>
			</tr>
		<tr>
			<td>${noveldto.novel_subject}</td>
			<td>${noveldto.novel_writer}</td>
			<td><img src="resources/img/${noveldto.novel_image}"></td>
		</tr>	
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="메인페이지" onclick="javascript:history.go(-2)">
			</td>
		</tr>		
	</table>
</form>
</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>