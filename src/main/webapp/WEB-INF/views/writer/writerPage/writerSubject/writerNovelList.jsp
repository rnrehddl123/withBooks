<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writerNovelList.JSP -->
<html>
<head>
	<title>������ �Ҽ� ���</title>
</head>
<body>
	<div align="center">
		<b> ���� �� �Ҽ� ���</b>
		<table border="1" width="800">
			<tr>
				<td colspan="6" align="right"><a href="#">���ο� �Ҽ� ����</a></td>
			</tr>
			<tr>
				<th>��ȣ</th>
				<th>�Ҽ�(�ø���)����(writerEpisodeList��)</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ��</th>
				<th>����(NovelUpdate)/����</th>
			</tr>
			<c:if test="">
			<tr>
				<td colspan="7">��ϵ� �Ҽ��� �����ϴ�.</td>
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