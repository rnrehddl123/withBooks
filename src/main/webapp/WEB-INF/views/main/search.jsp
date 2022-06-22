<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"/>
<table class="table">
  <thead>
  <div align="center">
  	<h1>소설 목록</h1>
  </div>
    <tr>
      <th scope="col" align="center">번호</th>
      <th scope="col" align="center">제목</th>
      <th scope="col" align="center">작가</th>
    </tr>
  </thead>
  	<c:if test="${empty listNovel}">
			<tr>
				<td colspan="3" align="center">검색된 소설이 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="ndto" items="${listNovel}">
			<tr>
				<td align="left">${ndto.nnum}</td>
				<td align="left">
					<a href="clientNovelInfo?nnum=${ndto.nnum}">
						${ndto.novel_subject}
					</a>
				</td>
				<td align="left">${ndto.novel_memberName}</td>
			</tr>
	</c:forEach>
  </tbody>
</table><p>
<table class="table">
    <thead>
  <div align="center">
  	<h1>작가 목록</h1>
  </div>
    <tr>
      <th scope="col" align="center">아이디</th>
    </tr>
  </thead>
  	<c:if test="${empty listWriter}">
			<tr>
				<td align="center">검색된 작가가 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="wdto" items="${listWriter}">
			<tr>
				<td align="left">
					<a href="writerNovelList?mnum=${wdto.mnum}">
						${wdto.member_id}
					</a>
				</td>
			</tr>
	</c:forEach>
  </tbody>
</table>
<div>
	
<jsp:include page="footer.jsp"/>