<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>[WithBooks] 공지사항</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>

<div class="noticeList">

	<h3>공지사항</h3>

	<table border="1" width="1000" height="500" align="center">
			<!-- 공지/안내 select-option -->
		<tr>
			<td>
				<a href="">[공지]엄청 긴 제목---------------------------------</a>
						<!-- AdminSlideMapper.xml : list -->
				<p>
				sysdate
			</td>
			<td>
				<input type="button" value="수정" onclick="window.location='noticeUpdate'">
						<!-- AdminNoticeMapper.xml : update -->
			</td>
			<td>
				<input type="button" value="삭제">
						<!-- AdminSlideMapper.xml : delete -->
			</td>
		</tr>
		
		<tr>
			<td>
			<a href="">[안내]제목제목2</a>
			<p>
			2022.03.01
			</td>
			<td>
			<input type="button" value="수정" onclick="window.location='noticeUpdate'">
			</td>
			<td>
			<input type="button" value="삭제">
			</td>
		</tr>
		
		<tr>
			<td>
			[공지/안내]공지사항 List
			<p>
			2022.02.01
			</td>
			<td>
			<input type="button" value="수정" onclick="window.location='noticeUpdate'">
			</td>
			<td>
			<input type="button" value="삭제">
			</td>
		</tr>
		
	</table>
	
	
	검색: <input type="text" name="search"> <input type="button" value="검색">
				<!-- AdminSlideMapper.xml : search -->
	

	<input type="button" value="글쓰기" align="right" onclick="window.location='noticeInsert'">
				<!-- AdminSlideMapper.xml : insert -->
	
</div>

</body>

</html>
<%@include file="../../adminFooter.jsp"%>