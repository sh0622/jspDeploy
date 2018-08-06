package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {

	//session객체를 얻어온다
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/** 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
	}

	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo student = session.selectOne("student.getStudentId",id);
		session.close();
		
		return student;
	}

	@Override
	public StudentVo getStudent(StudentVo setdentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo student = session.selectOne("student.getStudentVo",setdentVo);
		session.close();
		
		return student;
	}

	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList", map);
		session.close();
		
		return studentList;
	}

	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int stdTotCnt = session.selectOne("student.getStudentTotCnt");
		session.close();
		
		return stdTotCnt;
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int stdUpdateCnt = session.update("student.studentUpdate", studentVo);
		session.commit();
		session.close();
		
		return stdUpdateCnt;
	}
	

}
