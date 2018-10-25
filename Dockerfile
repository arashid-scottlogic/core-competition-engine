FROM openjdk:8-jre-alpine

# Set working directory
WORKDIR /app

# Copy jar file into container
COPY ./SNAPSHOT.jar /app

# port to expose
EXPOSE 80

CMD ["java", "-jar", "SNAPSHOT.jar"]