<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type = "text/javascript">
		function success(){
			var msg = window.confirm("�� ��Ͽ� �߰� �Ǿ����ϴ�")
			if(msg){
				location.href("clientHeartList")
				return
			}else{
				location.href("clientHeartList")
				return
			}
		}
	</script>
	
	<c:if test="${'success' == requestScope.result}">
		<script type = "text/javascript">
			success()
		</script>
	</c:if>
	
	<c:if test="${'success' != requestScope.result}">
		location.href = "clientHeartList"
	</c:if>