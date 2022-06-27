<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 작가신청</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div align="center">
		<hr color="green">
  		<h1>[ 신청서 ]</h1>
  		<hr color="green">	
</div>
<div>
	<table border="1" width="1000" height="500">
		<tr>
			<th>제목</th>
			<td>${getRequestWriter.request_subject}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${getRequestWriter.request_writer}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${getRequestWriter.request_reg_date}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${getRequestWriter.request_content}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-primary" onclick="window.location='upgradeClientOk?mnum=${getRequestWriter.memberDTO.mnum}&state=accept&rwnum=${getRequestWriter.rwnum}'">수락</button>
				<button type="button" class="btn btn-primary" onclick="window.location='upgradeClientRefuse?rwnum=${getRequestWriter.rwnum}&state=refuse'">거절</button>
				<button type="button" class="btn btn-primary" onclick="window.location='listUpgradeClient'">글목록</button>
			</td>	  
		</tr>
	</table>
</div>	
</body>
</html>
<%@include file="../../adminFooter.jsp"%>