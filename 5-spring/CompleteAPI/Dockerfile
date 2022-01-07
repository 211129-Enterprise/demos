FROM openjdk:8-jdk-alpine

# Copy the JAR from the target folder into the container
COPY /target/CompleteAPI-0.0.1-SNAPSHOT.jar CompleteAPI-0.0.1-SNAPSHOT.jar

# Array of commands to run in container
ENTRYPOINT ["java", "-jar", "/CompleteAPI-0.0.1-SNAPSHOT.jar"]