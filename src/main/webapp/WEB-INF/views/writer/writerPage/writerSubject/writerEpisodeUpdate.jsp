<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writeEpisodeUpdate.jsp -->
<html>
<head>
	<title>writeEpisodeUpdate</title>
</head>
<body>
	<div align="center">
		<form name="f" action="" method="post" onsubmit="return check()">
			<table border="1" width="800">
				<tr>
					<td colspan="2" align="center">소설 내용 수정</td>
				</tr>			
				<tr>
					<th width="20%">소 제 목(수정가능)</th>
					<td><input type="text" name="subject" size="50"></td>
				</tr>
				<tr>
					<th width="20%">내 용(수정가능)</th>
					<td><textarea name="content" rows="30" cols="70"></textarea></td>
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
</body>
</html>