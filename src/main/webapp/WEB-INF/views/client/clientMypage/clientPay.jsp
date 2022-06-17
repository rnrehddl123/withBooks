<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientPay -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>clientPay</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function payCheck() {
		//체크박스 동의 여부 확인
		var chk = document.updateCash.input_check.checked
		
		if(!chk){
			alert("구매에 동의해 주시기 바랍니다.")
			return false
		}
		//체크박스 포인트 여부 확인
		var isCashChk = false;
		var arr_cash = document.getElementsByName("cash")
		
		for(var i=0; i<arr_cash.length; i++){
			if(arr_cash[i].checked == true){
				isCashChk = true
				break
			}
		}
		if(!isCashChk){
			alert("충전하실 금액을 선택해 주세요.")
			return false;
		}
	}
</script>
<body>
<div align="center">
	<form name="updateCash" action="updateCash" method="POST" onSubmit="return payCheck()"> 
	<input type="hidden" name="mnum" value="${login.mnum}">
	<table width="600">
		<tr>
			<th colspan="3" align="left">내 포인트 <font color="blue">${login.cash}원</font></th>
		</tr>
		<tr>
			<td colspan="3"><hr width="600"></td>
		</tr>
		<tr>
			<th colspan="3" align="center">포인트 충전</th>
		</tr>
		<tr>
			<td colspan="3"><hr width="600"></td>
		</tr>
		<tr>
			<td align="center" width="10%"><input type="radio" id="1000" name="cash" value="1000"></td>
			<td align="center">1000포인트</td>
			<td align="center">1000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input type="radio" id="2000" name="cash" value="2000"></td>
			<td align="center">2000포인트</td>
			<td align="center">2000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input type="radio" id="3000" name="cash" value="3000"></td>
			<td align="center">3000포인트</td>
			<td align="center">3000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input type="radio" id="4000" name="cash" value="4000"></td>
			<td align="center">4000포인트</td>
			<td align="center">4000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input type="radio" id="5000" name="cash" value="5000"></td>
			<td align="center">5000포인트</td>
			<td align="center">5000원</td>
		</tr>
		<tr>
			<td colspan="3"><hr width="600"></td>
		</tr>
		<tr>
			<td align="center" colspan="3">
				<input type="checkbox" name="input_check" id="input_check" value=""/>
				상품, 가격, 유의 사항 등을 확인하셨으며 구매에 동의합니다.
			</td>
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