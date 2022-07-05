<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>이메일 인증번호 확인</title>
</head>
	<body>
		<div class="login">
			<div class="head">
				<img src="resources/img/nav_logo.png" alt="" width="110" height="50">
			</div>
			<div class="form">
				<form action="pw_set" method="post">
					<input type="hidden" name ="num" value="${num}">
					<div class="textbox inputWrapper">
						<input type="text" name="email_ok" class="form-control" placeholder="인증번호를 입력하세요">
						<div class="error"> </div>
					</div>
					<button type="submit" id="check" class="btn btn-primary">확인</button>
				</form>
			</div>
		</div>
	</body>
</html>