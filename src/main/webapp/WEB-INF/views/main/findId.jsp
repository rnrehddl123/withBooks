<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<div>
				<h3> 아이디 검색 결과</h3>
			</div>
			<div class="textbox">
		  		<h5>
					회원님의 아이디는 : ${dto.member_id} 입니다.
				</h5>
		 	</div>
		 	<button type="button" onclick="history.go(-1);">다시 찾기</button>
	</body>
</html>