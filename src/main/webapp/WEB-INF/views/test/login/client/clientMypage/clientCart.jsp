<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- clientCart -->
<html>
<head>
<title>clientCart</title>
</head>
<body>
<div align="center">
<form name="f" action="clientOrder" method="post">
	<table width="1000" border="1">
		<tr>
			<td colspan="7" align="center">
				<h4>��ٱ���</h4>
			</td>
		</tr>		
		<tr>
			<th width="5%">��ȣ</th>
			<th width="30%">����</th>
			<th width="10%">�۰���</th>
			<th width="30%">����</th>
			<th width="10%">�� �ݾ�</th>
			<th width="5%">����</th>
			<th width="10%">����</th>
		</tr>
		<!-- if -->
			<tr>	
				<td colspan="7">��ٱ��Ͽ� ��ϵ� ��ǰ�� �����ϴ�.</td>
			</tr>
		<!-- if�ݱ� -->
		<!-- for -->
		<tr>
			<td><!-- ��ȣ --></td>
			<td><!-- ���� --></td>
			<td><!-- �۰��� --></td>
			<td><!-- ���� --><img src=""></td>
			<td><!-- �ѱݾ� -->��</td>
			<td><!-- ���� --></td>
			<td><!-- ���� --><a href="cartDel?nnum=">����</a></td>
		</tr>	
		<!-- for�ݱ� -->
		<tr>
			<td colspan="4">
				<b>��ٱ����Ѿ� : ��</b><br>
			</td>
			<td colspan="3" align="center">
				<input type="submit" value="�ֹ��ϱ�">
				<input type="button" value="��Ӽ���" onclick="javascript:history.go(-2)">
			</td>
		</tr>		
	</table>
</form>
</div>
</body>
</html>