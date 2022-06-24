<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- clientNovelListForCate.jsp -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
<title>카테고리별 리스트</title>
<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
</head>
<body>
<div class="main_Wrap">
	<div class="c_Container">
		<div class="c_List">카테고리 목록</div><p>
		<c:forEach items="${listCategory}" var="list">
			<ul>
				<li><a href="clientNovelListForCateGET?cnum=${list.cnum}">${list.cate_name}</a></li>
			</ul>
		</c:forEach>
	</div>
	<div class="n_Wrap">
		<div class="n_Title">
			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-book-half" viewBox="0 0 16 16">
  			<path d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
			</svg><font size="4">   카테고리 >> ${selectCateName}</font> 
		</div>
		<div class="n_Container">
			<c:choose>
				<c:when test="${empty listForCate}">
					<div>등록된 소설이 없습니다.</div>				
				</c:when>
				<c:otherwise>			
					<c:forEach items="${listForCate}" var="list">
						<div class="n_Content"><a href="clientNovelInfo?nnum=${list.nnum}"><img class="n_image" src="resources/img/${list.novel_image}"></a><p>${list.novel_subject}<p>${list.novel_memberName}</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>