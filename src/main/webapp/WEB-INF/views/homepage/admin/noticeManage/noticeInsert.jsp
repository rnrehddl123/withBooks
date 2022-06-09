<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!-- notice.jsp의 글쓰기와 연결되는 jsp파일 -->
<html>
<head>
<title>공지사항 글쓰기</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="noticeInsert">
	<form name="f" action="#" method="post">
		<table border="1" width="500">
				<tr>
					<td colspan="2" align="center">공지사항 작성</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td>
						<select name="notice">
							<option value="gongji">공지
							<option value="annae">안내
						</select>
						
						<input type="text" name="subject" size="40">
					</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea name="content" rows="11" cols="50"></textarea></td>
				</tr>
				<tr>
					<th>관리자 암호</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="글쓰기">
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