FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./target/siga.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

