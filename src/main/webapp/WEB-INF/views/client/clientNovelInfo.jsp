<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- clientBookInfo -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
   <title>clientNovelInfo</title>
   <link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="clientNovelInfoWrapper">
	   <div class="clientNovelInfo flex">
			<div class="thumbnailWrapper">
				<img class="thumbnail" alt="" src="resources/img/HarryPotter.jpg">
				<div class="notice" >
					<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
					  <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"/>
					</svg>
				</div>
			</div>
			<div class="info">
				<div class="cate">현대판타지</div>
				<div class="title">요즘 웹소설은 제목이 길다</div>
				<div class="detail">
					<div class="writer"><strong>나는작가</strong> 저</div>
					<div>총 화</div>
					<div class="contant">
						앞으로 인류의 미래는 어떻게 될까? 인간은 정말 이기적이고 파괴적인 본성을 지닌 존재일까? 
						인류 그리고 지구의 미래는 정말 희망이 없는 것일까? 독일의 저명한 신경생물학자이자 
						정신의학자인 요아힘 바우어는 이러한 세상에 맞서 ‘인간성’을 내세운다.
						‘인간성’은 인간의 생물학적 본성으로, ‘공감과 공존’을 바탕으로 한다.
					</div>
				</div>
			</div>
		</div>
		<div class="listEpisode">
			<div class="list-group">
			  <a href="#" class="list-group-item list-group-item-action">1화:css는 귀찮다
			  	<p>2022-06-15</p>
			  </a>
			  <a href="#" class="list-group-item list-group-item-action">2화:퍼블리싱은 노가다
			  	<p>2022-06-15</p>
			  </a>
			  <a href="#" class="list-group-item list-group-item-action">3화:알림은 어렵다.
			  	<p>2022-06-15</p>
			  </a>
			  <a href="#" class="list-group-item list-group-item-action">4화:정말 어렵다.
			  	<p>2022-06-15</p>
			  </a>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">

	var notice = document.querySelector('.notice');
	var nnum = 1;
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
</script>

</html>
<jsp:include page="../main/footer.jsp"/>