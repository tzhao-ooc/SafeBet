# compile application into package
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# run application
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/safebet-0.0.1-SNAPSHOT.jar safebet.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","safebet.jar" ]