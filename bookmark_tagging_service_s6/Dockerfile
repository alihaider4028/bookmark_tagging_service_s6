FROM eclipse-temurin:17

WORKDIR /app

COPY target/search_service-s5-0.0.1-SNAPSHOT.jar /app/springboot-search.jar

ENTRYPOINT ["java", "-jar", "springboot-search.jar"]
