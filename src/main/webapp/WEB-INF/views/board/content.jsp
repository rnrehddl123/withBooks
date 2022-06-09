<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- content.jsp -->
<html>
<head>
	<title>글내용보기</title>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div align="center">
		<b>글내용 보기</b><p>
		<table border="1" width="800">
			<tr>
				<th bgcolor="yellow" width="20%">글번호</th>
				
				<th bgcolor="yellow" width="20%">조회수</th>
				
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">작성자</th>
				
				<th bgcolor="yellow" width="20%">작성일</th>
				
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글제목</th>
				
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글내용</th>
				
			</tr>
			<tr bgcolor="yellow">
				<td colspan="4" align="right">
					<input type="button" value="글수정">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="글삭제">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="글목록">
				</td>
			</tr>
		</table>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>










