FROM devopsdynamo17/open-jdk-24-slim

WORKDIR /app

COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar

CMD ["java", "-jar", "api-gateway.jar"]
