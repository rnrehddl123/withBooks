<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="cateUpdate">
		<b><h1>카테고리 수정</h1></b><p>
		<table border="1" width="1000" height="500">
			<tr>
				<th width="30%">카테고리 이름</th>
				<td width="70%"><input type="text" name="cname" class="box"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>