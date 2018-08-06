package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceInf;

/**
 * Servlet implementation class LprodServlet
 */
@WebServlet("/lprodList")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// left.jsp에서 파라미터로 값을 일시적으로 받아서 저장시킴
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		// page가 null일 경우와 아닐 경우 page, pageSize에 저장
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 1 : Integer.parseInt(pageSizeStr);
		
		// map으로 각 값을 저장시킴
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		// lprod 페이지 리스트, 전체 건수 조회
		LprodServiceInf lprodService = new LprodService();
		
		// lprodService의 getLprodPageList에 값을 저장, resultMap 에 list와 pageNavi 가 있다.
		Map<String, Object> resultMap = lprodService.getLprodPageList(paramMap);
		
		// 일시적으로 리스트를 저장 (이름, object)
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("pageList");
		request.setAttribute("lprodList", lprodList);
		
		// 페이지 네비게이션 문자열 저장
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		// request에 저장된 값을 다음 페이지에도 볼 수 있도록 주소에 forward해줌 
		RequestDispatcher rd = request.getRequestDispatcher("/lprod/lprodList.jsp");
		rd.forward(request, response);
	}


}
