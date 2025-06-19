# Use JDK 21 base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Make mvnw executable (just in case)
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

# Expose the port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/PartyTracker-0.0.1-SNAPSHOT.jar"]