FROM openjdk:21-jdk
WORKDIR /app
COPY /build/libs/customer-service-0.0.1-SNAPSHOT.jar /app/myapp.jar
CMD ["java", "-jar","/app/myapp.jar"]