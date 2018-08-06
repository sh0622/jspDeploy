package kr.or.ddit.boardTest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.boardTest.model.BoardTestVo;

public interface BoardTestServiceInf {

	/** 
	 * Method : getAllList
	 * 최초작성일 : 2018. 7. 12. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 게시판 전체 리스트 조회
	 */
	public List<BoardTestVo> getAllList();

	/** 
	 * Method : getPageAllList
	 * 최초작성일 : 2018. 7. 12. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param pageNivMap
	 * @return 
	 * Method 설명 : 전체 건수와 페이지 네이션 된 전체 리스트를 가져오는 서비스(통합)
	 */
	public Map<String, Object> getPageAllList(Map<String, Integer> pageNivMap);
	
}
