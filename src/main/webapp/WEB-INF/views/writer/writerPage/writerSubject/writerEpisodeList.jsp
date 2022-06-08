<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writerNovelList.JSP -->
<html>
<head>
	<title>ㅇㅇㅇ, 에피소드 목록</title>
</head>
<body>
	<div align="center">
		<b> (소 설 제 목) 에피소드 목록</b>
		<table border="1" width="800">
			<tr>
				<td colspan="5" align="right"><a href="#">새로운 에피소드 쓰기</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>에피소드 제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>수정(EpisodeUpdate)로/삭제</th>
			</tr>
			<c:if test="">
			<tr>
				<td colspan="5">등록된 소설이 없습니다.</td>
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