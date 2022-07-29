FROM openjdk:11-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway-service.jar
ENTRYPOINT ["java","-jar","/gateway-service.jar"]
EXPOSE 8080