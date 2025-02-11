##FROM ubuntu:latest
##LABEL authors="saisrinathalla"
##
##ENTRYPOINT ["top", "-b"]
## Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from target directory
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]






## Stage 1: Build the application
#FROM maven:3.8.7-amazoncorretto-17 AS build
#WORKDIR /app
#COPY . .
#RUN mvn clean package -DskipTests
#
## Stage 2: Create the final lightweight image
##FROM amazoncorretto:17-alpine
#FROM eclipse-temurin:17-jre-jammy
#
#
#WORKDIR /app
#COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]
