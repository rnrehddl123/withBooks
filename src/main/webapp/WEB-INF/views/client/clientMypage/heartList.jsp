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
<div align="center">
	<table class="outline">
	<tr height="30" align="center">
		<td colspan="3"><hr class="hrLine"></td>
	</tr>
	<tr height="30" align="center">
		<th colspan="3">내 찜 목록</th>
	</tr>
	<tr height="30" align="center">
		<td colspan="3"><hr class="hrLine"></td>
	</tr>
	<tr height="30" align="center">
		<th>이미지</th>
		<th>소설(시리즈) 제목</th>
		<th>삭제하기</th>
	</tr>
	<c:if test="${empty listHeart}">
		<tr>
			<td colspan="2" align="center">찜 한 소설이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="hdto" items="${listHeart}">
		<tr align="center">
			<td><img height="100" width="100" src="resources/img/${hdto.novelDTO.novel_image}"></td>
			<td><a href="clientNovelInfo?nnum=${hdto.novelDTO.nnum}">${hdto.novelDTO.novel_subject}</a></td>
			<td><button type="button" class="heart_del btn btn-primary" onclick="heart_del2(${hdto.hnum})">삭제</button></td>
		</tr>
	</c:forEach>
	</table>
	<hr class="hrLine">
</div>

<div align="center">
	<c:if test="${rowCount>0}">
		<c:if test="${startPage>1}">
			[<a href="heartList?pageNum=${startPage-1}">이전</a>]			
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			[<a href="heartList?pageNum=${i}"><c:out value="${i}"/></a>]	
		</c:forEach>
		<c:if test="${endPage<pageCount}">
			[<a href="heartList?pageNum=${endPage+1}">다음</a>]			
		</c:if>
	</c:if>
	
	<form name="f" action="heartList" method="post">
		<input type="hidden" name="mode" value="search">
			검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
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