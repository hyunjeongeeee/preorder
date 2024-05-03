CREATE TABLE `PRODUCT` (
	`PD_ID`	INT	NOT NULL,
	`PD_NAME`	VARCHAR(500)	NOT NULL,
	`PD_PRICE`	INT	NOT NULL,
	`PD_STOCK`	INT	NOT NULL,
	`PD_DESCRIPTION`	VARCHAR(1000)	NULL,
	`PD_STATUS`	CHAR(1)	NOT NULL	DEFAULT 'Y'
);

ALTER TABLE `PRODUCT` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`PD_ID`
);

INSERT INTO PRODUCT (PD_ID, PD_NAME, PD_PRICE, PD_STOCK, PD_DESCRIPTION, PD_STATUS) VALUES
                                    (1, '노트북', 1000000, 10, '고성능 노트북', 'Y'),
                                    (2, '스마트폰', 800000, 15, '최신 스마트폰', 'Y'),
                                    (3, '키보드', 150000, 20, '기계식 키보드', 'Y'),
                                    (4, '마우스', 50000, 30, '게이밍 마우스', 'Y'),
                                    (5, '모니터', 300000, 12, '24인치 모니터', 'Y'),
                                    (6, '헤드셋', 200000, 8, '소음 차단 헤드셋', 'Y'),
                                    (7, '스피커', 100000, 25, '블루투스 스피커', 'Y'),
                                    (8, '램', 80000, 40, '16GB DDR4 RAM', 'Y'),
                                    (9, '외장하드', 120000, 30, '1TB 외장하드', 'Y'),
                                    (10, '프린터', 400000, 5, '컬러 레이저 프린터', 'Y');
