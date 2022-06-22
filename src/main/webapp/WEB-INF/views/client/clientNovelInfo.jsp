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
				  	<a href="clientViewer?epnum=${episode.epnum}" class="list-group-item list-group-item-action">
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
			<form>
				<div class="content">
				  <div>
				  	<P>이 책을 평가해주세요!</P>
				  	<div>
				  		<div class="stars">
						    <i class="bi bi-star"></i>
						    <i class="bi bi-star"></i>
						    <i class="bi bi-star"></i>
						    <i class="bi bi-star"></i>
						    <i class="bi bi-star"></i>
						</div>
				  	</div>
				  	<div class="textdiv"><textarea cols="70" rows="6"></textarea></div>
				  	<button type="submit" class="btn btn-primary">작성하기</button>
				  </div>
				</div>
			</form>
		</div>
	</div>
	
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
	
	
	var star = document.querySelectorAll('.bi-star');
	
	
	star[0].addEventListener("click", function(e){

		console.log("asasasa")
	});
	
	
	

</script>



</html>
<jsp:include page="../main/footer.jsp"/>