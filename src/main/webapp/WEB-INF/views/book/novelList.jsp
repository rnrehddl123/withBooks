<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Ҽ����</title>
</head>
<body>
<div align="center">
	<table width="600">
		<caption>�Ҽ����</caption>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�۰�</th>
			<th>����</th>
			<th>ī�װ�</th>
			<th>�ٰŸ�</th>
		</tr>
	<c:if test="${empty novelList}">
		<tr>
			<td colspan="6">�Ҽ��� �����ϴ�.</td>
		</tr>
	</c:if>
	<c:forEach items="${novelList}" var="nL">
		<tr>		
			<td>${nL.nnum}</td>
			<td>${nL.novel_subject}</td>
			<td>${nL.novel_writername}</td>
			<td><img src="" width="" height=""></td>
			<td>${nL.novel_cate}</td>
			<td>${nL.novel_summary}</td>
		</tr>				
	</c:forEach>
	</table>
</div>
</body>
</html>