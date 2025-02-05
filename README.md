# Cinema Web Platform

This project is an **autodidact study** aimed at building a web platform that manages data through a **SQL database** using **JPA** and **QueryDSL**. It follows the **MVC design pattern** and leverages **OpenAPI** to document and visualize all existing endpoints. An additional module, called **Framework**, handles login and authentication, using **Keycloak** as an external Identity Provider.

---

## Features

- **JPA & QueryDSL**: CRUD operations and dynamic queries on a PostgreSQL (or any SQL) database.  
- **MVC Design Pattern**: Separation of concerns among controllers, services, and repositories.  
- **OpenAPI**: Automatic generation of REST API documentation and interactive testing.  
- **Authentication & Authorization**:
  - Delegated to a second application named **Framework**.
  - **Keycloak** is used as the external Identity Provider for user management and token issuance.

---

## Technologies & Dependencies

- **Java & Spring Boot**  
- **Spring Data JPA** for database interactions  
- **Spring Web** for REST endpoints  
- **QueryDSL** for advanced query building  
- **OpenAPI (SpringDoc)** for automatic API documentation  
- **Keycloak** for identity management (via the Framework application)  
- **PostgreSQL** as the main database  

---

## Getting Started

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/YourUsername/cinema-web-platform.git

2. **Navigate to the Project**
   ```bash
   cd cinema-web-platform

3. **Build and Run**
   Using Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
Or import the project into your preferred IDE and run the main class.

4. **Check the Endpoints**
   
   Visit http://localhost:8080/swagger-ui.html or http://localhost:8080/swagger-ui/index.html to view and test available APIs.

## Authentication Flow
Keycloak is configured in the external Framework application, which handles user credentials and token generation.
This Cinema Web Platform consumes the token and enforces security rules via Spring Security integrations (to be added/configured).
