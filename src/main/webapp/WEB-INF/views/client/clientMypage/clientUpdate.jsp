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
			<form name="updateMember" action="updateMember" method="POST" onsubmit="return check()">					
			<input type="hidden" name="mnum" value="${login.mnum}"/>
			<table border="1" class="writerUpdate">
  				<tr>
					<td colspan="2" align=center>회원수정</td>
 				</tr>
				<tr>
					<td width="150">이름</td>
					<td>
						<input type="text" name="Member_name" class="box" value="${login.member_name}" readOnly>
					</td>
				</tr>
				<tr>
					<td width="150">아이디</td>
					<td>
						<input type="text" name="Member_id" class="box" value="${login.member_id}" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150">비밀번호</td>
					<td>
						<input type="password" name="Member_passwd" class="box" value="${login.member_passwd}">
					</td>
  				</tr>
  				<tr>
					<td width="150">이메일</td>
					<td>
						<input type="text" name="Member_email" class="box" value="${login.member_email}" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150">전화번호</td>
					<td>
						<input type="text" name="Member_tel1" class="box" size="3" maxlength="3" value="${tel1}"> -
						<input type="text" name="Member_tel2" class="box" size="4" maxlength="4" value="${tel2}"> -
						<input type="text" name="Member_tel3" class="box" size="4" maxlength="4" value="${tel3}">
					</td>
  				</tr>
  				<tr>
  					<td width="150">주소</td>
					<td>
						<input type="text" name="Member_address" class="box" value="${login.member_address}" readOnly>
					</td>
  				</tr>
  				<tr>
  					<td width="150">출생년도</td>
					<td>
						<input type="text" name="Member_birth" class="box" value="${login.member_birth}" readOnly>
					</td>
  				</tr>
  				<tr>
  					<td colspan="2">
						<label><input type="radio" name="Member_sex" value="man" ${login.member_sex eq 'man' ? "checked" : '' }  onclick="return(false);"/>남</label>
						<label><input type="radio" name="Member_sex" value="woman" ${login.member_sex eq 'woman' ? "checked" : '' }  onclick="return(false);"/>여</label>
  					</td>
  				</tr>
  				<tr>
  					<td colspan="2">
			  		<div class="inputWrapper flex checkWrapper">
			  	<c:forEach items="${categoryList}" var="dto">
			  		<div class="form-check marginauto">
					  <input name="member_preferred" class="form-check-input" type="checkbox" value="${dto.cate_name}"
					  		 ${login.member_preferred1 eq dto.cate_name ? "checked" : ''} 
					  		 ${login.member_preferred2 eq dto.cate_name ? "checked" : ''} 
					  		 ${login.member_preferred3 eq dto.cate_name ? "checked" : ''} onclick="countCheck(this)">
					  <label class="form-check-label" for="flexCheckDefault">${dto.cate_name}</label>
					</div>
				</c:forEach>
			  </div>
					</td>
				</tr>
			  	<tr>
					<td colspan="2"><input type="submit" value="수정"><input type="button" onclick="history.back()" value="취소"></td>
  				</tr>
  			</table>
  			</form>
	</div>
	<script type="text/javascript">
		function countCheck(obj){
			var chkbox = document.getElementsByName("member_preferred");
			var chkCnt = 0;
			
			for(var i=0;i<chkbox.length; i++){
				if(chkbox[i].checked){
					chkCnt++;
				}
			}
			if(chkCnt>3){
				alert("장르는 3개만 체크해주세요.");
				obj.checked = false;
				return false;
			}
		}
	
	
	</script>
<jsp:include page="../../main/footer.jsp"/>