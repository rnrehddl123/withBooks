<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cartList -->
<table width="100%" border="1">
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
		
		<!-- for -->
		<tr>
			<td><!-- ��ȣ --></td>
			<td><!-- ���� --></td>
			<td><!-- �۰��� --></td>
			<td><!-- ���� --><img src=""></td>
			<td><!-- �ѱݾ� -->��</td>
			<td><!-- ���� --></td>
			<td><!-- ���� --><a href="cartDel.do?nnum=">����</a></td>
		</tr>	
		
		<tr>
			<td colspan="4">
				<b>��ٱ����Ѿ� : ��</b><br>
			</td>
			<td colspan="3" align="center">
				[<a href="order.do">�ֹ��ϱ�</a>]
				[<a href="javascript:history.go(-2)">��Ӽ���</a>]
			</td>
		</tr>		
	</table>