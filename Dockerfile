FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/javaee-spring-demo-1.0.0.war app.war

ENTRYPOINT ["java", "-jar", "app.war"]
