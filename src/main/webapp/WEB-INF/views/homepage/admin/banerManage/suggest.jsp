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
			<form name="s" action="InsertSuggest" method="post">
			<input type="hidden" name="nnum" value="${dto.nnum}"/>
			<input type="hidden" name="suggestNovel" value="${dto.novel_subject}"/>
			<td width="85%" align="center">${dto.novel_subject}</td>
			<td width="15%" align="center"><input type="submit" value="등록"></td>
			</form>	
		</tr>
		</c:forEach>
	</table>
	
	<form name="f" action="suggest" method="post">
	<input type="hidden" name="mode" value="search">
	검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
	 <!-- AdminSuggestMapper.xml : searchAdminSuggest -->
	 
	<table border="1" width="1000" height="300">
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
	 
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>