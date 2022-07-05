<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- saleManage.jsp -->
<html>
<head>  
	<title>[WithBooks] 총매출</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
	<div class="saleTotal">
		<font align="center">총 매 출 관 리</font><br>
		<table border="1" width="1000" height="500">
			<tr bgcolor="green" height="50">
				<th>날짜</th>
				<th>금액</th>
			</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="2">판매된 상품이 없습니다.</td>
			</tr>
		</c:if>			
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.PURCHASE_DATE}</td>
				<td>${dto.PURCHASE_PRICE}</td>
			</tr>		
			</c:forEach>				
		</table>
	</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>