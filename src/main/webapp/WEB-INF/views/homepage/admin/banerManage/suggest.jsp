<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%@ include file="../../adminHeader.jsp"%>
<body>
<div class="suggest">
	<b><h1>��õ�� ����</h1></b><p>
	<table border="1" width="1000" height="300">
		<tr height="50">
			<td>��õ ��ǰ ����Ʈ</td>	
			<td>����</td> 
		</tr>
		<tr>
			<td>�߸��Ҽ� aaa</td> <!-- AdminSuggestMapper.xml : listNovel -->
			<td><input type="button" value="����"></td> <!-- AdminSuggestMapper.xml : insert -->
		</tr>	
	</table>
	�˻� : <input type="text"><input type="button" value="�˻�"><p>
	 <!-- AdminSuggestMapper.xml : searchAdminSuggest -->
	 
	<table border="1" width="1000" height="300">
		<tr>
			<td>���� ����Ʈ</td>
			<td>����</td> 
		</tr>
		<tr>
			<td>�߸��Ҽ� aaa</td> <!-- AdminSuggestMapper.xml : listAdminSuggest -->
			<td><input type="button" value="����"></td> <!-- AdminSuggestMapper.xml : delete -->
		</tr>	
	</table>
	<input type="button" value="���">
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>