CREATE TABLE mem (
  id          VARCHAR2(12) NOT NULL PRIMARY KEY,
  pw          VARCHAR2(16) NOT NULL
    CONSTRAINT check_pw CHECK ( length(pw) > 6
                                AND length(pw) < 17 ),
  name        VARCHAR2(50) NOT NULL,
  adress      VARCHAR2(50) NULL,
  signup_ip   NUMBER(12) NULL,
  signup_date DATE NOT NULL
);

CREATE TABLE post (
  pst_no    INT NOT NULL PRIMARY KEY,
  id        VARCHAR2(12) NOT NULL,
  pst_title VARCHAR2(100) NOT NULL,
  pst_text  LONG NULL,
  pst_date  DATE NULL
);

CREATE TABLE comm (
  cmt_no       INT NOT NULL PRIMARY KEY,
  pst_no       INT NOT NULL,
  id           VARCHAR2(12) NOT NULL,
  cmt_chckopen NUMBER(1) NOT NULL,
  cmt_blame    NUMBER(1) NOT NULL,
  cmt_date     DATE NOT NULL,
  cmt_txt      VARCHAR2(900) NULL
);

ALTER TABLE post
  ADD CONSTRAINT pst_id FOREIGN KEY ( id )
    REFERENCES mem ( id );

ALTER TABLE comm
  ADD CONSTRAINT cmt_pst_no FOREIGN KEY ( pst_no )
    REFERENCES post ( pst_no );

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

SELECT
comm.id,
mem.pw,
mem.name,
mem.adress,
mem.signup_date,
comm.pst_no,
post.pst_title,
post.pst_date,
comm.id,
comm.cmt_no,
comm.cmt_txt,
comm.cmt_date
FROM mem left outer join post
on mem.id = post.id
left outer join comm
on mem.id = comm.id;

DROP TABLE mem;

DROP TABLE post;

DROP TABLE comm;

INSERT INTO mem (
  id,
  pw,
  name,
  adress,
  signup_ip,
  signup_date
) VALUES (
  'cezno',
  'zpwmsh1234',
  'CEZNO',
  'Busan',
  127000000001,
  sysdate
);

INSERT INTO mem (
  id,
  pw,
  name,
  adress,
  signup_ip,
  signup_date
) VALUES (
  'camael',
  'camael1234',
  'CAMAEL',
  'Busan',
  127000000001,
  sysdate
);

INSERT INTO post (
  pst_no,
  id,
  pst_title,
  pst_text,
  pst_date
) VALUES (
  1,
  'cezno',
  '이것은 test, This is 테스트',
  'String 클래스의 문자열 길이의 한계
  
결국, String 클래스의 문자열 길이의 한계는 힙 메모리의 크기에 따라 결정되며, 자바 가상 머신의 최대 힙 메모리의 크기를 넘을 수 없다.

즉, String 클래스의 문자열의 최대 가능 길이는 대체로 32비트 머신의 경우 2GB가 한계이며, 운영체계에 따라 대개 이보다 작다. 또한, 프로세스의 최대 힙 메모리 할당량 옵션에 따라 그 한계는 더 작아질 수 있다.

결론

String 클래스의 문자열 길이의 한계는 하드웨어 머신과 운영체계에서 허용하는 최대한의 크기까지 가능하며, 특별히 규약에서 제약하는 사항은 없다. 단, 자바 가상 머신에 따라 힙 메모리 할당에 옵션 설정이 있을 수 있다.
',
  sysdate
);

INSERT INTO comm (
  cmt_no,
  pst_no,
  id,
  cmt_chckopen,
  cmt_blame,
  cmt_date,
  cmt_txt
) VALUES (
  1,
  1,
  'camael',
  1,
  0,
  sysdate,
  '니렙에잠이오냐?'
);

INSERT INTO comm (
  cmt_no,
  pst_no,
  id,
  cmt_chckopen,
  cmt_blame,
  cmt_date,
  cmt_txt
) VALUES (
  2,
  1,
  'cezno',
  1,
  0,
  sysdate,
  '앙 개꿀띠'
);

INSERT INTO comm (
  cmt_no,
  pst_no,
  id,
  cmt_chckopen,
  cmt_blame,
  cmt_date,
  cmt_txt
) VALUES (
  3,
  1,
  'cezno',
  1,
  0,
  sysdate,
  '한 번 더 개꿀띠'
);

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

