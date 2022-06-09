<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- saleManage.jsp -->
<html>
<head>  
	<title>saleManage.jsp</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
	<div class="saleTotal">
		<font align="center">총 매 출 관 리</font><br>
		<table border="1" width="1000" height="500">
			<tr bgcolor="green" height="50">
				<th>번호</th>
				<th>아이디</th>
				<th>카테고리</th>
				<th>상품이름</th>
				<th>수량</th>
				<th>가격</th>
				<th>총액</th>
				<th>구매날짜</th>
			</tr>
		<c:if test="${empty listSale}">
			<tr>
				<td colspan="8">판매된 상품이 없습니다.</td>
			</tr>
		</c:if>			
		<c:forEach var="dto" items="${listSale}">
			<tr>
				<td align="right">${dto.num}</td>
				<td>${dto.id}</td>
				<td align="center">${dto.category}</td>
				<td align="center">${dto.productName}</td>
				<td align="center">${dto.qty}</td>
				<td align="center">${dto.price}</td>
				<td align="center">${dto.totalPrice}</td>
				<td align="center">${dto.sysdate}</td>
			</tr>		
			</c:forEach>				
		</table>
	</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>