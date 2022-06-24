<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"/>
<br><br>
<h3 align="center">소설 목록</h3>
<br><br>
<hr size="5px">
<br><br>
<div class="frame all">
	<div class="container-fluid">
		<div class="row fanarts">
  			<c:if test="${empty listNovel}">
				검색된 소설이 없습니다.
			</c:if>
    		<c:forEach var="ndto" items="${listNovel}">
    			<div class="grid-item col-xxlg-1 col-xlg-2 col-lg-2 col-md-3 col-sm-3 col-xs-6" align="left">
					<meta content="https://trakt.tv/movies/morbius-2022" itemprop="url">
					<div class="fanart poster stock-titles">
						<a href="clientNovelInfo?nnum=${ndto.nnum}">
							<img class="real" width="175" height="260" src="resources/img/${ndto.novel_image}" style="display: block;">
						</a>
						<a href="clientNovelInfo?nnum=${ndto.nnum}">
							<div class="shadow-base"></div>
						</a>
						<div class="titles has-worded-image">
							<h4>${ndto.novel_cate}</h4>
							<h4 class="generic novel_memberName">${ndto.novel_memberName}</h4>
							<a class="titles-link" href="clientNovelInfo?nnum=${ndto.nnum}">
								<h3>${ndto.novel_subject} <span class="novel_subject">${ndto.novel_subject}</span></h3>
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>	
    
<div align="center">
		<c:if test="${novelRowCount>0}">			
			<c:if test="${novelStartPage>1}">
				[<a href="searchMain?novelPageNum=${novelStartPage-1}&searchString=${searchString}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${novelStartPage}" end="${novelEndPage}">
				[<a href="searchMain?novelPageNum=${i}&searchString=${searchString}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${novelEndPage<novelPageCount}">
				[<a href="searchMain?novelPageNum=${novelEndPage+1}&searchString=${searchString}">다음</a>]			
			</c:if>
		</c:if>
</div>
<br><br>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" align="center"><h3>작가 목록</h3></div>

  <!-- Table -->
  <table class="table">
	<thead>
    	<tr>
      	<th scope="col" align="center">작가</th>
    	</tr>
  	</thead>
  	<c:if test="${empty listWriter}">
		<tr>
			<td align="center">검색된 작가가 없습니다.</td>
		</tr>
	</c:if>
  	<tbody>
    <c:forEach var="wdto" items="${listWriter}">
		<tr>
			<td align="left">
				<a href="searchWriterNovelList?mnum=${wdto.memberDTO.mnum}&novel_memberName=${wdto.novel_memberName}">
					${wdto.novel_memberName}
				</a>
			</td>
		</tr>
	</c:forEach>
  	</tbody>
  </table>
</div>
	<div align="center">
		<c:if test="${writerRowCount>0}">			
			<c:if test="${writerStartPage>1}">
				[<a href="searchMain?writerPageNum=${writerStartPage-1}&searchString=${searchString}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${writerStartPage}" end="${writerEndPage}">
				[<a href="searchMain?writerPageNum=${i}&searchString=${searchString}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${writerEndPage<writerPageCount}">
				[<a href="searchMain?writerPageNum=${writerEndPage+1}&searchString=${searchString}">다음</a>]			
			</c:if>
		</c:if>
	</div>
<div>
	
<jsp:include page="footer.jsp"/>