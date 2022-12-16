# Automatic Irrigation System
Developed by [Taiye Ogunlade](https://www.linkedin.com/in/taiye-ogunlade/)

# How to run this project

Java Version 17 is required to run this project.

The following guides illustrate how to run this project :

**1. Clone the project into your IDE** from https://github.com/syntax-tee/AutomaticIrrigationSystem.git <br/>
**2. Run maven command from terminal** ./mvnw spring-boot:run  <br/>

### Database Entity Relationship Diagram(ERD)
![Screenshot 2022-12-15 at 12 02 09](https://user-images.githubusercontent.com/49109632/207843383-2ae8a2cb-6418-4424-a516-61156fdc82dc.png)


### Database Model and Seed

Database seed data can be found in **data.sql**</br>
[src/main/resources/data.sql](https://github.com/syntax-tee/AutomaticIrrigationSystem/blob/master/src/main/resources/data.sql) </br>

Database schema is defined in  **schema.sql**</br>
[src/main/resources/schema.sql](https://github.com/syntax-tee/AutomaticIrrigationSystem/blob/master/src/main/resources/schema.sql) </br>

### Integration and Unit Tests
[src/test/java/com/ogunladetaiye/automaticirrigationsystem](https://github.com/syntax-tee/AutomaticIrrigationSystem/blob/master/src/test/java/com/ogunladetaiye/automaticirrigationsystem) </br>

### Application logs
[Logs Folder](https://github.com/syntax-tee/AutomaticIrrigationSystem/tree/master/logs) </br>

### Twilio SMS Alert
[Alert System Config](https://github.com/syntax-tee/AutomaticIrrigationSystem/tree/master/src/main/java/com/ogunladetaiye/automaticirrigationsystem/smsconfig) </br>
[Alert Service](https://github.com/syntax-tee/AutomaticIrrigationSystem/tree/master/src/main/java/com/ogunladetaiye/automaticirrigationsystem/services/AlertServiceImpl.java) </br>

### Database Documentation

http://localhost:8081/irrigation/h2-console

**Username:** admin </br>
**Password:** password
  
![Screenshot 2022-12-15 at 10 37 18](https://user-images.githubusercontent.com/49109632/207827311-e659dc9c-969a-48be-81a3-7028bf2e9b3e.png)
### Swagger API  Documentation

http://localhost:8081/irrigation/swagger-ui/index.html

![Screenshot 2022-12-15 at 10 36 58](https://user-images.githubusercontent.com/49109632/207827449-903baed6-b721-4b8a-8710-92fa4082b3c8.png)
