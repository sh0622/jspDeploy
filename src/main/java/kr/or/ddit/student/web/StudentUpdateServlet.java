package kr.or.ddit.student.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentUpdateViewServlet
 */
@WebServlet("/studentUpdate")
@MultipartConfig(maxFileSize = 1024 * 1000 * 5, maxRequestSize = 1024 * 1000 * 16)
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 학생 정보 수정 화면
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent(id);

		request.setAttribute("studentVo", studentVo);
		request.getRequestDispatcher("/student/studentUpdate.jsp").forward(
				request, response);

	}

	// 학생 정보 수정
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 파라미터 확인
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");

		// 첨부파일 받기
		Part picPart = request.getPart("pic");

		// 학생 정보 조회
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent(id);

		// 파라미터로 받은 값을 vo에 설정
		studentVo.setName(name);
		studentVo.setAddr1(addr1);
		studentVo.setAddr2(addr2);
		studentVo.setZipcd(zipcd);

		// if(프로필 이미지를 올린 경우) : 신규 이미지 사용
		// db에 있는 값을 조회 해서 사용

		if (picPart.getSize() > 0) {
			// 업로드당시 파일명(pic)
			// uuid를 통해 임의의 파일명을 하나 작성(picname)
			// 업로드 할 경로(FileUtil.fileUploadPath)

			String contentDisposition = picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picpath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();

			studentVo.setPic(pic);
			studentVo.setPicpath(picpath);
			studentVo.setPicname(picname);

			picPart.write(picpath + File.separator + picname);
			picPart.delete(); // 임시영역 불필요하니까 삭제
		}

		// 항생정보 업데이트
		studentService.studentUpdate(studentVo);

		// 학생정보 상세조회 화면으로 이동
		/*
		 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		 * ★★★★★★★★★★★★★★★★★★★★★★★★★ - forward : (요청1번) 계속 업데이트가 일어남 ex) 게시글등록 ,
		 * 새로고침 시 계속 등록이 됨
		 * 
		 * - redirect : (요청2번) 클라이언트에게 최초요청(update) > 로직처리 > 클라이언트에게 다른 주소로
		 * 재요청하라고 응답(조회) > redirect 정보를 바탕으로 재요청 서버상에서 데이터의 변경이 일어날 때 redirect
		 * 사용 F5 키를 누르고 새로고침 할경우 마지막 요청에 대해 반복하는것이기 때문에 ex) 게시글 수정
		 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		 */
		request.setAttribute("studentVo", studentVo);
		
		response.sendRedirect("/studentDetail?id=" + id);

	}
}
