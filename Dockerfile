FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN ./mvnw package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/hotel-booking-1.0.0.jar"]
