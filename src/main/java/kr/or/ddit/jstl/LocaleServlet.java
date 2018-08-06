package kr.or.ddit.jstl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocaleServlet
 */
@WebServlet("/localeSelect")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	
		// 1 . 파라미터로 locale 값을 받아 저장
		String locale = request.getParameter("locale");
	
		// null 이면 기본 ko, 아니면 locale로 
		locale = locale == null ? "ko" : locale;
	
		// locale 속성저장
		request.setAttribute("locale", locale);
		//System.out.println(locale);
		
		 */
	
		request.getRequestDispatcher("/jsp/jstl/locale/localeSelect.jsp").forward(request, response);
		
	}


}
