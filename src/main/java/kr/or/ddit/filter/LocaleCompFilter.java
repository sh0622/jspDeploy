package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Servlet Filter implementation class LocaleCompFilter
 */
//@WebFilter("/localeSelect")
public class LocaleCompFilter implements Filter {
   
	private Logger logger = (Logger) LoggerFactory.getLogger(LocaleCompFilter.class);
	
	public LocaleCompFilter() {
		
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		logger.debug(req.getRequestURI() + " : LocaleCompFilter doFilter");

		LocaleCompWrapper localeCompWrapper = new LocaleCompWrapper(req);
		
		chain.doFilter(localeCompWrapper, response);
		//chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
