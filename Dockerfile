FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/javaee-spring-demo-1.0.0.war app.war

COPY scripts/wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

ENTRYPOINT ["./wait-for-it.sh", "db:5432", "--timeout=30", "--strict", "--", "java", "-jar", "app.war"]
