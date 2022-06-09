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
		<form name="f" action="" method="post" onsubmit="return check()">
			<table align="center" class="writer">
				<tr>
					<td colspan="2" align="center">소설 수정</td>
				</tr>
				<tr>
					<th width="20%">작 가 필 명(수정)</th>
					<td><input type="text" name="writerName" size="50" class="width80"></td>
				</tr>
				<tr>
					<th width="20%">카 테 고 리(수정)</th>
					<td><input type="text" name="category" size="50" class="width80"></td>
				</tr>			
				<tr>
					<th width="20%">대 제 목(수정가능)</th>
					<td><input type="text" name="subject" size="50" class="width80"></td>
				</tr>
				<tr>
					<th width="20%">소 설 이 미 지(수정)</th>
					<td><input type="file" name="image" size="50" class="width80"></td>
				</tr>
				<tr>
					<th width="20%">줄 거 리(수정)</th>
					<td><textarea name="content" rows="10" cols="70" class="width80"></textarea></td>
				</tr>				
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="수정 완료">
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="../../../main/footer.jsp"/>