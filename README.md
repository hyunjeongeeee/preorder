👨‍🏫 PREORDER 프로젝트 소개
---
본 프로젝트는 고객이 신제품을 사전에 예약할 수 있는 멀티모듈 시스템을 제공합니다.<br>
독립적인 모듈 구조를 통해 각 기능이 최적화되어, 유연하고 확장 가능한 서비스 운영이 가능합니다.

⏲️ 개발 기간
---
2024.04.17 ~ 진행중

💻 개발환경
---
* Version : Java 21
* IDE : IntelliJ
* Framework : SpringBoot 3.2.4
* Database : MySQL
* ORM : JPA


🛠 ERD
---
![preorder-project-erd.png](![Copy of Copy of Copy of 예약구매멀티모듈3차수정](https://github.com/hyunjeongeeee/preorder/assets/144875940/975eb6ae-dbc8-4402-8304-262d1e94ace7)
)

💡 기술스택
---
* 백엔드: Spring Boot를 사용하여 RESTful API를 제공하고, Spring Cloud를 활용한 마이크로서비스 아키텍처를 구현
* 데이터베이스: JPA/Hibernate를 사용하여 데이터 무결성과 트랜잭션 관리를 강화하며, MySQL 데이터베이스로 데이터를 관리
* 인프라스트럭처: Docker 컨테이너를 통해 각 모듈을 독립적으로 배포하고 관리

📌 주요 기능
---
* JWT 사용한 로그인, 로그아웃 구현
* 구글 SMTP 사용한 이메일 인증 구현
* 스프링 시큐리티를 사용한 인증, 인가 구현
* API Gateway를 통한 마이크로서비스 아키텍처 구현

* 예약 구매: 사용자는 신제품 또는 한정판 제품을 출시 전에 예약 구매할 수 있음 
<br> ➡ 이는 제품의 예약 개시일과 종료일을 기반으로 관리
* 주문 상태 관리: 주문 상태는 예약 주문 후 자동으로 업데이트되며, 
<br>스케줄된 배치 작업을 통해 주문 상태가 '배송중', '배송완료' 등으로 시간에 따라 변경
* 멀티모듈 아키텍처: 각 기능별로 분리된 모듈(member-service, order-service, product-service 등)을 통해 
<br>서비스의 유지보수와 확장성이 향상

🔎 성능 최적화 사례
---
* MSA(MicroService Architecture) 도입: 서비스의 확장성과 유지보수성을 향상시키기 위해 마이크로서비스 
 <br>아키텍처를 도입했습니다.
* API Gateway 추가: 시스템의 안정성과 서비스 관리의 용이성을 위해 API Gateway를 추가했습니다.


✒️ [API 명세서](https://sweet-number-410.notion.site/API-8c6bb12325a24c6fa1dc9fb2f031ae9e?pvs=4)
---

🍀 프로젝트 기록 및 트러블슈팅 ➡ [VELOG](https://velog.io/@hyunjeong9592/series)
---
