<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="boardSidebar.jsp"/>
		<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
">

<script type="text/javascript">
var count1=0;
var count2=0;
	function increase(){
	    count1=count1+1;
	    document.querySelector("#countPlus").innerText=count1;
	}
	
	function decrease(){
	    count2=count2-1;
	    document.querySelector("#countMinus").innerText=count2;
	}
	
	
</script>

<table class="table">
  <thead>
  <div align="center">
  	<h1>자유게시판</h1>
  </div>
    <tr>
      <th scope="col" align="center">번호</th>
      <th scope="col" align="center">제목</th>
      <th scope="col" align="center">작성자</th>
      <th scope="col" align="center">작성일</th>
      <th scope="col" align="center">조회수</th>
     
    </tr>
  </thead>
  	<c:if test="${empty listBoard}">
			<tr>
				<td colspan="7" align="center">등록된 게시글이 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="Boarddto" items="${listBoard}">
			<tr>
				<td align="left">${Boarddto.bnum}</td>
				<td align="left">
					<a href="contentBoard?Bnum=${Boarddto.bnum}">
						${Boarddto.board_subject}
					</a>
				</td>
				<td align="left">${Boarddto.board_writer}</td>
				<td align="left">${Boarddto.board_date}</td>
				<td align="left">${Boarddto.board_readcount}</td>
			</tr>
	</c:forEach>
			
  </tbody>
</table>
<div>
	<c:if test="${rowCount>0}">
		<c:if test="${startPage>1}">
			[<a href="listBoard?pageNum=${startPage-1}">이전</a>]			
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			[<a href="listBoard?pageNum=${i}"><c:out value="${i}"/></a>]	
		</c:forEach>
		<c:if test="${endPage<pageCount}">
			[<a href="listBoard?pageNum=${endPage+1}">다음</a>]			
		</c:if>
	</c:if>
	
	<form name="f" action="listBoard" method="post">
		<input type="hidden" name="mode" value="search">
			검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
</div>

 <jsp:include page="../main/footer.jsp"/>
  



</body></html>