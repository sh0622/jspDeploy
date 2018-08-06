<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>logging</h3>
<tags:logging/>
<br>
	<c:forEach items="${studentList }" var="studentVo">
		${studentVo.id} / ${studentVo.name } / ${studentVo.call_cnt } / 
		<fmt:formatDate value="${studentVo.reg_dt }" pattern="yyyy.MM.dd"/>
		<br>
	</c:forEach>
<tags:logging/>




<h3 style="color:pink">color logging</h3>


<tags:colorLoggin color="pink" size="20"/>
<br>
	<c:forEach items="${studentList }" var="studentVo">
		${studentVo.id} / ${studentVo.name } / ${studentVo.call_cnt } / 
		<fmt:formatDate value="${studentVo.reg_dt }" pattern="yyyy.MM.dd"/>
		<br>
	</c:forEach>
<tags:colorLoggin color="pink"/>


<h3>prodSelect</h3>
<tags:prod lgu="P101"/>
<tags:prod lgu="P201"/>	
	
	
</body>
</html>