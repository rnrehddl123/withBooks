<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>������-��������</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>

<div class="noticeList">

	<h3>��������</h3>

	<table border="1" width="1000" height="500" align="center">
			<!-- ����/�ȳ� select-option -->
		<tr>
			<td>
				<a href="">[����]��û �� ����---------------------------------</a>
				<p>
				sysdate
			</td>
			<td>
				<input type="button" value="����" onclick="window.location='noticeUpdate'">
			</td>
			<td>
				<input type="button" value="����">
			</td>
		</tr>
		
		<tr>
			<td>
			<a href="">[�ȳ�]��������2</a>
			<p>
			2022.03.01
			</td>
			<td>
			<input type="button" value="����" onclick="window.location='noticeUpdate'">
			</td>
			<td>
			<input type="button" value="����">
			</td>
		</tr>
		
		<tr>
			<td>
			[����/�ȳ�]�������� List
			<p>
			2022.02.01
			</td>
			<td>
			<input type="button" value="����" onclick="window.location='noticeUpdate'">
			</td>
			<td>
			<input type="button" value="����">
			</td>
		</tr>
		
	</table>
	
	
	�˻�: <input type="text" name="search"> <input type="button" value="�˻�">
	

	<input type="button" value="�۾���" align="right" onclick="window.location='noticeInsert'">
	
</div>

</body>

</html>
<%@include file="../../adminFooter.jsp"%>