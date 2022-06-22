<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../main/header.jsp"/>
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
  	<h1>공지사항</h1>
  </div>
    <tr>
      <th scope="col" align="center">번호</th>
      <th scope="col" align="center">제목</th>
      <th scope="col" align="center">작성일</th>
      <th scope="col" align="center">조회수</th>
    </tr>
  </thead>
  	<c:if test="${empty listNotice}">
			<tr>
				<td colspan="4" align="center">등록된 공지사항이 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="nodto" items="${NlistNotice}">
			<tr>
				<td align="left">${nodto.nonum}</td>
				<td align="left">
					<a href="NcontentNotice?nonum=${nodto.nonum}">
						${nodto.notice_title}
					</a>
				</td>
				<td align="left">${nodto.notice_reg_date}</td>
				<td align="left">${nodto.notice_readPluscount}</td>
			</tr>
	</c:forEach>
  </tbody>
</table>
<div>
	<c:if test="${rowCount>0}">
		<c:if test="${startPage>1}">
			[<a href="NlistNotice?pageNum=${startPage-1}">이전</a>]			
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			[<a href="NlistNotice?pageNum=${i}"><c:out value="${i}"/></a>]	
		</c:forEach>
		<c:if test="${endPage<pageCount}">
			[<a href="NlistNotice?pageNum=${endPage+1}">다음</a>]			
		</c:if>
	</c:if>
	
	<form name="f" action="NlistNotice" method="post">
		<input type="hidden" name="mode" value="search">
			검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
</div>

 <jsp:include page="../main/footer.jsp"/>
  