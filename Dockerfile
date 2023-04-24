FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./target/SIGA-API-0.0.1-SNAPSHOT.jar .

EXPOSE 8090

ENTRYPOINT ["java","-jar","SIGA-API-0.0.1-SNAPSHOT.jar"]

