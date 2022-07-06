<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 추천작 관리</title>
</head>
<%@ include file="../../adminHeader.jsp"%>
<body>
<div class="suggest">
	<b><h1>추천작 관리</h1></b><p>
	<table border="1" width="1000" height="500">
		<tr height="50" align="center">
			<th colspan="3" >작품 리스트</th>	
		</tr>
		<c:if test="${empty listNovel}">
		<tr>
			<td colspan="3">등록된 작품이 없습니다.</td>	
		</tr>
		</c:if>
		<c:forEach items="${listNovel}" var="dto">
		<tr>
			<form name="s" action="insertSuggestOk" method="post">
			<input type="hidden" name="nnum" value="${dto.nnum}"/>
			<input type="hidden" name="suggestNovel" value="${dto.novel_subject}"/>
			<td width="20%" align="center">${dto.novel_memberName}</td>
			<td width="65%" align="center">${dto.novel_subject}</td>
			<td width="15%" align="center"><input type="submit" value="등록"></td>
			</form>	
		</tr>
		</c:forEach>
	</table>
	<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				[<a href="insertSuggest?pageNum=${startPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="insertSuggest?pageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				[<a href="insertSuggest?pageNum=${endPage+1}">다음</a>]			
			</c:if>
	</c:if>
	
	<form name="f" action="insertSuggest" method="post">
	<input type="hidden" name="mode" value="find">
	<select name="search">
			<option value="novel_memberName">작가명</option>
			<option value="novel_subject">제목</option>
	</select>
	검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
	 <!-- AdminSuggestMapper.xml : searchAdminSuggest -->
	 
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>