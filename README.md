# Car Rental Web Application

This web application is developed using Spring MVC and is aimed at managing car rental operations. It provides functionalities for managing the car catalog, customers, and rental operations.

## Project Overview

The application is designed to facilitate the following operations:

- **Authentication**: Agents can log in to the system to access the functionalities.
- **Car Management**: Agents can add, modify, delete, and view details of cars in the catalog. Each car is characterized by its registration, brand, date of entry into circulation, and rental price.
- **Rental Operations**: Agents can manage rental transactions, including specifying start and end dates, type of guarantee, rental fees (cash or check), guarantee amount, etc.
- **Availability Check**: Agents can check the availability of cars for a requested period.
- **Customer Access**: Customers have access to view the catalog of cars based on various criteria.

## Project Structure

The project follows the standard Maven directory structure and includes the following key components:

- **Controller**: Handles incoming requests and controls the flow of the application.
- **Service Layer**: Implements business logic and interacts with repositories.
- **Repository Layer**: Manages data access and persistence.
- **Views**: Contains Thymeleaf templates for rendering HTML pages.

## Technologies Used

- **Spring Boot**: Provides a framework for building Spring-based applications with minimal configuration.
- **Spring Security**: Ensures secure authentication and authorization.
- **Spring Data JPA**: Simplifies data access and persistence.
- **Thymeleaf**: Enables server-side rendering of HTML templates.
- **MySQL**: Used as the relational database management system.
- **Lombok**: Reduces boilerplate code by providing annotations for common tasks.
- **JUnit**: Framework for unit testing.

## Build and Run

To build and run the application locally, follow these steps:

1. Make sure you have Java 20 installed on your system.
2. Set up MySQL and create the necessary database schema.
3. Clone the repository and navigate to the project directory.
4. Build the project using Maven: `mvn clean install`.
5. Run the application: `java -jar target/location_des_voitures-0.0.1-SNAPSHOT.jar`.
6. Access the application in your web browser at `http://localhost:8080`.

## Dependencies

The project relies on the following key dependencies:

- **Spring Boot Starter Security**
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Thymeleaf**
- **Spring Boot Starter Web**
- **Thymeleaf Extras Spring Security 6**
- **Spring Boot DevTools**
- **MySQL Connector/J**
- **Project Lombok**
- **Spring Boot Starter Validation**
- **Spring Boot Starter Test**
- **Spring Security Test**
- **JetBrains Annotations**
- **Spring Security Core**

## Additional Notes

- Ensure that the necessary environment variables and configurations are set up before running the application.
- For production deployment, consider configuring a proper logging mechanism and securing sensitive information.
