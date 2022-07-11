<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerNovelList.JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>에피소드 목록</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div class="margintop" align="center">
		<b>${getNovel.novel_subject}의 에피소드 목록</b>
		<form name="f" action="EpisodeChange" method="post" onsubmit="return check()">
		<input type="hidden" name="mnum" value="${login.mnum}">
		<table align="center" class="table novel">
			<thead>
			<tr>
				<td colspan="5" align="right"><a href="writerEpisode?nnum=${getNovel.nnum}"><button type="button" class="btn btn-light">새로운 에피소드 쓰기</button></a> |
				 <a href="writerNovelList?mnum=${login.mnum}"><button type="button" class="btn btn-light">소설 목록으로 가기</button></a>
				  
				  	<select class="changeList" name="pp" onchange="change()">
						<option value="past">과거순</option>
						<option selected value="now">현재순</option>
					</select>
				 </td>
			</tr>
			<tr>
				<th>에피소드 제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>수정</th>
			</tr>
			</thead>
			<c:set var="pageNum" value="${episodeNum}"/>
			<c:if test="${empty listEpisodeCount}">
			<tr>
				<td colspan="4">등록된 에피소드가 없습니다.</td>
			</tr>
			</c:if>
			<tbody>
			<c:forEach var="dto" items="${listEpisodeCount}">
			<tr>
				<td align="center">${dto.EPI_SUBJECT}</td>
				<td align="center">${dto.EPI_DATE}</td>
				<td align="center">${dto.EPI_READCOUNT}</td>
				<td align="center"><a href="writerEpisodeUpdate?epnum=${dto.EPNUM}&nnum=${getNovel.nnum}"><button type="button" class="btn btn-light">수정</button></a></td>
			</tr>		
			</c:forEach>
			</tbody>
		</table>
		<ul class="pagination justify-content-center">
		<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				<li class="page-item"><a class="page-link" href="writerEpisodeList?nnum=${getNovel.nnum}&change=${change}&pageNum=${startPage-1}">이전</a></li>			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<li class="page-item"><a class="page-link" href="writerEpisodeList?nnum=${getNovel.nnum}&change=${change}&pageNum=${i}"><c:out value="${i}"/></a></li>	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				<li class="page-item"><a class="page-link" href="writerEpisodeList?nnum=${getNovel.nnum}&change=${change}&pageNum=${endPage+1}">다음</a></li>		
			</c:if>
		</c:if>
		</ul>
		</form>
	</div>
<script type="text/javascript">
function getParameter(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var changeValue = getParameter("change");
var changeOption = document.querySelectorAll('.changeList option')
for(var i=0;i<changeOption.length;i++){
	if(changeOption[i].value==changeValue){
		changeOption[i].selected = 'selected'
	}
}


function change(){
	var change = document.querySelector('.changeList').value
	console.log(change)
	location.href= "writerEpisodeList?nnum=${getNovel.nnum}&change="+change
}
</script>	
<jsp:include page="../../../main/footer.jsp"/>