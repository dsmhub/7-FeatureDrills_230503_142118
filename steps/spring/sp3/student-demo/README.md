# Spring Ex6 - Spring Data JPA

Project student-demo

Set up a simple Spring application with REST API & PostgreSQL database using Maven.

- simple spring application
    - basic dependencies:
      - org.springframework.boot:spring-boot-starter-parent:3.4.4
        spring-boot-starter-web 
        spring-boot-starter-test
        spring-boot-starter-data-jpa
      org.junit.jupiter:junit-jupiter
      org.assertj:assertj-core:2.7.0

- REST API with DB connection (PostgreSQL)
- application.properties file to hold app properties including server & logging configuration.

# TODO
- smoke test to check app starts, controller is available and simple http request returns successfully.
- unit test for the controller using MockMvc, simulating http requests without running the full server.

Spring Boot Tutorial (2023)
https://www.youtube.com/watch?v=9SGDpanrc8U
https://github.com/amigoscode/spring-data-jpa-course

- https://spring.io/projects/spring-data-jpa
- https://start.spring.io/
- https://docs.spring.io/spring-boot/appendix/application-properties/index.html
- https://spring.io/guides/gs/testing-web
- https://spring.io/
- https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/overview.html



# Sample Application Properties Settings

spring.application.name=student-demo
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true

server.error.include-message=always







