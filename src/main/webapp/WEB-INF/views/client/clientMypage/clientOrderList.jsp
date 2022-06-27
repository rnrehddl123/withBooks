<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientOrderList -->
<jsp:include page="../../main/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>구매내역</title>
</head>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
<body>
<div align="center">
	<h4>${login.member_name}님의 구매내역</h4> 
	<table border="1" width="60%">
<!-- 작품1 -->
		<tr>
			<td align="center">번호</td>
			<td align="center">제목</td>
			<td align="center">가격</td>
			<td align="center">날짜</td>
		</tr>
		<c:set var="pageNum" value="${purchaseNum}"/>
		<c:if test="${empty purchaseHistoryList}">
		<tr>
			<td align="center" colspan="4">구매내역이 없습니다.</td>
		</tr>
		</c:if>
		<c:forEach var="dto" items="${purchaseHistoryList}">
		<tr>
			<td align="center"><c:out value="${pageNum}"/></td>
				<c:set var="pageNum" value="${pageNum-1}"/>
			<td align="center">${dto.EPI_SUBJECT}</td>
			<td align="center">${dto.PURCHASE_PRICE}</td>
			<td align="center">${dto.PURCHASE_DATE}</td>
		</tr>
		</c:forEach>
	</table>
		<ul class="pagination justify-content-center pageinfo orderpageinfo">
		<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				<li class="page-item"><a class="page-link" href="clientOrderList?pageNum=${startPage-1}">이전</a></li>			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<li class="page-item"><a class="page-link" href="clientOrderList?pageNum=${i}"><c:out value="${i}"/></a></li>	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				<li class="page-item"><a class="page-link" href="clientOrderList?pageNum=${endPage+1}">다음</a></li>		
			</c:if>
		</c:if>
		</ul>
</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>