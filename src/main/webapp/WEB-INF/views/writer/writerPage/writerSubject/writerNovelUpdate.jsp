<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writeNovelUpdate.jsp -->
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>writeNovelUpdate</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<form name="f" action="update_Novel" method="post" onsubmit="return check()">
		<input type="hidden" name="num" value="${getNovel.nnum}"/>
			<table align="center" class="writer">
				<tr>
					<td colspan="2" align="center">소설 쓰기(처음 시작할 때)</td>
				</tr>
				<tr>
					<th width="20%">작 가 필 명</th>
					<td><input type="text" name="Novel_memberName" size="50" class="width80">${getNovel.Novel_memberName}</td>
				</tr>
				<tr>
					<th width="20%">카 테 고 리</th>
					<td><input type="text" name="Novel_cate" size="50" class="width80">${getNovel.Novel_cate}</td>
				</tr>			
				<tr>
					<th width="20%">대 제 목(소설의 제목)</th>
					<td><input type="text" name="Novel_subject" size="50" class="width80">${getNovel.Novel_subject}</td>
				</tr>
				<tr>
					<th width="20%">소 설 이 미 지</th>
					<td><input type="file" name="Novel_image" size="50" class="width80">${getNovel.Novel_image}</td>
				</tr>
				<tr>
					<th width="20%">줄 거 리</th>
					<td><textarea name="Novel_summary" rows="10" cols="70" class="width80">${getNovel.Novel_summary}</textarea></td>
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
<jsp:include page="../../../main/footer.jsp"/>