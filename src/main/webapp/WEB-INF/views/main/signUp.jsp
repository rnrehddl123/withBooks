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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="login sighup">
		<div class="head">
			<img src="resources/img/nav_logo.png" alt="" width="110" height="50">
		</div>
		
		<div class="form">
			<form name="signUp" method="POST" action="insertMember">
			  <div class="inputWrapper">
			    <input name="member_name" type="text" class="form-control" aria-describedby="emailHelp" placeholder="이름">
			  </div>
			  <div class="inputWrapper">
			    <input name="member_id" type="text" class="form-control" aria-describedby="emailHelp" placeholder="아이디">
			  </div>
			  <div class="inputWrapper">
			    <input name="member_passwd" type="password" class="form-control" id="exampleInputPassword1" placeholder="비밀번호">
			  </div>
			  <div class="flex inputWrapper">
			    <input name="member_tel1" type="text" class="form-control" aria-describedby="emailHelp" placeholder="전화번호">
			    <div class="marginauto">-</div>
			    <input name="member_tel2" type="text" class="form-control" aria-describedby="emailHelp" placeholder="전화번호">
			    <div class="marginauto">-</div>
			    <input name="member_tel3" type="text" class="form-control" aria-describedby="emailHelp" placeholder="전화번호">
			  </div>
			  <div class="inputWrapper">
			    <input name="member_address" type="text" id="address_kakao" class="form-control" aria-describedby="emailHelp" placeholder="주소" readonly>
			  </div>
			  <div class="inputWrapper">
			    <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="상세주소">
			  </div>
			  <div class="inputWrapper">
			    <input name="member_email" type="text" class="form-control" aria-describedby="emailHelp" placeholder="이메일">
			  </div>
			  <div class="flex inputWrapper">
			  	<input name="member_birth" type="text" class="form-control birth" aria-describedby="emailHelp" placeholder="생일">
			    <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
				  <input name="member_sex" value="man" type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" checked>
				  <label class="btn btn-outline-primary" for="btnradio1">남자</label>
				
				  <input name="member_sex" value="woman" type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
				  <label class="btn btn-outline-primary" for="btnradio2">여자</label>
				</div>
			  </div>
			  <div class="inputWrapper flex checkWrapper">
			    <div class="form-check marginauto">
				  <input name="member_preferred" class="form-check-input" type="checkbox" value="판타지" onclick="CountChecked(this)">
				  <label class="form-check-label" for="flexCheckDefault">
				    	판타지
				  </label>
				</div>
				<div class="form-check marginauto">
				  <input name="member_preferred" class="form-check-input" type="checkbox" value="로맨스" onclick="CountChecked(this)">
				  <label class="form-check-label" for="flexCheckDefault">
				    	로맨스
				  </label>
				</div>
				<div class="form-check marginauto">
				  <input name="member_preferred" class="form-check-input" type="checkbox" value="현판" onclick="CountChecked(this)">
				  <label class="form-check-label" for="flexCheckDefault">
				    	현판
				  </label>
				</div>
				<div class="form-check marginauto">
				  <input name="member_preferred" class="form-check-input" type="checkbox" value="판타지" onclick="CountChecked(this)">
				  <label class="form-check-label" for="flexCheckDefault">
				    	판타지
				  </label>
				</div>
				<div class="form-check marginauto">
				  <input name="member_preferred" class="form-check-input" type="checkbox" value="판타지" onclick="CountChecked(this)">
				  <label class="form-check-label" for="flexCheckDefault">
				    	판타지
				  </label>
				</div>
			  </div>
			  	<button type="submit" class="btn btn-primary">회원가입</button>
			 </form>
		</div>
	</div>
</body>


<script type="text/javascript">
window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}


var maxCount = 3;			
var count = 0;   						

function CountChecked(field){ 			
	if (field.checked) {				
		count += 1;		
	}
	else {				
		count -= 1;	
	}
	
	if (count > maxCount) {	
		alert("카테고리는 3개까지만 입력이 가능합니다.");	
	field.checked = false;					
	count -= 1;							
	}
}

</script>

</html>