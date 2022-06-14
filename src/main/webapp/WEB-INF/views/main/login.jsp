<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div class="login">
		<div class="head">
			<img src="resources/img/nav_logo.png" alt="" width="110" height="50">
		</div>
		
		<div class="form">
			<form name="f" action="login" method="post" onsubmit="return check()">
			  <div class="inputWrapper">
			    <input type="text" name="Member_id" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="아이디">
			  </div>
			  <div class="inputWrapper">
			    <input type="password" name="Member_passwd" class="form-control" id="exampleInputPassword1" placeholder="비밀번호">
			  </div>
			  <div class="inputWrapper">
			  	<div class="mb-3 form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">아이디 저장</label>
				    <div class="find">
				    	<a href="findId">아이디 찾기</a>
				    	<a href="findPassword">비밀번호 찾기</a>
				    </div>
			  	</div>
			  </div>
			  <button type="submit" class="btn btn-primary">로그인</button>
			  <button class="btn btn-light">회원가입</button>
			 </form>
		</div>
	</div>
</body>
</html>