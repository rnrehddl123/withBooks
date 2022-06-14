<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerNovelList.JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>ㅇㅇㅇ, 에피소드 목록</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<b> (소 설 제 목) 에피소드 목록</b>
		<table align="center" class="writer">
			<tr>
				<td colspan="6" align="right"><a href="#">새로운 에피소드 쓰기</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>에피소드 제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>수정 | 삭제</th>
			</tr>
			<c:if test="${empty listEpisode}">
			<tr>
				<td colspan="6">등록된 에피소드가 없습니다.</td>
			</tr>
			</c:if>
		<c:forEach var="dto" items="${listEpisode}">
			<tr>
				<td align="right">${dto.epnum}</td>
				<td>
					<a href="writerNovelEpisode?Epnum=${dto.epnum}">
						${dto.Epi_subject}
					</a>
				</td>
				<td align="center">${dto.epi_date}</td>
				<td align="center">${dto.epi_readcount}</td>
				<td align="center">${dto.epi_recommand}</td>
				<td align="center"><a href="update_Episode?Epnum=${dto.epnum}">수정</a> | <a href="delete_Episode?Epnum=${dto.epnum}">삭제</a></td>
			</tr>		
			</c:forEach>
		</table>
	</div>
<jsp:include page="../../../main/footer.jsp"/>