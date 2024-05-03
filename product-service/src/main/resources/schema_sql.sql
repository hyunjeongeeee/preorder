DROP TABLE IF EXISTS PRODUCT;

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