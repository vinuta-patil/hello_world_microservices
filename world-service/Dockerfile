# Use a base image with JDK
FROM openjdk:17-jdk-alpine

# Create a volume for temporary files
VOLUME /tmp

# Copy the JAR file built by Maven into the container
COPY target/world-service-0.0.1-SNAPSHOT.jar world-service.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/world-service.jar"]
