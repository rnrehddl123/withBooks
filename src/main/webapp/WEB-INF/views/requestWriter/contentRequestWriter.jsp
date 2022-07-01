<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- content.jsp -->
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
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
  			<div class="title"><h3 align="center">${getRequestWriter.request_subject}</h3></div>
  			<div class="boardInfo flex">
				<div class="time">
					${getRequestWriter.request_reg_date}
				</div>
			</div>
  			<div class="contant">
  				${getRequestWriter.request_content}
  			</div>
	  			
  		</div>
  		<div class="btn-group flex" role="group" aria-label="Basic example">
				  <button type="button" class="btn btn-primary" onclick="window.location='updateRequestWriter?Rwnum=${getRequestWriter.rwnum}'">글수정</button>
				  <button type="button" class="btn btn-primary" onclick="window.location='listRequestWriter'">글목록</button>
		</div>
  	</div>
</body>
</html>










