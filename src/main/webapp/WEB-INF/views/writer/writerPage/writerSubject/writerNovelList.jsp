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
	<div align="center">
		<b>${getMember.member_name}님의 소설</b>
		<table align="center" class="writer">
			<tr>
				<td colspan="5" align="right"><a href="writerNovel">새로운 소설 쓰기</a></td>
			</tr>
			<tr>
				<td align="center">번호</td>
				<td align="center">소설제목</td>
				<td align="center">작성자</td>
				<td align="center">수정 | 삭제</td>
			</tr>
			<c:set var="pageNum" value="${novelNum}"/>
			<c:if test="${empty listmemberNovel}">
			<tr>
				<td colspan="5">등록된 소설이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="dto" items="${listmemberNovel}">
			<tr>
				<td align="center"><c:out value="${pageNum}"/></td>
				<c:set var="pageNum" value="${pageNum-1}"/>
				<td>
					<a href="writerEpisodeList?nnum=${dto.NNUM}&change=now">
						${dto.NOVEL_SUBJECT}
					</a>
				</td>
				<td align="center">${dto.NOVEL_MEMBERNAME}</td>
				<td align="center"><a href="writerNovelUpdate?nnum=${dto.NNUM}&mnum=${getMember.mnum}">수정</a> | <a href="writerNoveldelete?nnum=${dto.NNUM}&mnum=${getMember.mnum}">삭제</a></td>
			</tr>		
			</c:forEach>
		</table>
	</div>
<jsp:include page="../../../main/footer.jsp"/>