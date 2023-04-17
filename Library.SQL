-------도서관리 프로그램

/*
 T_MEMBER - 회원
 T_MANAGER - 관리자
 T_BOOK - 도서
 T_RENTAL - 대여관리
*/


-- T_MEMBER - 회원 테이블(아이디(PK), 비밀번호, 이름, 핸드폰번호)
CREATE TABLE T_MEMBER (
       ID    VARCHAR(30) PRIMARY KEY,
       PWD   VARCHAR(30) NOT NULL,
       NAME  VARCHAR(30) NOT NULL,
       PHONE VARCHAR(13) NOT NULL
);

select * from t_member;


-- T_MANAGER - 관리자 테이블(아이디(PK), 비밀번호, 관리자 승인여부(1이면 관리자 0이면 승인전) 
CREATE TABLE T_MANAGER (
       ID       VARCHAR(30) PRIMARY KEY,
       PWD      VARCHAR(30) NOT NULL,
       approval CHAR(1) CHECK(approval IN('0', '1'))
);

DROP TABLE T_MANAGER;

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
       B_NO        NUMBER(5),
       U_ID        VARCHAR(30) NOT NULL,
       RENTAL_DATE DATE DEFAULT SYSDATE,
       RETURN_DATE DATE DEFAULT SYSDATE + 14,
       EXTENSION   NUMBER(1) DEFAULT 1,
       CONSTRAINT FK_B_NO 
              FOREIGN KEY (B_NO)
              REFERENCES T_BOOK (B_NO),
       CONSTRAINT FK_U_ID 
              FOREIGN KEY (U_ID)
              REFERENCES T_MEMBER (ID)
);