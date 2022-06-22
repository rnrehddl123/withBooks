<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- clientNovelListForCate.jsp -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
<title>카테고리별 리스트</title>
</head>
<body>
<div style="display:flex;">
	<div style="width:15%;">
		<table id="listCategory">
			<tr>
				<td><h5>카테고리 목록</h5></td>
			</tr>
			<c:forEach items="${listCategory}" var="list">
				<tr>
					<td>
						<a href="clientNovelListForCateGET?cnum=${list.cnum}"><div>${list.cate_name}</div></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="width:83%;">
		<table>
			<tr height="10%">
				<td>카테고리 >> </td>
			</tr>
			<c:forEach items="${listForCate}" var="list">
				<tr>
					<td>${list.novel_image},${list.novel_subject},${list.novel_memberName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>