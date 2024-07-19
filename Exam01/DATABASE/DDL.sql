CREATE TABLE BOOK_TBL_06(
    BOOK_NO NUMBER PRIMARY KEY,
    BOOK_NAME VARCHAR2(50 BYTE) NOT NULL,
    BOOK_COVERIMG VARCHAR2(20 BYTE),
    BOOK_DATE DATE,
    BOOK_PRICE NUMBER,
    BOOK_PUBLISHER VARCHAR2(50 BYTE),
    BOOK_INFO VARCHAR2(2000 BYTE)
);

INSERT INTO BOOK_TBL_06(BOOK_NO
                        , BOOK_NAME
                        , BOOK_COVERIMG
                        , BOOK_DATE
                        , BOOK_PRICE
                        , BOOK_PUBLISHER
                        , BOOK_INFO)
VALUES (100, '������', '100.jpg', '15/09/02', 24000, '���轺', '�ü��, DB����, ��Ʈ��ũ����, ����ȯ�汸��');

INSERT INTO BOOK_TBL_06(BOOK_NO
                        , BOOK_NAME
                        , BOOK_COVERIMG
                        , BOOK_DATE
                        , BOOK_PRICE
                        , BOOK_PUBLISHER
                        , BOOK_INFO)
VALUES (101, '�ڹ�', '101.jpg', '16/01/10', 20000, '���ڹ�', '���α׷��� ���');

INSERT INTO BOOK_TBL_06(BOOK_NO
                        , BOOK_NAME
                        , BOOK_COVERIMG
                        , BOOK_DATE
                        , BOOK_PRICE
                        , BOOK_PUBLISHER
                        , BOOK_INFO)
VALUES (102, '�ڹ������α׷���', '102.jpg', '16/10/30', 25000, '������', '����ȯ��/�������α׷�/��ġ���α׷�');

INSERT INTO BOOK_TBL_06(BOOK_NO
                        , BOOK_NAME
                        , BOOK_COVERIMG
                        , BOOK_DATE
                        , BOOK_PRICE
                        , BOOK_PUBLISHER
                        , BOOK_INFO)
VALUES (103, '���¼ҽ�Ȱ���ϱ�', '103.jpg', '17/09/01', 30000, '�ڿ���', '�������, ����, ����');

INSERT INTO BOOK_TBL_06(BOOK_NO
                        , BOOK_NAME
                        , BOOK_COVERIMG
                        , BOOK_DATE
                        , BOOK_PRICE
                        , BOOK_PUBLISHER
                        , BOOK_INFO)
VALUES (104, 'HTML', '104.jpg', '18/04/04', 10000, 'ȫ�浿', 'HTML/CSS/JAVASCRIPT/JQUERY');

SELECT * FROM book_tbl_06;
SELECT * FROM RENT_TBL_06;

CREATE TABLE RENT_TBL_06(
    RENT_NO NUMBER PRIMARY KEY,
    BOOK_NO NUMBER NOT NULL,
    RENT_PRICE NUMBER NOT NULL,
    RENT_DATE DATE NOT NULL,
    RENT_STATUS CHAR(1 BYTE) DEFAULT 0 NOT NULL 
);

INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10001, 100, 2400, '18/07/02', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10002, 101, 2000, '18/07/04', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10003, 100, 2400, '18/08/02', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10004, 100, 2400, '18/08/12', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10005, 102, 2500, '18/08/13', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10006, 103, 3000, '18/08/13', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10007, 103, 3000, '18/08/20', 0);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10008, 100, 2400, '18/09/03', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10009, 100, 2400, '18/09/08', 1);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10010, 100, 2400, '18/09/14', 0);
INSERT INTO RENT_TBL_06(RENT_NO, BOOK_NO, RENT_PRICE, RENT_DATE, RENT_STATUS)
VALUES(10011, 102, 2500, '18/09/14', 0);

SELECT NVL(MAX(book_no), 0) +1
			FROM book_tbl_06;

SELECT b.book_no
       , b.book_name
       , SUM(r.rent_price) as total
       , count(r.rent_status) as count
FROM book_tbl_06 b JOIN rent_tbl_06 r
                   ON b.book_no = r.book_no
GROUP BY b.book_no, b.book_name
ORDER BY b.book_no;
                
