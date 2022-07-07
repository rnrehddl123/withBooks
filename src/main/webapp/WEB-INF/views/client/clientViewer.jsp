<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="resources/css/main.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/client.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div class="view">
		<nav class="top">
			<div class="content flex">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
				</svg>
				<a>${epdto.epi_subject}</a>
				<div class="notice icon">
					<div class="bell">
						<i class="bi bi-bell"></i>
					</div>
				</div>
			</div>
		</nav>
		<div class="content text">
			<p><br></p>
			<p><br></p>
			<p><br></p>
			<p><br></p>
			${epdto.epi_content}
			<p><br></p>
			<p><br></p>
			<p><br></p>
			<p><br></p>
		</div>
		<footer class="bot">
			<div class="content flex">
				<div class="icon">
					<div class="prev_btn">
						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-caret-left" viewBox="0 0 16 16">
						  <path d="M10 12.796V3.204L4.519 8 10 12.796zm-.659.753-5.48-4.796a1 1 0 0 1 0-1.506l5.48-4.796A1 1 0 0 1 11 3.204v9.592a1 1 0 0 1-1.659.753z"/>
						</svg>
					</div>
					<div class="next_btn">
						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-caret-right" viewBox="0 0 16 16">
						  <path d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z"/>
						</svg>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<jsp:include page="/WEB-INF/views/purchase_modal.jsp"></jsp:include>
</body>
<body oncontextmenu="return false" onselectstart="return false" ondragstart="return false" onkeydown="return false">

<script type="text/javascript">

	document.oncontextmenu = function(){return false;}


	var chevron=document.querySelector('.bi-chevron-left');
	chevron.addEventListener("click", function (e) {
		location.href="http://localhost:8080/withbooks/clientNovelInfo?nnum=${noveldto.nnum}"
	});


	var content = document.querySelector('.text.content');
	content.addEventListener("click", function (e) {
		if(document.querySelector(".top").classList.contains('hide')){
			document.querySelector(".top").classList.remove("hide")
			document.querySelector(".bot").classList.remove("hide")
		}else {
			document.querySelector(".top").classList.add("hide")
			document.querySelector(".bot").classList.add("hide")
		}
		
	});
	
	
	window.addEventListener("wheel", function (e) {
		
		let scrollLocation = document.documentElement.scrollTop; // 현재 스크롤바 위치
		let windowHeight = window.innerHeight; // 스크린 창
		let fullHeight = document.body.scrollHeight; //  margin 값은 포함 x

		if (scrollLocation + windowHeight >= fullHeight-80 || 80 >= scrollLocation) {
			document.querySelector(".top").classList.remove("hide")
			document.querySelector(".bot").classList.remove("hide")
		}else{
			document.querySelector(".top").classList.add("hide")
			document.querySelector(".bot").classList.add("hide")
		}});
	
	
	var prev_btn = document.querySelector('.prev_btn');
	var next_btn = document.querySelector('.next_btn');
	var epnum = ${epdto.epnum};
	var nextData = {
            method: 'POST',
            body: '${epdto.epnum}',
            headers: {
                'Content-Type': 'text/plain'
            }
        };

	
	
	
	
	next_btn.addEventListener('click', function(e){
			fetch('checkNextEpi', nextData)
	        .then(response => response.json())
	        .then(response => {
	        	console.log(response);
	        	if(response.type=='Purchase'){
	        		modal_msg.innerHTML="다음화를 구매 하시겠습니까?";
	        		modal_footer.innerHTML="<button onclick='close_modal()' type='button' class='btn btn-secondary close' data-bs-dismiss='modal'>닫기</button><a href=EpisodeOrder?epnum="
	        		+response.epnum+"><button type='button' class='btn btn-primary'>구매하기</button></a>"
	        		purchase_modal.classList.remove('hidden');
	        	}else if(response.type=='noepi'){
	        		modal_msg.innerHTML="다음화가 없습니다"
	        		purchase_modal.classList.remove('hidden');
	        	}else if(response.type=='go'){
	        		purchase_modal.classList.add('hidden');
	        		location.href='clientViewer?epnum='+response.epnum;
		        }
	        });
    });
	
	prev_btn.addEventListener('click', function(e){
		fetch('checkPrevEpi', nextData)
        .then(response => response.json())
        .then(response => {
        	if(response.type=='Purchase'){
        		modal_msg.innerHTML="이전화를 구매 하시겠습니까?";
        		modal_footer.innerHTML="<button onclick='close_modal()' type='button' class='btn btn-secondary close' data-bs-dismiss='modal'>닫기</button><a href=EpisodeOrder?epnum="
        		+response.epnum+"><button type='button' class='btn btn-primary'>구매하기</button></a>"
        		purchase_modal.classList.remove('hidden');
        	}else if(response.type=='noepi'){
        		modal_msg.innerHTML="이전화가 없습니다"
        		purchase_modal.classList.remove('hidden');
        	}else if(response.type=='go'){
        		purchase_modal.classList.add('hidden');
        		location.href='clientViewer?epnum='+response.epnum;
	        }
        });
	});
	
	var nnnum;
	<c:if test="${not empty noticeNovelDTO}">
		nnnum=${noticeNovelDTO.nnnum};
	</c:if>
	
	var mnum;
	<c:if test="${not empty login.mnum}">mnum=${login.mnum}</c:if>
	
	var nnum = ${noveldto.nnum};
	
	var bell_icon = document.querySelector('.bi-bell');
	if(nnnum!=null){
		bell_icon.classList.remove('bi-bell');
		bell_icon.classList.add('bi-bell-fill');
	}
	
	var noticeData = {
            method: 'POST',
            body: JSON.stringify({ nnum, mnum }),
            headers: {
                'Content-Type': 'application/json'
            }
        };
	
	
	
	bell_icon.addEventListener('click', function(e){
		if(mnum==null){
			location.href='login';
		}else{
			if(bell_icon.classList.contains('bi-bell-fill')){
				fetch('deleteNoticeNovel', noticeData)
		        .then(response => response.text())
		        .then(response => {
		            console.log(response)
		        });
				bell_icon.classList.remove('bi-bell-fill');
				bell_icon.classList.add('bi-bell');
			}else{
				fetch('setNoticeNovel', noticeData)
		        .then(response => response.text())
		        .then(response => {
		            console.log(response)
		        });
				bell_icon.classList.add('bi-bell-fill');
				bell_icon.classList.remove('bi-bell');
			}
		}
    });
	
	
</script>
</html>