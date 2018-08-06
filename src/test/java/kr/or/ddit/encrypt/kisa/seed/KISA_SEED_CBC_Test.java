package kr.or.ddit.encrypt.kisa.seed;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SEED_CBC_Test {
	
	private Logger logger = LoggerFactory.getLogger(KISA_SEED_CBC_Test.class);

	/** 
	 * Method : encrytest
	 * 최초작성일 : 2018. 7. 18. 
	 * 작성자 : PC12
	 * 변경이력 :  
	 * Method 설명 : kisa seed 블록 암호화 테스트
	 */
	@Test
	public void encrytest() {
		// 블록 암호화는 비밀번호를 제외한 개인 정보를 암호화 할 때 사용
		// 복호화가 가능한 암호 방식
		
		/***Given***/
		String plainTest = "1234"; // 암호화 하기 전 문자

		/***When***/
		String encryptText = KISA_SEED_CBC.Encrypt(plainTest);		// 암호화시킴 
		String decryptText = KISA_SEED_CBC.Decrypt(encryptText);	// 암호화한 문자열을 복호화함
		
		logger.debug("encryptText : " + encryptText);
		logger.debug("decryptText : " + decryptText);
		
		/***Then***/
		assertEquals(plainTest, decryptText);

	}

}
