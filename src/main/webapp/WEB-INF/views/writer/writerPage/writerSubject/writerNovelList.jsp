<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writerNovelList.JSP -->
<html>
<head>
	<title>내가쓴 소설 목록</title>
</head>
<body>
	<div align="center">
		<b> 내가 쓴 소설 목록</b>
		<table border="1" width="800">
			<tr>
				<td colspan="6" align="right"><a href="#">새로운 소설 쓰기</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>소설(시리즈)제목(writerEpisodeList로)</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>수정(NovelUpdate)/삭제</th>
			</tr>
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
		</table>
	</div>
</body>
</html>