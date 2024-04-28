INSERT INTO MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_EMAIL, MEMBER_PHONE, MEMBER_ADDR, ROLE) VALUES
                  (1, 'user01', 'pass01', '홍길동', 'user01@example.com', '010-1234-5678', '서울시 강남구 도곡동', 'USER'),
                  (2, 'user02', 'pass02', '김서방', 'user02@example.com', '010-2345-6789', '서울시 서초구 반포동', 'USER'),
                  (3, 'user03', 'pass03', '이순신', 'user03@example.com', '010-3456-7890', '서울시 송파구 잠실동', 'USER'),
                  (4, 'user04', 'pass04', '장보고', 'user04@example.com', '010-4567-8901', '서울시 용산구 한남동', 'USER'),
                  (5, 'user05', 'pass05', '유관순', 'user05@example.com', '010-5678-9012', '서울시 강동구 천호동', 'USER');

INSERT INTO PRODUCT (PD_ID, MEMBER_ID, PD_NAME, PD_PRICE, PD_STOCK, PD_DESCRIPTION) VALUES
                    (1, '1', '스마트폰', 1000000, 30, '최신 모델 스마트폰'),
                    (2, '2', '노트북', 2000000, 20, '고성능 노트북'),
                    (3, '3', '태블릿', 600000, 25, '휴대용 태블릿'),
                    (4, '4', '스마트워치', 400000, 15, '멀티 기능 스마트워치'),
                    (5, '5', '이어폰', 150000, 50, '고음질 이어폰');
INSERT INTO WISHLIST (WISH_ID, PD_ID, MEMBER_NO, OP_ID, PD_COUNT) VALUES
                                                      (1, 1, 1, 1, 1),
                                                      (2, 2, 2, 2, 2),
                                                      (3, 3, 3, 3, 1),
                                                      (4, 4, 4, 4, 1),
                                                      (5, 5, 5, 5, 2);
INSERT INTO ORDERS (ORDER_ID, PD_ID, MEMBER_NO, ORDER_ADDR, ORDER_PHONE, ORDER_MEMO, ORDER_PRICE, ORDER_DATE, ORDER_STATUS) VALUES
                            (1, 1, 1, '서울시 강남구', '010-1111-2222', '문 앞에 놓아주세요.', 1000000, '2023-04-01', '배송전'),
                            (2, 2, 2, '서울시 서초구', '010-2222-3333', '빠른 배송 부탁드립니다.', 2000000, '2023-04-02', '배송중'),
                            (3, 3, 3, '서울시 송파구', '010-3333-4444', NULL, 600000, '2023-04-03', '배송완료'),
                            (4, 4, 4, '서울시 용산구', '010-4444-5555', '직접 받겠습니다.', 400000, '2023-04-04', '배송중'),
                            (5, 5, 5, '서울시 강동구', '010-5555-6666', '부재시 경비실에 맡겨주세요.', 150000, '2023-04-05', '배송완료');
-- INSERT INTO OPTIONS (OP_ID, PD_ID, OP_STOCK) VALUES
--                                                  (1, 1, 100),
--                                                  (2, 2, 50),
--                                                  (3, 3, 75),
--                                                  (4, 4, 40),
--                                                  (5, 5, 60);

