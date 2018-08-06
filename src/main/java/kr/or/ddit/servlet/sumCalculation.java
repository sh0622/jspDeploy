package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sumCalculation() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getParameter 사용자가 보낸 파라미터를 받아오는 작업
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int result = 0;
		
		//PrintWriter pw = response.getWriter();
		
		if(start>end){
			result = 0;
		}else{
			for(int i=start; i<=end; i++){
				result += i;
			}
		}
		
		//request 객체에 일시적으로 값을 저장하는 방법
		request.setAttribute("sumResult", result);
		
	
		//session에 sumResult를 저장한다.
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumResult.jsp");
		rd.forward(request, response);
		
		//System.out.println(result);
		/*pw.print(result);
		pw.close();*/
	}

}
