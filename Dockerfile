FROM eclipse-temurin:11-jre
COPY target/project-barbershop*.jar /usr/src/project-barbershop.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/project-barbershop.jar", "--spring.config.location=file:/opt/conf/application.properties"]