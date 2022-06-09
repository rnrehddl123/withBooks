<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerUpdate -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
			<font size="3">개 인 정 보 수 정</font><p>
			<table align="center" class="writerUpdate">
  				<tr>
					<td colspan="2" align=center class="m2">회원수정</td>
 				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="name" class="box" readOnly>
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">아이디</td>
					<td class="m3">
						<input type="text" name="id" class="box" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">비밀번호</td>
					<td class="m3">
						<input type="password" name="passwd" class="box">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">이메일</td>
					<td class="m3">
						<input type="text" name="email" class="box">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">전화번호</td>
					<td class="m3">
						<input type="text" name="hp1" class="box" size="3" maxlength="3"> -
						<input type="text" name="hp2" class="box" size="4" maxlength="4"> -
						<input type="text" name="hp3" class="box" size="4" maxlength="4">
					</td>
  				</tr>
  				<tr>
  					<td width="150" class="m3">주소</td>
					<td class="m3">
						<input type="text" name="address" class="box">
					</td>
  				</tr>
  				<tr>
  					<td width="150" class="m3">출생년도</td>
					<td class="m3">
						<input type="text" name="year" class="box">
					</td>
  				</tr>
  				<tr>
  					<td colspan="2"><input type="checkbox" name="man">남&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  					<input type="checkbox" name="woman">여</td>
  				</tr>
  				<tr>
  					<td>취향</td>
  					<td><input type="checkbox" name="preffered">판타지</td>
  				<tr>
					<td colspan="2" align="center">
						[수정][취소]
					</td>
  				</tr>
  				
  			</table>
	</div>
<jsp:include page="../../main/footer.jsp"/>