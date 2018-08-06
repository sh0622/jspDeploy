package kr.or.ddit.boardTest.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.boardTest.model.BoardTestVo;

public interface BoardTestDaotInf {
	
	
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
	 * Method 설명 : 게시판 페이지에 맞는 리스트 조회
	 */
	public List<BoardTestVo> getPageAllList(Map<String, Integer> pageNivMap);
	
	/** 
	 * Method : getAllCnt
	 * 최초작성일 : 2018. 7. 12. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 게시판 전체 건수 조회
	 */
	public int getAllCnt();
	
}
