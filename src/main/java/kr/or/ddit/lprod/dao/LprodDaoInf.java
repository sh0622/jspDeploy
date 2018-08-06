package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodDaoInf {
	/** 
	 * Method : selectAllLprod
	 * 최초작성일 : 2018. 7. 9. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 전체 lprod 정보를 가져온다.
	 */
	List<LprodVo> selectAllLprod();
	
	/** 
	 * Method : selectLprod
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param lprod_id
	 * @return 
	 * Method 설명 : id에 맞는 lprod정보를 가져온다.
	 */
	LprodVo selectLprodId(int lprod_id);
	
	/** 
	 * Method : selectLprod
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param lprod_id
	 * @return 
	 * Method 설명 : id에 맞는 lprod정보를 가져온다.
	 */
	LprodVo selectLprodVo(LprodVo lprodvo);
	
	/** 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 11. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param map
	 * @return 
	 * Method 설명 : lprod 페이지 리스트 반환
	 */
	List<LprodVo> getLprodPageList(Map<String, Integer> map);
	
	/** 
	 * Method : getLprodTotCnt
	 * 최초작성일 : 2018. 7. 11. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : lprod 전체 갯수 반환
	 */
	int getLprodTotCnt();
	
}
