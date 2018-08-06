<%@page import="java.io.FileReader"%>
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
<%-- localhost:8180/jsp/jstl/out.jsp --%>
<%
	FileReader reader = new FileReader(application.getRealPath("/main.jsp"));
	pageContext.setAttribute("reader", reader);
%>

<%-- 
<!-- main.jsp 파일 경로가 나옴 -->
<%= application.getRealPath("/main.jsp") %>
 --%>
 
<c:out value="${reader }"></c:out>

</body>
</html>