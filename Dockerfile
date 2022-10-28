FROM openjdk:17-alpine
ARG JAR_FILE=target/todo-backend-task1-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} todo-backend-task1.jar
ENTRYPOINT ["java", "-jar", "todo-backend-task1.jar"]