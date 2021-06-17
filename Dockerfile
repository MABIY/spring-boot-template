FROM  openjdk:11.0.11-jdk
ARG JAR_FILE=ci/*.jar
RUN adduser --system --group spring
USER spring:spring
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
