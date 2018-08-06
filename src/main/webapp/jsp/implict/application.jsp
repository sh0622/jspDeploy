<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//request, response, session, out
		//application : 서버 전반적인 정보를 갖고있음(page, request, session, application)
		application.getRealPath("/jsp/implict/application.jsp");
		application.getInitParameter("ADMIN_USER");
	%>
	

	<h3>application</h3>
	application.getContextPath() : <%= application.getContextPath() %> <br> <!-- 현재 서버 path -->
	application.getServletContextName(): <%= application.getServletContextName() %> <br> 
	application.getMajorVersion(): <%= application.getMajorVersion() %> <br> <!-- servlet 버젼 -->
	application.getMinorVersion(): <%= application.getMinorVersion() %> <br>
	application.getRealPath("/jsp/implict/application.jsp") : <%= application.getRealPath("/jsp/implict/application.jsp") %>
	<!-- 실제 서버의 물리적인 주소(절대경로)를 알랴줌  -->
	application.getInitParameter("ADMIN_USER") : <%= application.getInitParameter("ADMIN_USER") %>

</body>
</html>