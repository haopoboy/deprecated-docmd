FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY target/*.jar /usr/src/app
EXPOSE 8080
CMD [ "java", "-jar", "docmd-0.1-SNAPSHOT.jar" ]