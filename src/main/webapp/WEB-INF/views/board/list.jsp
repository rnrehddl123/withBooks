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
				<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
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
			<div align="right">
					<input type="submit" value="게시판 글등록" onclick="window.location='writeBoard'">
				</div>
  </tbody>
</table>

 <jsp:include page="../main/footer.jsp"/>
  



</body></html>