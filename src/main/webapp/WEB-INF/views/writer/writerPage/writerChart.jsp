<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writerChart -->


<jsp:include page="../../main/header.jsp"/>
<html>

<head>

<title> </title>

<!-- stylesheet -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.11/c3.min.css"/>

</head> 

<body>

<!-- javascript -->

<script src="https://d3js.org/d3.v3.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.11/c3.min.js"></script>

</body>

​

<div id="combochart"></div>

​

<script>

var chart = c3.generate({
	  bindto: "#combochart",
	  data: {
	    columns: [
	      ["에피소드", 1000, 900, 850, 800, 760, 720, 680, 640, 600, 600, 600, 600, 600, 600, 600, 600, 600],
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
	      show : false
	    },
	  },
	});

</script>

​

</html>

<jsp:include page="../../main/footer.jsp"/>