# our base build image
FROM maven:3.6.1-jdk-11-slim AS maven
# copy the project files
COPY ./pom.xml ./pom.xml
# build all dependencies
RUN mvn dependency:go-offline -B
# copy your other files
COPY ./src ./src

# build for release
RUN mvn package
# our final base image
FROM openjdk:8u212-jre-alpine3.9
# set deployment directory
WORKDIR /weather-forecast-api
# copy over the built artifact from the maven image
COPY --from=maven ./target/weather-forecast-api.jar ./
# expose port
EXPOSE 8080
# set the startup command to run your binary
ENTRYPOINT ["java", "-jar", "./weather-forecast-api.jar"]