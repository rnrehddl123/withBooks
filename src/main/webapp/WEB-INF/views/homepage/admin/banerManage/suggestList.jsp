<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 추천작 리스트</title>
</head>
<%@ include file="../../adminHeader.jsp"%>
<body>
<div class="suggest">
	<b><h1>추천작 리스트</h1></b><p>
	<table border="1" width="1000" height="500">
		<tr width="10%" height="50" align="center">
			<th colspan="2" align="center">추천작</th>
		</tr>
	<c:if test="${empty listAdminSuggest}">
		<tr>
			<td colspan="2">등록된 추천작이 없습니다.</td>	
		</tr>
	</c:if>
	<c:forEach items="${listAdminSuggest}" var="sdto">
		<tr>
			<td width="70%" align="center">${sdto.suggestNovel}</td>
			<td width="30%" align="center"><input type="button" value="삭제" onclick="window.location='deleteSuggest?sunum=${sdto.sunum}'"></td>
		</tr>
	</c:forEach>
	</table>
	<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				[<a href="listSuggest?pageNum=${startPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="listSuggest?pageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				[<a href="listSuggest?pageNum=${endPage+1}">다음</a>]			
			</c:if>
	</c:if>
	
	<form name="f" action="listSuggest" method="post">
	<input type="hidden" name="mode" value="search">
	검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
	 
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>