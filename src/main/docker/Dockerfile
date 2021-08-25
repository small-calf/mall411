FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD mall.jar mall.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mall.jar"]