<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../main/header.jsp"/>
<link href="resources/css/notice.css" rel="stylesheet" type="text/css" />
<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
">

<table class="table titletitle">
  
  <div align="center" >
  
  	<h1 class="h1">공지사항</h1>
  	
  	<p>
  </div>
  <!-- 
    <tr>
      <th scope="col" align="center">번호</th>
      <th scope="col" align="center">제목</th>
      <th scope="col" align="center">작성일</th>
      <th scope="col" align="center">조회수</th>
    </tr>
     -->
 
 <div class="list">	
  	<c:if test="${empty NlistNotice}">
			<tr>
				<td colspan="4" align="center">등록된 공지사항이 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="nodto" items="${NlistNotice}">
			<tr>
				<!-- <td align="left">${nodto.nonum}</td> -->			<!-- 넘버 안붙이는게 나아보임 -->
				<td align="center">
					<a href="NcontentNotice?nonum=${nodto.nonum}" class="inner">
						<font size="4">${nodto.notice_title}</font>
					</a><br>
					<font size="2" color="grey">${nodto.notice_reg_date}</font>
				</td>
				<!-- <td align="left">${nodto.notice_readPluscount}</td> -->	<!-- 조회수도 가리는 편이 자연스러운 것 같음 -->
			</tr>
	</c:forEach>
  </tbody>
  </div>
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
	
	<p>
	
	<form name="f" action="NlistNotice" method="post">
		<input type="hidden" name="mode" value="search">
			<input type="text" name="searchString" placeholder="검색">
			<input type="submit" value="검색"><p>
	</form>
</div>

 <jsp:include page="../main/footer.jsp"/>
  