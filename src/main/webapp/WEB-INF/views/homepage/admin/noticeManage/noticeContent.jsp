<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- notice.jsp의 글쓰기와 연결되는 jsp파일 -->
<html>
<head>
<title>[WithBooks] 공지사항 글쓰기</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="contentNotice">
	<form name="f" action="insertNotice" method="post">
		<table border="1" width="500" width="1000" height="500">
				<tr>
					<td colspan="2" align="center">공지사항 보기</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td>
						<input type="text" name="notice_title" size="40" value="${getNotice.notice_title}" readOnly>
					</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea name="notice_content" rows="11" cols="50" readOnly>${getNotice.notice_content}</textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="button" value="수정" onclick="window.location='updateNotice?nonum=${getNotice.nonum}'">
						<input type="button" value="삭제" onclick="window.location='deleteNotice?nonum=${getNotice.nonum}'">
						<input type="button" value="목록보기" onclick="window.location='listNotice'">
					</td>
				</tr>
		</table>
	</form>
</div>
</body>

</html>
<%@include file="../../adminFooter.jsp"%>