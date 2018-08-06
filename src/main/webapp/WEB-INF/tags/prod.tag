<%@ tag import="java.sql.SQLException"%>
<%@ tag import="java.sql.ResultSet"%>
<%@ tag import="java.sql.DriverManager"%>
<%@ tag import="javax.naming.spi.DirStateFactory.Result"%>
<%@ tag import="java.sql.PreparedStatement"%>
<%@ tag import="java.sql.Statement"%>
<%@ tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ attribute name="lgu" type="java.lang.String" required="true" %>

<%
	String lgu = (String)jspContext.getAttribute("lgu"); // ctag.jsp의 lgu 값을 받아옴

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB접속 : Connection객체 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc12";
		String pass = "java";
		conn = DriverManager.getConnection(url, user, pass);
		
		// 3. Statement객체 생성 : Statement객체는 Connection객체를 이용해서 생성한다.
		stmt = conn.createStatement();
		
		// 4. SQL문을 Statement객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장한다.
		String sql = "select prod_id, prod_name from prod where prod_lgu = '" + lgu +"'";	// DB랑 똑같이 작성한다.
		rs = stmt.executeQuery(sql);		
		
		// 5. <select> <option value=prod_id>prod_name</option> </select> 을 만든다
		out.write("<select>");
		
		while (rs.next()) {
			out.write("<option value=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
		}
		
		out.write("<select>");
		
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if (rs!=null) try{ rs.close(); }catch (SQLException e2) {}
		if (stmt!=null) try{ stmt.close(); }catch (SQLException e2) {}
		if (conn!=null) try{ conn.close(); }catch (SQLException e2) {}
	}	

%>
