<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- order.jsp -->
<c:set var="total" value="0"/>

<table class = "outline" width = "80%">
	<tr bgcolor = "blue">
		<th colspan = "3"><font color = "blue">���� ������ ����</font></th>
	</tr>
	
	<tr class = "m1">
		<th>��ǰ��</th>
		<th>����</th>
		<th>�ݾ�</th>
	</tr>
	<c:choose>
	<c:when test="${not empty order}">	
	<tr>
		<td align = "center">${order.�̸�}</td>
		<td align = "right">${order.����} ��</td>
		<td align = "right">
		<fmt:formatNumber value="${order.����}" pattern="###,###"/> ��</td>
		<c:set var="total" value="${order.���� * order.����}"/>
	</tr>
</c:when>	
<c:otherwise>
	<c:forEach var="pdto" items="${orderList}">
	<tr>
		<td align = "center">${pdto.pname}</td>
		<td align = "right">${pdto.pqty} ��</td>
		<td align = "right">
		<fmt:formatNumber value="${pdto.price}" pattern="###,###"/> ��</td>
		<c:set var="total" value="${total + pdto.pqty * pdto.price}"/>
	</tr>
	</c:forEach>
</c:otherwise>	
</c:choose>

<tr class = "m1">
		<td colspan = "3" align = "center">
		�����Ͻ� �Ѿ���:
		<font color = "red">
		<fmt:formatNumber value="${total}" pattern="###,###"/> ��</font>
		</td>
	</tr>
</table>