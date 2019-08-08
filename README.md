                                   ANZ coding challenge

Design / Architecture:

 I have chosen Spring Boot to create this application. The reason for choosing Spring Boot is its convention over configuration approach and ability to create standalone applications.
Project structure was generated using Spring Initializer.

Tech-Stack Used to build application:

1) Spring boot embedded Tomcat Server

2) In-Memory h2 Database (but can be used with any jdbc compliant database)

3) Spring Rest

4) Jackson : Java to Json mapping

5) Unit Testing Persistence : JPA provided by Hibernate

6) JUnit : Unit Test Framework

7) Mockito : Mocking framework

8) Maven : Build integration

9) Build Environment: SpringToolSuit(STS)


How to run this application:

Clone the git repo using following command
git clone https://github.com/RamaKommineni/BankAccount.git

This will create a folder BankAccount in your current working directory.

Using application:

Query the below enpoints in PostMan to get the prepopulated records

1) And endpoint to get list of accounts registered under one user
endpoint URL: http://localhost:8080/bankapp/api/account/rama@gmail.com
http method= GET
add following  http headers:
key=Content-Type value=application/json

2) And endpoint to get list of transactions under one account
Endpoint URL: http://localhost:8080/bankapp/api/account/585309209/transactions
Http method= GET
add following  http headers:
key=Content-Type value=application/json

Design Patterns Used:
IOC, Facade

Testing:

JUnit coverage is provided for the application using the Mockito framework.

Author
Rama Kommineni









