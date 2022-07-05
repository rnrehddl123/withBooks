<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientUpdate -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>clientUpdate</title>
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
		<div class="form">
			<form name="edit" action="updateMember" method="POST" onsubmit="return check()">					
			<input type="hidden" name="mnum" value="${login.mnum}"/>
  				<div class="inputWrapper">
					<input name="member_name" required type="text" class="form-control"
					 		aria-describedby="emailHelp" placeholder="이름" value="${login.member_name}" readOnly>
				</div>	
				<div class="inputWrapper">	
					<input name="member_id" required type="text" class="form-control" 
							aria-describedby="emailHelp" placeholder="아이디" value="${login.member_id}" readOnly>
					</div>	
  				<div class="inputWrapper">
					<input name="member_passwd" required type="password" class="form-control"
							 id="exampleInputPassword1" placeholder="비밀번호" value="${login.member_passwd}">
				</div>
  				<div class="flex inputWrapper">
					<input name="Member_tel1" required type="text" class="form-control"
							 aria-describedby="emailHelp" placeholder="전화번호" maxlength="3" minlength="3" value="${Member_tel1}">
					<div class="marginauto">-</div>
					<input name="Member_tel2" required type="text" class="form-control"
							 aria-describedby="emailHelp" placeholder="전화번호" maxlength="4" minlength="4" value="${Member_tel2}">
					<div class="marginauto">-</div>
					<input name="Member_tel3" required type="text" class="form-control"
							 aria-describedby="emailHelp" placeholder="전화번호" maxlength="4" minlength="4" value="${Member_tel3}">
				</div>
				<div class="inputWrapper">
					<input name="member_address" required type="text" id="address_kakao" class="form-control"
							 aria-describedby="emailHelp" placeholder="주소" value="${login.member_address}" readOnly>	
				</div>
  				<div class="inputWrapper">
			    	<input type="text" requird class="form-control" aria-describedby="emailHelp" placeholder="상세주소">
			    </div>
  				<div class="inputWrapper">
					<input name="member_email" required type="text" class="form-control"
							 aria-describedby="emailHelp" placeholder="이메일" value="${login.member_email}" readOnly>
				</div>	
  				<div class="flex inputWrapper">
					<input name="member_birth" type="text" class="form-control birth" aria-describedby="emailHelp" value="${login.member_birth}" readOnly>
			    	<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
				  		<input name="member_sex" required value="man" type="radio" class="btn-check" 
				  				name="btnradio" id="btnradio1" autocomplete="off" value="man" ${login.member_sex eq 'man' ? "checked" : '' }  onclick="return(false);">
				  		<label class="btn btn-outline-primary" for="btnradio1">남자</label>
				
				  		<input name="member_sex" required value="woman" type="radio" class="btn-check"
				  				 name="btnradio" id="btnradio2" autocomplete="off" value="woman" ${login.member_sex eq 'woman' ? "checked" : '' }  onclick="return(false);">
				  		<label class="btn btn-outline-primary" for="btnradio2">여자</label>
					</div>
				</div>
  				<div class="inputWrapper flex checkWrapper">
			  		<c:forEach items="${categoryList}" var="dto">
			  			<div class="form-check marginauto">
					  		<input name="member_preferred" class="form-check-input" type="checkbox" value="${dto.cate_name}"
					  			${login.member_preferred1 eq dto.cate_name ? "checked" : ''} 
					  			${login.member_preferred2 eq dto.cate_name ? "checked" : ''} 
					  			${login.member_preferred3 eq dto.cate_name ? "checked" : ''} onclick="countCheck(this)">
					  		<label class="form-check-label" for="flexCheckDefault">${dto.cate_name}</label>
						</div>
					</c:forEach>
			  	</div>
			  	<button type="submit" class="btn btn-primary">수정</button>
			  	<button type="button" class="btn btn-primary" onclick="history.back()">취소</button>		
			</form>
  		</div>
	</div>
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

	function countCheck(obj){
		var chkbox = document.getElementsByName("member_preferred");
		var chkCnt = 0;
		
		for(var i=0;i<chkbox.length; i++){
			if(chkbox[i].checked){
				chkCnt++;
			}
		}
		if(chkCnt>3){
			alert("카테고리는 3개까지만 입력이 가능합니다.");
			obj.checked = false;
			return false;
		}
	}
	
	
</script>
<jsp:include page="../../main/footer.jsp"/>