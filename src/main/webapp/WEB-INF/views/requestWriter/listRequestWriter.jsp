<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<jsp:include page="requestWriterSidebar.jsp"/>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
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
      <!-- <th scope="col" align="center">번호</th> --> <!-- 굳이 사용자에게 번호가 보일 필요가 없어보입니다. -->
      <th scope="col" align="center">작성일</th>
      <th scope="col" align="center">제목</th>
      <th scope="col" align="center">작성자</th>
      <th scope="col" align="center">상태</th>
      
    </tr>
  </thead>
  	<c:if test="${empty listRequestWriter}">
			<tr>
				<td colspan="4" align="center">작가 신청 내역이 없습니다.</td>
			</tr>
	</c:if>
  <tbody>
    <c:forEach var="rdto" items="${listRequestWriter}">
			<tr>
				<!-- <td align="left">${rdto.rwnum}</td> -->
				<td align="left">
					<fmt:parseDate var="request_reg_date" value="${rdto.request_reg_date}" pattern="yyyy-MM-dd" /> <!-- string형 날짜=>date형으로 형변환 -->
					<fmt:formatDate  value="${request_reg_date}" pattern="yyyy-MM-dd"/><!-- date날짜 불러오기 -->
						<!-- ${rdto.request_reg_date} -->
				</td>
				<td align="left">
					<a href="contentRequestWriter?Rwnum=${rdto.rwnum}">
						${rdto.request_subject}
					</a>
				</td>
				<td align="left">${rdto.request_writer}</td>
				<td align="left">
					<div class="requestFont">
						<c:if test="${rdto.request_state eq 'accept'}">
						수락
						</c:if>
						<c:if test="${rdto.request_state eq 'refuse'}">
						거절
						</c:if>
						<c:if test="${rdto.request_state eq null}">
						대기중
						</c:if>
					</div>
				</td>
				
			</tr>	
	</c:forEach>	
			
  </tbody>
</table>

<!-- 작가신청하기 버튼 -->
  <div align="center" class="buttonList">
  	<input type="button" class="review_btn btn btn-primary" value="작가신청하기" onclick="window.location='writeRequestWriter?'">
  </div>

 <jsp:include page="../main/footer.jsp"/>
  



</body></html>