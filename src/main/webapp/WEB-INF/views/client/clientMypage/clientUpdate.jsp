<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientUpdate -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
<title>clientUpdate</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
			<font size="3">개 인 정 보 수 정</font><p>
			<table width="600" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center>회원수정</td>
 				</tr>
				<tr>
					<td width="150">이름</td>
					<td>
						<input type="text" name="name" class="box" readOnly>
					</td>
				</tr>
				<tr>
					<td width="150">아이디</td>
					<td>
						<input type="text" name="id" class="box" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150">비밀번호</td>
					<td>
						<input type="password" name="passwd" class="box">
					</td>
  				</tr>
  				<tr>
					<td width="150">이메일</td>
					<td>
						<input type="text" name="email" class="box">
					</td>
  				</tr>
  				<tr>
					<td width="150">전화번호</td>
					<td>
						<input type="text" name="hp1" class="box" size="3" maxlength="3"> -
						<input type="text" name="hp2" class="box" size="4" maxlength="4"> -
						<input type="text" name="hp3" class="box" size="4" maxlength="4">
					</td>
  				</tr>
  				<tr>
  					<td width="150">주소</td>
					<td>
						<input type="text" name="address" class="box">
					</td>
  				</tr>
  				<tr>
  					<td width="150">출생년도</td>
					<td>
						<input type="text" name="year" class="box">
					</td>
  				</tr>
  				<tr>
  					<td><input type="checkbox" name="man">남</td>
  					<td><input type="checkbox" name="woman">여</td>
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
</body>
</html>
<jsp:include page="../../main/footer.jsp"/>