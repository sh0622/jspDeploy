package kr.or.ddit.boardTest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.boardTest.model.BoardTestVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class BoardTestDao implements BoardTestDaotInf {

	//session객체를 얻어온다
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<BoardTestVo> getAllList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardTestVo> allList = session.selectList("boardTestxml.getAllList");
		session.close();
		
		return allList;
	}

	@Override
	public List<BoardTestVo> getPageAllList(Map<String, Integer> pageNivMap) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardTestVo> pageAllList = session.selectList("boardTestxml.getPageAllList", pageNivMap);
		session.close();
		
		return pageAllList;
	}

	@Override
	public int getAllCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int allCnt = session.selectOne("boardTestxml.getAllCnt");
		session.close();
		
		return allCnt;
	}
	
}
