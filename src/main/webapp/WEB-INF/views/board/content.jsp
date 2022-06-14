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
  		<div class="boardWrapper">
  			<div class="title">${getBoard.board_subject}</div>
  			<div class="boardInfo flex">
  				<div class="iconWrapper">
	  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
					${getBoard.board_writer}
				</div>
				<div class="iconWrapper">	
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
					  <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
					  <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
					</svg>
					${getBoard.board_readcount}
				</div>
				<div class="time">
					${getBoard.board_date}
				</div>
			</div>
  			<div class="contant">
  				${getBoard.board_content}
  			</div>
	  			<div class="btn-group flex" role="group" aria-label="Basic example">
				  <button type="button" class="btn btn-primary" onclick="window.location='updateBoard?Bnum=${getBoard.bnum}'">글수정</button>
				  <button type="button" class="btn btn-primary" onclick="window.location='deleteBoard.do?Bnum=${getBoard.bnum}'">글삭제</button>
				  <button type="button" class="btn btn-primary" onclick="window.location='listBoard'">글목록</button>
				</div>
  		</div>
  		
  	
  	
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










