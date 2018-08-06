package kr.or.ddit.boardTest.web;

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

import kr.or.ddit.boardTest.model.BoardTestVo;
import kr.or.ddit.boardTest.service.BoardTestService;

/**
 * Servlet implementation class BoardTestServlet
 */
@WebServlet("/boardTestList")
public class BoardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*BoardTestService boardTestService = new BoardTestService();
		List<BoardTestVo> allList = boardTestService.getAllList();
		request.setAttribute("allList", allList);*/
		
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 1 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> allMap = new HashMap<String, Integer>();
		
		allMap.put("page", page);
		allMap.put("pageSize", pageSize);
		
		BoardTestService boarderTestService = new BoardTestService();
		
		Map<String, Object> resultMap = boarderTestService.getPageAllList(allMap);
		
		List<BoardTestVo> boardList = (List<BoardTestVo>)resultMap.get("allList");
		request.setAttribute("boardList", boardList);
		
		String pageNavi = (String) resultMap.get("pageNiv");
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/boardTest/boardTestList.jsp");
		rd.forward(request, response);
		
	}


}
