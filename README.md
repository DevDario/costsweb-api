<h1 align="center">
  CostsWeb Backend
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Purpose&message=Backend Infrastructure for a Frontend Project &color=8257E5&labelColor=000000" alt="Desafio" />
</p>

> Backend Infrastructure for [Costs-Web]([https://github.com/DevDario/Costs-Web) Project, A minimal **Project Manager System**

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Good Practices Applied

- SOLID, DRY, YAGNI, KISS
- API STATEFULL (using session-based authentication)
- Queries With Spring Data JPA
- DI(Dependency Injection)
- Error Treatments
- Automatic API docs Generation with Swagger OpenAPI 3

## How to Run 

- First you need to clone this to your machine
```bash
  git clone https://github.com/DevDario/costsweb-backend
```

- Then access it
```bash
  cd costsweb-backend
```

- Now you can build the project:
```bash
$ ./mvnw clean package
```
- and then run it:
```bash
$ java -jar target/costswebapi-0.0.1-SNAPSHOT.jar
```

You can access the API here: [localhost:8081](http://localhost:8081). <br>
And you can see Swagger running right here [localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## API Endpoints
1. Operations(CRUD) with Projects
2. Operations(CRUD) with Project Services

### 1. Operations(CRUD) with Projects

> _Note: I've used [httpie](https://httpie.io) to perform the above requests in the CLI_

- Create a new Project
```bash
$ http POST :8081/project/new name="project1" budget=1000 usedBudget:0.0 category:"DEVELOPMENT" deadline:"2024-10-14T00:00:00.000+00:00"

[
  {
    "id": 1,
	"name": "project1",
	"budget": 1000.0,
	"usedBudget": 0.0,
	"category": "DEVELOPMENT",
	"createdAt": "2024-10-14T00:00:00.000+00:00",
	"deadline": "2024-10-20T00:00:00.000+00:00",
	"services": []
  }
]
```

- List all Projects
```bash
$ http GET :8081/project/all

[
  {
    "id": 1,
	"name": "project1",
	"budget": 1000.0,
	"usedBudget": 0.0,
	"category": "DEVELOPMENT",
	"createdAt": "2024-10-14T00:00:00.000+00:00",
	"deadline": "2024-10-20T00:00:00.000+00:00",
	"services": []
  }
]
```

- Update a Project
```bash
$ http PUT :8081/project/edit/1 name="project1" budget=2000 usedBudget:0.0 category:"PLANNING" deadline:"2024-10-14T00:00:00.000+00:00"

[
  {
    "id": 1,
	"name": "project1",
	"budget": 2000.0,
	"usedBudget": 0.0,
	"category": "PLANNING",
	"createdAt": "2024-10-14T00:00:00.000+00:00",
	"deadline": "2024-10-20T00:00:00.000+00:00",
	"services": []
  }
]

```

- Delete a Project
```bash
http DELETE :8081/project/del/1

[ ]
```

### 2. Operations(CRUD) with Project Services

- Add(Create) a new service to a project
```bash
$ http POST :8081/project/1/services/new name="design" budget="500"

[
  {
    "id": 1,
	"name": "project1",
	"budget": 500.0,
	"usedBudget": 500.0,
	"category": "DEVELOPMENT",
	"createdAt": "2024-10-14T00:00:00.000+00:00",
	"deadline": "2024-10-20T00:00:00.000+00:00",
	"services": [
	    {
	        "id":1,
	        "name":"design",
	        "budget":500.0,
	        "description":""
	    }
	]
  }
]
```

- List all services from a project
```bash
$ http GET :8081/project/1/service/services

[
    {
	    "id":1,
	    "name":"design",
	    "budget":500.0,
	    "description":""
	}
]
```

- List all services from all projects
```bash
$ http GET :8081/service/all

[
    {
	    "id":1,
	    "name":"design",
	    "budget":500.0,
	    "description":""
	}
]

```

- Delete a service from a project
```bash
http DELETE :8081/project/1/service/services/1

[ ]
```
