<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 작가신청</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="clientUpgrade">
	<div><b><h3 align="center">작가 신청 관리</h3></b></div><br>
	<table border="1" width="1000" height="500">
		<tr height="50">
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
			<td>aaa</td>			<!-- 회원번호,이름,전화번호,작품 다 링크 걸어서 해당 회원페이지로 이동하게 하기 -->
			<td>
				<a href="">수락</a>| <!-- 회원관리 페이지로 넘어가게 하기 -->
				<a href="">거절</a>
			</td>
		</tr>
		<tr>
			<td>002</td>
			<td>이수환</td>
			<td>000-1111-1111</td>
			<td>bbb</td>
			<td>
				<a href="">수락</a>|
				<a href="">거절</a>
			</td>
		</tr>
		<tr>
			<td>003</td>
			<td>김민수</td>
			<td>000-2222-2222</td>
			<td>ccc</td>
			<td>
				<a href="">수락</a>|
				<a href="">거절</a>
			</td>
		</tr>
		<tr>
			<td>004</td>
			<td>여수환</td>
			<td>000-3333-3333</td>
			<td>ddd</td>
			<td>
				<a href="">수락</a>| 
				<a href="">거절</a>
			</td>
		</tr>
		<tr>
			<td colspan="5">총 신청 인원 : 4</td>
	</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>