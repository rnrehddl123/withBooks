<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- clientBookInfo -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
   <title>clientNovelInfo</title>
   <link href="resources/css/client.css" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
</head>
<body>
	<div class="clientNovelInfoWrapper">
	   <div class="clientNovelInfo flex">
			<div class="thumbnailWrapper">
				<img class="thumbnail" alt="" src="resources/img/${noveldto.novel_image}">
				<div class="notice <c:if test="${not empty noticeNovelDTO}">active</c:if>" >
					<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
					  <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"/>
					</svg>
				</div>
			</div>
			<div class="info">
				<div class="cate">${noveldto.novel_cate}</div>
				<div class="title">${noveldto.novel_subject}</div>
				<div class="detail">
					<div class="writer"><strong>${noveldto.novel_memberName}</strong> 저</div>
					<div>총 ${fn:length(elist)}화</div>
					<div class="contant">
						${noveldto.novel_summary}
					</div>
				</div>
			</div>
		</div>
		<div class="listEpisode">
			<div class="list-group">
				<c:forEach items="${elist}" var="episode">
				  	<a onclick="epclick(${episode.epnum})" class="list-group-item list-group-item-action">
				  		${episode.epi_subject}
				  		<p>${episode.epi_date}</p>
				  	</a>
			 	</c:forEach>
			</div>
		</div>
	</div>
	
	<div class="review_wrapper">
		<div class="review">
			<label class="form-label">리뷰</label>
			<hr>
			<div class="review_content">
				<div class="review_chart">
					<c:if test="${ascore ne 'NaN'}">
						${ascore}
					</c:if>
					<div class="review_score">
						<div class="review_chart_star">
							<i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						</div>
						<div class="review_chart_star fill">
							<i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						    <i class="bi bi-star-fill"></i>
						</div>
					</div>
				</div>
				<div class="review_form">
				<P>이 책을 평가해주세요!</P>
				<div>
				<div class="stars" onmouseout="starout()">
				    <i class="bi bi-star"></i>
				    <i class="bi bi-star"></i>
				    <i class="bi bi-star"></i>
				    <i class="bi bi-star"></i>
				    <i class="bi bi-star"></i>
				</div>
				</div>
					<div class="textdiv"><textarea class="textarea" cols="76" rows="6"></textarea></div>
					<button class="review_btn btn btn-primary">작성하기</button>
				</div>
			</div>
			<div class="review_list">
				<c:if test="${empty reviewList}">
					첫번째 리뷰를 작성해 주세요.
				</c:if>
				<c:if test="${not empty reviewList}">
					<c:forEach items="${reviewList}" var="review">
						<section class="review_section">
							<div class="review_info">
								<div class="review_star count_${review.SCORE}">
									<i class="bi bi-star-fill user_score"></i>
								    <i class="bi bi-star-fill user_score"></i>
								    <i class="bi bi-star-fill user_score"></i>
								    <i class="bi bi-star-fill user_score"></i>
								    <i class="bi bi-star-fill user_score"></i>
								</div>
								<p>${review.MEMBER_ID}</p>
								<p>${review.REVIEW_DATE}</p>
							</div>
							<div class="review_content">
								<p>${review.CONTENT}</p>
							</div>
						</section>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/purchase_modal.jsp"></jsp:include>
</body>
<script type="text/javascript">

	var notice = document.querySelector('.notice');
	var nnum = ${noveldto.nnum};
	var mnum;
	<c:if test="${not empty login.mnum}">mnum=${login.mnum}</c:if>
	var noticeData = {
            method: 'POST',
            body: JSON.stringify({ nnum, mnum }),
            headers: {
                'Content-Type': 'application/json'
            }
        };
	
	notice.addEventListener('click', function(e){
		if(mnum==null){
			location.href='login';
		}else{
			if(notice.classList.contains('active')){
				fetch('deleteNoticeNovel', noticeData)
		        .then(response => response.text())
		        .then(response => {
		            console.log(response)
		        });
		        notice.classList.remove('active');
			}else{
				fetch('setNoticeNovel', noticeData)
		        .then(response => response.text())
		        .then(response => {
		            console.log(response)
		        });
		        notice.className += ' active';
			}
		}
    });
	
	
	var star = document.querySelectorAll('.stars .bi-star');
	
	function starout(){
		for(var i=0;i<star.length;i++){
			star[i].classList.remove('temp');
			if(!star[i].classList.contains('click')){
				star[i].classList.remove('bi-star-fill');
				star[i].classList.add('bi-star');
			}
		}
	}
	
	
	function epclick(e){
		if(mnum==null){
			location.href='login';
		}
		fetch('selectEpi', {
            method: 'POST',
            body: JSON.stringify({ epnum:e}),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(response => {
        	console.log(response);
        	if(response.type=='go'){
        		location.href='clientViewer?epnum='+e;
        	}else {
        		if(response.type=='Purchase'){
            		modal_msg.innerHTML="구매 하시겠습니까?";
            		modal_footer.innerHTML="<button onclick='close_modal()' type='button' class='btn btn-secondary close' data-bs-dismiss='modal'>닫기</button><a href=EpisodeOrder?epnum="
            		+e+"><button type='button' class='btn btn-primary'>구매하기</button></a>"
            		purchase_modal.classList.remove('hidden');
            	}
			}
        });
	}
	
	
	
	var review_btn=document.querySelector('.review_btn');

	
	
	review_btn.addEventListener('click', function(e){
		if(mnum==null){
			location.href='login';
		}
		var content=document.querySelector('.textarea').value;
		var score= document.querySelectorAll('.click').length;
		if(content==''){
			alert('리뷰 내용을 입력해 주세요');
			return;
		}else if(score==0){
			alert('별점을 입력해주세요.');
			return;
		}
		if(review_btn.innerHTML=='작성하기'){
			fetch('insertReview', {
		          method: 'POST',
		          body: JSON.stringify({ nnum, content,score}),
		          headers: {
		              'Content-Type': 'application/json'
		          }
		      })
			.then(response => response.text())
			.then(response => {
			    if(response=='overap'){
			    	alert('리뷰는 하나만 작성이 가능합니다.');
			    }
			});
		}else{
			var rnum=${review.RNUM}
			fetch('updateReview', {
		          method: 'POST',
		          body: JSON.stringify({ nnum, content,score,rnum}),
		          headers: {
		              'Content-Type': 'application/json'
		          }
		      })
			.then(response => response.text())
			.then(response => {
			    if(response=='overap'){
			    	alert('리뷰를 작성해주시고 수정해주셔야합니다..');
			    }
			});
		}
		
    });
	
	
<c:if test="${not empty review}">
	var score=${review.SCORE}
	document.querySelector('.textarea').value='${review.CONTENT}'
	for(var i=0;i<score;i++){
		star[i].classList.add('bi-star-fill');
		star[i].classList.add('click');
		star[i].classList.remove('bi-star');
	}
	review_btn.innerHTML='수정하기'
</c:if>
	
	
	
	
	
	star[0].addEventListener("mouseover", function(e){
		star[0].classList.remove('bi-star');
		star[0].classList.add('bi-star-fill');
		if(!star[1].classList.contains('click')){
			star[1].classList.remove('bi-star-fill');
			star[1].classList.add('bi-star');
		}
		if(!star[2].classList.contains('click')){
			star[2].classList.remove('bi-star-fill');
			star[2].classList.add('bi-star');
		}
		if(!star[3].classList.contains('click')){
			star[3].classList.remove('bi-star-fill');
			star[3].classList.add('bi-star');
		}
		if(!star[4].classList.contains('click')){
			star[4].classList.remove('bi-star-fill');
			star[4].classList.add('bi-star');
		}
		star[0].classList.add('temp');
		star[1].classList.remove('temp');
		star[2].classList.remove('temp');
		star[3].classList.remove('temp');
		star[4].classList.remove('temp');
	})
	star[0].addEventListener("click", function(e){
		star[0].classList.add('click');
		star[1].classList.remove('click');
		star[2].classList.remove('click');
		star[3].classList.remove('click');
		star[4].classList.remove('click');
		star[1].classList.remove('bi-star-fill');
		star[1].classList.add('bi-star');
		star[2].classList.remove('bi-star-fill');
		star[2].classList.add('bi-star');
		star[3].classList.remove('bi-star-fill');
		star[3].classList.add('bi-star');
		star[4].classList.remove('bi-star-fill');
		star[4].classList.add('bi-star');
	})
	
	star[1].addEventListener("mouseover", function(e){
		star[0].classList.remove('bi-star');
		star[0].classList.add('bi-star-fill');
		star[1].classList.remove('bi-star');
		star[1].classList.add('bi-star-fill');
		if(!star[2].classList.contains('click')){
			star[2].classList.remove('bi-star-fill');
			star[2].classList.add('bi-star');
		}
		if(!star[3].classList.contains('click')){
			star[3].classList.remove('bi-star-fill');
			star[3].classList.add('bi-star');
		}
		if(!star[4].classList.contains('click')){
			star[4].classList.remove('bi-star-fill');
			star[4].classList.add('bi-star');
		};
		star[0].classList.add('temp');
		star[1].classList.add('temp');
		star[2].classList.remove('temp');
		star[3].classList.remove('temp');
		star[4].classList.remove('temp');
	})
	star[1].addEventListener("click", function(e){
		star[0].classList.add('click');
		star[1].classList.add('click');
		star[2].classList.remove('click');
		star[3].classList.remove('click');
		star[4].classList.remove('click');
		star[2].classList.remove('bi-star-fill');
		star[2].classList.add('bi-star');
		star[3].classList.remove('bi-star-fill');
		star[3].classList.add('bi-star');
		star[4].classList.remove('bi-star-fill');
		star[4].classList.add('bi-star');
	})
	
	
	
	star[2].addEventListener("mouseover", function(e){
		star[0].classList.remove('bi-star');
		star[0].classList.add('bi-star-fill');
		star[1].classList.remove('bi-star');
		star[1].classList.add('bi-star-fill');
		star[2].classList.remove('bi-star');
		star[2].classList.add('bi-star-fill');
		if(!star[3].classList.contains('click')){
			star[3].classList.remove('bi-star-fill');
			star[3].classList.add('bi-star');
		}
		if(!star[4].classList.contains('click')){
			star[4].classList.remove('bi-star-fill');
			star[4].classList.add('bi-star');
		};
		star[0].classList.add('temp');
		star[1].classList.add('temp');
		star[2].classList.add('temp');
		star[3].classList.remove('temp');
		star[4].classList.remove('temp');
	})
	
	star[2].addEventListener("click", function(e){
		star[0].classList.add('click');
		star[1].classList.add('click');
		star[2].classList.add('click');
		star[3].classList.remove('click');
		star[4].classList.remove('click');
		star[3].classList.remove('bi-star-fill');
		star[3].classList.add('bi-star');
		star[4].classList.remove('bi-star-fill');
		star[4].classList.add('bi-star');
	})
	
	star[3].addEventListener("mouseover", function(e){
		star[0].classList.remove('bi-star');
		star[0].classList.add('bi-star-fill');
		star[1].classList.remove('bi-star');
		star[1].classList.add('bi-star-fill');
		star[2].classList.remove('bi-star');
		star[2].classList.add('bi-star-fill');
		star[3].classList.remove('bi-star');
		star[3].classList.add('bi-star-fill');
		if(!star[4].classList.contains('click')){
			star[4].classList.remove('bi-star-fill');
			star[4].classList.add('bi-star');
		};
		star[0].classList.add('temp');
		star[1].classList.add('temp');
		star[2].classList.add('temp');
		star[3].classList.add('temp');
		star[4].classList.remove('temp');
	})
	
	star[3].addEventListener("click", function(e){
		star[0].classList.add('click');
		star[1].classList.add('click');
		star[2].classList.add('click');
		star[3].classList.add('click');
		star[4].classList.remove('click');
		star[4].classList.remove('bi-star-fill');
		star[4].classList.add('bi-star');
	})
	
	star[4].addEventListener("mouseover", function(e){
		star[0].classList.remove('bi-star');
		star[0].classList.add('bi-star-fill');
		star[1].classList.remove('bi-star');
		star[1].classList.add('bi-star-fill');
		star[2].classList.remove('bi-star');
		star[2].classList.add('bi-star-fill');
		star[3].classList.remove('bi-star');
		star[3].classList.add('bi-star-fill');
		star[4].classList.remove('bi-star');
		star[4].classList.add('bi-star-fill');
		star[0].classList.add('temp');
		star[1].classList.add('temp');
		star[2].classList.add('temp');
		star[3].classList.add('temp');
		star[4].classList.add('temp');

	})
	
	star[4].addEventListener("click", function(e){
		star[0].classList.add('click');
		star[1].classList.add('click');
		star[2].classList.add('click');
		star[3].classList.add('click');
		star[4].classList.add('click');
	})
	
	var review_chart_star=document.querySelector('.review_chart_star.fill');
	var ascore=${ascore}*20+'%';
	review_chart_star.style.width=ascore;
	
	
	

</script>



</html>
<jsp:include page="../main/footer.jsp"/>