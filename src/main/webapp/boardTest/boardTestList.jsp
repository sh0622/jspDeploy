<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<title>게시판 Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>글번호</th>
									<th>글제목</th>
									<th>글쓴이</th>
									<th>날짜</th>
								</tr>
								<c:forEach items="${boardList}" var="vo">
									<tr>
										<td>${vo.board_no}</td>
										<td>${vo.board_title}</td>
										<td>${vo.board_writer}</td>
										<td>${vo.board_date}</td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
<!-- 								<li><a href="#">1</a></li> -->
<!-- 								<li><a href="#">2</a></li> -->
<!-- 								<li><a href="#">3</a></li> -->
<!-- 								<li><a href="#">4</a></li> -->
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