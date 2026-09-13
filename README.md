# Spring Boot Academic Management API (Lab 7)

A RESTful Spring Boot web application for managing academic resources—specifically **Classrooms** and **Courses**—with Jakarta Validation and in-memory storage.

---

## Technical Features

* **Framework:** Spring Boot 3.x
* **Language:** Java 17+
* **Validation:** Jakarta Validation (`@Valid`, `@Pattern`, `@Size`, `@Positive`, etc.)
* **Boilerplate Reduction:** Project Lombok (`@Data`, `@AllArgsConstructor`, `@RequiredArgsConstructor`)
* **Storage:** In-memory `ArrayList` within Service layers

---

## Prerequisites & Installation

1. **Java Development Kit (JDK 17 or higher)** installed.
2. **Maven** or your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Clone the project and run the application:

```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run
