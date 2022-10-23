FROM openjdk:17-jdk-slim-buster
COPY target/learn-0.0.1-SNAPSHOT.jar learn-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","learn-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081