package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */

@WebServlet("/fileUpload")

/*
 - maxFileSize
 : 업로드 파일의 최대 크기 값, 기본 값은 -1 (크기 제한 없음) 
 - maxRequestSize
 : HTTP 요청의 최대 크기 값, 기본 값은 -1 (크기 제한 없음) 
 - location 
 : 파일 저장 경로, 파일은 Part의 write 메서드가 호출될 때 저장
 
 - bytes
   : 1kb = 1024  
   : 1MB = 1kb * 1000
   : 5MB = 1MB * 5 == 1KB * 1000 * 5 = 1024 * 1000 * 5 
 */
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
    
	//* file은 반드시 method=post 타입으로 보내야한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//parameter : userId, uploadFile
		//일반 텍스트 파라미터는 request.getParamter를 통해서 얻을 수 있다.
		//파일의 경우 request.getPart를 통해서 얻을 수 있다.
		logger.debug("contentType : " + request.getContentType());
		logger.debug("userId : " +  request.getParameter("userId"));
		//logger.debug("uploadFile : " + request.getParameter("uploadFile"));
		
		// getPart : jsp 에서 파일이 선택이 됐는지 확인 하고 정보 저장
		Part uploadFilePart = request.getPart("uploadFile");
		// logger.debug("part getName : " + uploadFilePart.getName());
		
		// file 이름에 대한 정보를 획득 : request.getHeader("Content-Disposition")
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition"); //form-data; name="uploadFile"; filename="sally.png"
		logger.debug("contentDisposition :  "+ contentDisposition);
		
		// 파일이름 저장
		String fileName = FileUtil.getFileName(contentDisposition);
		logger.debug("fileName : " + fileName);
		
		// 파일 저장 경로 설정
		// 실무 : 별도 storage
		// 개발환경 : 임의 영역(서버 변경시, 재가동시 업로드 파일 삭제됨)
		
		// /fileUpload 디렉토리에 임의로 작성
		// D:\A_TeachingMaterial\7.JspSpring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\fileUpload
		
		// url --> realpath : application 객체에서 제공해주는 메소드
		// doPost 메소드 안에서 application(servletConext) 객체를 구한다
		
		// servlet context 구하는 방법
		// 1. request.getServletContext()
		// 2. getServletContext() : 서블릿에서 제공해주는 메소드
		
		// 1.임의의 배포경로 => url 통해 접근이 가능(주소창에), 서버가 클린되면 다 사라짐
		//ServletContext servletContext = getServletContext();
		//String path = servletContext.getRealPath("/fileUpload");
		
		// 2.고정된 영역으로 배포 
		String path = FileUtil.fileUploadPath;
		
		
		// file size가 정상적인 경우에만 업로드 하기
		if(uploadFilePart.getSize() > 0){
			//uploadFilePart.write(path + File.separator + fileName); // File.separator  : os 환경에 맞게 변경해줌 "\\"
			
			// 사용자가 업로드한 실제 파일명은 디비상에 저장하고, 물리적 파일명은 임의로 적용한다. 
			uploadFilePart.write(path + File.separator + UUID.randomUUID().toString());
			
			// path : D:\A_TeachingMaterial\7.JspSpring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\fileUpload
			// fileName : sally.png
			uploadFilePart.delete();
		}
		
	}
}
