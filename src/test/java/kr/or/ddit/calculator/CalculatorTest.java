package kr.or.ddit.calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	/*
	 * beforeClass(@beforeClass) 
	 * setup() (@Before)실행 --> add 테스트 메소드 실행 --> tearDown()(@After)실행
	 * setup() (@Before)실행 --> minus 테스트 메소드 실행 --> tearDown()(@After)실행
	 * setup() (@Before)실행 --> mul 테스트 메소드 실행 --> tearDown()(@After)실행
	 * setup() (@Before)실행 --> div 테스트 메소드 실행 --> tearDown()(@After)실행
	 * afterClass(@afterClass)
	 * 
	 *  ** 테스트 메소드 실행 순서는 보장되지 않는다.
	 */
	
	private Calculator cal;
	private int param1;
	private int param2;
	
	/* static 은 활용빈도가 낮아서 사용 안 함
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void AfterClass(){
		System.out.println("afterClass");
	}
	*/
	
	@Before
	public void setup(){
		System.out.println("before");
		cal = new Calculator();
		param1 = 5;
		param2 = 6;
	}
	
	@After
	public void tearDwon(){
		System.out.println("after");
		
	}

	/** 
	 * Method : addTest
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 계산기의 덧셈 기능 테스트
	 */
	@Test
	public void addTest() {
		/***Given***/

		/***When***/
		int addResult = cal.add(param1, param2);

		/***Then***/
		assertEquals(11, addResult);

	}
	
	/** 
	 * Method : minusTest
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 계산기의 뺄셈 기능 테스트
	 */
	@Test
	public void minusTest(){
		/***Given***/
		
		/***When***/
		int minusResult = cal.minus(param1, param2);

		/***Then***/
		assertEquals(-1, minusResult);
	}
	
	
	/** 
	 * Method : mulTest
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 계산기의 곱셈 기능 테스트
	 */
	
	@Test
	public void mulTest(){
		/***Given***/

		/***When***/
		int mulResult = cal.mul(param1, param2);

		/***Then***/
		assertEquals(30, mulResult);
	}
	
	/** 
	 * Method : divTest
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 계산기의 나눗셈 기능 테스트
	 */
	@Test
	public void divTest(){
		/***Given***/

		/***When***/
		int divResult = cal.div(param1, param2);

		/***Then***/
		assertEquals(0, divResult);
	}
	
	/** 
	 * Method : diveByZeroTest
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : 계산기 나눗셈의 0으로 나누었을 때의 예외 확인 
	 */
	@Test
	public void divZeroTest(){
		/***Given***/
		param2 = 0;
		
		/***When***/
		int divResult = cal.div(param1, param2);
		
		/***Then***/
		assertEquals(0, divResult);

	}
	

}
