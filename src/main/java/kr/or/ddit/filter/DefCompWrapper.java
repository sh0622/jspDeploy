package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// 수정을 요청하는 래퍼 클래스
//1. 필터를 통해 변경하고싶은 요청 정보가 있다면 HttpServletRequestWrapper에서 이미 정의되어있는 메서드를 오버라이딩 하여 재정의시킨다.
//   그리고 구현한 래퍼 클래스의 객체를 FilterChain의 doFilter() 메서드에 넘겨주면 된다. 

public class DefCompWrapper extends HttpServletRequestWrapper{
	
	private Map<String, String[]> map;
	
	public DefCompWrapper(HttpServletRequest request){
		super(request);
		
//		파라미터 얻어오는 메서드를 재작성, 안 그러면 원래 request객체에 있는 메서드 사용하려고 하기 때문에
//		map 객체에 새로운 파라미터를 넣기 위해 
		
//		request.getParameter(name)
//		request.getParameterValues(name);
//		request.getParameterMap();
//		request.getParameterNames();
		
		// 2. 전달받은 request 객체의 파라미터 정보를 map을 복사하여 저장한다.
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		// defComp 파라미터를 확인하고 없으면 등록(defComp는 dmfComp.jsp에서의 name으로 파라미터가 저장된 key값)
		String[] defComps = map.get("defComp");
		
		// defComp파라미터가 null 혹은 whiteSpace인 경우 --> 기본값으로 설정
		if(defComps == null || defComps[0].equals("")) 
			map.put("defComp", new String[]{"defCompValue"});
			
	}


	// 사용자의 파라미터값 수정 위해서 메서드 재정의 오버라이딩
	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		
		// values값이 null이 아니면 첫번째 값을 리턴
		if(values != null)
			return values[0];
		else
			return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return map; // 우리가 만든 map객체를 리턴
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
