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
<div class="mar" align="center">
	<h4 class="mar">${login.member_name}님의 구매내역</h4> 
	<table class="table table-striped orderListpage">
<!-- 작품1 -->
		<thead>
		<tr>
			<th scope="col" align="center">번호</th>
			<th scope="col" align="center">소설 제목</th>
			<th scope="col" align="center">에피소드 제목</th>
			<th scope="col" align="center">가격</th>
			<th scope="col" align="center">날짜</th>
		</tr>
		</thead>
		<c:set var="pageNum" value="${purchaseNum}"/>
		<c:if test="${empty purchaseHistoryList}">
		<tr>
			<td align="center" colspan="5">구매내역이 없습니다.</td>
		</tr>
		</c:if>
		<tbody>
		<c:forEach var="dto" items="${purchaseHistoryList}">
		<tr>
			<td align="center"><c:out value="${pageNum}"/></td>
				<c:set var="pageNum" value="${pageNum-1}"/>
			<td align="center">${dto.NOVEL_SUBJECT}</td>
			<td align="center">${dto.EPI_SUBJECT}</td>
			<td align="center">${dto.PURCHASE_PRICE}</td>
			<td align="center">${dto.PURCHASE_DATE}</td>
		</tr>
		</c:forEach>
		</tbody>
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