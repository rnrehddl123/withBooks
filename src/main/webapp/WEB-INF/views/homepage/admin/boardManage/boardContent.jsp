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
			<table>
  				<tr>
  					<td>번호</td>
  					<td>${getBoard.bnum}</td>
  				</tr>
  				<tr>
  					<td>제목</td>
  					<td>${getBoard.board_subject}</td>
  				</tr>
  				<tr>
  					<td>작성자</td>
  					<td>${getBoard.board_writer}</td>
  				</tr>
  				<tr>
  					<td>작성일</td>
  					<td>${getBoard.board_date}</td>
  				</tr>
  				<tr>
  					<td>내용</td>
  					<td>${getBoard.board_content}</td>
  				</tr>
  				<tr>
  					<td>조회수</td>
  					<td>${getBoard.board_readcount}</td>
  				</tr>
  				<tr>
  					<td colspan="2"><a href="deleteBoardAdmin?bnum=${getBoard.bnum}">삭제</a></td>
  				</tr>	
			</table>
		</div>	
<%@ include file="../../adminFooter.jsp"%>