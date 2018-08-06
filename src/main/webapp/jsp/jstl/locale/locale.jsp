<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	작성된 msg파일
	msg.properties --> 디폴트파일
	msg_ko.properties 
	msg_en.properties
	msg_ja.properties
	
	basename="디폴트" bundle태그 안에서 msg를 출력할 수 있다.
 --%>
 
 <%
 	pageContext.setAttribute("userId", "brown");
 %>
 
<%-- c:set --%>
<c:set var="userId" value="brown" />

<%--
	setLocale 태그를 통해 임의로 로케일을 수정(일본어로)
	<fmt:setLocale value="ja"/> 하면 프로퍼티스파일에 자동으로 msg_ja 이런 식으로 붙는다.
--%>

<fmt:setLocale value="ja"/> 
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="hello"/><br><br>
	<fmt:message key="visitor">
		<fmt:param value="${userId }"/>
	</fmt:message>
</fmt:bundle>

<!--  변수에 값을 담아 bundle로 사용 -->
<h3>setBundle</h3>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
<fmt:message bundle="${msg }" key="hello"/> <br>
<fmt:message bundle="${msg }" key="visitor">
	<fmt:param value="${userId }"/>
</fmt:message> 

</body>
</html>