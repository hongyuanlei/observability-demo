FROM maven:3.8.3-openjdk-17 AS build

ARG OPEN_TELEMETRY_AGENT_VERSION=2.14.0
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v${OPEN_TELEMETRY_AGENT_VERSION}/opentelemetry-javaagent.jar /tmp/
RUN chmod 644 /tmp/opentelemetry-javaagent.jar

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-slim

WORKDIR /app

COPY --from=build /tmp/opentelemetry-javaagent.jar /opt/otel/opentelemetry-javaagent.jar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", \
    "-javaagent:/opt/otel/opentelemetry-javaagent.jar", \
    "-Dotel.service.name=my-kotlin-app", \
    "-jar", \
    "app.jar"]

