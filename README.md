RecipesProject - Spring Boot Application

A Spring Boot REST API for managing recipes, supporting **JSON data import, sorting, and searching** with filters like calories, title, and rating.

Features
- Load recipes from a JSON file into the database.
- Retrieve recipes with **pagination** and **sorting by rating**.
- Search recipes by:
  - Calories (greater than / less than a given value)
  - Title (case-insensitive)
  - Rating (greater than / less than a given value)

Tech Stack
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL
- Jackson (ObjectMapper) for JSON parsing
