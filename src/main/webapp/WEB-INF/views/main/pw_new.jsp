<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<title>새 비밀번호 설정</title>
</head>
	<body>
		<div class="login">
			<div class="head">
				<img src="resources/img/nav_logo.png" alt="" width="110" height="50">
			</div>
			<form action="pw_new" method="POST" class="content" onsubmit="return check_pass()">
				<div class="form">
					<div class="textbox inputWrapper">
						<input id="pw" name="pw" class="form-control" type="password" placeholder="새비밀번호">
					</div>
					<div class="textbox inputWrapper">
						<input id="pw2" type="password" class="form-control" onchange="isSame();" placeholder="새비밀번호 확인">
						<div class="error">
						</div>
					</div>
					<span id=same></span>
					<br><br>
					<button type="submit" id="check" class="btn btn-primary">비밀번호변경 찾기</button>
				</div>
			</form>
		</div>
	</body>
	<script type="text/javascript">
		function check_pass(){
			console.log("asdasd")
			if(document.querySelector('#pw').value==document.querySelector('#pw2').value){
				return true;
			}
			alert("비밀번호 확인이 일치하지 않습니다.");
			return false;
		}
		function isSame(){
			if(document.querySelector('#pw').value==document.querySelector('#pw2').value){
				document.querySelector('.error').innerHTML="사용가능한 비밀번호 입니다."
			}else{
				document.querySelector('.error').innerHTML="비밀번호가 일치하지 않습니다."
			}
			return false;
		}
		
	</script>
</html>