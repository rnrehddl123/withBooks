<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 작가신청</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="upgradeClient">
	<div><b><h3 align="center">작가 신청 관리</h3></b></div><br>
	<table border="1" width="1000" height="500">
		<tr height="50">
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>
				수락|거절
			</th>
			<th>상태</th>
		</tr>
	<c:if test="${empty listClientUpgrade}">
		<tr>
			<td colspan="5" align="center">작가 신청 회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="udto" items="${listClientUpgrade}">
		<tr>
			<td>${udto.memberDTO.mnum}</td>
			<td>${udto.request_writer}</td>
			<td><a href="upgradeClientContent?rwnum=${udto.rwnum}">${udto.request_subject}</a></td>
			<td><a href="upgradeClientOk?mnum=${udto.memberDTO.mnum}&state=accept&rwnum=${udto.rwnum}">수락</a>| <!-- 회원관리 페이지로 넘어가게 하기 -->
				<a href="upgradeClientRefuse?rwnum=${udto.rwnum}&state=refuse">거절</a>
			</td>
			<td>
				<c:if test="${udto.request_state eq 'accept'}">
					수락
				</c:if>
				<c:if test="${udto.request_state eq 'refuse'}">
					거절
				</c:if>
				<c:if test="${udto.request_state eq null}">
					대기중
				</c:if>
			</td>	
		</tr>		
	</c:forEach>	
	</table>
	<div align="center">
		<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				[<a href="listUpgradeClient?pageNum=${startPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="listUpgradeClient?pageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				[<a href="listUpgradeClient?pageNum=${endPage+1}">다음</a>]			
			</c:if>
		</c:if>
	</div>
	<form name="f" action="listUpgradeClient" method="post">
		<input type="hidden" name="mode" value="search">
		<select name="search">
					<option value="Request_writer">이름</option>
					<option value="Request_subject">제목</option>
		</select>
		검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>