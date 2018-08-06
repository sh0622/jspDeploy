package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. logout 요청시 session 무효화 작업
		//2. login.jsp 로 redirect
		
		//session획득
		HttpSession session = request.getSession();
		session.invalidate(); //session을 무효화
		
		/*
		  
		• Redirect(단순이동) : Web Container는 Redirect 명령이 들어오면 웹 브라우저에게 다른 페이지로 이동하라고 명령을 내린다.
							그러면 웹 브라우저는 URL을 지시된 주소로 바꾸고 그 주소로 이동한다.
							다른 웹 컨테이너에 있는 주소로 이동이 가능하다. 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
					
							사용자(최초 요청) ---> 서버 페이지 ---> 사용자 ---->서버 페이지 --> 사용자(최종 반환) 2번 요청
					
		• Forward(값을 전달) : Web Container 차원에서 페이지 이동만 있다. 실제로 웹 브라우저는 다른 페이지로 이동했음을 알 수 없다.
								그렇기 때문에, 웹 브라우저에는 최초에 호출한 URL이 표시되고 이동한 페이지의 URL 정보는 볼 수 없다.
								동일한 웹 컨테이너에 있는 페이지로만 이동할 수 있다.
								현재 실행중인 페이지와 Forwad에 의해 호출될 페이지는 request와 response 객체를 공유
							 
								사용자 ---> 서버 페이지 --> 서버페이지 --> 사용자 1번요청 빠름 

		 */
		response.sendRedirect("/login/login.jsp");
		
		
		// 1.loginSession.jsp 확인
		// 2.데이터가 없을 경우 : login.jsp에서 로그인
		//  2-1. loginSession.jsp 확인(값증가)
		//  2-2. main.jsp에서 로그아웃
		//  2-3. loginSession.jsp 확인(값감소)
		// 3.데이터가 있을 경우 : login.jsp
		//  3-1.main.jsp에서 로그아웃
		//  3-2.loginSession.jsp 확인(값감소)
		
	}


}
