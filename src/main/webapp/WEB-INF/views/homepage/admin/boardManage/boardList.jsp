<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 게시판 관리</title>
</head>

<%@ include file="../../adminHeader.jsp"%>
		<div class="adminboard">
			<b><h1>게시판 관리</h1></b><p>
			<table border="1" width="1000" height="500">
   				<tr>
      				<th>번호</th>
      				<th>제목</th>
      				<th>작성자</th>
      				<th>작성일</th>
      				<th>조회수</th>
      				<th>삭제</th>
    			</tr>
  			<c:if test="${empty listBoard}">
				<tr>
					<td colspan="6" align="center">등록된 게시글이 없습니다.</td>
				</tr>
			</c:if>
    		<c:forEach var="bdto" items="${listBoard}">
				<tr>
					<td align="left">${bdto.bnum}</td>
					<td align="left">
						<a href="contentBoardAdmin?bnum=${bdto.bnum}">
							${bdto.board_subject}
						</a>
					</td>
					<td>${bdto.board_writer}</td>
					<td>${bdto.board_date}</td>
					<td>${bdto.board_readcount}</td>
					<td>
						<input type="button" value="삭제" onclick="window.location='deleteBoardAdmin?bnum=${bdto.bnum}'">
					</td>
				</tr>		
			</c:forEach>
			</table>
			<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				[<a href="listBoardAdmin?pageNum=${startPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="listBoardAdmin?pageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				[<a href="listBoardAdmin?pageNum=${endPage+1}">다음</a>]			
			</c:if>
	</c:if>
			
			<form name="f" action="listBoardAdmin" method="post">
				<input type="hidden" name="mode" value="search">
				<select name="search">
					<option value="Board_writer">글쓴이</option>
					<option value="Board_subject">제목</option>
				</select>
				검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
			</form>
		</div>	
<%@ include file="../../adminFooter.jsp"%>