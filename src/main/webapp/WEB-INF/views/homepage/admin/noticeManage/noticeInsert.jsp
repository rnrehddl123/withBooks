<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!-- notice.jsp�� �۾���� ����Ǵ� jsp���� -->
<html>
<head>
<title>�������� �۾���</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="noticeInsert">
	<form name="f" action="#" method="post">
		<table border="1" width="500">
				<tr>
					<td colspan="2" align="center">�������� �ۼ�</td>
				</tr>
				<tr>
					<th>�� ��</th>
					<td>
						<select name="notice">
							<option value="gongji">����
							<option value="annae">�ȳ�
						</select>
						
						<input type="text" name="subject" size="40">
					</td>
				</tr>
				<tr>
					<th>�� ��</th>
					<td><textarea name="content" rows="11" cols="50"></textarea></td>
				</tr>
				<tr>
					<th>������ ��ȣ</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="�۾���">
						<input type="reset" value="�ٽ��ۼ�">
						<input type="button" value="��Ϻ���">
					</td>
				</tr>
		</table>
	</form>
</div>
</body>

</html>
<%@include file="../../adminFooter.jsp"%>