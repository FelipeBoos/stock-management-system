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
- **service/** — Business rules and validations
- **ui/** — Console menus and navigation
- **util/** - Console utilities

## Project Status

Level 1 — Category CRUD (console) + Product entity added (domain)

- aven project setup
- Layered architecture (domain, repository, service, ui)
- Domain exceptions (BusinessException, ValidationException, NotFoundException)
- Category entity with validations
- In-memory repository
- Service layer with business rules
- Unit tests for category validations
- Console menu navigation with loops and pause behavior
- Initial Product domain entity

## Current Features

- Console-based menu system with navigation and pause handling
- Category management via console (full CRUD):
  - Create
  - List
  - Update
  - Delete
- Product management via console:
  - entity and repository only; service and validations next
- In-memory persistence
- Clean architecture separation (UI, Service, Repository, Domain)