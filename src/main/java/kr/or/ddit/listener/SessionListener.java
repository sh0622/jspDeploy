package kr.or.ddit.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;


public class SessionListener implements HttpSessionListener {
// web.xml 에 listener class추가 해줌
	
	private Logger logger = (Logger) LoggerFactory.getLogger(SessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.debug("session id created: " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("session destroyed : " + se.getSession().getId());

	}

}
