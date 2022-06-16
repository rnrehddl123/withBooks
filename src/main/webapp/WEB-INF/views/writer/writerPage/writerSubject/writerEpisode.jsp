<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writeEpisode.jsp -->
<jsp:include page="../../../main/header.jsp"/>
<html>
<head>
	<title>writeEpisode</title>
	<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
	<script src="//cdn.quilljs.com/1.3.6/quill.min.js"></script>
	<script type="text/javascript">
		function check(){
			if (f.Epi_content.value==""){
				alert("내용을 입력해 주세요!!")
				f.Epi_content.focus()
				return false
			}
			return true
		}
	</script>
</head>
<link href="resources/css/writer.css" rel="stylesheet" type="text/css" />
	<div align="center">
		<form class="editorWrapper" name="f" action="insertEpisode" method="post" onsubmit="return check()">
			<input type="hidden" value="${login.mnum}" name="mnum">
			<input type="hidden" name="nnum" value="${nnum}">
			<div class="mb-3">
			  <div class="flex"><label for="exampleFormControlInput1" class="form-label">제목</label></div>
			  <input type="text" name="Epi_subject" class="form-control" id="exampleFormControlInput1" required>
			</div>
			<div class="mb-3 box">
				<div class="flex"><label for="exampleFormControlTextarea1" class="form-label">내용</label></div>
			<div class="box">
				<div id="editor">
				</div>
				<input type="hidden" name="Epi_content" id='hidden-input' required>
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
  
  let inputElement = document.getElementById('hidden-input')
  quill.on('text-change', function() {
    inputElement.value = myEditor.children[0].innerHTML;
  });
  
  html.legth
  
  
</script>
<jsp:include page="../../../main/footer.jsp"/>