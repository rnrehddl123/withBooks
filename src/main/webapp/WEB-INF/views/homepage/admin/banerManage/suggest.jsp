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
	<form action="" method="post">
	<table border="1" width="1000" height="300">
		<tr height="50" align="center">
			<th colspan="2" >추천 작품 리스트</th>	
		</tr>
		<c:if test="${empty listNovel}">
		<tr>
			<td colspan="2">등록된 작품이 없습니다.</td>	
		</tr>
		</c:if>
		<c:forEach items="${listNovel}" var="ndto">
		<tr>
			<td><input type="checkbox" name="item" value="${ndto.Novel_subhect}">
			${ndto.Novel_subhect}
			</td>
			<td><input type="button" value="선택"></td>
		</tr>
		</c:forEach>	
	</table>
	</form>
	검색 : <input type="text"><input type="button" value="검색"><p>
	 <!-- AdminSuggestMapper.xml : searchAdminSuggest -->
	 
	<form action="suggest" method="post"> 
	<table border="1" width="1000" height="300">
		<tr align="center">
			<th colspan="2">선택 리스트</th>
		</tr>
		<c:if test="${empty paramValues.item}">
		<tr>
			<td colspan="2">등록된 작품이 없습니다.</td>	
		</tr>
		</c:if>
		<c:forEach items="${paramValues.item}" var="ndto">
		<tr>
			<td>${paramValues.item}</td>
			<td><input type="button" value="삭제"></td>
		</tr>
		</c:forEach>	
	</table>
	<input type="submit" value="등록">
	</form>
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>