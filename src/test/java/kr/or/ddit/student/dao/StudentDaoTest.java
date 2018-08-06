package kr.or.ddit.student.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {

	//@Before --> @Test --> @After 
	
	//테스트 메소드 안에 중복되는 내용 : StudentDao 구현체에 대한 생성 로직
	// --> @before 어노테이션이 붙은 setup 메소드 위임 
	//모든 테스트 메소드에서 StudentDao객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	//클래스 변수를 setup메소드에서 초기화 하는 로직이 필요!!! 
	
	private int id;
	private StudentVo studentvo;
	private StudentDaoInf studentDao;
	private Map<String, Integer> map ;
	
	@Before
	public void setup(){
		id = 25;
		studentvo = new StudentVo();
		
		studentvo.setId(24);
		studentDao = new StudentDao();
		
		map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);
		
		
		
	}
	
	//test 조건에 따라 맞을수도 있고 아닐수도 있다 ?? 
	
	/** 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Test
	public void selectAllStudentsTest() {
		/***Given***/
		
		/***When***/
		List<StudentVo> studentList = studentDao.selectAllStudents();
		
		for(StudentVo vo : studentList)
			System.out.println(vo);
		
		/***Then***/
		assertEquals(25, studentList.size()); //db에 있는 테이블 갯수와 list사이즈가 동일

	}
	
	/** 
	 * Method : selectStudents
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 학생 정보 조회
	 */
	@Test
	public void selectStudentsByIdTest() {
		/***Given***/
		
		/***When***/
		StudentVo studentvo3 = studentDao.getStudent(id);
		
		/***Then***/
		assertEquals("한송희", studentvo3.getName()); //db에 있는 테이블 갯수와 list사이즈가 동일

	}
	
	/** 
	 * Method : selectStudents2
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 학생 정보 조회
	 */
	@Test
	public void selectStudentsByVoTest(){
		
		/***Given***/

		/***When***/
		StudentVo studentvo2 = studentDao.getStudent(studentvo);

		/***Then***/
		assertEquals("윤성호", studentvo2.getName());
	}
	
	
	/** 
	 * Method : selectStudentsByMap
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 학생 페이지 조회
	 */
	@Test
	public void selectStudentsByMapTest(){
		/***Given***/
		
		/***When***/
		List<StudentVo> studentList = studentDao.getStudentPageList(map);
		
		for (StudentVo studentVo : studentList) {
			System.out.println(studentVo);
		}
		
		/***Then***/
		assertEquals(10, studentList.size());
	}
	
	/** 
	 * Method : selectStudentsByMap
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 세번째 페이지 학생 다섯명인 페이지 조회
	 */
	@Test
	public void selectStudentsByMap2Test(){
		/***Given***/
		
		/***When***/
		List<StudentVo> studentList = studentDao.getStudentPageList(map);
		
		for (StudentVo studentVo : studentList) {
			System.out.println(studentVo);
		}
		
		/***Then***/
		assertEquals(5, studentList.size());
	}
	
	
	@Test
	public void getStudentTotCntTest(){
		/***Given***/

		/***When***/
		int stdTotCnt = studentDao.getStudentTotCnt();
		System.out.println(stdTotCnt);
		
		/***Then***/
		assertEquals(25, stdTotCnt);

	}
	
	@Test
	public void studentUpdateTest(){
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setId(2);
		studentVo.setName("강병관");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("sally.png");
		studentVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");
		studentVo.setPicname("a8787427-fb2d-42dc-862b-a8e4caaf1c76");
		
		/***When***/
		int stdUpdateCnt = studentDao.studentUpdate(studentVo);
		
		/***Then***/
		assertEquals(1, stdUpdateCnt);

	}

}
