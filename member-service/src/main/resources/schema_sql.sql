DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER (
	`MEMBER_NO`	INT	NOT NULL,
	`MEMBER_ID`	VARCHAR(100)	NOT NULL,
	`MEMBER_PW`	VARCHAR(100)	NOT NULL,
	`MEMBER_ADDR`	VARCHAR(500)	NOT NULL,
	`MEMBER_NAME`	VARCHAR(100)	NOT NULL,
	`MEMBER_EMAIL`	VARCHAR(100)	NOT NULL,
	`MEMBER_PHONE`	VARCHAR(100)	NOT NULL,
	`MEMBER_STATUS`	ENUM('USER','ADMIN')	NOT NULL
);

ALTER TABLE `MEMBER` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
                                                             `MEMBER_NO`
    );
