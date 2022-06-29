<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src='https://www.google.com/recaptcha/api.js'></script>
	<script type="text/javascript">
	$(function() {
		$('#adminLogin').submit(function() {
				var captcha = 1;
				$.ajax({
		            url: 'pro/VerifyRecaptcha',
		            type: 'post',
		            data: {
		                recaptcha: $("#g-recaptcha-response").val()
		            },
		            success: function(data) {
		                switch (data) {
		                    case 0:
		                        console.log("자동 가입 방지 봇 통과");
		                        captcha = 0;
		                		break;
		                    case 1:
		                        alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
		                        break;
		                    default:
		                        alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
		                   		break;
		                }
		            }
		        });
				if(captcha != 0) {
					return false;
				} 
		});
	});
	
	function FormSubmit() {
		if (grecaptcha.getResponse() == "") {
			alert("리캡챠를 체크해야 합니다.");
			return false;
		} else {
			return true;
		}
	}
	</script>
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