package kr.or.ddit.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class DefCompFilter
 */
//@WebFilter("/defCompServlet")
// 사용할 servlet, 요청되면 filter도 나와야 하니까, servlet의 url 과 동일하게 /* 로 할 시엔 모든 servlet이 거쳐간다. 
// 현재에는 defCompServlet 만 거쳐가서 위와같이 지정해준다.

public class DefCompFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(DefCompFilter.class);
	
	public DefCompFilter() {

	}

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 전 처리
		HttpServletRequest req = (HttpServletRequest)request; // ServletRequest 타입이라 형변환, url 정보 가져오기
		
		// lock이 걸려있는 map 객체라 임의 등록이 불가능하다. --> wrapper를 통해 해결
		// Map<String, String[]> requestMap = req.getParameterMap();
		// requestMap.put("defComp", new String[]{"valueByFilter"} );
		
		logger.debug(req.getRequestURI() + "DefCompFilter doFilter"); // 정상적으로 작동하는지 확인
		// 요청한 wrapper 클래스에 객체 전달
		DefCompWrapper defCompWrapper = new DefCompWrapper(req);
		//defCompWrapper.getParameter(name);
		

		// filter / servlet 요청처리
		// chain.doFilter(request, response);
		chain.doFilter(defCompWrapper, response);
		
		// 후 처리
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
