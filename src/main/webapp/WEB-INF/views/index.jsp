<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1 align="center">홈페이지</h1>
<h1>-------------------------------------------------------------------------</h1>	
<ul>
		<div>
			<h1>메인</h1>
				<li><h3><a href="main">메인</a></h3></li>	
				<li><h3><a href="login">로그인</a></h3>
				<li><h3><a href="signUp">회원가입</a></h3>
				<li><h3><a href="NlistNotice">공지사항</a></h3>
				<li><h3><a href="Heart">찜</a></h3>
			<h1>-------------------------------------------------------------------------</h1>	
		</div>
		
		<div>
		<h1>일반고객</h1>
			<li><h3><a href="clientNovelListForCate">일반회원 카테고리별 소설목록 페이지</a></h3>
			<li><h3><a href="clientLeave">일반회원 탈퇴페이지</a></h3>
			<li><h3><a href="clientOrder">일반회원 주문하기</a></h3>
			<li><h3><a href="clientCart">일반회원 장바구니</a></h3>
			<li><h3><a href="clientLibrary?mnum=${login.mnum}">일반회원 내 서재</a></h3>
			<li><h3><a href="clientOrderList?mnum=${login.mnum}">일반회원 구매내역</a></h3>
			<li><h3><a href="clientPay?mnum=${login.mnum}">일반회원 충전하기</a></h3>
			<li><h3><a href="clientUpdate">일반회원 개인정보수정</a></h3>
			<li><h3><a href="clientMypage">일반회원 마이페이지</a></h3>
			<li><h3><a href="clientNovelInfo">일반회원 소설요약</a></h3>
			<li><h3><a href="clientViewer">일반회원 뷰어</a></h3>
			<li><h3><a href="listRequestWriter">작가 신청 관리</a></h3>
			<h1>-------------------------------------------------------------------------</h1>	
		</div>
		
		<div>
		<h1>작가</h1>
			<li><h3><a href="writerNovel">소설 작성</a></h3>
			<li><h3><a href="writerNovelList?mnum=${login.mnum}">소설 리스트</a></h3>
			<li><h3><a href="writerChart">Chart</a></h3>
			<li><h3><a href="writerLibrary">작가 소설 구매 내역</a></h3><!-- 추후 삭제 -->
			<li><h3><a href="writerOrderList">주문 리스트</a></h3>
			<li><h3><a href="writerPay">작가 Pay</a></h3>
		<h1>-------------------------------------------------------------------------</h1>	
		</div>
		
		<div>
		<h1>게시판</h1>
			<li><h3><a href="listBoard">자유게시판</a></h3>
		<h1>-------------------------------------------------------------------------</h1>		
		</div>
		
		<div>
		<h1>관리자</h1>
			<li><h3><a href="homepage">관리자 페이지</a></h3>
			<li><h3><a href="slide">슬라이드 관리</a></h3>
			<li><h3><a href="insertSuggest">추천작 추가</a></h3>
			<li><h3><a href="listSuggest">추천작 목록</a></h3>
			<li><h3><a href="insertCate">카테고리 추가</a></h3>
			<li><h3><a href="listCate">카테고리 목록</a></h3>
			<li><h3><a href="insertNotice">공지사항 추가</a></h3>
			<li><h3><a href="listNotice">공지사항 목록</a></h3>
			<li><h3><a href="listBoardAdmin">게시판 관리</a></h3>
			<li><h3><a href="listClient">회원 관리</a></h3>
			<li><h3><a href="listWriter">작가 관리</a></h3>
			<li><h3><a href="listUpgradeClient">작가 신청 관리</a></h3>
			<li><h3><a href="saleManageClient">회원 매출 관리</a></h3>
			<li><h3><a href="saleManageWriter">작가 매출 관리</a></h3>
			<li><h3><a href="saleTotal">총 매출 관리</a></h3>
		<h1>-------------------------------------------------------------------------</h1>		
		</div>	
</ul>

</body>
</html>
