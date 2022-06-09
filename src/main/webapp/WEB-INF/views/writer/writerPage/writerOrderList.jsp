<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- order.jsp -->
<jsp:include page="../../main/header.jsp"/>
<html>
<head>
	<title>writeOrderList</title>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
<body>
	<div align="center">
<c:set var="total" value="0"/>

<table align="center" class="writer">
   <tr>
      <th colspan = "3"><font color = "blue">결재 내역서 보기</font></th>
   </tr>
   
   <tr class = "m1">
      <th>상품명</th>
      <th>수량</th>
      <th>금액</th>
   </tr>
   <c:choose>
   <c:when test="${not empty order}">   
   <tr>
      <td align = "center"></td>
      <td align = "right"> 개</td>
      <td align = "right">
      <fmt:formatNumber value="" pattern="###,###"/> 원</td>
      <c:set var="total" value=""/>
   </tr>
</c:when>   
<c:otherwise>
   <c:forEach var="pdto" items="">
   <tr>
      <td align = "center"></td>
      <td align = "right"> 개</td>
      <td align = "right">
      <fmt:formatNumber value="" pattern="###,###"/> 원</td>
      <c:set var="total" value=""/>
   </tr>
   </c:forEach>
</c:otherwise>   
</c:choose>

<tr class = "m1">
      <td colspan = "3" align = "center">
      결재하실 총액은:
      <font color = "red">
      <fmt:formatNumber value= pattern="###,###"/> 원</font>
      </td>
   </tr>
</table>
</div>
<jsp:include page="../../main/footer.jsp"/>