<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- writeForm.jsp -->
<html>
<head>
	<title>글쓰기</title>
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
		<form name="f" action="write_board.do" method="post" onsubmit="return check()">
			<table border="1" width="500">
				<tr bgcolor="yellow">
					<td colspan="2" align="center">글 쓰 기</td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">이 름</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">제 목</th>
					<td><input type="text" name="subject" size="50"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">Email</th>
					<td><input type="text" name="email" size="50"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">내 용</th>
					<td><textarea name="content" rows="11" cols="50"></textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">비밀번호</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td align="center" colspan="2">
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" onclick="window.location='list_board.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>