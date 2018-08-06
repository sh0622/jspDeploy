package kr.or.ddit.cookie.util;

public class CookieUtil {

	/** 
	 * Method : getCookie
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param cookie
	 * @param name
	 * @return 
	 * Method 설명 : 쿠키 조회
	 */
	public String getCookie(String cookie, String name) {
		// cookie  : userId=brown; rememberMe=y
		
		String[] cookies = cookie.split("; ");
		String cookieResult = "";
		
		for (String cookieStr : cookies) {
			String[] cookieNameValue = cookieStr.split("=");
			
			String cookieName = cookieNameValue[0];
			String cookieValue = cookieNameValue[1];
			
			if(name.equals(cookieName)){
				cookieResult = cookieValue;
				break;
			}
		}
		
		return cookieResult;
	
	}

}

/*
		//String[] cookieName = cookie.split("; ");
		//cookieStr : userId=brown, rememberMe=y, checkYn=n
		
		// userId, brown
		// rememberMe, yg
		for(int i=0; i<cookieName.length; i++){
			String[] cookieName2 = cookieName[i].split("=");
			if(cookieName2[0].equals(name)){
				result = cookieName2[1];
			}
		}
		
		for (String str : cookieName) {
			cookieName2 = str.split("=");
			if(str.equals(name)){ //0부터 6번째자리 자른게 name 과 같으면
				result = str.substring(7); 
			}
		}
 */