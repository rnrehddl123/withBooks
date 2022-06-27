<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- content.jsp -->
<html>
<jsp:include page="../main/header.jsp"/>
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
  			<div class="title">
  				<div>${getBoard.board_subject}</div>
  			</div>
  			<div class="boardInfo flex">
  				<div class="iconWrapper">
	  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
					<div>${getBoard.board_writer}</div>
				</div>
				<div class="iconWrapper">	
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
					  <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
					  <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
					</svg>
					<div>${getBoard.board_readcount}</div>
				</div>
				<div class="time">
					${getBoard.board_date}
				</div>
			</div>
  			<div class="contant" style="white-space: pre-line">
  				${getBoard.board_content}
  			</div>
	  			<div class="btn-group flex" role="group" aria-label="Basic example">
				  <button type="button" class="btn btn-primary" onclick="window.location='updateBoard?Bnum=${getBoard.bnum}'">글수정</button>
				  <button type="button" class="btn btn-primary" onclick="window.location='deleteBoard.do?Bnum=${getBoard.bnum}'">글삭제</button>
				  <button type="button" class="btn btn-primary" onclick="window.location='listBoard'">글목록</button>
				</div>
  			</div>
  	</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>