Tools/Technology:
Java 8
Spring Boot 2.0
Hibernate 5.0
Tomcat
Spring security using basic auth
Spring Tool Suite

Projcct Set up:
1) Unzip the file
2) Import the project as existing projet into STS (Spring tool suite)
3) Clean, build project through STS provided utility under 'project' tab
4) Go to Run Configurations
5) In left pane, right click on Spring boot app, click new configuration, provide any arbitrary name for run configuarion, 
   select project under 'project' dropdown (assignment in this case), click on search button against 'Main Type' label; 
   select 'com.uxpsystems.assignment.DemoApplication'.
6) Click on run button.
7) This will start the inbuilt tomcat server and deploy the application.


Testing application:
1) Install Postman
2) Import the collection named 'Amdocs.postman_collection.json' stored inside 'assignment' folder into Postman by going to file -> import -> browse to file 'Amdocs.postman_collection.json'.
3) Under each postman request(getUser, createUser etc), go to 'authorization' tab. Select 'Authorization Type' as 'Basic Auth'.
   Give username as 'Abhishek' and password as 'Amdocs@123'. Hit the 'send' button. Corresponding response will be collected under response body tab.
   The URL are as below:

  GET USer By Id : http://localhost:8085/users/{id}
  ex http://localhost:8085/users/1

  GET ALL Users:  http://localhost:8085/users

  POST : http://localhost:8085/users
        Sample Request Body:  {
    "username": "Mahesh1",
    "password": "Mahesh@johnson",
    "userStatus": "Activated"
}

  PUT: http://localhost:8085/users/{id}
       Sample Request Body: {
    "id":{id},
    "username": "Pooja_M",
    "password": "Pooja@citi",
    "userStatus": "Activated"
}

     replace {id} with actual existing user id in both URL and JSON body.

  DEL: http://localhost:8085/users/{id}

 
   

