package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// 클라이언트의 응답을 변경시 wrapper 클래스를 이용
public class LocaleCompWrapper extends HttpServletRequestWrapper{
	
	private Map<String, String[]> map;
	
	public LocaleCompWrapper(HttpServletRequest req){
		super(req);
		
		// filter에서 넘겨받은 파라미터값을 map에 저장
		map = new HashMap<String, String[]>(req.getParameterMap());
		
		String[] locale = map.get("locale");
		
		if(locale == null || locale[0].equals(""))
			map.put("locale", new String[]{"ja"});
	}

	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		
		if(values != null)
			return values[0];
		else
			return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return map;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(map.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return map.get(name);
	}
	
	
}
