<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  application.getContextPath() 서버 경로==> " / " -->
<form action="<%= application.getContextPath() %>sumCalculation" method="post">
	start : <input type="text" id="start" name="start"></input>
	end : <input type="text" id="end" name="end"></input>
	<input type="submit"/>
</form>
</body>
</html>