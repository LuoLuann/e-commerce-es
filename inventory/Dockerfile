FROM openjdk:17
EXPOSE 8082
ADD ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]