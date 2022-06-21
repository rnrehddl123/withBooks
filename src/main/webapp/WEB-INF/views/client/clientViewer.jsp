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
				<div class="icon">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
					  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
					</svg>
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
					  <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"/>
					</svg>
				</div>
			</div>
		</nav>
		<div class="content">
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
				<a>화</a>
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

<script type="text/javascript">
	document.addEventListener("wheel", function (e) {
		  if (e.deltaY > 0) {
			  document.querySelector(".top").classList.add("hide")
			  document.querySelector(".bot").classList.add("hide")
		  } else {
			  document.querySelector(".top").classList.remove("hide")
			  document.querySelector(".bot").classList.remove("hide")
		  }
		});
	
	
	var purchase_modal = document.querySelector('.purchase_modal');
	var close_btn = document.querySelector('.purchase_modal .close');
	var prev_btn = document.querySelector('.prev_btn');
	var next_btn = document.querySelector('.next_btn');
	var modal_msg = document.querySelector('.modal-body p');
	var modal_footer = document.querySelector('.modal-footer');
	var epnum = ${epdto.epnum};
	var nextData = {
            method: 'POST',
            body: '${epdto.epnum}',
            headers: {
                'Content-Type': 'text/plain'
            }
        };
	
	function close_modal(){
		purchase_modal.classList.add('hidden');
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
</script>
</html>