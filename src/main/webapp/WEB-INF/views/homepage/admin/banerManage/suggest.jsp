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
		<tr height="50" align="center">
			<th colspan="2" >��õ ��ǰ ����Ʈ</th>	
		</tr>
		<tr>
			<td>�߸��Ҽ� aaa</td> <!-- AdminSuggestMapper.xml : listNovel -->
			<td><input type="button" value="����"></td> <!-- AdminSuggestMapper.xml : insert -->
		</tr>	
	</table>
	�˻� : <input type="text"><input type="button" value="�˻�"><p>
	 <!-- AdminSuggestMapper.xml : searchAdminSuggest -->
	 
	<table border="1" width="1000" height="300">
		<tr align="center">
			<th colspan="2">���� ����Ʈ</th>
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