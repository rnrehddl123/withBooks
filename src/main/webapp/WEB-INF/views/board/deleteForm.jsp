<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- deleteForm.jsp -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 60%;
">
	<title>글삭제</title>
</head>
<body>
	<div align="center">
		<form name="f" action="deleteBoard" method="post">
		<input type="hidden" name="bnum" value="${param.Bnum}"/>
			<div>
					<h1>게시글 삭제</h1>
			</div>
			<div class="mb-3" align="center">	
				  <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
				  <input type="password" name="passwd" class="form-control" id="exampleFormControlInput1" placeholder="****">
				</div>
			<tr>
			<div align="center">
				<input type="submit" value="글삭제">
				<input type="button" value="글목록" onclick="window.location='listBoard'">
			</div>	
			</tr>
		</form>
	</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>