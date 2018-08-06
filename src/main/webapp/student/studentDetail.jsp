<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$("button").on("click", function(){
		$("#frm").submit();
	});
});
</script>
</head>

<body>

	<%-- top include --%>
	<%@ include file="/common/top.jsp"%>
	<!-- studentDetailServlet으로 넘겨줌 -->
	

	<div class="container-fluid">
		<div class="row">
		
			<%-- left include --%>
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form" action="/studentUpdate" method="get" id="frm">
				
				<%--
				servlet으로 파라미터 넘기기 위한 input
				콘솔의 개발자창에서 $("#frm").serialize() 하면 넘어가는 값 볼 수 있다			
				--%>
				<input type="hidden" name="id" value="${studentVo.id }">
				<input type="hidden" name="name" value="${studentVo.name }">

					<div class="form-group">
						<label for="pic" class="col-sm-2 control-label">프로필</label>
						<div class="col-sm-10">
							<img src="/pic?id=${studentVo.id }"
								style="width: 200px; height: 200px;">
							<%-- picDownloadServlet --%>
						</div>
					</div>


					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">학생 아이디</label>
						<div class="col-sm-10">
							<label class="control-label" >${studentVo.id }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">학생 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.name }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="call_cnt" class="col-sm-2 control-label">호출횟수</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.call_cnt }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.addr1 }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.addr2 }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.zipcd }</label>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" >학생수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
