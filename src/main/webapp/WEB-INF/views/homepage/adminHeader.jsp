<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="resources/css/admin.css" rel="stylesheet" type="text/css" />    
</head>
<body>
<main>
<div class="col-md-3 adminSideBar">
<!-- 사이드 바 메뉴-->
<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
      <span class="fs-4">관리자 페이지</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="slide" class="nav-link active" aria-current="page">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
          	슬라이드 관리
        </a>
      </li>
      <li>
        <a href="suggest" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
          	추천작 관리
        </a>
      </li>
      <li>
        <a href="cateInsert" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg>
          	카테고리 추가
        </a>
      </li>
      <li>
        <a href="cateList" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	카테고리 목록
        </a>
      </li>
      <li>
        <a href="noticeInsert" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	공지사항 추가
        </a>
      </li>
      <li>
        <a href="noticeUpdate" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	공지사항 수정
        </a>
      </li>
      <li>
        <a href="noticeList" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	공지사항 목록
        </a>
      </li>
      <li>
        <a href="boardList" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	게시판 관리
        </a>
      </li>
      <li>
        <a href="clientList" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	회원 관리
        </a>
      </li>
      <li>
        <a href="clientUpgrade" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	작가 신청 관리
        </a>
      </li>
      <li>
        <a href="saleManageClient" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	회원 매출 관리
        </a>
      </li>
      <li>
        <a href="saleManageWriter" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	작가 매출 관리
        </a>
      </li>
      <li>
        <a href="saleTotal" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          	총 매출 관리
        </a>
      </li>
    </ul>
    <hr>
    <div class="dropdown">
      <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
        <strong>mdo</strong>
      </a>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
        <li><a class="dropdown-item" href="#">New project...</a></li>
        <li><a class="dropdown-item" href="#">Settings</a></li>
        <li><a class="dropdown-item" href="#">Profile</a></li>
        <li><hr class="dropdown-divider"></li>
        <li><a class="dropdown-item" href="#">Sign out</a></li>
      </ul>
    </div>
 </div>
		<div class="adminmain">