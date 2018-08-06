<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
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
	<h3>request</h3>
	표현식 : <%= request.getAttribute("requestScop") %><br>
	EL	   : ${requestScope.requestScop}<br> <!--  키에 맞는 값을 가져옴 -->
	EL	   : ${requestScop}
	
	<h3>session</h3>
	표현식 : <%= session.getAttribute("sessionScop") %><br>
	EL	   : ${sessionScope.sessionScop}<br>
	EL	   : ${sessionScop}

	<h3>application</h3>
	표현식 : <%= application.getAttribute("applicationScop") %><br>
	EL	   : ${applicationScope.applicationScop}<br>
	EL	   : ${applicationScop}

	<h3>sameName</h3>
	EL 	   : ${sameName }  어떤 영역의 값을 가져오니? --> 가장 작은 영역에서 부터 큰 영역으로 검색 
															pageContext -> request -> session -> application <br>	
															
															
															
	<h3>학생 리스트</h3>
	<%-- 표현식 : <%= request.getAttribute("studentList") %> <br><br> --%>
	
	표현식 <br>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CALL_CNT</th>
		</tr>
			<%
				List<StudentVo> studentList = (List<StudentVo>)request.getAttribute("studentList");
			
				for(StudentVo vo2 : studentList){
					pageContext.setAttribute("vo", vo2);
				%>
				
				<tr>
				<td><%= vo2.getId() %></td>
				<td><%= vo2.getName() %></td>
				<td><%= vo2.getCall_cnt() %></td>
				</tr> 
				
			<% } %>
	</table>
	
	<br><br><br><br><br><br><br>
<%-- 	EL	   : ${requestScope.studentList} <br>		 --%>

	EL : 
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CALL_CNT</th>
		</tr>
	<!--  studentList 속성에서 하날 뺴와 -->
	<c:forEach items="${studentList }" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.call_cnt}</td>
		</tr>
	</c:forEach>
	</table>										
</body>
</html>