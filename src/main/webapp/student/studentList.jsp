<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

<script>
$(function(){
	$("table tbody tr").on("click", function(){
		//tr태그의 data-id 속성 값을 읽어서 input 태그의 id값으로 설정 
		//form태그를 submit
		$("#id").val($(this).data("id"));
		$("#frm").submit();
	});	
});
</script>

</head>
<body>
<!-- 서블릿에 요청하고 studentServlet 에서 학생리스트 전체 불러옴 request에다가 리스트 담아서 jsp에 포워드함 controller랑 view랑 하는 역할다름 -->
	<%@ include file="/common/top.jsp"%>
	
	<!-- studentDetailServlet으로 넘겨줌 -->
	<form action="/studentDetail" method="get" id="frm">
		<input type="hidden" name="id" id="id">
	</form>
	
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">학생</h2>
						<div class="table-responsive">
							<table class="table table-striped">
							<thead>
								<tr>
									<th>학생 ID</th>
									<th>학생 이름</th>
									<th>지명 횟수</th>
									<th>등록일자(yyyy-mm-dd)</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="vo">
								<%-- tr 태그 클릭시 상세 페이지로 이동 css common.css 추가 --%>
									<tr data-id="${vo.id }"> <%-- 클릭시 td의 id값을 가져오기 위해 --%>
										<td>${vo.id}</td>
										<td>${vo.name}</td>
										<td>${vo.call_cnt}</td>
										<td><fmt:formatDate value="${vo.reg_dt}" pattern="yyyy-MM-dd"/>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<%= request.getAttribute("pageNavi") %>
							</ul>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
