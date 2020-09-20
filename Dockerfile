FROM zenika/alpine-maven:3-jdk-8 AS build
COPY src /app/src
COPY pom.xml /app/
RUN mvn -f /app/pom.xml clean package -DskipTests


FROM openjdk:8-jre-alpine
COPY --from=build /app/target/tcc-0.0.1-SNAPSHOT.jar /app/tcc-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "/app/tcc-0.0.1-SNAPSHOT.jar"]