FROM eclipse-temurin:17-jdk-alpine

# Update package lists and install make
RUN apt-get update && \
    apt-get install -y \
        curl=7.68.0-1ubuntu2.8 \
        && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY target/server-0.0.1.jar server-0.0.1.jar
EXPOSE 8080
CMD ["java","-jar","server-0.0.1.jar"]