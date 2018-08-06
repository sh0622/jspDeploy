package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DefCompServlet
 */
@WebServlet("/defCompServlet")
public class DefCompServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// view로 위임
		// 파라미터 값 확인할 jsp
		request.getRequestDispatcher("/jsp/defCompResult.jsp").forward(request, response);
		
	}

}
