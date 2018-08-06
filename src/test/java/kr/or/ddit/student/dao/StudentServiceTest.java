package kr.or.ddit.student.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	//@Before --> @Test --> @After 
	
	//테스트 메소드 안에 중복되는 내용 : StudentDao 구현체에 대한 생성 로직
	// --> @before 어노테이션이 붙은 setup 메소드 위임 
	//모든 테스트 메소드에서 StudentDao객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	//클래스 변수를 setup메소드에서 초기화 하는 로직이 필요!!! 
	//테스트 메소드에서 StudentService를 생성하는 로직은 삭제
	
	private StudentServiceInf studentService;
	private int id;
	private StudentVo sv;
	private Map<String, Integer> map;
	
	@Before
	public void setup(){
		id = 25;
		sv = new StudentVo();
		sv.setId(24);
		studentService = new StudentService();
		map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
	}
	
	@Test
	public void selectAllStudentsTest(){
		
		/***Given***/

		/***When***/
		List<StudentVo> studentList = studentService.selectAllStudents();
		
		for (StudentVo studentVo : studentList) {
			System.out.println(studentVo);
		}
		/***Then***/
		assertEquals(25, studentList.size());
		
	}
	
	/** 
	 * Method : selectStudent
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : id에 맞는 회원의 정보를 반환
	 */
	@Test
	public void selectStudentTest(){
		/***Given***/

		/***When***/
		StudentVo studentvo = studentService.getStudent(id);
		System.out.println(studentvo.getName());
		
		/***Then***/
		assertEquals("한송희", studentvo.getName());

	}
	
	/** 
	 * Method : selectStudent2
	 * 최초작성일 : 2018. 7. 10. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : vo에 맞는 회원의 정보를 반환
	 */
	@Test
	public void selectStudent2Test(){
		/***Given***/

		/***When***/
		StudentVo studentvo = studentService.getStudent(sv);
		System.out.println(studentvo.getName());
		
		/***Then***/
		assertEquals("윤성호", studentvo.getName());

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
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		
		// 학생 페이지 리스트
		List<StudentVo> pageList = (List<StudentVo>) resultMap.get("pageList");
		
		// 학생 전체 건수
		int totCnt = (int)resultMap.get("totCnt");
		
		/***Then***/
		assertEquals(5, pageList.size());		// 학생 페이지 리스트 건수에 대한 검증
		assertEquals(25, totCnt);				// 학생 전체 건수에 대한 검증
	}
	
	/** 
	 * Method : calculatePageNavi
	 * 최초작성일 : 2018. 7. 11. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 전체 건수를 인자로 페이지 네비게이션 사이즈를 구한다
	 */
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;
		
		int cnt = totCnt / pageSize;		//몫
		int mod = totCnt % pageSize;		//나머지
		
		if(mod>0)
			cnt++;
		
		/***When***/
		
		double naviSize = (totCnt / pageSize);
		//System.out.println(Math.ceil((double)totCnt / (double)pageSize));
		//Math.floor(a);

		/***Then***/

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
		int stdUpdateCnt = studentService.studentUpdate(studentVo);

		/***Then***/
		assertEquals(1, stdUpdateCnt);
		
	}
	
}
