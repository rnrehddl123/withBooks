<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- clientDelete.jsp -->
<jsp:include page="../../main/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>ȸ �� Ż ��</title>
</head>
<script type="text/javascript">
		function check(){
			var loginPasswd = "${session.Member_passwd}"
			
			if (leave.Member_passwd.value == null || leave._passwd.value.trim().equals("")){
					alert("��й�ȣ�� �Է��� �ּ���.")
					leave.Member_passwd.focus()
					return false
			}else if (leave.Member_passwd.value != loginPasswd){
					alert("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���.")
					leave.Member_passwd.focus()
					return false
			}else{
				if (leave.Member_passwd.value == loginPasswd)document.leave.submit()
			}
		}
	</script>
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
					������ Ż�� ���ϽŴٸ� �Ʒ��� ��й�ȣ�� �Է��Ͻð� ȸ��Ż�� ��ư�� �����ּ���.</td>
			</tr>
			<tr height="50"></tr><!-- ���� -->
			<tr>
				<td align="center">��й�ȣ : <input type="password" name="Member_passwd"></td>
			</tr>
			<tr height="30"></tr><!-- ���� -->
			<tr>
				<td align="center"><input type="submit" name="leave" value="ȸ��Ż��"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>