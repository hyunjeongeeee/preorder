CREATE TABLE `ORDERS` (
	`ORDER_ID`	INT	NOT NULL,
	`PD_ID`	INT	NOT NULL,
	`MEMBER_NO`	INT	NOT NULL,
	`ORDER_ADDR`	VARCHAR(500)	NOT NULL,
	`ORDER_PHONE`	VARCHAR(100)	NOT NULL,
	`ORDER_MEMO`	VARCHAR(1000)	NULL,
	`ORDER_PRICE`	INT	NOT NULL,
	`ORDER_DATE`	DATE	NOT NULL,
	`ORDER_STATUS`	ENUM ('배송전', '배송중', '배송완료', '취소중',
					'취소완료', '반품중', '반품완료') NULL DEFAULT '배송전'
);

CREATE TABLE `WISHLIST` (
	`WISH_ID`	INT	NOT NULL,
	`PD_ID`	INT	NOT NULL,
	`MEMBER_NO`	INT	NOT NULL,
	`OP_ID`	INT	NOT NULL,
	`PD_COUNT`	INT	NOT NULL
);


ALTER TABLE `WISHLIST` ADD CONSTRAINT `PK_WISHLIST` PRIMARY KEY (
	`WISH_ID`,
	`PD_ID`,
	`MEMBER_NO`
);


INSERT INTO ORDERS (ORDER_ID, PD_ID, MEMBER_NO, ORDER_ADDR, ORDER_PHONE, ORDER_MEMO, ORDER_PRICE, ORDER_DATE, ORDER_STATUS) VALUES
    (1, 1, 1, '서울시 강남구 어딘가', '010-0000-0001', '빠른 배송 부탁드립니다.', 1000000, '2024-01-01', '배송중'),
    (2, 2, 2, '서울시 서초구 어딘가', '010-0000-0002', '주의깊게 포장해주세요.', 800000, '2024-01-02', '배송완료'),
    (3, 3, 3, '서울시 종로구 어딘가', '010-0000-0003', '', 150000, '2024-01-03', '배송전'),
    (4, 4, 4, '서울시 중구 어딘가', '010-0000-0004', '부재시 경비실에 맡겨주세요.', 50000, '2024-01-04', '취소중'),
    (5, 5, 5, '서울시 용산구 어딘가', '010-0000-0005', '선물용이니 예쁘게 포장해주세요.', 300000, '2024-01-05', '배송완료'),
    (6, 6, 6, '서울시 동작구 어딘가', '010-0000-0006', '', 200000, '2024-01-06', '배송중'),
    (7, 7, 7, '서울시 구로구 어딘가', '010-0000-0007', '', 100000, '2024-01-07', '취소완료'),
    (8, 8, 8, '서울시 강동구 어딘가', '010-0000-0008', '빨리 필요합니다.', 80000, '2024-01-08', '반품중'),
    (9, 9, 9, '서울시 강서구 어딘가', '010-0000-0009', '', 120000, '2024-01-09', '반품완료'),
    (10, 10, 10, '서울시 송파구 어딘가', '010-0000-0010', '빠른 배송 부탁드립니다.', 400000, '2024-01-10', '배송전');


INSERT INTO WISHLIST (WISH_ID, PD_ID, MEMBER_NO, OP_ID, PD_COUNT) VALUES
                                                  (1, 1, 1, 1, 2),
                                                  (2, 2, 2, 2, 1),
                                                  (3, 3, 3, 3, 3),
                                                  (4, 4, 4, 4, 1),
                                                  (5, 5, 5, 5, 2),
                                                  (6, 6, 6, 6, 1),
                                                  (7, 7, 7, 7, 1),
                                                  (8, 8, 8, 8, 2),
                                                  (9, 9, 9, 9, 1),
                                                  (10, 10, 10, 10, 1);


