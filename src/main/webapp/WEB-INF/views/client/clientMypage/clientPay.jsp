<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientPay -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>clientPay</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<script type="text/javascript">
	function iamport(){
		var radio=document.querySelectorAll('.radio_cash');
		var cash;
		var point;
		if(document.querySelectorAll('.radio_cash').value==null){
			alert("상품을 선택해 주세요.");
		}
		for (var i=0; i<radio.length; i++) {
            if (radio[i].checked == true) {
                cash=radio[i].value;
                point=radio[i].id;
                break;
            }
        }
		//가맹점 식별코드
		IMP.init('imp61999487');
		IMP.request_pay({
		    pg : 'kcp',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : point , //결제창에서 보여질 이름
		    amount : cash, //실제 결제되는 가격
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울 강남구 도곡동',
		    buyer_postcode : '123-456'
		}, function(rsp) {
			console.log(rsp);
		    if ( rsp.success ) {
		        var data={
		        	imp_uid:rsp.imp_uid,
			        merchant_uid:rsp.merchant_uid,
			        paid_amount:rsp.paid_amount,
			        apply_num:rsp.apply_num
		        }
		        var payData = {
			            method: 'POST',
			            body: JSON.stringify(data),
			            headers: {
			                'Content-Type': 'application/json'
			            }
			        };
		        fetch('purchaseCash', payData)
		        .then(response => response.text())
		        .then(response => {
		        	alert("결제에 성공하셨습니다.");
		            location.href='clientMypage'
		        });
		    } else {
		    	 var msg = '결제에 실패하였습니다.';
		         msg += '에러내용 : ' + rsp.error_msg;
		    }
		});
	}
	
</script>
<body>
<div align="center">
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
			<td align="center" width="10%"><input class="radio_cash" type="radio" id="1000포인트" name="cash" value="1"></td>
			<td align="center">1000포인트</td>
			<td align="center">1000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input class="radio_cash" type="radio" id="2000포인트" name="cash" value="2"></td>
			<td align="center">2000포인트</td>
			<td align="center">2000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input class="radio_cash" type="radio" id="3000포인트" name="cash" value="3"></td>
			<td align="center">3000포인트</td>
			<td align="center">3000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input class="radio_cash" type="radio" id="4000포인트" name="cash" value="4"></td>
			<td align="center">4000포인트</td>
			<td align="center">4000원</td>
		</tr>
		<tr>
			<td align="center" width="10%"><input class="radio_cash" type="radio" id="5000포인트" name="cash" value="5"></td>
			<td align="center">5000포인트</td>
			<td align="center">5000원</td>
		</tr>
		<tr>
			<td colspan="3"><hr width="600"></td>
		</tr>
		<tr>
			<td align="center" colspan="3"><button onclick="iamport()">결제하기</button></td>
		</tr>
	</table>

</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>