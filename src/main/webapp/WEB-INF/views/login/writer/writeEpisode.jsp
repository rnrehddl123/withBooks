<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writeEpisode.jsp -->
<html>
<head>
	<title>writeEpisode</title>
</head>
<body>
	<div align="center">
		<form name="f" action="" method="post" onsubmit="return check()">
			<table border="1" width="800">
				<tr>
					<td colspan="2" align="center">�Ҽ� ���� ����</td>
				</tr>			
				<tr>
					<th width="20%">�� �� ��(���� 1ȭ,2ȭ)</th>
					<td><input type="text" name="subject" size="50"></td>
				</tr>
				<tr>
					<th width="20%">�� ��</th>
					<td><textarea name="content" rows="30" cols="70"></textarea></td>
				</tr>				
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="�ۼ� �Ϸ�">
						<input type="reset" value="�ٽ� �ۼ�">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>