package kr.or.ddit.student.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//StudentService 객체를 생성, 학생 전체 리스트를 조회
		//학생 전체 리스트 request객체에 속성으로 설정
		//studentList.jsp로 forward
		
		//page, pageSize 파라미터 
		//-------------------------------------------------------------------------------------------------
		//parameter : 사용자가 입력해서 서버로 넘겨지는 값
		//파라미터값이 없을 경우 ==> 기본값으로 page : 1, pageSize : 10
		//attribute : 조회된 결과를 일시적으로 저장한 값
		
//		request.getParameter(name);
//		request.getAttribute(name);
//		request.setAttribute(name, o);
		
		
		// left.jsp에서 파라미터로 값을 일시적으로 받아서 저장시킴 ==> /studentList?page=1&pageSize=10
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		
		// page가 null일 경우와 아닐 경우 page, pageSize에 저장
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSzie = pageSizeStr == null ? 1 : Integer.parseInt(pageSizeStr);
		
		// map으로 각 값을 저장시킴
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSzie);
		
		// 학생 페이지 리스트, 전체 건수 조회
		StudentServiceInf studenservice = new StudentService();
		
		// studentService의 getStudentPageList에 값을 저장
		// List<StudentVo> studentList = studenservice.getStudentPageList(paramMap);
		Map<String, Object> resultMap = studenservice.getStudentPageList(paramMap);
		
		// 일시적으로 리스트를 저장 (이름, object)
		List<StudentVo> studentList = (List<StudentVo>)resultMap.get("pageList");
		request.setAttribute("list", studentList);
		
		//페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);

		// request에 저장된 값을 다음 페이지에도 볼 수 있도록 주소에 forward해줌 
		RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
