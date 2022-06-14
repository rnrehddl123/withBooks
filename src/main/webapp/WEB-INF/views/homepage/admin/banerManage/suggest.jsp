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
	<form action="suggest" method="post">
	<table border="1" width="1000" height="300">
		<tr height="50" align="center">
			<th colspan="2" >작품 리스트</th>	
		</tr>
		<c:if test="${empty listNovel}">
		<tr>
			<td colspan="2">등록된 작품이 없습니다.</td>	
		</tr>
		</c:if>
		<c:forEach items="${listNovel}" var="dto">
		<tr>
			<input type="hidden" name="nnum" value="${dto.nnum}"/>
			<input type="hidden" name="suggestNovel" value="${dto.novel_subject}"/>
			<td width="70%">${dto.novel_subject}</td>
			<td width="15%"><input type="submit" value="등록"></td>	
		</tr>
		</c:forEach>
	</table>
	
	</form>
	검색 : <input type="text"><input type="button" value="검색"><p>
	 <!-- AdminSuggestMapper.xml : searchAdminSuggest -->
	 
	<table border="1" width="1000" height="500">
		<tr width="10%" height="50" align="center">
			<th width="70%">추천작</th>
			<th width="30%">삭제</th>
		</tr>
	<c:if test="${empty listAdminSuggest}">
		<tr>
			<td colspan="2">등록된 추천작이 없습니다.</td>	
		</tr>
	</c:if>
	<c:forEach items="${listAdminSuggest}" var="sdto">
		<tr>
			<td width="70%">${sdto.suggestNovel}</td>
			<td width="30%"><a href="suggestDelete?sunum=${sdto.sunum}">삭제</a></td>
		</tr>
	</c:forEach>
	</table>
	 
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>