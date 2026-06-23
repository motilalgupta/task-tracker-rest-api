# 📝 Task Tracker REST API

A simple Task Tracker REST API built using Spring Boot. This project demonstrates CRUD operations and PATCH requests without using a database. Tasks are stored in memory using Java collections.

## Features

* Create a task
* View all tasks
* Update a task
* Update task status using PATCH
* Update task title using PATCH
* Delete a task
* Filter tasks by due date

## Technologies Used

* Java
* Spring Boot
* Spring Web
* REST API
* Postman

## Task Model

```java
private Long id;
private String title;
private String description;
private Status status;
private LocalDate dueDate;
```

## Status Enum

```java
public enum Status {
    PENDING,
    DONE
}
```

## API Endpoints

### Get All Tasks

```http
GET /tasks
```

### Create Task

```http
POST /tasks
```

### Update Task

```http
PUT /tasks/{id}
```

### Update Task Status

```http
PATCH /tasks/{id}/status?status=DONE
```

### Update Task Title

```http
PATCH /tasks/{id}/title?newTitle=LearnSpringBoot
```

### Delete Task

```http
DELETE /tasks/{id}
```

### Filter Tasks by Due Date

```http
GET /tasks?dueBefore=2025-12-31
```

## Sample Request

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Build REST APIs",
  "status": "PENDING",
  "dueDate": "2025-12-31"
}
```

## Learning Outcomes

* REST API Development
* CRUD Operations
* HTTP Methods (GET, POST, PUT, PATCH, DELETE)
* Request Parameters
* Path Variables
* ResponseEntity Handling
* Enum Usage in Java
* Spring Boot Fundamentals

## Author

Motilal Gupta
Java & Spring Boot Developer

```
```
