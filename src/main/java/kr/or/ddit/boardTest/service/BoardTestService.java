package kr.or.ddit.boardTest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.boardTest.dao.BoardTestDao;
import kr.or.ddit.boardTest.dao.BoardTestDaotInf;
import kr.or.ddit.boardTest.model.BoardTestVo;

public class BoardTestService implements BoardTestServiceInf {

	BoardTestDaotInf boardDao = new BoardTestDao();
	
	/** 
	 * Method : getAllList
	 * 최초작성일 : 2018. 7. 12. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 게시판 전체 리스트 반환
	 */
	@Override
	public List<BoardTestVo> getAllList() {
		return boardDao.getAllList();
	}
	
	
	/** 
	 * Method : getPageAllList
	 * 최초작성일 : 2018. 7. 12. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param pageNivMap
	 * @return 
	 * Method 설명 : 전체 건수와 페이지 네이션 된 전체 리스트를 가져오는 서비스(통합)
	 */
	@Override
	public Map<String, Object> getPageAllList(Map<String, Integer> pageNivMap) {
		
		Map<String, Object> pageAllMap = new HashMap<String, Object>();
		
		List<BoardTestVo> allList = boardDao.getPageAllList(pageNivMap);
		pageAllMap.put("allList", allList);
		
		int allCnt = boardDao.getAllCnt();
		pageAllMap.put("allCnt", allCnt);
		
		int page = pageNivMap.get("page");
		int pageSize = pageNivMap.get("pageSize");
		
		pageAllMap.put("pageNiv", pageNavi(page, pageSize, allCnt));
		
		return pageAllMap;
	}
	
	
	
	public String pageNavi(int page, int pageSize, int allCnt){
		int cnt = allCnt / pageSize;
		int mod = allCnt % pageSize;
		
		if(mod>0){
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page - 1;
		int nextPage = page == cnt ? page : page + 1;
		
		pageNaviStr.append("<li> <a href=\"/boardTestList.jsp?page="+ prevPage +"&pageSize="+ pageSize +"\" aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&laquo;</span></a> </li>");
		
		for(int i=1; i<=cnt; i++){
			String activeClass = "";
			
			if(i==cnt){
				activeClass = "class=\"active\"";
			}
			pageNaviStr.append("<li " + activeClass +"> <a href=\"/boardTestList?page=" + i + "&pageSize="+ pageSize + "\">" + i + "</a></li>");
		}
		pageNaviStr.append("<li> <a href=\"/boardTestList?page="+ nextPage +"&pageSize="+ pageSize +"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

}
