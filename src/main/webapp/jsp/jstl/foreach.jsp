<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>

 <tr>
  <th>학생ID</th>
  <th>학생이름</th>
  <th>학생호출횟수</th>
 </tr>
 
 <c:forEach items="${studentList }" var="vo" begin="2" end="5" step="2" varStatus="status"> 
	 <tr>
	 	<td>${vo.id} / ${status.index}</td>
	 	<td>${vo.name}</td>
	 	<td>${vo.call_cnt}</td><br>
	 </tr>
 </c:forEach>
 
 <h3>foreach map</h3>
 <%-- map있는 값들을 전부 조회해서 출력
 		map.get("name"), map.get("alias")
  --%> 
<c:forEach items="${map }" var="entry">
	${entry.key }  : ${entry.value }<br>
</c:forEach>  

<%-- 문자열을 ,단위로 잘라서 저장 --%>
<h3>forTokens</h3>
<c:forTokens items="${lineRangers }" delims="," var="ranger">
	${ranger } <br>
</c:forTokens>

</table>
</body>
</html>