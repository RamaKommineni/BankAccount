                                   Tabcorp coding challenge

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


Application Assumptions:
Regarding (Total number of bets sold per hour) rest endpoint, requirement was not clear. So I have assumed that I will pass fromDate and toDate as request parameters to limit the number of records return in the response.


How to run this application

Clone the git repo using following command
git clone https://github.com/RamaKommineni/Tabcorp.git

This will create a folder tabcorp in your current working directory.

Using application:

Create some bets using any Rest client (I have used Postman)

endpoint URL: http://localhost:8080/api/bet/create

http method= POST

add following  http headers:
 
key=Content-Type value=application/json

Paste the following content to the body section then click send

{
 "customerID":345,
 
 "dateTime":"2019-05-28 11:58",
 
  "betType":"WIN",
  
  "propNumber":456,
  
  "investment":2000 
  
  }
  
By running this URL multiple times with the different bets, we can create multiple bets and can be stored in DB for testing the rest of the api's.
  
==>Run the following endpoint to get Total investment per bet type:

endpoint URL: http://localhost:8080/api/bet/getInvestmentPerBetType

key=Content-Type value=application/json

"method": "GET"


==>Run the following endpoint to get Total investment per CustomerID:

endpoint URL: http://localhost:8080/api/bet/getInvestmentPerCustomerID

key=Content-Type value=application/json

"method": "GET"



==>Run the following endpoint to get Total bets sold per BetType

endpoint URL: http://localhost:8080/api/bet/getTotalBetsSoldPerBetType

key=Content-Type value=application/json

"method": "GET"



==>Run the following endpoint to get Total number of bets sold per Hour

endpoint URL: http://localhost:8080/api/bet/getTotalNumberOfBetsSoldPerHour

key=Content-Type value=application/json

"method": "GET"

Here we need to send the toDate and fromDate query params to get the bets sold per hour.

"key": "fromDate", "value": "2019-05-24"

"key": "toDate","value": "2019-05-27"



Testing:

JUnit coverage is provided for the application using the Mockito framework.

Author

Rama Kommineni









