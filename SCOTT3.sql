/* 2023년 2월15일 */
-- SUBSTR함수와 다른 함수 합계 사용 --
SELECT JOB,
    SUBSTR(JOB, -LENGTH(JOB)), -- JOB의 길이는 5이고, 5에 대한 음수를 취하면 뒤에서 부터 음수값이 커지면서 읽어 냄
    SUBSTR(JOB, -LENGTH(JOB) ,2),
    SUBSTR(JOB, -3)
FROM EMP;

-- REPLACE : 특정 문자열 데이터에 포함된 문자를 다른 문자로 대체 할 때 사용 (자바의 문법과 유사), 대체할 문자열을 넣지 않으면 삭제의 효과
SELECT '010-5506-4146' AS 변경이전,
    REPLACE('010-5006-4146', '-', ' ') 하이픈을 공백으로, 
    REPLACE('010-5006-4146', '-') 하이픈 삭제
    FROM DUAL;

-- LPAD / READ : 공간에 칸수를 지정하고, 빈칸 만큼 특정 문자로 채우는 기능
SELECT LPAD('ORACLE', 10, '+') FROM DUAL;
SELECT RPAD('ORACLE', 10, '+') FROM DUAL;
SELECT 'ORACLE',
    LPAD('ORACLE', 10, '@') AS LPAD_1,
    RPAD('ORACLE', 10, '*') AS RPAD_1,
    LPAD('ORACLE', 10) AS LPAD_2,
    RPAD('ORACLE', 10) AS RPAD_2
FROM DUAL;

--개인정보 뒷자리를 * 표시로 출력하기
SELECT
    RPAD('971225-', 14, '*') AS RPAD_JUMIN,
    RPAD('010-5006-', 13, '*')AS RPAD_PHONE
FROM DUAL;

-- 두 문자열을 합치는 CONCAT 함수
SELECT CONCAT(EMPNO, ENAME),
    CONCAT(EMPNO, CONCAT(' : ', ENAME)) -- 중첩 사용
    FROM EMP
    WHERE ENAME = 'JAMES';
    
-- TRIM/LTRIM/RTRIM : 문자열 내에서 특정 문자를 지우기 위해 사용
SELECT '[' || TRIM(' _ ORACLE_ ') || ']' AS TRIM,
    '[' || LTRIM(' _ ORACLE_ ') || ']' AS LTRIM,
    '[' || LTRIM('<_ ORACLE_>', '_<') || ']' AS LTRIM_2, -- 문자열이 문자를 지우기 때문에 순서가 맞지 않아도 지워짐
    '[' || RTRIM(' _ ORACLE_ ') || ']' AS RTRIM,
    '[' || RTRIM('<_ ORACLE_>', '_>') || ']' AS RTRIM_2
FROM DUAL;

SELECT TRIM('     JKS2024    ') AS TRIM FROM DUAL;

SELECT SYSDATE AS NOW,
    SYSDATE-1 AS YESTERDAY, -- 운영체제에서 읽어온 시간정보에서 1일을 뺌
    SYSDATE+1 AS TOMORROW -- 운영체제에서 읽어온 시간정보에서 1일을 더함
FROM DUAL;

/* 몇 개월 이후의 날짜를 구하는 ADD_MONTHS 함수 */
-- 특정 날짜에 지정한 개월 수 이후 날짜 데이터를 반환하는 함수
-- ADD_MONTHS (날짜 데이터, 더할 개월 수)

SELECT SYSDATE,
    ADD_MONTHS(SYSDATE, 3)
    FROM DUAL;
    
 /* 실습 문제 : 사원에 대해 사원번호, 이름, 입사일, 10주년 경과된 날짜를 출력하기 */
SELECT EMPNO, ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 120) AS WORK10YEAR FROM EMP;

/* 현재 시간과 8개월 이후 시간 출력 
SELECT SYSDATE 현재시간,
    ADD_MONTHS(SYSDATE, 8) AS "8개월 경과일" 
FROM EMP;*/

SELECT EMPNO, ENAME, HIREDATE, SYSDATE,
    MONTHS_BETWEEN(HIREDATE, SYSDATE) AS MOTHS1,
    MONTHS_BETWEEN(SYSDATE, HIREDATE) AS MOTHS2,
    TRUNC (MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONHS3
FROM EMP;

FROM EMP;
/* 돌아오는 요일, 달의 마지막 날짜를 구하는 NEXT_DAY, LAST_DAY 함수 */

SELECT SYSDATE,
    NEXT_DAY(SYSDATE, '목요일'),
    LAST_DAY(SYSDATE)
FROM DUAL;

SELECT EXTRACT(YEAR FROM DATE '1998-03-07')
FROM DUAL;

SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL; -- 현재 몇월인지 추출

/* 자료형을 변환하는 형 변환 함수 */
-- 오라클도 자바와 마찬가지로 명시적 형변환과 묵시적 형변환이 있습니다.
-- 자동(묵시적) 형변환 : 숫자와 문자 자료형의 연산은 자동으로 숫자를 변환(자바와 다른점)

SELECT EMPNO, ENAME, EMPNO + '500'
FROM EMP;

/*날짜, 숫자를 문자로 변환하는 TO_CHAR 함수 */
-- TO_CHAR 함수는 날짜, 숫자데이터를 문자 데이터로 변환해주는 함수입니다.
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS "현재 날짜와 시간"
FROM DUAL;

-- 다양한 형식으로 출력하기
SELECT SYSDATE,
    TO_CHAR(SYSDATE, 'CC') AS 세기,
    TO_CHAR(SYSDATE, 'YY') AS 연도,
    TO_CHAR(SYSDATE, 'YYYY/MM/DD PM HH:MI:SS') AS "년/월/일 시:분:초",
    TO_CHAR(SYSDATE, 'Q') AS 쿼터,
    TO_CHAR(SYSDATE, 'DD') AS 일,
    TO_CHAR(SYSDATE, 'DDD') AS 경과일,
    TO_CHAR(SYSDATE, 'HH') AS "12시간제",
    TO_CHAR(SYSDATE, 'HH12') AS "12시간제",
    TO_CHAR(SYSDATE, 'HH24') AS "24시간제",
    TO_CHAR(SYSDATE, 'W') AS 몇주차
FROM DUAL;

-- 특정 언어에 맞춰서 날짜 출력하기
SELECT SYSDATE,
    TO_CHAR(SYSDATE, 'MM') AS MM,
    TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = KOREAN') AS MON_KOR,
    TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = JAPANESE') AS MON_JPN,
FROM DUAL;

SELECT SYSDATE,
     TO_CHAR(SYSDATE, 'MM') AS MM,
     TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MON_KOR,
     TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = JAPANESE') AS MON_JPN,
     TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MON_ENG,
     TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MONTH_KOR,
     TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = JAPANESE') AS MONTH_JPN,
     TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MONTH_ENG
FROM DUAL;

-- 숫자 데이터 형식을 지정하여 출력하기
-- 9 : 숫자의 한 자리르 의미하고 빈 자리를 채우지 않음
-- 0 : 빈 자리를 0으로 채움
-- $ : 달러 표시를 붙임
-- L : 지역 화폐 단위를 표시
-- . : 소수점 표시
-- , : 천 단위 표시

/* 1981년 6월 1일 이후에 입사한 사원 정보 출력하기 */
SELECT * FROM EMP WHERE HIREDATE > TO_DATE('1981/06/01' , 'YYYY/MM/DD');

/* NVL 함수의 사용법 */
-- NVL(데이터열, 앞의 데이터가 NULL일 경우 반환 할 데이터)
SELECT EMPNO, ENAME, SAL ,COMM,
    NVL(COMM,0), 
    SAL*12+NVL (COMM,0)
FROM EMP;

--NVL2(검사할 데이터열, NULL이 아닌 경우에 대한 계산식, NULL인 경우에 대한 계산식)
SELECT EMPNO, ENAME, COMM,
    NVL2(COMM, 'O', 'X') AS "NULL 여부 표시",
    NVL2(COMM, SAL*12+COMM, SAL*12) AS "연봉 계산"
FROM EMP;

SELECT EMPNO, ENAME, JOB, SAL,
     DECODE(JOB,
     'MANAGER' , SAL*1.1,
     'SALESMAN', SAL*1.05,
     'ANALYST' , SAL,
     SAL*1.03) AS UPSAL
 FROM EMP;
 
 SELECT EMPNO, ENAME, COMM,
    CASE
        WHEN COMM IS NULL THEN '해당 사항 없음'
        WHEN COMM = 0 THEN '수당없음'
        WHEN COMM > 0 THEN '수당 : ' || COMM
    END AS 수당표시
 FROM EMP;    
 
 /* 오늘의 실습 문제 
 노션에 있는 4개 문제
 --1
SELECT EMPNO,
    RPAD(SUBSTR(EMPNO, 1, 2), 4, '*') AS MASKING_EMPNO,
       ENAME,
    RPAD(SUBSTR(EMNAME, 1, 1), LENGTH(ENAME), '*') AS MASKING_ENAME
    FROM EMP
    WHERE LENGTH(ENAME) >= 5
    AND LENGTH(ENAME) < 6;

--2
SELECT EMPNO, ENAME, SAL,
    TRUNC(SAL/21.5, 2) AS DAY_PAY,
    ROUND(SAL/21.5/8, 1) AS TIME_PAY
FROM EMP;
 
--3
SELECT EMPNO, ENAME, HIREDATE,
    TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3),'월요일'), 'YYYY-MM-DD' AS R_JOB,
    NVL(TO_CHAR(COMM), 'N/A') AS COMM
FROM EMP;

--4
SELECT EMPNO, ENAME, MGR,
    CASE
        WHEN MGR IS NULL THEN '0000'
        WHEN SUBSTR(MGR, 1, 2) = '78' THEN '8888'
        ELSE TO_CHAR(MGR)
    END AS CHG_MGR
   FROM EMP; 



 SCOTT 계정 문제
 --1
 SELECT SYSDATE NOW FROM DUAL;
 
 --2
 SELECT * FROM EMP;
 SELECT EMPNO, ENAME, SAL FROM EMP ORDER BY SAL DESC;
 
 --3
 SELECT * F
 