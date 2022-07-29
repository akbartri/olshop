FROM openjdk:11-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-service.jar
ENTRYPOINT ["java","-jar","/config-service.jar"]
EXPOSE 10001