FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-repair.jar
ENTRYPOINT ["java", "-jar", "/ms-repair.jar"]