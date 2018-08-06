package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodService implements LprodServiceInf {

	LprodDaoInf ld = new LprodDao();
	
	@Override
	public List<LprodVo> selectAllLprod() {
		return ld.selectAllLprod();
	}

	@Override
	public LprodVo selectLprodId(int lprod_id) {
		return ld.selectLprodId(lprod_id);
	}

	@Override
	public LprodVo selectLprodVo(LprodVo lprodvo) {
		return ld.selectLprodVo(lprodvo);
	}

	// 페이지 리스트와 건수를 한꺼번에 가져오기 
	@Override
	public Map<String, Object> getLprodPageList(Map<String, Integer> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 페이지 리스트 저장
		List<LprodVo> lprodList = ld.getLprodPageList(map);
		resultMap.put("pageList", lprodList);
				
		// 학생 전체 건수 저장
		int totCnt = ld.getLprodTotCnt();
		resultMap.put("totCnt", totCnt);
		
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}
	
	
	public String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if(mod>0){
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page -1;
		int nextPage = page == cnt ? page : page +1;
		
		pageNaviStr.append("<li> <a href=\"/lprodList?page="+ prevPage +"&pageSize="+ pageSize +"\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span></a> </li>");
		
		for(int i=1; i<=cnt; i++){
			String activeClass = "";
			
			if(i==page){
				activeClass = "class=\"active\"";
			}
			
			pageNaviStr.append("<li " + activeClass +"> <a href=\"/lprodList?page=" + i + "&pageSize="+ pageSize + "\">" + i + "</a></li>");
		}
		
		pageNaviStr.append("<li> <a href=\"/lprodList?page="+ nextPage +"&pageSize="+ pageSize +"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");

		
		return pageNaviStr.toString();
	}

}
