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
			<ul class="flex titleWrapper">
				<li>제목</li>
				<li><input type="text"></li>
			</ul>
			<div class="box">
				<div id="editor">
				</div>
				<input type="hidden" name="quill" id='hidden-input'>
			<button type="submit" class="btn btn-primary">등록</button>
			<div class="mb-3">
			  <label for="exampleFormControlInput1" class="form-label">Email address</label>
			  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
			</div>
			<div class="mb-3">
			  <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
			  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
		</form>
	</div>
<script>
  var quill = new Quill('#editor', {
    theme: 'snow'
  });
  
  var myEditor = document.querySelector('#editor')
  var html = myEditor.children[0].innerHTML;
  
  let inputElement = document.getElementById('hidden-input')
  quill.on('text-change', function() {
    inputElement.value = myEditor.children[0].innerHTML;
  });
</script>
<jsp:include page="../../../main/footer.jsp"/>