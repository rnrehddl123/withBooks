<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writeEpisode.jsp -->
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>writeEpisode</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<form name="f" action="" method="post" onsubmit="return check()">
			<table align="center" class="writer">
				<tr>
					<td colspan="2" align="center">소설 내용 쓰기</td>
				</tr>			
				<tr>
					<th width="20%">소 제 목</th>
					<td><input type="text" name="subject" size="65" class="width80"></td>
				</tr>
				<tr>
					<th width="20%">내 용</th>
					<td><textarea name="content" rows="30" cols="70" class="width80"></textarea></td>
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