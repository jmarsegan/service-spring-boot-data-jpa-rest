Launch :
 - cd service-spring-boot-data-jpa-rest
 - mvn spring-boot:run
 
 Endpoints : => cf tests unitaires
  - GET http://localhost:8080
  - GET http://localhost:8080/people
  - GET http://localhost:8080/people/1
  - 
$ curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8080/people
HTTP/1.1 201 Created
Server: Apache-Coyote/1.1
Location: http://localhost:8080/people/1
Content-Length: 0
Date: Wed, 26 Feb 2014 20:26:55 GMT

 Devtools :
  - live restart
  
 Unit Test :
  - WebEnvironment.RANDOM_PORT
