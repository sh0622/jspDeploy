package kr.or.ddit.cookie.util;

import static org.junit.Assert.*;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;

public class CookieUtilTest {
	
	private String cookie;
	
	@Before
	public void setup(){ //쿠키값 저장
		cookie = "userId=brown; rememberMe=y; checkYn=n";
	}
	
	@Test
	public void cookieNameValueSplitTest(){
		/***Given***/
		String cookie = "userId=brown";

		/***When***/
		String[] cookieArr = cookie.split("=");

		/***Then***/
		assertEquals("userId", cookieArr[0]);
		assertEquals("brown", cookieArr[1]);		
	}

	@Test
	public void getCookieTest() {
		
		/***Given***/
		CookieUtil cookieUtil = new CookieUtil();

		/***When***/
		//userId ==> brown
		String cookieValue = cookieUtil.getCookie(cookie,"userId");

		/***Then***/
		assertEquals("brown", cookieValue);

	}

}

