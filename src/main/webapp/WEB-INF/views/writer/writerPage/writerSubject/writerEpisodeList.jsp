<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writerNovelList.JSP -->
<html>
<head>
	<title>������, ���Ǽҵ� ���</title>
</head>
<body>
	<div align="center">
		<b> (�� �� �� ��) ���Ǽҵ� ���</b>
		<table border="1" width="800">
			<tr>
				<td colspan="5" align="right"><a href="#">���ο� ���Ǽҵ� ����</a></td>
			</tr>
			<tr>
				<th>��ȣ</th>
				<th>���Ǽҵ� ����</th>
				<th>�ۼ���</th>
				<th>��ȸ��</th>
				<th>����(EpisodeUpdate)��/����</th>
			</tr>
			<c:if test="">
			<tr>
				<td colspan="5">��ϵ� �Ҽ��� �����ϴ�.</td>
			</tr>
		</c:if>
		<c:forEach var="#" items="">
			<tr>
				<td align="right"></td>
				<td>
					<a href="#?#=">
						
					</a>
				</td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
			</tr>		
			</c:forEach>
		</table>
	</div>
</body>
</html>