<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerNovelList.JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../../main/header.jsp"/>
<html>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<b>${novel_memberName}님의 소설</b>
		<table align="center" class="writer">
			<tr>
				<td colspan="4" align="right"><a href="writerNovel">새로운 소설 쓰기</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>소설(시리즈)제목(writerEpisodeList로)</th>
				<th>작성자</th>
				<th>추천수</th>
			</tr>
			<c:if test="${empty listmemberNovel}">
			<tr>
				<td colspan="4">등록된 소설이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="dto" items="${listmemberNovel}">
			<tr>
				<td align="right">${dto.nnum}</td>
				<td>
					<a href="writerEpisodeList?nnum=${dto.nnum}">
						${dto.novel_subject}
					</a>
				</td>
				<td align="center">${dto.novel_memberName}</td>
				<td align="center">${dto.novel_recommand}</td>
			</tr>		
			</c:forEach>
		</table>
	</div>
<jsp:include page="../../../main/footer.jsp"/>