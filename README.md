Task Management Microservices
================================
This repository contains a Task Management Microservices System built using Spring Boot, Spring Cloud, Eureka, JWT Security, and MySQL. The system is designed to manage tasks,
users, and submissions in a scalable microservices architecture.

Architecture

The system follows a microservices architecture with the following components:

User Service <----> Task Service <----> Submission Service
        \               /
         \             /
         ---- Task-Gateway ----
                |
            Eureka Server


User Service – Manages user registration, authentication, and profile management.

Task Service – Handles task creation, updating, and management.

Submission Service – Manages submissions related to tasks.

Task-Gateway – API Gateway for routing requests to microservices.

Eureka Server – Service discovery for all microservices.

JWT Security – Secures APIs with JWT authentication.

MySQL Database – Stores persistent data for all services.

Services
1. User Service

Handles user registration, login, and profile management.

JWT authentication integrated.

Endpoints: /api/users/**

2. Task Service

Create, update, delete, and view tasks.

Links tasks to users.

Endpoints: /api/tasks/**

3. Submission Service

Allows users to submit task completions.

Endpoints: /api/submissions/**

4. Task-Gateway

Central API gateway for routing requests.

Load balancing and JWT token validation.

5. Eureka Server

Handles service registration and discovery.

Each microservice registers with Eureka for dynamic discovery.

Technologies

Backend: Java, Spring Boot, Spring Cloud

Microservices: Eureka Server, Spring Cloud Gateway

Security: JWT Authentication, Spring Security

Database: MySQL

Build Tool: Maven

Other: REST API, JSON

Setup & Installation
Prerequisites

Java 17+
