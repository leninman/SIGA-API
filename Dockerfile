FROM openjdk:17-jdk-alpine

VOLUME /tmp

COPY ./target/siga.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

