# Stage 1: Build the application using Maven with Java 26
FROM maven:3.9.9-eclipse-temurin-26 AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the application (skip tests to make deployment faster)
RUN mvn clean package -DskipTests


# Stage 2: Run the application with Java 26
FROM eclipse-temurin:26-jre
WORKDIR /app

# Copy the built .jar file from the first stage
COPY --from=build /app/target/*.jar app.jar

# Expose the standard Spring Boot port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]