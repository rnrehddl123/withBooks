<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientUpdate -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>clientUpdate</title>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
			<font size="3">개 인 정 보 수 정</font><p>
			<form name="f" action="clientUpdate" method="post" onsubmit="return check()">					
			<input type="hidden" name="mnum" value="${login.mnum}"/>
			
			<table border="1" align="center" class="writerUpdate">
  				<tr>
					<td colspan="2" align=center class="m2">회원수정</td>
 				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="Member_name" class="box" value="${login.member_name}" readOnly>
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">아이디</td>
					<td class="m3">
						<input type="text" name="Member_id" class="box" value="${login.member_id}" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">비밀번호</td>
					<td class="m3">
						<input type="password" name="Member_passwd" class="box" value="${login.member_passwd}">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">이메일</td>
					<td class="m3">
						<input type="text" name="Member_email" class="box" value="${login.member_email}">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">전화번호</td>
					<td class="m3">
						<input type="text" name="member_tel1" class="box" size="3" maxlength="3" value="${login.member_tel1}"> -
						<input type="text" name="member_tel2" class="box" size="4" maxlength="4" value="${login.member_tel2}"> -
						<input type="text" name="member_tel3" class="box" size="4" maxlength="4" value="${login.member_tel3}">
					</td>
  				</tr>
  				<tr>
  					<td width="150" class="m3">주소</td>
					<td class="m3">
						<input type="text" name="Member_address" class="box" value="${login.member_address}">
					</td>
  				</tr>
  				<tr>
  					<td width="150" class="m3">출생년도</td>
					<td class="m3">
						<input type="text" name="Member_birth" class="box" value="${login.member_birth}">
					</td>
  				</tr>
  				<tr>
  					<td colspan="2"><input type="checkbox" name="Member_sex" value="${login.member_sex}">남&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  					<input type="checkbox" name="Member_sex" value="${login.member_sex}">여</td>
  				</tr>
  				<tr>
  					<td>취향</td>
  					<td><input type="checkbox" name="preffered1" value="${login.member_preffered1}">판타지</td>
  				<tr>
					<td colspan="2" align="center">
						[수정][취소]
					</td>
  				</tr>
  				
  			</table>
  			</form>
	</div>
<jsp:include page="../../main/footer.jsp"/>