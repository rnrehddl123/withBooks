<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- clientDelete.jsp -->
<jsp:include page="../../main/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>회 원 탈 퇴</title>
</head>
<script type="text/javascript">
		function check(){
			var loginPasswd = "${session.Member_passwd}"
			
			if (leave.Member_passwd.value == null || leave._passwd.value.trim().equals("")){
					alert("비밀번호를 입력해 주세요.")
					leave.Member_passwd.focus()
					return false
			}else if (leave.Member_passwd.value != loginPasswd){
					alert("비밀번호가 틀렸습니다. 다시 입력해 주세요.")
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
				<td align="center"><font color="blue" size="20px">WithBooks 탈퇴</font></td>
			</tr>
			<tr height="50"></tr><!-- 공백 -->
			<tr>
				<td align="center">WithBooks 탈퇴를 하시면 모든 회원정보가 삭제되며 복구하실 수 없습니다.<br>
					정말로 탈퇴를 원하신다면 아래에 비밀번호를 입력하시고 회원탈퇴 버튼을 눌러주세요.</td>
			</tr>
			<tr height="50"></tr><!-- 공백 -->
			<tr>
				<td align="center">비밀번호 : <input type="password" name="Member_passwd"></td>
			</tr>
			<tr height="30"></tr><!-- 공백 -->
			<tr>
				<td align="center"><input type="submit" name="leave" value="회원탈퇴"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>