<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- novelList.JSP -->
<html>
<head>
	<title>내가쓴 소설 목록</title>
</head>
<body>
	<div align="center">
		<b> 내가 쓴 소설 목록</b>
		<table border="1" width="800">
			<tr bgcolor="yellow">
				<td colspan="7" align="right"><a href="#">새로운 소설 쓰기</a></td>
			</tr>
			<tr bgcolor="yellow">
				<th>번호</th>
				<th>소설(시리즈) 제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>소설 쓰기</th>
				<th>수정/삭제</th>
			</tr>
<<<<<<< HEAD:src/main/webapp/WEB-INF/views/test/login/writer/novelList.jsp
			<c:if test="">
			<tr>
				<td colspan="7">등록된 소설이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="#" items="">
			<tr>
				<td align="right"></td>
				<td>
					<a href="#?#=">
						
					</a>
				</td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
			</tr>		
			</c:forEach>
=======
>>>>>>> WJ:src/main/webapp/WEB-INF/views/login/writer/novelList.jsp
		</table>
	</div>
</body>
</html>