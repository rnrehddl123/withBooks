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
<div class="cateList">
	<b><h3>ī�װ� ���</h3></b>
	<table border="1" width="1000" height="500">
		<tr>
			<th>ī�װ� ��ȣ</th>
			<th>ī�װ� �̸�</th>
		</tr>
		<tr>
			<td>001</td>
			<td>ȣ��</td>
		</tr>
		<tr>
			<td>002</td>
			<td>�θǽ�</td>
		<tr>
			<td>003</td>
			<td>��Ÿ��</td>
		</tr>
		<tr>
			<td>004</td>
			<td>�߸�</td>
		</tr>
	</table>
	
	<p>
	
		<input type="button" value="ī�װ� �߰�" onclick="window.location='cateInsert'">
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>