package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Dispatcher : 클라이언트가 최초 요청 한걸 서버안에서 위임?함 (주소가 바뀌지 않은채로)
 */
@WebServlet("/forwardServlet")
public class FowardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ForwardServlet doGet");
		
		//foword.jsp로 위임
		//getRequestDispatcher(위임할 주소)
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/forward.jsp");
		rd.forward(request, response);
	
	}

}