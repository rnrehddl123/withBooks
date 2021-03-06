<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/header.jsp"/>
<jsp:include page="boardSidebar.jsp"/>
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
		<form name="f" action="updateBoard" method="post" onsubmit="return check()">
		 <input type="hidden" name="bnum" value="${param.Bnum}"/>
		 <!-- <c:forEach var="Boarddto" items="${listBoard}"> -->
			<div>
						<h1>게시판 글 수정</h1>
			</div>
				<div class="mb-3" align="left">	
				  <label for="exampleFormControlInput1" class="form-label">이름</label>
				  <input name="Board_writer" type="text" class="form-control" id="exampleFormControlInput1" value="${getBoard.board_writer}" placeholder=${getBoard.board_writer} readOnly>
				</div>
				<div class="mb-3" align="left">
				  <label for="exampleFormControlInput2" class="form-label">제목</label>
				  <input name="Board_subject" type="text" class="form-control" id="exampleFormControlInput2" value="${getBoard.board_subject}" placeholder=${getBoard.board_subject}>
				</div>
				<div class="mb-3" align="left">
				  <label for="exampleFormControlInput3" class="form-label">Email</label>
				  <input name="Board_email" type="text" class="form-control" id="exampleFormControlInput3" value="${getBoard.board_email}" placeholder="name@example.com" readOnly>
				</div>
				<div class="mb-3" align="left" style="white-space:pre;">
				  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
				  <textarea name="Board_content" class="form-control" id="exampleFormControlTextarea1" value="${getBoard.board_content}" rows="10"></textarea>
				</div>
				<div class="mb-3" align="left">
					 <label for="exampleFormControlInput4" class="form-label">비밀번호</label>
					<input name="Board_passwd" type="password" class="form-control" id="exampleFormControlInput3" name="passwd" placeholder="****" value="${getBoard.board_passwd}"></td>
				</div>
			<!-- </c:forEach> -->
				<div align="center">
					<input type="submit" value="등록">
					<input type="reset" value="다시작성">
					<input type="button" value="게시판 목록" onclick="window.location='listBoard'">
				</div>
				
			</tbody>
		</form>
	</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>