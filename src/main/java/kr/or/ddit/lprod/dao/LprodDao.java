package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class LprodDao implements LprodDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
			
	/** 
	 * Method : selectAllLprod
	 * 최초작성일 : 2018. 7. 9. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 전체 lprod 정보를 조회한다.
	 */
	@Override
	public List<LprodVo> selectAllLprod() {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.selectAllLprod");
		session.close();
		
		return lprodList;
	}

	/** 
	 * Method : selectLprod
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param lprod_id
	 * @return 
	 * Method 설명 : lprod 정보 조회
	 */
	@Override
	public LprodVo selectLprodId(int lprod_id) {
		SqlSession session = sqlSessionFactory.openSession();
		LprodVo lprodvo = session.selectOne("lprod.selectLprodId",lprod_id);
		session.close();
		
		return lprodvo;
	}

	/** 
	 * Method : selectLprodVo
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param lprodvo
	 * @return 
	 * Method 설명 : lprod 정보 조회
	 */
	@Override
	public LprodVo selectLprodVo(LprodVo lprodvo) {
		SqlSession session = sqlSessionFactory.openSession();
		LprodVo vo = session.selectOne("lprod.selectLprodVo", lprodvo);
		session.close();
		
		return vo;
	}
	
	
	/** 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 11. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param map
	 * @return 
	 * Method 설명 : lprod 페이지 리스트 반환
	 */
	@Override
	public List<LprodVo> getLprodPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> vo = session.selectList("lprod.getLprodPageList", map);
		session.close();
		
		return vo;
	}
	
	/** 
	 * Method : getLprodTotCnt
	 * 최초작성일 : 2018. 7. 11. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : lprod 전체 갯수 반환
	 */
	@Override
	public int getLprodTotCnt() {
	SqlSession session = sqlSessionFactory.openSession();
	int cnt = session.selectOne("lprod.getLprodTotCnt");
	session.close();
	
	return cnt;
	}
	
	

}
