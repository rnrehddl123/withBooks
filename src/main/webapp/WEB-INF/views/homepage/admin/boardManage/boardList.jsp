<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 게시판 관리</title>
</head>

<%@ include file="../../adminHeader.jsp"%>
		<div class="adminboard">
			<b><h1>게시판 관리</h1></b><p>
			<table border="1" width="1000" height="500">
				<tr bgcolor="green" height="50">
					<th>번호</th>
					<th width="30%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
					<th>삭제</th>
				</tr>
				<tr>
					<td>1</td>
					<td width="30%">aa</td>
					<td>홍길동</td>
					<td>2022.06.08</td>
					<td>11</td>
					<td><input type="button" value="삭제"></td>
				</tr>
			</table>
		</div>	
<%@ include file="../../adminFooter.jsp"%>