# Full Stack Project - Backend

This project was built in Java Spring Boot. 

## Project Description

This project supports API services for [Insights](https://chriskokc.github.io/react-decision-making/). 

It allows users to reate, read, update and delete a particular decision record by setting up `GET`, `POST`, `PUT` and `DELETE` endpoints.

## Code structure
Within the API, several layers were created:
- `Controller`  for setting up endpoints
- `Service`  for hadnling all business logic of the API
- `Repository`  for communicating with databases
  
### Decision Model
Decision Class was created which stores users' data with the following properties:
- `id`
- `createdBy`
- `title`
- `content`
- `type`
- `dateCreated`

To create an object from the Decision Class, user requires to submit data in JSON format with the body:
```
{
  "createdBy": "userName",
  "title": "any title",
  "content": "any content",
  "type": "Life"
}
```

