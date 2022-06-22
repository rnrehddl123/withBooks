<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- notice.jsp의 글쓰기와 연결되는 jsp파일 -->
<html>
<head>
<title>[WithBooks] 공지사항 글쓰기</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="insertNotice">
	<form name="f" action="insertNotice" method="post">
		<table border="1" width="500" width="1000" height="500">
				<tr>
					<td colspan="2" align="center">공지사항 작성</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td>
						<input type="text" name="notice_title" size="40">
					</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea name="notice_content" rows="11" cols="50"></textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기">
					</td>
				</tr>
		</table>
	</form>
</div>
</body>

</html>
<%@include file="../../adminFooter.jsp"%>