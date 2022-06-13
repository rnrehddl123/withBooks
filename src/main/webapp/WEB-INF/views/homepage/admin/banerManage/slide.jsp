<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../adminHeader.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 슬라이드 관리 페이지</title>

<script type="text/javascript">
	function readURL(input) {
  		if (input.files && input.files[0]) {
    		var reader = new FileReader();
    		reader.onload = function(e) {
      		document.getElementById('preview').src = e.target.result;
   	 	};
    	reader.readAsDataURL(input.files[0]);
  		} else {
    		document.getElementById('preview').src = "";
 		}
	}
</script>

</head>
<body>
<div align="center">
	<form name="f" action="slide" 
							method="post" enctype="multipart/form-data">
	<table border="1" width="1000" height="500">
		<tr>
			<td>
			<input type="file" name="slidet_image" onchange="readURL(this);">
			<img id="preview" />
			</td>
			<td><input type="submit" value="등록하기"></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>
<%@ include file="../../adminFooter.jsp"%>    