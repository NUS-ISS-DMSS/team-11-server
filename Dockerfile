FROM eclipse-temurin:17-jdk-alpine

# Install required packages
RUN apk update && \
    apk add --no-cache \
        make \
        # Add other testing dependencies here \
    && rm -rf /var/cache/apk/*

WORKDIR /app
COPY target/server-0.0.1.jar server-0.0.1.jar
EXPOSE 8080
CMD ["java","-jar","server-0.0.1.jar"]