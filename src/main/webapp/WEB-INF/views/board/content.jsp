<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- content.jsp -->
<html>
<jsp:include page="boardSidebar.jsp"/>
		<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
">
<head>
	<title>글내용보기</title>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div align="center">
  		<b>내가 쓴 글</b><p>
  		<table border="1" width="800">
			<tr>
				<th bgcolor="yellow" width="20%">글번호</th>
				<td align="center" width="30%">${getBoard.Bnum}</td>
				<th bgcolor="yellow" width="20%">조회수</th>
				<td align="center" width="30%">${getBoard.Board_readcount}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">작성자</th>
				<td align="center" width="30%">${getBoard.Board_writer}</td>
				<th bgcolor="yellow" width="20%">작성일</th>
				<td align="center" width="30%">${getBoard.Board_reg_date}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글제목</th>
				<td width="80%" colspan="3">${getBoard.Board_subject}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글내용</th>
				<td width="80%" colspan="3">${getBoard.Board_content}</td>
			</tr>
			<tr bgcolor="yellow">
				<td colspan="4" align="right">
					<input type="button" value="글수정"
					onclick="window.location='updateBoard?Bnum=${getBoard.Bnum}'">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="글삭제" 
					onclick="window.location='deleteBoard.do?Bnum=${getBoard.Bnum}'">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="글목록" onclick="window.location='listBoard'">
				</td>
			</tr>
		</table>
  	</div>
  	
<jsp:include page="../main/footer.jsp"/>
</body>
</html>










