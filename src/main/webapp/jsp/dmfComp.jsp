<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/defCompServlet" method="post">
<%-- name 값이 파라미터 값 --%>
	<input type="text" name="defComp"/>
	<input type="submit" value="전송"/>
</form>
</body>
</html>