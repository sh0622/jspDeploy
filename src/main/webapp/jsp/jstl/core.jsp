<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  core 라이브러리 사용 ==> jstl 사용을 하기 위해 taglib 지시자 작성 
      page 지시자 : page에 대한 설정
      include : 다른 jsp를 포함할 때 사용
      taglib : 태그라이브러리 등록할때 사용
      
      prefix 는 기본적으로 core라이브러리를 c로 표현
      uri는 core위치를 설정
 --%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- loaclhost:8180/jsltServlet --%>
request.userId : ${userId} / ${requestScope.userId} <br><br>

<!--  set : 특정 영역에 변수를 새로 생성 (defualt : page) 영역을 지정 해주면 거기에 들어감..
	pageContext.setAttribute("test", "testValue"); 해주는 값과
	<c:set var="test" value="testValue"/> 값과 동일하다.
	
	일반적으로는 servlet에서 setAttribute...해주어서 사용빈도가 높진ㅇ ㅏㄶ다.
-->

<%
	pageContext.setAttribute("test", "testValue");  
%>

c:set: <c:set var="test" value="testValue"/> ${test } <br><br>

pageContext.getAttribute("test") : <%= pageContext.getAttribute("test") %>

<h3>c:set scope</h3>
c:set: <c:set var="test" value="testSessionValue" scope="session"/> ${test } / ${sessionScope.test} <br><br>

<!-- el은 영역이 작은 곳 부터 큰곳으로 순차 검색되기 때문에 값이 testValue가 나온다..
	다르게 주려면 scope를 이용하여 가져옴
	page -> request -> session -> application
-->

<h3>c:set target, property</h3>
${studentVo }<br>

<c:set target="${studentVo }" property="name" value="brown"/>
${studentVo }<br>

</body>
</html>