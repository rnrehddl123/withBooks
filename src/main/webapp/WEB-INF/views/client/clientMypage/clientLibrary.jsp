<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- clientLibrary.jsp -->
<jsp:include page="../../main/header.jsp"/>
<head>
	<title>내 서재</title>
	<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<div class="lib_wrraper">
	<h3>내 서재</h3>
	<section class="flex">
		<c:forEach var="dto" items="${nlist}">
			
			<div class="content_wrraper">
				<a href="clientNovelInfo?nnum=${dto.nnum}&change=now">
					<div class="lib_content">
						<img src="/with/${dto.novel_image}" onError="this.src='resources/img/nav_logo.png'">
						<p>${dto.novel_subject}<p>
						<p>${dto.novel_memberName}</p>
					</div>
				</a>
			</div>
			
		</c:forEach>
	</section>
</div>
<jsp:include page="../../main/footer.jsp"/>