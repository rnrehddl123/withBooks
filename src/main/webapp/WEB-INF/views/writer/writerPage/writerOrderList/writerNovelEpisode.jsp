<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerNovelEpisode -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<font>${getEpisode.epi_content}</font>
		<font><a href="writerNovelList?mnum=${login.mnum}">소설 목록으로 가기</a></font>
	</div>
	
<jsp:include page="../../../main/footer.jsp"/>