<%@ page session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
    <meta charset="UTF-8"/>
    <link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
	<h1 class="page-header">Chat</h1>		
	
	<table class="table table-bordered">
		<tr>
			<td><input type="text" name="user" id="user" class="form-control" placeholder="유저명"></td>
			<td>
				<button type="button" class="btn btn-default btnConnect">테스트 연결</button>
				<button type="button" class="btn btn-default btnSend">테스트 전송</button>
				<button type="button" class="btn btn-default btnDisconnect">종료</button>
			</td>
		</tr>
		<tr>
			<td colspan="2"><div id="list"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" name="msg" id="msg" placeholder="대화 내용을 입력하세요." class="form-control"></td>
		</tr>
	</table>
	
</div>
<script type="text/javascript">
//채팅 서버 주소
let url = "ws://localhost:8080/withbooks/chatserver";
   		
// 웹 소켓
let ws;


// 연결하기
var btnConnect=document.querySelector('.btnConnect')
btnConnect.addEventListener('click',function(e){
	ws = new WebSocket(url);
		
   	// 소켓 이벤트 매핑
   	ws.onopen = function (e) {
		ws.send(document.querySelector('#user').value);
	};
	
	ws.onmessage=function (e) {
		console.log(e.data)
	};
})

var btnDisconnect=document.querySelector('.btnDisconnect')
btnDisconnect.addEventListener('click',function(e){
   	// 소켓 이벤트 매핑
	ws.close();
   	
})

var btnSend=document.querySelector('.btnSend')
btnSend.addEventListener('click',function(e){
   	// 소켓 이벤트 매핑
	ws.send(document.querySelector('#msg').value);
})


</script>
</body>
</html>