<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<html>
<head>  
	<title>�Խ��� ���</title>
</head>
<body>
<%@ include file="../main/header.jsp"%>
	<div align="center">
		<b>�Խ��� ���</b>
		<table border="1" width="800">
			<tr bgcolor="yellow">
				<td colspan="6" align="right"><a href="write_board.do">�Խ��� �� �ۼ�</a></td>			
			</tr>
			<tr bgcolor="green">
				<th>��ȣ</th>
				<th width="30%">����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ</th>
			</tr>
		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="6">��ϵ� �Խñ��� �����ϴ�.</td>
			</tr>
		</c:if>			
		<c:forEach var="dto" items="${listBoard}">
			<tr>
				<td align="right">${dto.num}</td>
				<td>
					<a href="content_board.do?num=${dto.num}">
						${dto.subject}
					</a>
				</td>
				<td align="center">${dto.writer}</td>
				<td align="center">${dto.reg_date}</td>
				<td align="center">${dto.readcount}</td>
			</tr>		
			</c:forEach>				
		</table>
	</div>
	<%@ include file="../main/footer.jsp"%>
</body>
</html>