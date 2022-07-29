FROM openjdk:11-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery-service.jar
ENTRYPOINT ["java","-jar","/discovery-service.jar"]
EXPOSE 8761