<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientPay -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>writerPay</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<form name="purchaseCash" action="purchaseCash" method="POST"> 
	<input type="hidden" name="mnum" value="${login.mnum}">
	<table width="600">
		<tr>
			<th colspan="3" align="left">내 포인트 <font color="blue">${login.cash}원</font></th>
		</tr>
		<tr>
			<td colspan="3"><hr width="600"></td>
		</tr>
		<tr>
			<th colspan="3" align="center">에피소드 구매</th>
		</tr>
		<tr>
			<td colspan="3"><hr width="600"></td>
		</tr>
		<tr>
			<td align="center" width="10%"><input type="radio" name="cash" value="100"></td>
			<td align="center">100포인트</td>
			<td align="center">100원</td>
		</tr>
		<tr>
			<td colspan="3"><hr width="600"></td>
		</tr>
		<tr>
			<td align="center" colspan="3"><input type="checkbox" name="agree" value="" required>상품, 가격, 유의 사항 등을 확인하셨으며 구매에 동의합니다.</td>
		</tr>
		<tr>
			<td align="center" colspan="3"><input type="submit" value="결제"></td>
		</tr>
		<tr>
			<td align="center" colspan="3">(유의 사항)</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>