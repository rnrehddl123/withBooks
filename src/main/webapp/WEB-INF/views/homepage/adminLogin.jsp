<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<form name="adminLogin" method="post" onsubmit="return FormSubmit();">
		<input type="text" name="Admin_id">
		<input type="password" name="Admin_passwd">
		<input type="submit" name="submit" value="로그인">
		<div class="g-recaptcha" data-sitekey="6LdWvKEgAAAAAKsSdaskcLooRyUyvtrkvOal89oT"></div>
	</form>
</body>
</html>