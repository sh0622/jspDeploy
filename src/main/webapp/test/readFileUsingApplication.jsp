<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	String resourcePath = "/message/notice.txt";
%>

자원의 실제 경로 : <br>
<%= application.getRealPath(resourcePath) %>
<br>
--------------<br>
<%= resourcePath %>의 내용 <br>
--------------<br>
<%
	char[] buff = new char[128];
	int len = -1;
	
	try(InputStreamReader br = new InputStreamReader(
			application.getResourceAsStream(resourcePath),"utf-8")){
		while((len=br.read(buff))!=-1){
			out.print(new String(buff,0,len));
		}
	} catch(IOException ex){
		out.println("익셉션 발생 : " + ex.getMessage());
	}
%>
</body>
</html>