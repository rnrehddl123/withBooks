<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>[WithBooks] 공지사항</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>

<div class="noticeList">

	<h3>공지사항</h3>

	<table border="1" width="1000" height="500" align="center">
	<c:if test="${empty listNotice}">
		<tr>
			<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
		</tr>
	</c:if>
    <c:forEach var="ndto" items="${listNotice}">
		<tr>
			<td width="60%">
				<a href="noticeContent?nonum=${ndto.nonum}">
					${ndto.notice_title}
				</a>
			</td>
			<td width="20%">${ndto.notice_reg_date}</td>
			<td width="10%"><input type="button" value="수정" onclick="window.location='noticeUpdate?nonum=${ndto.nonum}'"></td>
			<td width="10%"><input type="button" value="삭제" onclick="window.location='noticeDelete?nonum=${ndto.nonum}'"></td>
		</tr>		
	</c:forEach>	
	</table>
	
	
	검색: <input type="text" name="search"> <input type="button" value="검색">
				<!-- AdminSlideMapper.xml : search -->
	

	<input type="button" value="글쓰기" align="right" onclick="window.location='noticeInsert'">
				<!-- AdminSlideMapper.xml : insert -->
	
</div>

</body>

</html>
<%@include file="../../adminFooter.jsp"%>