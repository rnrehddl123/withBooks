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
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
      <th scope="col">조회수</th>
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
				<td align="right">${Boarddto.Bnum}</td>
				<td>
					<a href="contentBoard?Bnum=${Boarddto.Bnum}">
						${Boarddto.Board_subject}
					</a>
				</td>
				<td align="center">${Boarddto.Board_writer}</td>
				<td align="center">${Boarddto.Board_reg_date}</td>
				<td align="center">${Boarddto.Board_readcount}</td>
			</tr>		
			</c:forEach>	
			<div align="right">
					<input type="submit" value="게시판 글등록" onclick="window.location='writeBoard'">
				</div>
  </tbody>
</table>

 <jsp:include page="../main/footer.jsp"/>
  



</body></html>