<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- myLibrary.jsp -->
<html>
<head>
	<title>���� ������ �Ҽ� ���</title>
</head>
<body>
<<<<<<< HEAD
	<table border = "1" width = "95%" align = "center">
		<tr height = "50"><th colspan = "5">���� ������ �Ҽ� ���</th></tr>
		
		<tr height = "30">
		<th>�̹���</th>	
		<th>�Ҽ�(�ø���) ����</th>
		<th>å �б�</th>
		<th>���� ����</th>
		<th>����</th>
	</tr>
	
	<c:if test="${empty #}">
		<tr>
			<td colspan = "5" align = "center">������ �Ҽ� ����� �����ϴ�.</td>
		</tr>
	</c:if>
	
	<td colspan = "1" align = "center">
			<a href = "#">[���ο� �Ҽ� ����]</a>
	</td>
	</table>
=======
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
>>>>>>> main
</body>
</html>
