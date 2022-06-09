<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- updateForm.jsp -->
<html>
<head>
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
		<form name="f" action="update_board" method="post" onsubmit="return check()">
			<font size="3">글 수 정</font><p>
			<table border="1" width="500">
				<tr>
					<th bgcolor="yellow" width="20%">이 름</th>
					
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">제 목</th>
					
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">Email</th>
					
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">내 용</th>
					
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">비밀번호</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td align="center" colspan="2">
						<input type="submit" value="글수정">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>