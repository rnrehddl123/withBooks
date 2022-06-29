<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writeNovel.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>writeNovel</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div class="mb-3" align="center">
		<form name="f" action="writerNovel" method="post" onsubmit="return check()" enctype="multipart/form-data">
			<input type="hidden" value="${login.mnum}" name="mnum">
			<table align="center" class="writer">
				<tr>
					<td colspan="2" align="center">소설 쓰기</td>
				</tr>
				<tr>
					<th width="20%">작 가 필 명</th>
					<td><div class="flex widthmar">
					<input type="text" class='novel_name' name="Novel_memberName" size="50" class="my-auto form-control" required>
					<button class="my-auto check_btn" type="button" style="font: small-caption">중복 체크</button>
					</div></div></td>
				</tr>
				<tr>
					<th width="20%">카 테 고 리</th>
					<td>
						<div class="cateWrapper widthmar">
  						     <c:forEach items="${listCategory}" var="dto">
			  					<div class="form-check">
								  <input class="form-check-input" name="Novel_cate" type="radio" value="${dto.cate_name}" required>
								  <label class="form-check-label" for="flexRadioDefault1">
 									  ${dto.cate_name}
								  </label>
								</div>
			  				</c:forEach>
						</div>
					</td>
				</tr>			
				<tr>
					<th width="20%">대 제 목(소설의 제목)</th>
					<td><input type="text" name="Novel_subject" size="50" class="widthmar form-control" required></td>
				</tr>
				<tr>
					<th width="20%">소 설 이 미 지</th>
					<td><input type="file" name="file" size="50" class="widthmar form-control"></td>
				</tr>
				<tr>
					<th width="20%">줄 거 리</th>
					<td><textarea name="Novel_summary" rows="10" cols="70" class="widthmar form-control" required></textarea></td>
				</tr>				
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="작성 완료">
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</table>
		</form>
	</div>

<script type="text/javascript">
	
	var check_name=false
	document.querySelector('.check_btn').addEventListener('click', function(e){
		fetch("checkNovelMemberName",{
	        method: 'POST',
	        body: document.querySelector('.novel_name').value,
	        headers: {
	            'Content-Type': 'text/plain'
	    	}})
	    .then(response => response.text())
	    .then(response => {
	    	console.log(response)
	        check_name=response;
	        if(check_name=="false"){
	        	alert('다른 작가님 사용하시는 이름입니다.')
	        }
	    });
	})
	
	function check(){
		if(check_name=='false'){
			alert('중복체크를 실행해주세요')
			return false;
		}
		return true;
	}
</script>
<jsp:include page="../../../main/footer.jsp"/>