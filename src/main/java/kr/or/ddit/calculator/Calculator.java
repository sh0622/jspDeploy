package kr.or.ddit.calculator;

/**
 * Calculator.java
 * 
 * @author PC12
 * @since 2018. 7. 6.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *
 
수정일
 
수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 6. PC12 최초 생성
 *
 * </pre>
 */
public class Calculator {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		/* 덧셈 */
		int addResult = cal.add(5, 6);
		
		if(addResult == 11)
			System.out.println("덧셈결과가 올바릅니다");
		else
			System.out.println("덧셈결과가 틀렸습니다");
		
		//////////////////////////////////////////////////////
		
		/* 뺄셈 */
		int minusResult = cal.minus(6, 4);
		if(minusResult == 2)
			System.out.println("뺄셈 결과가 올바릅니다");
		else
			System.out.println("뺄셈 결과가 틀렸습니다");
		
		//////////////////////////////////////////////////////
		
		// mul : 곱하기, div : 나누기
		
		/* 곱하기 */
		int mulResult = cal.mul(2, 2);
		if(mulResult == 4)
			System.out.println("곱셈 결과가 올바릅니다");
		else
			System.out.println("곱셈 결과가 틀렸습니다");
		
		
		int divResult = cal.div(8, 4);
		if(divResult == 2)
			System.out.println("나눗셈 결과가 올바릅니다");
		else
			System.out.println("나눗셈 결과가 틀렸습니다");
	}
	

	/** 
	 * Method : div
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param i
	 * @param j
	 * @return 
	 * Method 설명 : 나눗셈
	 */
	int div(int i, int j) {
		if(j==0)
			return 0;
		else
			return i / j;
	}


	/** 
	 * Method : mul
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param i
	 * @param j
	 * @return 
	 * Method 설명 : 곱셈
	 */
	int mul(int i, int j) {
		return i * j;
	}


	/** 
	 * Method : minus
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param i
	 * @param j
	 * @return 
	 * Method 설명 : 계산기의 뺄샘 기능
	 */
	int minus(int i, int j) {
		return i-j;
	}


	/** 
	 * Method : add
	 * 최초작성일 : 2018. 7. 6. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param i
	 * @param j
	 * @return 
	 * Method 설명 : 계산기의 덧셈 기능
	 */
	int add(int i, int j) {
		return i+j;
	}
	
	
	
}
