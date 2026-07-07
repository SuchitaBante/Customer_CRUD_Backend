# Use Java 21 runtime
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Render provides the PORT environment variable
ENV PORT=10000

# Expose the Render port
EXPOSE 10000

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]