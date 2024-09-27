FROM openjdk:17
EXPOSE 8383
ADD ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]