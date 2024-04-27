#openjdk:21 이미지를 기반으로 새로운 이미지 생성
FROM openjdk:21

# JAR_FILE 환경변수 설정하고 해당 환경변수에 파일명.jar 할당
# docker 파일과 같은 경로가 아닐경우 경로까지 작성해야함, *.jar 로도 가능
ARG JAR_FILE=/build/libs/demo-0.0.1-SNAPSHOT.jar

# 컨테이너 내부에 JAR_FILE 복사 -> 컨테이너 내부에 demo-springboot.jar 가 생성됨
COPY ${JAR_FILE} demo-springboot.jar
#COPY ./build/libs/demo-0.0.1-SNAPSHOT.jar ./build/libs/demo-0.0.1-SNAPSHOT.jar
# 컨테이너가 시작될 때 실행할 명령어 지정
# java -jar demo-springboot.jar 명령어를 실행해 SpringBoot 애플리케이션 구동
ENTRYPOINT ["java","-jar","demo-springboot.jar"]



