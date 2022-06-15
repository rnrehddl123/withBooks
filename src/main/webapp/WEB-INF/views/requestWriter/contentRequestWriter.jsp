<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- content.jsp -->
<html>
<jsp:include page="requestWriterSidebar.jsp"/>
		<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
">
<head>
	<title>내용보기</title>
</head>
<body>
	<div align="center">
		<hr color="green">
  		<h1>[ 신청서 ]</h1>
  		<hr color="green">
  		
  	</div>
  	<div>
  		<div class="boardWrapper">
  			<div class="title">${getRequestWriter.requestWriter_subject}</div>
  			<div class="boardInfo flex">
  				<div class="iconWrapper">
	  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
					${getRequestWriter.requestWriter_writer}
				</div>
				<div class="time">
					${getRequestWriter.requestWriter_date}
				</div>
			</div>
  			<div class="contant">
  				${getRequestWriter.requestWriter_content}
  			</div>
	  			<div class="btn-group flex" role="group" aria-label="Basic example">
				  <button type="button" class="btn btn-primary" onclick="window.location='updateRequestWriter?Rwnum=${getRequestWriter.rwnum}'">글수정</button>
				  <button type="button" class="btn btn-primary" onclick="window.location='listRequestWriter'">글목록</button>
				</div>
  		</div>
  	</div>
</body>
</html>










