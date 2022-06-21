<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="requestWriterSidebar.jsp"/>
		<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
">

<table class="table">
  <thead>
  <div align="center">
  	<h1>작가 신청 페이지</h1>
  </div>
    <tr>
      <th scope="col" align="center">번호</th>
      <th scope="col" align="center">제목</th>
      <th scope="col" align="center">작성자</th>
      <th scope="col" align="center">작성일</th>
    </tr>
  </thead>
  	<c:if test="${empty listRequestWriter}">
			<tr>
				<td colspan="4" align="center">등록된 게시글이 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="rdto" items="${listRequestWriter}">
			<tr>
				<td align="left">${rdto.rwnum}</td>
				<td align="left">
					<a href="contentRequestWriter?Rwnum=${rdto.rwnum}">
						${rdto.request_subject}
					</a>
				</td>
				<td align="left">${rdto.request_writer}</td>
				<td align="left">${rdto.request_reg_date}</td>
			</tr>		
			</c:forEach>	
			<div align="right">
					<input type="submit" value="작가 신청 하기" onclick="window.location='writeRequestWriter'">
				</div>
  </tbody>
</table>

<div>
	<c:if test="${rowCount>0}">
		<c:if test="${startPage>1}">
			[<a href="listRequestWriter?pageNum=${startPage-1}">이전</a>]			
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			[<a href="listRequestWriter?pageNum=${i}"><c:out value="${i}"/></a>]	
		</c:forEach>
		<c:if test="${endPage<pageCount}">
			[<a href="listRequestWriter?pageNum=${endPage+1}">다음</a>]			
		</c:if>
	</c:if>
	
	<form name="f" action="listlistRequestWriter" method="post">
		<input type="hidden" name="mode" value="search">
			검색 : <input type="text" name="searchString"><input type="submit" value="검색" placeholder="작가 이름"><p>
	</form>
</div>

 <jsp:include page="../main/footer.jsp"/>
  



</body></html>