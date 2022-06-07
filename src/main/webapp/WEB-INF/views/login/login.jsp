<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
	<div align="center">
		<b><h3>로그인</h3></b>
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" size="50"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="id" size="50"></td>
			</tr>	
			<tr>
				<td>
				<input type="checkbox" name="login">
				로그인 상태 유지
				</td>
				<td>아이디 찾기|비밀번호 재설정</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="로그인"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="회원가입"></td>
			</tr>		
		</table>
	</div>
</body>
</html>