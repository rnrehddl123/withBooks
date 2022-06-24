<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
</head>

<%@ include file="../../adminHeader.jsp"%>
		<div class="adminboard">
			<b><h1>결제 내역</h1></b><p>
			<table border="1" width="1000" height="500">
   				<tr height="10%">
      				<th>pnum</th>
      				<th>imp_uid</th>
      				<th>merchant_uid</th>
      				<th>paid_amount</th>
      				<th>apply_num</th>
    			</tr>
  			<c:if test="${empty listPay}">
				<tr>
					<td colspan="6" align="center">결제 내역이 없습니다.</td>
				</tr>
			</c:if>
    		<c:forEach var="pdto" items="${listPay}">
				<tr>
					<td>${pdto.pnum}</td>
					<td>${pdto.imp_uid}</td>
					<td>${pdto.merchant_uid}</td>
					<td>${pdto.paid_amount}</td>
					<td>${pdto.apply_num}</td>
				</tr>		
			</c:forEach>
			</table>
			<c:if test="${payRowCount>0}">			
				<c:if test="${payStartPage>1}">
					[<a href="listPay?payPageNum=${payStartPage-1}">이전</a>]			
				</c:if>
				<c:forEach var="i" begin="${payStartPage}" end="${payEndPage}">
					[<a href="listPay?payPageNum=${i}"><c:out value="${i}"/></a>]	
				</c:forEach>
				<c:if test="${payEndPage<payPageCount}">
					[<a href="listPay?payPageNum=${payEndPage+1}">다음</a>]			
				</c:if>
			</c:if>
		</div>	
<%@ include file="../../adminFooter.jsp"%>