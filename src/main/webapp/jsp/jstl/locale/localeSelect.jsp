<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <!-- jquery를 정적include해준다 -->
<%@ include file="/common/jquery.jsp" %>
<script>

//select box 변경시 요청이 되도록 수정
$(function(){
	//페이지 로딩시 select box설정
	$("select[name=locale]").val("${param.locale}").prop("selected",true);
	//$("select[name=locale]").val("ko").prop("selected",true);
	
	//select box 변경 이벤트
	$("select[name=locale]").change(function(){
		console.log("아무거나");
		$("form").submit();
	});
});
</script>


</head>
<body>
<!-- form의 action 주소를 이용해 localeServlet에 넘겨줌 -->
locale : ${locale }
<form action="/localeSelect" method="get">
	<!-- name을 통해 파라미터 값을 넘겨준다 -->
	<select id="locale" name="locale">
		<option value="ko">한국어</option>
		<option value="ja">日本語</option>
		<option value="en">English</option>
	</select>
	<input type="submit" value="submit"/>
</form>
	
	<%-- c:set --%>
	<c:set var="userId" value="brown" />
	
	<%-- setLocale 태그를 통해 임의로 로케일을 수정(일본어로) --%>
	<fmt:setLocale value="${param.locale }"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/><br><br>
		<fmt:message key="visitor">
			<fmt:param value="${userId }"/>
		</fmt:message>
	</fmt:bundle>
	<br>
</body>
</html>