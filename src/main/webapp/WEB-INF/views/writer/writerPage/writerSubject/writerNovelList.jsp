<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerNovelList.JSP -->
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>내가쓴 소설 목록</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<b> 내가 쓴 소설 목록</b>
		<table align="center" class="writer">
			<tr>
				<td colspan="5" align="right"><a href="#">새로운 소설 쓰기</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>소설(시리즈)제목(writerEpisodeList로)</th>
				<th>작성자</th>
				<th>추천수</th>
				<th>수정 | 삭제</th>
			</tr>
			<c:if test="${empty listNovel}">
			<tr>
				<td colspan="5">등록된 소설이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="dto" items="${listNovel}">
			<tr>
				<td align="right">${dto.nnum}</td>
				<td>
					<a href="writerNovelEpisodeList?Epnum=${dto.nnum}">
						${dto.Novel_subject}
					</a>
				</td>
				<td align="center">${dto.Novel_memberName}</td>
				<td align="center">${dto.Novel_recommand}</td>
				<td align="center"><a href="update_Novel?nnum=${dto.nnum}">수정</a> | <a href="delete_Novel?nnum=${dto.nnum}">삭제</a></td>
			</tr>		
			</c:forEach>
		</table>
	</div>
<jsp:include page="../../../main/footer.jsp"/>