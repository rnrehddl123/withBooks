<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- saleManage.jsp -->
<html>
<head>  
	<title>[WithBooks] 일반회원 매출</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
	<div class="saleManageClient">
		<font align="center">회 원 매 출 관 리</font><br>
		<table border="1" width="300" height="500">
			<tr bgcolor="green" height="50">
				<th>회원번호</th>
				<th>회원이름</th>
				<th>매출</th>
			</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="3">판매된 상품이 없습니다.</td>
			</tr>
		</c:if>			
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.MNUM}</td>
				<td>${dto.MEMBER_NAME}</td>
				<td>${dto.PRICE}원</td>
			</tr>		
			</c:forEach>				
		</table>
	</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>