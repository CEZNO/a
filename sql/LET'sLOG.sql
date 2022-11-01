
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
--	tel	        UK	            NULL,
--	birth	        NN	            NULL,

CREATE TABLE POST (
	pst_no	    INT             NOT NULL PRIMARY KEY,
	id	        VARCHAR2(12)	NOT NULL UNIQUE,
	pst_title	VARCHAR2(100)	NOT NULL,
	pst_text	LONG	        NULL,
	pst_date	DATE	        NULL
);
--	post_hdr	N	NULL,

CREATE TABLE COMM (
	cmt_no	        INT	            NOT NULL PRIMARY KEY,
    pst_no          INT             NOT NULL UNIQUE,
   	id	            VARCHAR2(12)	NOT NULL,
    cmt_chckopen    NUMBER(1)       NOT NULL,
    cmt_blame       NUMBER(1)       NOT NULL,
    cmt_date        DATE            NOT NULL,
    cmt_txt         VARCHAR2(900)   NULL
);

ALTER TABLE POST ADD CONSTRAINT pst_id 
    FOREIGN KEY(id) REFERENCES MEM(id);

ALTER TABLE COMM ADD CONSTRAINT cmt_pst_no 
    FOREIGN KEY(pst_no) REFERENCES POST(pst_no);
    
INSERT INTO MEM(id, pw, name, adress, signup_ip, signup_date)
VALUES ('cezno', 'zpwmsh1234', 'CEZNO', 'Busan', 127000000001, sysdate);

commit;

select * from mem;

select * from post;

select * from comm;

DROP TABLE mem;

DROP TABLE POST;

DROP TABLE COMM;

SELECT
    *
FROM
    mem as m
left outer join post as p
on m.id = p.id
left outer join comm as c
ON p.pst_no = c.pst_no;

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

