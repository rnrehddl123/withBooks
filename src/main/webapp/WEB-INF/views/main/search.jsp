<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"/>
<br><br>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" align="center"><h3>소설 목록</h3></div>

  <!-- Table -->
  <table class="table">
  <thead>
    <tr>
      <th scope="col" align="center">번호</th>
      <th scope="col" align="center">카테고리</th>
      <th scope="col" align="center">제목</th>
      <th scope="col" align="center">작가</th>
    </tr>
  </thead>
  	<c:if test="${empty listNovel}">
			<tr>
				<td colspan="4" align="center">검색된 소설이 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="ndto" items="${listNovel}">
			<tr>
				<td align="left">${ndto.nnum}</td>
				<td align="left">${ndto.novel_cate}</td>
				<td align="left">
					<a href="clientNovelInfo?nnum=${ndto.nnum}">
						${ndto.novel_subject}
					</a>
				</td>
				<td align="left">${ndto.novel_memberName}</td>
			</tr>
	</c:forEach>
  </tbody>
  </table>
</div>
<div align="center">
<c:if test="${novelRowCount>0}">			
			<c:if test="${novelStartPage>1}">
				[<a href="searchMain?novelPageNum=${novelStartPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${novelStartPage}" end="${novelEndPage}">
				[<a href="searchMain?novelPageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${novelEndPage<novelPageCount}">
				[<a href="searchMain?novelPageNum=${novelEndPage+1}">다음</a>]			
			</c:if>
</c:if>
</div>
<br><br>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" align="center"><h3>작가 목록</h3></div>

  <!-- Table -->
  <table class="table">
	<thead>
    	<tr>
      	<th scope="col" align="center">작가</th>
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
					${wdto.member_name}
				</a>
			</td>
		</tr>
	</c:forEach>
  	</tbody>
  </table>
</div>
<div align="center">
<c:if test="${writerRowCount>0}">			
			<c:if test="${writerStartPage>1}">
				[<a href="searchMain?writerPageNum=${writerStartPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${writerStartPage}" end="${writerEndPage}">
				[<a href="searchMain?writerPageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${writerEndPage<writerPageCount}">
				[<a href="searchMain?writerPageNum=${writerEndPage+1}">다음</a>]			
			</c:if>
</c:if>
</div>
<div>
	
<jsp:include page="footer.jsp"/>