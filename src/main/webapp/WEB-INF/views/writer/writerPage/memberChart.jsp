<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerChart -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../main/header.jsp"/>

<head>

<title> </title>

<!-- stylesheet -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.11/c3.min.css"/>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />

</head> 

<body>

<!-- javascript -->

<script src="https://d3js.org/d3.v3.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.11/c3.min.js"></script>

</body>
<div class="mar80">
<h3 class="fonset" align="center">${login.member_name}님의 정산내역</h3>
<div class="chart">
	<div id="combochart" class="posi"></div>
</div>
​


<div class="marginmargin" align="center">
		<table align="center" class="table novel">
			<thead>
			<tr>
				<td colspan="3" align="right"><a href="clientMypage"><button type="button" class="btn btn-light">마이페이지로 가기</button></a></td>
			</tr>
			<tr>
				<th>날짜</th>
				<th>구매수</th>
				<th>정산가격</th>
			</tr>
			</thead>
			<c:if test="${empty sumChart}">
			<tr>
				<td colspan="3">판매가 되지 않았습니다</td>
			</tr>
			</c:if>
			<tbody>
			<c:forEach var="sdto" items="${sumChart}">
			<tr>
				<td align="center">${sdto.MONTH}</td>
				<td align="center">${sdto.COUNT}</td>
				<td align="center">${sdto.COUNT*100}</td>
			</tr>		
			</c:forEach>
			</tbody>
		</table>
	</div>
​</div>
<script>

var chart = c3.generate({
	  bindto: "#combochart",
	  size : {
		  width : 700,
		  height : 500
	  },
	  data: {
		x : "날짜",
	    columns: [
	    	["날짜"<c:forEach var="dto" items="${memberChart}">,"${dto.PURCHASE_DATE}"</c:forEach>],
	    	["구매수"<c:forEach var="dto" items="${memberChart}">,${dto.COUNT}</c:forEach>
	    ],
	    ],
	    types: {
	      pension1: "area",
	    },
	    colors: {
	      pension1: "#337ab7",
	    },
	  },
	  bar: {
	    width: {
	      ratio: 0.2,            
	    },
	  },
	  axis: {
	    x: {
	      show : false,
	      type : "category",
	    },
	  },
	});
</script>

<jsp:include page="../../main/footer.jsp"/>