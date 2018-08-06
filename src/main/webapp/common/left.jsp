<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="#">사용자</a></li>
		<li><a href="/studentList?page=1&pageSize=10">학생</a></li> <!-- servlet파일 연결 무조건 1페이지를 조회하게끔,, -->
		<li><a href="/lprodList?page=1&pageSize=10">lprod테이블</a></li>
		<li><a href="/boardTestList?page=1&pageSize=10">게시판 테이블</a></li>
		<!-- @WebServlet("/studentList") -->
	</ul>
</div>