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
		<form name="f" action="writerNovelUpdate" method="post" onsubmit="return check()" enctype="multipart/form-data">
		<input type="hidden" value="${login.mnum}" name="mnum">
		<input type="hidden" name="nnum" value="${getNovel.nnum}"/>
			<table align="center" class="writer">
				<tr>
					<td colspan="3" align="center">소설 쓰기(처음 시작할 때)</td>
				</tr>
				<tr>
					<th width="20%">작 가 필 명</th>
					<td colspan="2"><input type="text" name="Novel_memberName" size="50" class="width80" value="${getNovel.novel_memberName}" required></td>
				</tr>
				<tr>
					<th width="20%">카 테 고 리</th>
					<td colspan="2">${getNovel.novel_cate}</td>
				</tr>			
				<tr>
					<th width="20%">대 제 목(소설의 제목)</th>
					<td colspan="2"><input type="text" name="Novel_subject" size="50" class="width80" value="${getNovel.novel_subject}" required></td>
				</tr>
				<tr>
					<th width="20%">소 설 이 미 지</th>
					<td><input type="file" name="file" size="50" class="width80" value="${getNovel.novel_image}"></td>
				</tr>
				<tr>
					<th width="20%">줄 거 리</th>
					<td colspan="2"><textarea name="Novel_summary" rows="10" cols="70" class="width80" required>${getNovel.novel_summary}</textarea></td>
				</tr>				
				<tr>
					<td align="center" colspan="3">
						<input type="submit" value="작성 완료">
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="../../../main/footer.jsp"/>