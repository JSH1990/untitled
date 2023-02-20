/* 2023.02.20 */
/* NATURAL JOIN : 동등 조인과 비슷하지만 WHERE 조건절없이 조인하는 방식 */
-- 두 테이블의 동일한 이름(컬럼 또는 열)을 갖는 컬럼은 모두 조인 됨
-- DEPTNO 열이 양쪽 테이블에 모두 존재함

SELECT EMPNO, ENAME, DNAME
    FROM EMP NATURAL JOIN DEPT;

-- 일반적인 동등조인인 경우는 아래의 쿼리문의 에러가 발생 합니다. DEPTNO가 어디소속인지 모호성이 발생함
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, DNAME, LOC
    FROM EMP NATURAL JOIN DEPT
    ORDER BY DEPTNO, EMPNO;

/* JOIN ~ USING : 기존의 등가 조인을 대신하는 조인 방식 입니다. */
-- FROM TABLE1 JOIN TABLE2 USING(기준열)
SELECT EMPNO, ENANE, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, DNAME, LOC
    FROM EMP JOIN DEPT USING(DEPTNO)
    WHERE SAL >= 3000
    ORDER BY DEPTNO, EMPNO;
    
 /* JOIN ~ ON : 가장 범용성 있는 JOIN ~ ON 키워드를 사용한 조인방식 */
 -- FROM TABLE1 JOIN TABLE2 ON(조인 조건식)
 
 /* 서브 쿼리 : SQL문 안에 작성하는 작은 SELECT 문을 의미합니다. 주로 WHERE절에 사용 */
 -- 서브쿼리는 반드시 괄호(서브 쿼리) 안에 넣어 표현합니다.
 -- 사원의 이름으로 사원이 속한 부서 번호를 찾음
 -- 메인 쿼리에서 부서이름과 부서번호를 비교해서 원하는 결과를 찾음
 SELECT DNAME
    FROM DEPT
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'KING')
    
/* 서브 쿼리를 이용해 'JONES'의 급여보다 높은 급여를 받는 사원 정보 출력
SELECT *
    FROM EMP
    WHERE SAL > (SELECT SAL
                FROM EMP
                WHERE ENAME = 'JONES');
/* 서브 쿼리의 특징 */
-- 조회 대상의 오른쪽에 놓이며 () 묶어서 사용
-- 대부분의 경우 ORDER BY 절을 사용할수 없음
-- 메인 쿼리의 대상과 서브쿼리의 대상은 같은 자료형이거나 같은 개수로 지정
-- 서브쿼리와 메인쿼리는 연산자와 함께 상호 작용하는 방식에 따라 단일행 서브 쿼리와 다중해 서브 쿼리

SELECT *
    FROM EMP
    WHERE HIREDATE < (SELECT HIREDATE
                            FROM EMP
                            WHERE ENAME = 'JAMES');
                            
SELECT EMPNO, ENAME, JOB, SAL, D.DEPTNO, D.NAME, D.LOC
    FROM EMP E JOIN DEPT D
    ON E.DEPTNO = D.DEPTNO
    WHERE E.DEPTNO = 20
    AND E.SAL > (SELECT AVG(SAL)
                    FROM EMP)
                    
/* 실행결과가 여러개인 다중행 서브쿼리 */
-- IN 연산자 : 메인 쿼리의 데이터가 서브쿼리의 결과 중 하나라도 일치한 데이터가 있다면 TRUE
SELECT * 
    FROM EMP
    WHERE SAL IN (SELECT MAX(SAL)
                    FROM EMP
                    GROUP BY DEPTNO);

-- ANY 연산자 : 메인쿼리의 비교 조건이 서브쿼리의 여러 검색 결과 중 하나 이상 만족되면 TRUE 반환               
SELECT * 
    FROM EMP
    WHERE SAL = ANY (SELECT MAX(SAL)
                    FROM EMP
                    GROUP BY DEPTNO);
                    
SELECT SAL FROM EMP WHERE DEPTNO = 30;

//ALL 연산자 : 메인 쿼리의 비교 조건이 서브쿼리의 여러 검색 결과와 모두 일치하면 반환

SELECT EMPNO, ENAME, SAL
    FROM EMP  
    WHERE SAL < ALL(SELECT SAL FROM EMP WHERE JOB = 'MANAGER');
    
/* FROM 절에 사용하는 서브쿼리 */
-- 메인 쿼리의 FROM절을 서브 쿼리로 이용하는 방법으로 다른 말로는 인라인뷰라고 합니다.
-- 테이블이 너무커서 일부분만 사용하고자 하는 경우
-- 보안상 보여 주고 싶은 열을 제한 해야 하는 경우

-- 먼저 정렬하고 해당 개수만 가져 오기
-- ROWNUM : 오라클에서 일련번호를 부여하기 위해서 사용되는 예약어 (즉, 행번호 매기기)
SELECT ROWNUM, ENAME, SAL
    FROM(SELECT * FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 3;

-- SELECT 절에 사용하는 서브 쿼리
-- SELECT문 사용하는 단일행 서브 쿼리를 스칼라 서브 쿼리
SELECT EMPNO, ENAME, JOB, SAL,
    (SELECT GRADE FROM SALGRADE
                WHERE E.SAL BETWEEN LOSAL AND HISAL) AS SALGRADE,
                DEPTNO,
                (SELECT DNAME FROM DEPT
                                WHERE E.DEPTNO = DEPT.DEPTNO) AS DNAME
                 FROM EMP E;     

SELECT ENAME, DEPTNO, SAL, (SELECT TRUNC(AVG(SAL)) FROM EMP   
                            WHERE DEPTNO = E.DEPTNO) AS "부서평균급여"
                            FROM EMP E;
                            
* 부서 위치가 NEWYORK 인 경우에 본사, 아니면 분점으로 반환 하기 */
SELECT EMPNO, ENAME, 
        CASE WHEN DEPTNO = (SELECT DEPTNO
                            FROM DEPT
                            WHERE LOC = 'NEW YORK')
                THEN '본사'
                ELSE '분점'
                END AS 소속
                FROM EMP
                ORDER BY 소속 DESC;