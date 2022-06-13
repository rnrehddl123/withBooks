<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writeEpisodeUpdate.jsp -->
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>writeEpisodeUpdate</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
		<form name="f" action="update_Episode" method="post" onsubmit="return check()">
		<input type="hidden" name="num" value="${getEpisode.Epnum}"/>
			<table align="center" class="writer">
				<tr>
					<td colspan="2" align="center">소설 내용 수정</td>
				</tr>			
				<tr>
					<th width="20%">소 제 목(수정가능)</th>
					<td><input type="text" name="Epi_subject" size="65" class="width80" value="${getEpisode.Epi_subject}"></td>
				</tr>
				<tr>
					<th width="20%">내 용(수정가능)</th>
					<td><textarea name="Epi_content" rows="30" cols="70" class="width80" value="${getEpisode.Epi_content}"></textarea></td>
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