<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
<title>[WithBooks] 공지사항 수정</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="updateNotice">
	<form name="f" action="updateNotice" method="post">
	<input type="hidden" name="nonum" value="${getNotice.nonum}"/>
		<table border="1" width="1000" height="500">
				<tr>
					<td colspan="2" align="center">공지사항 수정</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td>
						<input type="text" name="notice_title" size="40" value="${getNotice.notice_title}">
					</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea name="notice_content" rows="11" cols="50">${getNotice.notice_content}</textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="등록하기">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" onclick="window.location='listNotice'">
					</td>
				</tr>
		</table>
	</form>
</div>
</body>

</html>
<%@include file="../../adminFooter.jsp"%>