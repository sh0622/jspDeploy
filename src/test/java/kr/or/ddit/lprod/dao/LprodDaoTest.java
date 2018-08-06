package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class LprodDaoTest {
	
	private int lprod_id;
	private LprodVo lv;
	private LprodDaoInf lprodDao;
	private Map<String, Integer> map;
	
	@Before
	public void setup(){
		lprod_id = 1;
		lv = new LprodVo();
		lv.setLprod_id(2);
		lprodDao = new LprodDao();
		
		map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
	}
	
	@Test
	public void selectAllLprodTest(){
		/***Given***/

		/***When***/
		List<LprodVo> lprodList = lprodDao.selectAllLprod();
		
		for(LprodVo vo : lprodList)
			System.out.println(vo);
		
		/***Then***/
		assertEquals(11, lprodList.size());
	}
	
	@Test
	public void selectLprodTestByIdTest(){
		/***Given***/

		/***When***/
		LprodVo lprodvo = lprodDao.selectLprodId(lprod_id);
		
		System.out.println(lprodvo.getLprod_nm());

		/***Then***/
		assertEquals("컴퓨터제품", lprodvo.getLprod_nm());

	}
	
	@Test
	public void selectLprodTestByVoTest(){
		/***Given***/

		/***When***/
		LprodVo lprodvo = lprodDao.selectLprodVo(lv);
		System.out.println(lprodvo.getLprod_nm());

		/***Then***/
		assertEquals("전자제품", lprodvo.getLprod_nm());

	}
	
	/** 
	 * Method : getLprodPageList
	 * 최초작성일 : 2018. 7. 11. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 페이지 리스트 반환
	 */
	@Test
	public void getLprodPageList(){
		/***Given***/
		

		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodPageList(map);
		
		for (LprodVo lprodVo : lprodList) {
			System.out.println(lprodVo);
		}

		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	@Test
	public void getLprodTotCnt(){
		/***Given***/
		

		/***When***/
		int stdTotCnt = lprodDao.getLprodTotCnt();
		System.out.println(stdTotCnt);
		
		/***Then***/
		assertEquals(11, stdTotCnt);
		
	}
	
	
	
}
