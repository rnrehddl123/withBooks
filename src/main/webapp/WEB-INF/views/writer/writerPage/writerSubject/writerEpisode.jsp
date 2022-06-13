<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writeEpisode.jsp -->
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>writeEpisode</title>
	<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
	<script src="//cdn.quilljs.com/1.3.6/quill.min.js"></script>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
	<div align="center">
		<form class="editorWrapper" name="f" action="" method="post" onsubmit="return check()">
			<div class="mb-3">
			  <div class="flex"><label for="exampleFormControlInput1" class="form-label">제목</label></div>
			  <input type="email" class="form-control" id="exampleFormControlInput1">
			</div>
			<div class="mb-3 box">
				<div class="flex"><label for="exampleFormControlTextarea1" class="form-label">내용</label></div>
			<div class="box">
				<div id="editor">
				  <p><br></p>
				</div>
				<input type="hidden" name="quill" id='hidden-input'>
			</div>
			<button type="submit" class="btn btn-primary">등록</button>
		</form>
	</div>
<script>
  var quill = new Quill('#editor', {
    theme: 'snow'
  });
  
  var myEditor = document.querySelector('#editor')
  var html = myEditor.children[0].innerHTML;
  
  let inputElement = document.querySelector('#hidden-input')
  quill.on('text-change', function() {
    inputElement.value = html;
    console.log(html);
  });
</script>
<jsp:include page="../../../main/footer.jsp"/>