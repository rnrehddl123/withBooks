<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="requestWriterSidebar.jsp"/>
<html><head>
<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 60%;
">
<!-- updateForm.jsp -->
	<title>글수정</title>
	<script type="text/javascript">
		function check(){
			if (f.writer.value==""){
				alert("이름을 입력해 주세요!!")
				f.writer.focus()
				return false
			}
			if (f.subject.value==""){
				alert("제목을 입력해 주세요!!")
				f.subject.focus()
				return false
			}
			if (f.content.value==""){
				alert("내용을 입력해 주세요!!")
				f.content.focus()
				return false
			}
			if (f.passwd.value==""){
				alert("비밀번호를 입력해 주세요!!")
				f.passwd.focus()
				return false
			}
			return true
		}
	</script>
</head>
<body>
	<div align="center">
		<form name="f" action="updateRequestWriter" method="post" onsubmit="return check()">
			<div>
						<h1>신청서 수정</h1>
			</div>
				<div class="mb-3" align="left">	
				  <label for="exampleFormControlInput1" class="form-label">이름</label>
				  <input name="RequestWriter_writer" type="text" class="form-control" id="exampleFormControlInput1" placeholder="name">
				</div>
				<div class="mb-3" align="left">
				  <label for="exampleFormControlInput2" class="form-label">제목</label>
				  <input name="RequestWriter_subject" type="text" class="form-control" id="exampleFormControlInput2" placeholder="제목">
				</div>
				<div class="mb-3" align="left">
				  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
				  <textarea name="RequestWriter_content" class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
				</div>
				
				<div align="center">
					<input type="submit" value="등록">
					<input type="reset" value="다시작성">
					<input type="button" value="홈" onclick="window.location='main'">
				</div>
				
			</tbody>
		</form>
	</div>
</body>
</html>