<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
쿼리문
<!-- 

select * from student where id = 1;

-- page 당 10건 씩 데이터 조회
-- 정렬기준 name 컬럼 기준
-- 1pagem, pageSzie 10 : 1~10 ( (#{page}-1)*#{pageSize}+1 )
-- 2page, pageSize 10 : 11~20
-- 3page, pageSize 10 : 21~30
-- rownum : 오라클에서 지원하는 가상컬럼으로 쿼리의 결과에 1부터 하나씩 증가하여 붙는 컬럼입니다.
-- rownum은 중간에 있는 값은 못 읽어옴

--1. 이름순으로 정렬
select *
  from student
  order by name;
  
--2. 컬럼 번호
select student.*, rownum
  from student
  order by name;

--3. 전체 이름순 정렬된 학생을 컬럼번호로 조회
select a.*, rownum rn
  from
(select *
  from student
  order by name) a;
  
--4. order by가 젤 마지막에 되어서 전체를 한번 묶어주고 실행 
select *
  from
  (select a.*, rownum rn
    from
        (select *
          from student
          order by name) a)
  where rn between 1 and 10;
  where (#{page}-1)*#{pageSize}+1

-- ziptb 테이블 페이징 처리 : zipcode 기준 정렬
-- 1~10 , 11~20
select *
  from
      (select a.*, rownum rn
            from
                (select *
                  from ziptb
                  order by zipcode) a)
  where rn between 11 and 20; 
 --where rn bwtween 1 and 10;
  
select ziptb.*, rownum
  from ziptb
  order by zipcode;
  
select a.*, rownum rn
  from  
    (select *
      from ziptb
      order by zipcode) a;
 
select *
  from(
      select a.*, rownum rn
      from  
        (select *
          from ziptb
          order by zipcode) a)
    where rn between 1 and 10;
    

 -->
</body>
</html>