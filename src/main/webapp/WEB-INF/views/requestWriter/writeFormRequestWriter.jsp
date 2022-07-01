<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="requestWriterSidebar.jsp"/>
<html><head>
<div align="center" style="
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
    width: 60%;
">
	<title>글쓰기</title>
	<script type="text/javascript">
		function check(){
			var member_name = '${login.member_name}';
			if (f.Request_writer.value=="" || f.Request_writer.value!=member_name){
				alert("이름을 다시 입력해 주세요!!")
				f.Request_writer.focus()
				return false
			}
			if (f.Request_subject.value==""){
				alert("제목을 입력해 주세요!!")
				f.Request_subject.focus()
				return false
			}
			if (f.Request_content.value==""){
				alert("내용을 입력해 주세요!!")
				f.Request_content.focus()
				return false
			}
			return true
		}
	</script>
</head>
<body>

	<div align="center">
		<form name="f" action="writeRequestWriter" method="post" onsubmit="return check()">
			<input type="hidden" name="mnum" value="${login.mnum}"/>
			<div>
						<h1>작가 신청</h1>
						<h3>※ 일반회원이 작가로 등업하기 위한 신청서 작성 페이지 입니다.※</h3>
						<h5>※ 등재하고싶은 소설의 간략한 내용을 적어주세요.※</h5>
			</div>
				<div class="mb-3" align="left">	
				  <label for="exampleFormControlInput1" class="form-label">이름</label>
				  <input name="Request_writer" type="text" class="form-control" placeholder="${login.member_name}">
				</div>
				<div class="mb-3" align="left">
				  <label for="exampleFormControlInput2" class="form-label">제목</label>
				  <input name="Request_subject" type="text" class="form-control" placeholder="제목">
				</div>
				<div class="mb-3" align="left">
				  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
				  <textarea name="Request_content" class="form-control" rows="10"></textarea>
				</div>
				
				<div align="center">
					<input type="submit" value="등록">
					<input type="reset" value="다시작성">
					<input type="button" value="홈" onclick="window.location='main'">
				</div>
				
			</tbody>
		</form>
	</div>
	

</body></html>