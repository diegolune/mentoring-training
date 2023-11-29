<h1 align="center">
  <br>
  <a href="https://github.com/diegolune"><img src="https://avatars.githubusercontent.com/u/151127090?v=4" alt="Diego Luna" width="200"></a>
  <br>
  Diego Luna
  <br>
</h1>

## How To Use

To clone and run this application, you'll need [Git](https://git-scm.com) and [Maven](https://maven.apache.org/download.cgi).

From your command line:


```bash
# Clone this repository on your selected folder
#HTTPS
$ git clone https://github.com/diegolune/mentoring-training.git

#SSH
$ git clone git@github.com:diegolune/mentoring-training.git

# Go into the repository
$ cd mentoring-training

# Install dependencies
$ mvn clean install

# Run the app
$ mvn spring-boot:run
```

## To see endpoints locally:
go to api`s [endpoint](http://localhost:8080/swagger-ui/index.html)

## Accessing local H2 database
go to [H2 database console](http://localhost:8080/h2-console/l)

Fill out params with below values: 
    
    JDBC URL: jdbc:h2:mem:testdb
    
    User Name: diego
    
    Password: password




