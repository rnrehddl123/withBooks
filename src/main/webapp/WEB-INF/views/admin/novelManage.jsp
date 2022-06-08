<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>관리자-작품관리</title>
</head>

<body>

<div align="center">

	<h3>작품관리(삭제)페이지</h3>
	<!-- 전체작품 List -->
	
	검색: <input type="text" name="search"> <input type="button" value="검색">
	<p>
	
	<table border="1" width="600" align="center">
	
	<!-- 기본 틀 -->
	<tr>
		<td>
		[소설번호pk] 소설제목 | 작가 | 업로드날짜 | 삭제
		</td>
	</tr>
	
	<!-- 예시 -->
	
	<tr>
		<td>
		<a href="">[1] 동동이야기 | 작가1 | 2022.08.01</a> | <!-- 작품페이지로 이동 -->
		<a href="">삭제</a> <!-- 삭제 팝업 -->
		</td>
	</tr>
	
	<tr>
		<td>
		<a href="">[2] 둥둥이야기 | 작가2 | 2022.08.09</a> | <!-- 작품페이지로 이동 -->
		<a href="">삭제</a> <!-- 삭제 팝업 -->
		</td>
	</tr>
	
	<tr>
		<td>
		<a href="">[9218] 엄청 긴 제목ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ | 작가3 | 2022.08.22</a> | <!-- 작품페이지로 이동 -->
		<a href="">삭제</a> <!-- 삭제 팝업 -->
		</td>
	</tr>
	
	</table>

</body>

</html>