<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="clientUpgrade">
	<div>작가 신청 관리</div><br>
	<table border="1">
		<tr>
			<th>회원 번호</th>
			<th>회원 이름</th>
			<th>전화번호</th>
			<th>작품</th>
			<th>수락|거절</th>
		</tr>
		<tr>
			<td>001</td>
			<td>이제동</td>
			<td>000-0000-0000</td>
			<td>aaa</td>
			<td>수락|거절</td>
		</tr>
		<tr>
			<td>002</td>
			<td>이수환</td>
			<td>000-1111-1111</td>
			<td>bbb</td>
			<td>수락|거절</td>
		</tr>
		<tr>
			<td>003</td>
			<td>김민수</td>
			<td>000-2222-2222</td>
			<td>ccc</td>
			<td>수락|거절</td>
		</tr>
		<tr>
			<td>004</td>
			<td>여수환</td>
			<td>000-3333-3333</td>
			<td>ddd</td>
			<td>수락|거절</td>
		</tr>
		<tr>
			<td colspan="5">총 신청 인원 : 4</td>
	</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>