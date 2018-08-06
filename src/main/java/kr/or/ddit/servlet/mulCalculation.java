package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public mulCalculation() {
		 
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int par1 = Integer.parseInt(request.getParameter("par1"));
		int par2 = Integer.parseInt(request.getParameter("par2"));
		int result = par1 * par2;
		
		System.out.println(result);
		
	}

}
