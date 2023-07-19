This application is part of the coding challenge sent to me from Genesys as part of the interview process. 

In this application I have taken the backend challenge, where I had to create a REST API to query data and return sensor information (e.g temperature and windspeed) 
and return this with filtering, an example query might be "Return the temperature from sensor one in the last 14 days". 

I created classes that would be used in the database, I then created a service file where this would action upon these variables. 
From here I created a repository class that would then be leveraged to make queries to the database and return/update/create the queries in the form of GET and POST requests. 
I created a controller class that would handle the GET and POST requests. 

I also added a class that would give exception handling for certain requests (i.e. setTemperature() in the SensorData.java file). 

The GET and POST requests were accessed via Postman where I would make a call to my localhost (example: GET - http://localhost:8080/api/all-temperature this would retrieve all the temperature details for all 30 days in the database)

I created the database using MySQL Workbench, I created a connection that I specified in the application.properties file and from here I was able to access the database. 

I posted information to the database using a POST request which would save the inputted JSON to the database under the certain columns that I had attached appropriate annotations to the variables used. 

My process to getting this to work is:
    1) I set up a database in MySQL workbench with the data in the application.properties file, I then called the database genesys and created a schema called genesys
    2) I started the application which then created the table and database on the MySQL Workbench application
    3) I then went to Postman and I ran a POST request with specified JSON information that I created and I populated the database with the POST request - http://localhost:8080/api/sensor-data
    4) From there I can call specific post requests and GET requests, an example of these are;
            i) POST - http://localhost:8080/api/sensor-data
            ii)GET - http://localhost:8080/api/http://localhost:8080/api/all-temperature


