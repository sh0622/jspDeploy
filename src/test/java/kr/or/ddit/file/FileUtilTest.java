package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class FileUtilTest {

	
	@Test
	public void getFileNametest() {
		/***Given***/
		String contentDispostion = "form-data; name=\"uploadFile\"; filename=\"cony.png\"";

		/***When***/
		String fileName = FileUtil.getFileName(contentDispostion);
		System.out.println(fileName);
		
		/***Then***/
		assertEquals("cony.png", fileName);

	}

}
