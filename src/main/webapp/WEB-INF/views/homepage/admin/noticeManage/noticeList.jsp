<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>[WithBooks] 공지사항</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>

<div class="listNotice">

	<h3>공지사항</h3>

	<table border="1" width="1000" height="500" align="center">
	<c:set var="pageNum" value="${noticeNum}"/>
	<c:if test="${empty listNotice}">
		<tr>
			<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
		</tr>
	</c:if>
    <c:forEach var="ndto" items="${listNotice}">
		<tr>
			<td width="60%">
				<a href="contentNotice?nonum=${ndto.nonum}">
					${ndto.notice_title}
				</a>
			</td>
			<td width="20%">${ndto.notice_reg_date}</td>
			<td width="10%"><input type="button" value="수정" onclick="window.location='updateNotice?nonum=${ndto.nonum}'"></td>
			<td width="10%"><input type="button" value="삭제" onclick="window.location='deleteNotice?nonum=${ndto.nonum}'"></td>
		</tr>		
	</c:forEach>	
	</table>
	<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				[<a href="listNotice?pageNum=${startPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="listNotice?pageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				[<a href="listNotice?pageNum=${endPage+1}">다음</a>]			
			</c:if>
	</c:if>
	
	<form name="f" action="listNotice" method="post">
	<input type="hidden" name="mode" value="search">
	검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
				<!-- AdminSlideMapper.xml : search -->
	

	<input type="button" value="글쓰기" align="right" onclick="window.location='insertNotice'">
				<!-- AdminSlideMapper.xml : insert -->
	
</div>

</body>

</html>
<%@include file="../../adminFooter.jsp"%>