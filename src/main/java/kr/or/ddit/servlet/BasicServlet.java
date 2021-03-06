package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{

	@Override
	public void destroy() {
		System.out.println("destroy         ");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init ");
	}
	
	
	/**
	* Method : doGet
	* 최초작성일 : 2018. 7. 2.
	* 작성자 : PC17
	* 변경이력 :
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 현재 날짜를 출력
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		pw.write("hello servlet world");
		pw.println();
		
		Date dt = new Date();
		pw.write("current time " + dt.toString());
		pw.close();
	}

	
}
