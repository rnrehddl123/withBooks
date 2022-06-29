<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerChart -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../main/header.jsp"/>
<html>

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

​
<div class="chart">
<div id="combochart" class="posi"></div>
</div>
​

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
	    	["날짜"<c:forEach var="dto" items="${writerChart}">,"${dto.PURCHASE_DATE}"</c:forEach>],
	    	["구매수"<c:forEach var="dto" items="${writerChart}">,${dto.COUNT}</c:forEach>
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

​

</html>

<jsp:include page="../../main/footer.jsp"/>