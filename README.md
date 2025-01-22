This project is a backend service for a basic matchmaking system using spring boot


* Doctor in JSON Format:
```
{
    "id": "e04a4de0-1033-4352-9abd-4cef931bfbfe",
    "name": "ali jafarian",
    "specialization": "general surgery",
    "location": "tehran",
    "availability": true
}
```
* Patient in JSON Format:
```
{
    "id": "3667b4c1-20ca-418c-8c22-7c82aab9e8a1",
    "name": "sadeq rezaei",
    "medicalCondition": "general surgery",
    "preferredLocation": "isfahan"
}
```

### Post Method 
Endpoints:
* http://localhost:8080/doctors
* http://localhost:8080/patients

### Get Method
Endpoints:
* http://localhost:8080/doctors
* http://localhost:8080/doctors/{id}
* http://localhost:8080/patients
* http://localhost:8080/patients/{id}
* http://localhost:8080/match/{id}/basedOn/all
* http://localhost:8080/match/{id}/basedOn/locationAndSpecialization
* http://localhost:8080/match/{id}/basedOn/specialization

### Put Method
Endpoint:
* http://localhost:8080/doctors
* http://localhost:8080/patients

### Delete Method
Endpoints:
* http://localhost:8080/doctors/{id}
* http://localhost:8080/patients/{id}


##  Technologies Used 
*  Spring Boot 
*  H2 
*  Hibernate

##  IDE used
*  IntelliJ IDEA


> **Note:** By default spring boot application starts on port number 8080. If port 8080 is occupied in your system then you can change the port number by uncommenting and updating the **server.port** property inside the **application.yml** file that is available inside the **src > main > resources** folder.

