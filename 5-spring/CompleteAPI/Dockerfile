FROM openjdk:8-jdk-alpine

# Copy the JAR from the target folder into the container
COPY /target/CompleteAPI-0.0.1-SNAPSHOT.jar CompleteAPI-0.0.1-SNAPSHOT.jar 

ENTRYPOINT ["java", "-jar", "/CompleteAPI-0.0.1-SNAPSHOT.jar"]