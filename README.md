# Stock Management System

Java console application for inventory and order management.

## Tech Stack
- Java 17
- Maven

## How to run
```bash
mvn clean compile
mvn exec:java

## Project Structure

- **app/** — Application entry point
- **domain/** — Domain entities
- **repository/** — Data access
- **service/** — Business rules
- **ui/** — Console menus

## Project Status

**Level 1 — console menus, category management and business validations**

- Maven project setup
- Layered architecture (domain, repository, service, ui)
- Domain exceptions (Business, Validation, NotFound)
- Category entity with validations
- In-memory repository
- Service layer with business rules
- Unit tests for category validations

## Current Features

- Console-based navigation with nested menus
- Category management:
  - Create categories via terminal
  - Validate unique and non-empty names
- In-memory persistence
- Clean architecture separation (UI, Service, Repository, Domain)