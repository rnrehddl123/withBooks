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
		</div>	
<%@ include file="../../adminFooter.jsp"%>