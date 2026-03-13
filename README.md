# Student Management System

A full-stack Student Management System built using Spring Boot and MySQL.

## Features

- Add Student
- View Student List
- Update Student
- Delete Student
- Pagination Support
- Search Students
- Input Validation
- Exception Handling
- Swagger API Documentation

## Tech Stack

Backend:
- Spring Boot
- Spring Data JPA
- REST APIs

Database:
- MySQL

Frontend:
- HTML
- CSS
- JavaScript
- Bootstrap

## Project Architecture

Browser UI
↓
Controller
↓
Service
↓
Repository
↓
MySQL Database

## API Endpoints

POST /students  
GET /students/{id}  
PUT /students/{id}  
DELETE /students/{id}  
GET /students/pagination?page=0&size=10

## How to Run

1. Start MySQL database
2. Run Spring Boot application
3. Open browser

http://localhost:8080
