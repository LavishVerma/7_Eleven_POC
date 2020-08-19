# 7_Eleven_POC
Setting up the Project:-
1. Create two schemas in MySQL workbench
   - crudms
   - loginregisterms
   
2. Run "Eureka server" as a Spring boot application. This application will be running on http://localhost:8761/ 
3. Run "CRUD", "Dummy_Data" and "Login_register" microservices in any order.
-----------------------------------------------------------------------------------------------------------------------------------------
Available Endpoints

*Dummy_data microservice:-
>GET -  localhost:8003/user/dummydata/n  - n is the number of random data you want to insert into database.

*CRUD microservice-:
>GET -  localhost:8002/crud/data   -  To retriece all data.

>GET -  localhost:8002/crud/data/id   -  To retriece a specific data with id.

>POST - localhost:8002/crud/data   -  To store data into database.
   format:-{
        "name": "Bateman",
        "age": 75,
        "detectedcity": "Barnala",
        "detectedstate": "Andhra Pradesh",
        "date": "14-3-1969",
        "currentstatus": "Home-Qurantined"
    }
    
>PUT  -  localhost:8002/crud/data/id  - To update a specific data.  
 format:-{
        "name": "Bateman",
        "age": 75,
        "detectedcity": "Barnala",
        "detectedstate": "Andhra Pradesh",
        "date": "14-3-1969",
        "currentstatus": "Home-Qurantined"
    }
    
>DELETE  -  localhost:8002/crud/data/id  - To delete a specific data.  

*Login_regsiter microservice:-
>POST - localhost:8001/user/register  - To store user data into database.
format-{
  "phonenumber" : "7986301374",
  "email" : "lavishver97@gmail.com",
  "password" : "lavish123"
}

>POST - localhost:8001/user/login  - To check authenticity of user.
format-{
  "phone" : "7986301374",
  "password" : "lavish123"
}
    



-----------------------------------------------------------------------------------------------------------------------------------------
This project includes three Microservices
1. CRUD 
 > Perform CRUD operations into a database.
2. Login_register
 > Perform authentication.
3. Dummy_data
 > Save your time by generating random data.
