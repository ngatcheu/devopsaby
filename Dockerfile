FROM openjdk:17-alpine
MAINTAINER NgatcheuFabrice
EXPOSE 8087
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
