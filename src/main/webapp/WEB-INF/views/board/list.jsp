<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<html>
<head>  
	<title>게시판 목록</title>
</head>
<body>
<%@ include file="../main/header.jsp"%>
	<div align="center">
		<b>게시판 목록</b>
		<table border="1" width="800">
			<tr bgcolor="yellow">
				<td colspan="6" align="right"><a href="write_board.do">게시판 글 작성</a></td>			
			</tr>
			<tr bgcolor="green">
				<th>번호</th>
				<th width="30%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="6">등록된 게시글이 없습니다.</td>
			</tr>
		</c:if>			
		<c:forEach var="dto" items="${listBoard}">
			<tr>
				<td align="right">${dto.num}</td>
				<td>
					<a href="content_board.do?num=${dto.num}">
						${dto.subject}
					</a>
				</td>
				<td align="center">${dto.writer}</td>
				<td align="center">${dto.reg_date}</td>
				<td align="center">${dto.readcount}</td>
			</tr>		
			</c:forEach>				
		</table>
	</div>
	<%@ include file="../main/footer.jsp"%>
</body>
</html>