# JWT Authentication With Spring Boot 2
# Use Technologies below:

# Backend server

## All of the bellow technologies are used --

Spring Boot 2

Spring Security

Authentication and Authorization using JSON Web Token (JWT) 

Spring Data

Hibernate 5 + JPA 2

H2 Or Postgresql Database 


Lombok


Maven

# Build & run  Maven Spring Boot Applications 

Project name : Ejogajog Service

goto where pom.xml is keep

`mvn install`

`java -jar target/EjogajogService 0.0.1-SNAPSHOT.jar`

`mvn spring-boot:run`


# Swagger API Docs

When you run our application, specification will be generated. You can check it here:

### http://localhost:9090/v2/api-docs

### http://localhost:9090/swagger-ui.html#

## Added predefined roles data IN role table
-INSERT INTO roles(name) VALUES('ROLE_CUSTOMER');
-INSERT INTO roles(name) VALUES('ROLE_ADMIN');