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
		<b><h1>ī�װ� ����</h1></b><p>
		<table border="1" width="1000" height="500">
			<tr>
				<th width="30%">ī�װ� �̸�</th>
				<td width="70%"><input type="text" name="cname" class="box"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="����">
					<input type="reset" value="���">
				</td>
			</tr>
		</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>