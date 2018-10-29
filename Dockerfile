FROM openjdk:8-jre-alpine

# Set working directory
WORKDIR /app

# Copy jar file into container
COPY ./output/application.jar /app

# port to expose
EXPOSE 8080

CMD ["java", "-jar", "application.jar"]