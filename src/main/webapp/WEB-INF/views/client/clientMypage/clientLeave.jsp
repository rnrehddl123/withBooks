<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- clientDelete.jsp -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>ȸ �� Ż ��</title>
</head>
<body>
	<div align="center">
		<form name="leaveMember" action="leaveMember" method="POST">
		<input type="hidden" name="mnum" value="1">
		<table width="600" heigth="600">
			<tr>
				<td align="center"><font color="blue" size="20px">WithBooks Ż��</font></td>
			</tr>
			<tr height="50"></tr><!-- ���� -->
			<tr>
				<td align="center">WithBooks Ż�� �Ͻø� ��� ȸ�������� �����Ǹ� �����Ͻ� �� �����ϴ�.<br>
					������ Ż�� ���ϽŴٸ� �Ʒ��� ��й�ȣ�� �Է��Ͻð� Ż���ϱ� ��ư�� �����ּ���.</td>
			</tr>
			<tr height="50"></tr><!-- ���� -->
			<tr>
				<td align="center">��й�ȣ : <input type="password" name="Member_passwd" value=""></td>
			</tr>
			<tr height="30"></tr><!-- ���� -->
			<tr>
				<td align="center"><input type="submit" value="Ż���ϱ�"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>