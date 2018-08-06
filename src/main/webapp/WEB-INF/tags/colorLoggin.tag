<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 속성 지정 -->
<%@ attribute name="color" type="java.lang.String" required="true" %>
<%@ attribute name="size" type="java.lang.Integer" required="false" %>

<%-- size속성이 들어오지 않으면 기본값으로 30 설정
	if, set
--%>

<%--

<c:if test="${size == null}">
	<c:set var="size" value="30"/>
</c:if>

 --%>
<c:choose>
	<c:when test="${size == null}">
		<c:set var="size" value="50"/>
	</c:when>
	
	<c:when test="${size == 0}">
		<c:set var="size" value="30"/>
	</c:when>
</c:choose>


<font color="${color}">
<c:forEach begin="0" end="${size }">=</c:forEach>



</font>
