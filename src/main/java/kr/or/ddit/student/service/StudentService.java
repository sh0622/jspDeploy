package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf {

	StudentDaoInf sd = new StudentDao();
	
	@Override
	public List<StudentVo> selectAllStudents() {
		return sd.selectAllStudents();
	}

	@Override
	public StudentVo getStudent(int id) {
		return sd.getStudent(id);
	}

	@Override
	public StudentVo getStudent(StudentVo setdentVo) {
		return sd.getStudent(setdentVo);
	}

	// 페이지 리스트와 전체 건수를 한번에 가져오는 방법
	@Override
	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		
		// 학생 페이지 리스트 조회
		List<StudentVo> pageList = sd.getStudentPageList(map);
		resultMap.put("pageList", pageList);
		
		// 학생 전체 건수 조회
		int totCnt = sd.getStudentTotCnt();
		resultMap.put("totCnt", totCnt);
		
		// 페이지 네비게이션 html 생성
		int page = map.get("page"); // 활성화 된 페이지를 알아야 active클래스를 줄 수 있어서
		int pageSize = map.get("pageSize");
	
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}
	
	
	/** 
	 * Method : makePageNavi
	 * 최초작성일 : 2018. 7. 11. 
	 * 작성자 : PC12
	 * 변경이력 : 
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return 
	 * Method 설명 : 페이지 네비게이션 문자열 생성
	 */
	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize;		//몫
		int mod = totCnt % pageSize;		//나머지
		
		if(mod>0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer(); 
		
//		아래처럼 쓸 경우 메모리 때문에 성능이 안 좋아서 StringBuffer로 쓰면 좋다.
//		String str = "test";
//		String str2 = str + "test";
//		String str3 = str + str2;
		
		int prevPage = page == 1 ? 1 : page - 1;
		int nextPage = page == cnt ? page : page + 1;
		
		pageNaviStr.append("<li> <a href=\"/studentList?page="+ prevPage +"&pageSize="+ pageSize +"\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span></a> </li>");
		
	    
		for(int i=1; i<=cnt; i++){
			// 파라미터 /studentList?page=1&pageSize=10 를 바꿔준다
			
			String activeClass = ""; // activeClass줄 변수를 만든다
				
			if( i == page )
				activeClass = "class=\"active\""; 
			
			pageNaviStr.append("<li " + activeClass +"> <a href=\"/studentList?page=" + i + "&pageSize="+ pageSize + "\">" + i + "</a></li>");
			// 현재 페이지가 아니면 공백, 맞을 경우 activeClass
		}
		
		
		pageNaviStr.append("<li> <a href=\"/studentList?page="+ nextPage +"&pageSize="+ pageSize +"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");

		
		return pageNaviStr.toString();
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		return sd.studentUpdate(studentVo);
	}



}
