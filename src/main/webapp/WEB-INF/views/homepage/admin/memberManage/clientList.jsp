<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="clientList">
	<p>
	<b><h3 align="center">회원 관리</h3></b>
	<table border="1" width="1000" height="500">
		<tr height="50">
			<th>회원 번호</th>
			<th>회원 이름</th>
			<th>전화번호</th>
			<th>권한</th>
			<th>계정삭제</th>
		</tr>
		<tr>
			<td>001</td>
			<td>이제동</td>
			<td>000-0000-0000</td>
			<td>일반회원</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
		<tr>
			<td>002</td>
			<td>이수환</td>
			<td>000-1111-1111</td>
			<td>일반회원</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
		<tr>
			<td>003</td>
			<td>김민수</td>
			<td>000-2222-2222</td>
			<td>일반회원</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
		<tr>
			<td>004</td>
			<td>여수환</td>
			<td>000-3333-3333</td>
			<td>일반회원</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
	</table>
	
	<p>
	
	<b><h3 align="center">작가 관리</h3></b>
	<table border="1" width="1000" height="500">
		<tr height="50"> 
			<th>작가 번호</th>
			<th>작가 이름</th>
			<th>전화번호</th>
			<th>작품</th>
			<th>계정삭제</th>
		</tr>
		<tr>
			<td>001</td>
			<td><a href="writerNovelList">이제동</a></td>
			<td>000-0000-0000</td>
			<td>aaa</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
		<tr>
			<td>002</td>
			<td><a href="writerNovelList">이수환</a></td>
			<td>000-1111-1111</td>
			<td>bbb</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
		<tr>
			<td>003</td>
			<td><a href="writerNovelList">김민수</a></td>
			<td>000-2222-2222</td>
			<td>ccc</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
		<tr>
			<td>004</td>
			<td><a href="writerNovelList">여수환</a></td>
			<td>000-3333-3333</td>
			<td>ddd</td>
			<td><input type="button" value="계정삭제"></td>
		</tr>
	</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>