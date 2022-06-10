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
<form name="f" action="clientOrder" method="post">
	<table width="1000" border="1">
		<tr>
			<td colspan="7" align="center">
				<h4>장바구니</h4>
			</td>
		</tr>		
		<tr>
			<th width="5%">번호</th>
			<th width="30%">제목</th>
			<th width="10%">작가명</th>
			<th width="30%">사진</th>
			<th width="10%">총 금액</th>
			<th width="5%">수량</th>
			<th width="10%">삭제</th>
		</tr>
		<!-- if -->
			<tr>	
				<td colspan="7">장바구니에 등록된 상품이 없습니다.</td>
			</tr>
		<!-- if닫기 -->
		<!-- for -->
		<tr>
			<td><!-- 번호 --></td>
			<td><!-- 제목 --></td>
			<td><!-- 작가명 --></td>
			<td><!-- 사진 --><img src=""></td>
			<td><!-- 총금액 -->원</td>
			<td><!-- 수량 --></td>
			<td><!-- 삭제 --><a href="cartDel?nnum=">삭제</a></td>
		</tr>	
		<!-- for닫기 -->
		<tr>
			<td colspan="4">
				<b>장바구니총액 : 원</b><br>
			</td>
			<td colspan="3" align="center">
				<input type="submit" value="주문하기">
				<input type="button" value="계속쇼핑" onclick="javascript:history.go(-2)">
			</td>
		</tr>		
	</table>
</form>
</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>