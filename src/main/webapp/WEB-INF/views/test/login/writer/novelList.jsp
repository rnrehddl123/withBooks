<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- novelList.JSP -->
<html>
<head>
	<title>������ �Ҽ� ���</title>
</head>
<body>
	<div align="center">
		<b> ���� �� �Ҽ� ���</b>
		<table border="1" width="800">
			<tr bgcolor="#">
				<td colspan="7" align="right"><a href="#">���ο� �Ҽ� ����</a></td>
			</tr>
			<tr bgcolor="#">
				<th>��ȣ</th>
				<th>�Ҽ�(�ø���) ����</th>
				<th>ȭ ����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ��</th>
				<th>����/����</th>
			</tr>
			<c:if test="${empty #}">
			<tr>
				<td colspan="7">��ϵ� �Ҽ��� �����ϴ�.</td>
			</tr>
		</c:if>
		<c:forEach var="#" items="${#}">
			<tr>
				<td align="right">${#.#}</td>
				<td>
					<a href="#?#=${#.#}">
						${#.#}
					</a>
				</td>
				<td align="center">${#.#}</td>
				<td align="center">${#.#}</td>
				<td align="center">${#.#}</td>
				<td align="center">${#.#}</td>
				<td align="center">${#.#}</td>
				<td align="center">${#.#}</td>
				<td align="center">${#.#}</td>
			</tr>		
			</c:forEach>
		</table>
	</div>
</body>
</html>