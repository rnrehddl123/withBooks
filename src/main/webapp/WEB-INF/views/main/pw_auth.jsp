<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증번호 확인</title>
</head>
	<body>
		<form action="pw_set" method="post">
		<input type="hidden" name ="num" value="${num}">
			<div class=content>
				<div class="textbox">
				<input type="text" name="email_ok" placeholder="인증번호를 입력하세요"><label>인증번호 </label>
				<div class="error"> </div>
			</div><br><br>
				<input type="submit" id="check" value="확인">
	</form>
	</body>
</html>