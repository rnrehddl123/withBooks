<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- saleManage.jsp -->
<html>
<head>  
	<title>saleManage.jsp</title>
</head>
<body>
	<div align="center">
		<font align="center">�� �� �� �� �� ��</font><br>
		<table border="1" width="800">
			<td align="center"><font size="50">���� ���� ��Ʈ(�Ŀ� �����)</font></td>
		</table>
		<table border="1" width="800">
			<tr bgcolor="green">
				<th>��ȣ</th>
				<th>���̵�</th>
				<th>ī�װ���</th>
				<th>��ǰ�̸�</th>
				<th>����</th>
				<th>����</th>
				<th>�Ѿ�</th>
				<th>���ų�¥</th>
			</tr>
		<c:if test="${empty listSale}">
			<tr>
				<td colspan="8">�Ǹŵ� ��ǰ�� �����ϴ�.</td>
			</tr>
		</c:if>			
		<c:forEach var="dto" items="${listSale}">
			<tr>
				<td align="right">${dto.num}</td>
				<td>${dto.id}</td>
				<td align="center">${dto.category}</td>
				<td align="center">${dto.productName}</td>
				<td align="center">${dto.qty}</td>
				<td align="center">${dto.price}</td>
				<td align="center">${dto.totalPrice}</td>
				<td align="center">${dto.sysdate}</td>
			</tr>		
			</c:forEach>				
		</table>
	</div>
</body>
</html>