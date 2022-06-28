<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerNovelList.JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>내가쓴 소설 목록</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div class="margintop" align="center">
		<b>${getMember.member_name}님의 소설</b>
		<table align="center" class="table novel">
			<thead>
			<tr>
				<td colspan="5" align="right"><a href="writerNovel"><button type="button" class="btn btn-light">새로운 소설 쓰기</button></a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>소설제목</th>
				<th>작성자</th>
				<th>수정</th>
			</tr>
			</thead>
			<c:set var="pageNum" value="${novelNum}"/>
			<c:if test="${empty listmemberNovel}">
			<tr>
				<td colspan="5">등록된 소설이 없습니다.</td>
			</tr>
			</c:if>
			<tbody>
			<c:forEach var="dto" items="${listmemberNovel}">
			<tr>
				<td align="center"><c:out value="${pageNum}"/></td>
				<c:set var="pageNum" value="${pageNum-1}"/>
				<td align="center">
					<a class="a" href="writerEpisodeList?nnum=${dto.NNUM}">
						${dto.NOVEL_SUBJECT}
					</a>
				</td>
				<td align="center">${dto.NOVEL_MEMBERNAME}</td>
				<td align="center"><a href="writerNovelUpdate?nnum=${dto.NNUM}&mnum=${getMember.mnum}"><button type="button" class="btn btn-light">수정</button></a></td>
			</tr>		
			</c:forEach>
			</tbody>
		</table>
	</div>
<jsp:include page="../../../main/footer.jsp"/>