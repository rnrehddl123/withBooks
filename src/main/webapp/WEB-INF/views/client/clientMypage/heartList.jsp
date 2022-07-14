<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- clientLibrary.jsp -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
	<title>내 찜 목록</title>
	<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="lib_wrraper">
	<h3>내 찜목록</h3>
	<section class="flex">
		<c:forEach var="hdto" items="${listHeart}">
			<div class="content_wrraper">
				<a href="clientNovelInfo?nnum=${hdto.novelDTO.nnum}">
					<div class="lib_content">
						<img src="/with/${hdto.novelDTO.novel_image}" onError="this.src='resources/img/nav_logo.png'">
						<p>${hdto.novelDTO.novel_subject}<p>
						<button type="button" class="heart_del btn btn-primary" onclick="heart_del2(${hdto.hnum})">삭제</button>
					</div>
				</a>
			</div>
			
		</c:forEach>
	</section>
</div>
<div align="center">
	<ul class="pagination justify-content-center">
	<c:if test="${rowCount>0}">
		<c:if test="${startPage>1}">
			<li class="page-item"><a class="page-link" href="heartList?pageNum=${startPage-1}">이전</a></li>			
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<li class="page-item"><a class="page-link" href="heartList?pageNum=${i}"><c:out value="${i}"/></a></li>	
		</c:forEach>
		<c:if test="${endPage<pageCount}">
			<li class="page-item"><a class="page-link" href="heartList?pageNum=${endPage+1}">다음</a></li>		
		</c:if>
	</c:if>
	</ul>
	<form name="f" action="heartList" method="post">
		<input type="hidden" name="mode" value="search">
			<input type="text" name="searchString" placeholder="검색"><input type="submit" value="검색"><p>
	</form>
</div>

</body>
<jsp:include page="../../main/footer.jsp"/>


<script type="text/javascript">
	var heart_del = document.querySelector('.heart_del');
	var mnum;
	<c:if test="${not empty login.mnum}">mnum=${login.mnum}</c:if>
	
		function heart_del2(hnum){
				fetch('deleteHeart', {
					method: 'POST',
		            body: JSON.stringify({ hnum }),
		            headers: {
		                'Content-Type': 'application/json'
		            }
		        })
		        .then(response => response.text())
		        .then(response => {
		            console.log(response)
		            history.go(0);
		        });
				heart_del.classList.remove('active');
		}
			

</script>