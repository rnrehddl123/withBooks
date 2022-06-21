<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerNovelList.JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>에피소드 목록</title>
	<
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<b>${getNovel.novel_subject}의 에피소드 목록</b>
		<form name="EpisodeOrder" action="EpisodeOrder" method="post" onsubmit="return check()">
		<input type="hidden" name="mnum" value="${login.mnum}">
		<input type="hidden" name="Purchase_price" value="100">
		<table align="center" class="writer">
			<tr>
				<td colspan="6" align="right"><a href="writerEpisode?nnum=${getNovel.nnum}">새로운 에피소드 쓰기</a> |
				 <a href="writerNovelList?mnum=${login.mnum}">소설 목록으로 가기</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>에피소드 제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>수정</th>
			</tr>
			<c:if test="${empty listEpisode}">
			<tr>
				<td colspan="6">등록된 에피소드가 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="dto" items="${listEpisode}">
			<tr>
				<td align="center"><input type="radio" name="epnum" value="${dto.epnum}"></td>
				<td><a href="clientViewer?epnum=${dto.epnum}">${dto.epi_subject}</a></td>
				<td align="center">${dto.epi_date}</td>
				<td align="center">${dto.epi_readcount}</td>
				<td align="center">${dto.epi_recommand}</td>
				<td align="center"><a href="writerEpisodeUpdate?epnum=${dto.epnum}&nnum=${getNovel.nnum}">수정</a></td>
			</tr>		
			</c:forEach>
		</table>
			<input type="submit" value="결제">
		</form>
	</div>
<jsp:include page="../../../main/footer.jsp"/>