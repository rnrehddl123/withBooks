<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../main/header.jsp"/>
		<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
">
<head>
	<title>[withBooks]공지사항</title>
	
	<link href="resources/css/notice.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">

  		<h1>공지사항</h1>
  		
  	</div>
  	<div>
  		<div class="noticeWrapper">
  			<div class="title"><h3>${getNotice.notice_title}</h3></div>
  			<!--<div class="noticeInfo flex">
  				<div class="iconWrapper">
	  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
					관리자
				</div>
				<div class="iconWrapper">	
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
					  <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
					  <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
					</svg>
					${getNotice.notice_readPluscount}
				</div> 
				
				</div> -->
			
  			<div class="content" style="white-space: pre-line" align="left">
  				${getNotice.notice_content}

  			</div>
  			
  			<div class="time" align="center">
					${getNotice.notice_reg_date}
			</div>
					
  			<p>
  			</div>
  			
  			
	  			<div class="btn-group flex" role="group" aria-label="Basic example">
				  <button type="button" class="btn btn-primary" onclick="window.location='NlistNotice'">공지사항 목록</button>
				</div>
  		
  	</div>
</body>
 <jsp:include page="../main/footer.jsp"/>











