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
      <td align = "center"></td>
      <td align = "right"> ��</td>
      <td align = "right">
      <fmt:formatNumber value="" pattern="###,###"/> ��</td>
      <c:set var="total" value=""/>
   </tr>
</c:when>   
<c:otherwise>
   <c:forEach var="pdto" items="">
   <tr>
      <td align = "center"></td>
      <td align = "right"> ��</td>
      <td align = "right">
      <fmt:formatNumber value="" pattern="###,###"/> ��</td>
      <c:set var="total" value=""/>
   </tr>
   </c:forEach>
</c:otherwise>   
</c:choose>

<tr class = "m1">
      <td colspan = "3" align = "center">
      �����Ͻ� �Ѿ���:
      <font color = "red">
      <fmt:formatNumber value= pattern="###,###"/> ��</font>
      </td>
   </tr>
</table>