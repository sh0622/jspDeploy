<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- requestm , session 은 기본객체라 따로 생성 안해주고 바로 쓸수있음 서비스의 인자값으로 왔던 객체 -->
	sumResult : <%= request.getAttribute("sumResult") %> <br>
	
	<%
		HttpSession sess = request.getSession();
	%>
	
	기본객체 session sumResult : <%= session.getAttribute("sumResult") %><br>
	request 객체 session sumResult : <%= session.getAttribute("sumResult") %><br>
</body>
</html>