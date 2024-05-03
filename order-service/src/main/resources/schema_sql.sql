DROP TABLE IF EXISTS ORDERS;

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