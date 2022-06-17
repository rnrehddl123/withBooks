<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- clientNovelListForCate.jsp -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
<title>카테고리별 리스트</title>
</head>
<body>
	<div class="container">
		<div class="item">
			<div id="categoryList">
				<ul>
					<li>카테고리 목록</li>
					<c:forEach items="${CategoryDTO}" var="dto">
						<li><input type="button" value="${dto.Cate_name}"></li>	
					</c:forEach>
				</ul>
			</div>
		</div>
		
		<div class="item">
			<div id="Cate_name">
				<h3>${CategoryDTO.Cate_name}</h3>
			</div>
			<c:forEach items="${NovelDTO}" var="dto">
				<div>
					<div>
						<div>${dto.Novel_image}</div>
					</div>
					<div>
						<h3>${dto.Novel_subject}</h3>
						<p>${dto.Novel_memberName}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>