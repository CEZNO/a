-- 각 테이블 생성
CREATE TABLE mem (
  no          INT NOT NULL PRIMARY KEY,
  id          VARCHAR2(12) NOT NULL UNIQUE,
  pw          VARCHAR2(16) NOT NULL
    CONSTRAINT check_pw CHECK ( length(pw) > 7
                                AND length(pw) < 17 ),
  name        VARCHAR2(50) NOT NULL,
  address     VARCHAR2(50) NULL,
  signup_ip   NUMBER(12) NULL,
  signup_date DATE NOT NULL
);

CREATE TABLE post (
  no        INT NOT NULL,
  pst_no    INT NOT NULL PRIMARY KEY,
  pst_title VARCHAR2(100) NOT NULL,
  pst_txt   LONG NULL,
  pst_date  DATE NULL,
  hit       INT NULL
);

CREATE TABLE comm (
  no           INT NOT NULL,
  cmt_no       INT NOT NULL PRIMARY KEY,
  pst_no       INT NOT NULL,
  cmt_txt      VARCHAR2(900) NULL,
  cmt_date     DATE NOT NULL,
  cmt_chckopen NUMBER(1) NOT NULL,
  cmt_blame    NUMBER(1) NOT NULL
);

-- 외래키 설정
ALTER TABLE post
  ADD CONSTRAINT pst_mem_no FOREIGN KEY ( no )
    REFERENCES mem ( no );

ALTER TABLE comm
  ADD CONSTRAINT cmt_pst_no FOREIGN KEY ( pst_no )
    REFERENCES post ( pst_no );

ALTER TABLE comm
  ADD CONSTRAINT cmt_mem_no FOREIGN KEY ( no )
    REFERENCES mem ( no );

-- 각 테이블 조회
SELECT
  *
FROM
  mem;

SELECT
  *
FROM
  post;

SELECT
  *
FROM
  comm;

-- 회원 정보 조회(이용자)
SELECT
  no,
  id,
  pw,
  name,
  address,
  signup_date
FROM
  mem;

-- 작성 게시글 조회(이용자)
SELECT
mem.name,
post.pst_no,
post.pst_title,
post.pst_txt,
post.pst_date,
post.hit
FROM mem LEFT OUTER JOIN post
ON mem.no = post.no
WHERE mem.name LIKE ?;

-- 작성자 댓글 조회(이용자)
SELECT
mem.name,
comm.pst_no,
comm.cmt_no,
comm.cmt_txt,
comm.cmt_date
FROM mem
LEFT OUTER JOIN comm
ON mem.no =
comm.no
WHERE mem.name LIKE ?;

-- 각 테이블 삭제
DROP TABLE mem;

DROP TABLE post;

DROP TABLE comm;

-- 회원 정보 입력 예시
INSERT INTO mem (
  no,
  id,
  pw,
  name,
  address,
  signup_ip,
  signup_date
) VALUES (
  1,
  'cezno',
  'zpwmsh1234',
  'CEZNO',
  'Busan',
  127000000001,
  sysdate
);

INSERT INTO mem (
  no,
  id,
  pw,
  name,
  address,
  signup_ip,
  signup_date
) VALUES (
  2,
  'camael',
  'camael1234',
  'CAMAEL',
  'Busan',
  127000000001,
  sysdate
);

-- 게시글 정보 입력 예시
INSERT INTO post (
  pst_no,
  no,
  pst_title,
  pst_txt,
  pst_date
) VALUES (
  1,
  1,
  '이것은 test, This is 테스트',
  'String 클래스의 문자열 길이의 한계
  
결국, String 클래스의 문자열 길이의 한계는 힙 메모리의 크기에 따라 결정되며, 자바 가상 머신의 최대 힙 메모리의 크기를 넘을 수 없다.

즉, String 클래스의 문자열의 최대 가능 길이는 대체로 32비트 머신의 경우 2GB가 한계이며, 운영체계에 따라 대개 이보다 작다. 또한, 프로세스의 최대 힙 메모리 할당량 옵션에 따라 그 한계는 더 작아질 수 있다.

결론

String 클래스의 문자열 길이의 한계는 하드웨어 머신과 운영체계에서 허용하는 최대한의 크기까지 가능하며, 특별히 규약에서 제약하는 사항은 없다. 단, 자바 가상 머신에 따라 힙 메모리 할당에 옵션 설정이 있을 수 있다.
',
  sysdate
);

-- 댓글 정보 입력 예시
INSERT INTO comm (
  no,
  cmt_no,
  pst_no,
  cmt_chckopen,
  cmt_blame,
  cmt_date,
  cmt_txt
) VALUES (
  2,
  1,
  1,
  1,
  0,
  sysdate,
  '니렙에잠이오냐?'
);

INSERT INTO comm (
  no,
  cmt_no,
  pst_no,
  cmt_chckopen,
  cmt_blame,
  cmt_date,
  cmt_txt
) VALUES (
  1,
  2,
  1,
  1,
  0,
  sysdate,
  '앙 개꿀띠'
);

INSERT INTO comm (
  no,
  cmt_no,
  pst_no,
  cmt_chckopen,
  cmt_blame,
  cmt_date,
  cmt_txt
) VALUES (
  1,
  3,
  1,
  1,
  0,
  sysdate,
  '한 번 더 개꿀띠'
);

시퀀스 확인.
create sequence mem_seq;
삭제
drop sequence mem_seq;

시퀀스 현재 값 조회. 
select last_number from user_sequences where sequence_name = 'mem_seq';
시퀀스 재설정.
alter sequence mem_seq increment by -22 ;

시퀀스 조회 
select mem_seq.nextval from dual;
시퀀스 증가치 변경 
alter sequence mem_seq increment by 1;

COMMIT;

--DROP TABLE IF EXISTS post_files;
--
--CREATE TABLE post_files (
--	post_no	FK	NOT NULL,
--	file_name	NN	NULL
--);

--DROP TABLE IF EXISTS profile;
--
--CREATE TABLE profile (
--	id	FK	NOT NULL,
--	usericon	N	NULL,
--	userhdr	N	NULL,
--	chckopen	NN	NULL
--);

--DROP TABLE IF EXISTS answer;
--
--CREATE TABLE answer (
--	a_no	PK	NOT NULL,
--	q_no	FK	NOT NULL,
--	a_title	NN	NULL,
--	a_text	NN	NULL
--);

--DROP TABLE IF EXISTS signin;
--
--CREATE TABLE signin (
--	id	FK	NOT NULL,
--	signin_ip	NN	NULL,
--	signin_date	NN	NULL
--);

--DROP TABLE IF EXISTS blog_scrap;
--
--CREATE TABLE blog_scrap (
--	scrap_no	PK	NOT NULL,
--	id	FK	NOT NULL,
--	post_no	FK	NOT NULL,
--	scr_date	NN	NULL
--);

--DROP TABLE IF EXISTS question;
--
--CREATE TABLE question (
--	q_no	PK	NOT NULL,
--	id	FK	NOT NULL,
--	q_title	NN	NULL,
--	q_text	NN	NULL
--);

--DROP TABLE IF EXISTS tag;
--
--CREATE TABLE tag (
--	post_no	FK	NOT NULL,
--	t_name	NN	NULL
--);

--DROP TABLE IF EXISTS q_files;
--
--CREATE TABLE q_files (
--	q_no	FK	NOT NULL,
--	q_file	N	NULL
--);

--DROP TABLE IF EXISTS cmt_reply;
--
--CREATE TABLE cmt_reply (
--	cmt_no	FK	NOT NULL,
--	id	FK	NOT NULL,
--	cmt_rep	FK	NULL,
--	rep_date	NN	NULL
--);

