# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine
# Set the working directory inside the container
WORKDIR /app
# Copy the packaged JAR file into the containe
COPY target/springbootapp-0.0.1-SNAPSHOT.jar /app/springbootapp-0.0.1-SNAPSHOT.jar
# Expose the port on which your Spring Boot application will ru
EXPOSE 8082
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/springbootapp-0.0.1-SNAPSHOT.jar"]
