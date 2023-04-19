-------도서관리 프로그램

/*
 T_MEMBER - 회원
 T_BOOK - 도서
 T_RENTAL - 대여관리
*/

-- T_MEMBER - 회원 테이블(아이디(PK), 비밀번호, 이름, 핸드폰번호)
CREATE TABLE T_MEMBER (
       ID    VARCHAR(30) PRIMARY KEY,
       PWD   VARCHAR(30) NOT NULL,
       NAME  VARCHAR(30) NOT NULL,
       PHONE VARCHAR(13) NOT NULL,
       GRADE VARCHAR(20) DEFAULT '회원' CHECK ( GRADE IN ( '회원', '관리자' ) )
);

ALTER TABLE T_MEMBER MODIFY
       GRADE VARCHAR(30) DEFAULT '회원' CHECK ( GRADE IN ( '회원', '관리자' ) );

SELECT *
  FROM T_MEMBER;



-- T_BOOK - 도서 테이블(도서번호(PK), 제목, 저자, 등록일, 발행일, 출판사, 장르)
CREATE TABLE T_BOOK (
       B_NO      NUMBER(5) PRIMARY KEY,
       TITLE     VARCHAR(200) NOT NULL,
       WRITER    VARCHAR(200) NOT NULL,
       REG_DATE  VARCHAR(200) DEFAULT SYSDATE,
       PUB_DATE  DATE NOT NULL,
       PUBLISHER VARCHAR(200) NOT NULL,
       GENRE     VARCHAR(200)
);

-- T_RENTAL - 대여관리 테이블(대여 번호, 도서번호, 대여회원, 대여일, 반납일, 연장가능횟수)
CREATE TABLE T_RENTAL (
       R_NO        NUMBER(5) PRIMARY KEY,
       B_NO        NUMBER(5) UNIQUE,
       U_ID        VARCHAR(30) NOT NULL,
       RENTAL_DATE DATE DEFAULT SYSDATE,
       RETURN_DATE DATE DEFAULT SYSDATE + 14,
       EXTENSION   NUMBER(1) DEFAULT 1,
       CONSTRAINT FK_B_NO FOREIGN KEY ( B_NO )
              REFERENCES T_BOOK ( B_NO ),
       CONSTRAINT FK_U_ID FOREIGN KEY ( U_ID )
              REFERENCES T_MEMBER ( ID )
);

SELECT *
  FROM T_BOOK;

CREATE SEQUENCE SEQ_T_RENTAL NOCACHE;

COMMIT;

SELECT *
  FROM T_RENTAL;

SELECT B_NO,
       TITLE,
       WRITER,
       REG_DATE,
       PUB_DATE,
       PUBLISHER,
       GENRE,
       CASE
              WHEN B_NO IN (
                     SELECT B_NO
                       FROM T_RENTAL
              ) THEN
                     '대여불가'
              ELSE
                     '대여가능'
       END AS 대여현황
  FROM T_BOOK;

SELECT B.B_NO,
       B.TITLE,
       RENTAL_DATE,
       RETURN_DATE,
       EXTENSION
  FROM T_RENTAL A
  JOIN T_BOOK B ON A.B_NO = B.B_NO
 WHERE U_ID = 'aaa';

UPDATE T_RENTAL
   SET RETURN_DATE = RETURN_DATE + 7,
       EXTENSION = '0'
 WHERE U_ID = 'aaa'
   AND B_NO      = 1
   AND EXTENSION = '1';

COMMIT;

UPDATE T_MEMBER
   SET
       NAME = '끼현'
 WHERE ID = 'ggihyun';

SELECT *
  FROM T_MEMBER;

INSERT INTO T_MEMBER VALUES (
       'admin01',
       '1234',
       '관리자',
       '010-0000-0000',
       '관리자'
);

INSERT INTO T_BOOK (
       B_NO,
       TITLE,
       WRITER,
       PUB_DATE,
       PUBLISHER,
       GENRE
) VALUES (
       SEQ_T_BOOK_NO.NEXTVAL,
       '세이노의 가르침',
       '세이노',
       '2023-03',
       '데이원',
       '자기개발'
);

COMMIT;

delete from t_member where id = 'bbangmi';

SELECT *
  FROM T_BOOK;
  
  update t_book set writer = '김준성' where b_no = 4;
  commit;