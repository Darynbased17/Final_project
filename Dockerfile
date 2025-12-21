FROM eclipse-temurin:17-jdk
LABEL maintainer="daryn"
COPY build/libs/Final_project-0.0.1-SNAPSHOT.jar my-backend-aviation-spring.jar
ENTRYPOINT ["java", "-jar", "my-backend-aviation-spring.jar"]