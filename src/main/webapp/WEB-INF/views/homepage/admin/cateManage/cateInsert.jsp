<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[WithBooks] 카테고리 입력</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="insertCate">
		<b><h1>카테고리 추가</h1></b><p>
		<form name="f" action="insertCate" method="post">
		<table border="1" width="500" height="200">
			<tr>
				<th width="30%">카테고리 이름</th>
				<td width="70%"><input type="text" name="cate_name" class="box"></td>
			</tr>
			<tr height="50">
				<td align="center" colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
		</form>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>