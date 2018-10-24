FROM openjdk:8-jdk-alpine

# Set working directory
WORKDIR /app

# Copy current directory contents into container
COPY . /app

# port to expose
EXPOSE 80

RUN dos2unix gradlew
RUN ./gradlew build
CMD ["java", "-jar", "build/libs/application-0.0.1-SNAPSHOT.jar"]