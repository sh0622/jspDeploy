R<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- oracle db의 student 테이블을 조회하여 화면에 출력 -->

<%
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
		String sql = "select * from student";	// DB랑 똑같이 작성한다.
		rs = stmt.executeQuery(sql);		
		
		// 5. 결과 처리 : ResultSet객체에 저장되어 있는 자료를 반복문을 이용하여 차례로 읽어와 처리한다.
		System.out.println("=== 실행 결과 ===");
		
		while (rs.next()) {
			// 컬럼의 데이터를 가져오기 위한 메서드는 
			// get자료형() 메서드를 사용하는데 이 메서드의 매개값으로 '컬럼명' 또는 '컬럼번호'를 지정하면 된다.
			// (컬럼 번호는 1번부터 시작한다.)
			/* System.out.println("Lprod_id : "+rs.getInt(1));				
			System.out.println("Lprod_gu : "+rs.getString("lprod_gu"));
			System.out.println("Lprod_nm : "+rs.getString("lprod_nm"));
			System.out.println("--------------------------------");
			 */
			out.write("번호 : " + rs.getInt("std_num")+" / ");
			out.write("이름 : " + rs.getString("std_name")+" / ");
			out.write("국어 : " + rs.getString("std_kor")+" / ");
			out.write("영어 : " + rs.getString("std_eng")+" / ");
			out.write("수학 : " + rs.getString("std_mat")+"<br><br>");
			
		}
	
		System.out.println("출력 완료");
		
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
</body>
</html>