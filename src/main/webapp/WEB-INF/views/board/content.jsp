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
	<div align="center">
		<hr color="green">
  		<h1>[ 자유 게시판 ]</h1>
  		<hr color="green">
  		
  	</div>
  	<div>
  		<table border="3" width="50%" height="60%">
  		
			<tr>
				<th width="20%">글번호</th>
				<td align="left" width="30%">${getBoard.bnum}</td>
			</tr>
			<tr>
				<th width="20%">조회수</th>
				<td align="left" width="30%">${getBoard.board_readcount}</td>
			</tr>
			<tr>
				<th width="20%">작성자</th>
				<td align="left" width="30%">${getBoard.board_writer}</td>
			</tr>
			<tr>
				<th width="20%">작성일</th>
				<td align="left" width="30%">${getBoard.board_date}</td>
			</tr>
			<tr>
				<th width="20%">글제목</th>
				<td width="80%" colspan="3">${getBoard.board_subject}</td>
			</tr>
			<tr>
				<th width="20%">글내용</th>
				<td width="80%" colspan="3">${getBoard.board_content}</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="글수정"
					onclick="window.location='updateBoard?Bnum=${getBoard.bnum}'">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="글삭제" 
					onclick="window.location='deleteBoard.do?Bnum=${getBoard.bnum}'">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="글목록" onclick="window.location='listBoard'">
				</td>
			</tr>
		</table>
  	</div>
</body>
</html>










