<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientBookInfo -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
   <title>clientNovelInfo</title>
   <link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
   <div>
      <table border="1" align="center" width="600" height="600">
         <tr>
            <td align="center" rowspan="2">일러스트</td>
            <td align="center" colspan="3">제목 : </td>
         </tr>
         <tr>
            <td align="center" colspan="3">별점 : </td>
         </tr>
         <tr>
            <td height="10%" align="center" colspan="4">소설 요약</td>
         </tr>
         <tr   height="5%">
            <td colspan="2">제목</td>
            <td>날짜</td>
            <td>조회수</td>
         </tr>
         <tr height="40%">
            <td colspan="4" align="left">
               <ul>
                  <li><h3>소설 목록</h3></li>
                  <li><h3>1</h3></li>
                  <li><h3>for문 활용 1개씩 늘어나가는 목록</h3></li>
               </ul>      
            </td>
         </tr>
      </table>
   </div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>