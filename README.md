# hibernate-jpa-examples
Here’s a professional and complete README.md template for your Hibernate JPA examples repository covering basic to advanced JPA and Hibernate concepts:

## Hibernate JPA Examples

This repository contains various Hibernate JPA examples demonstrating key concepts and features of Java Persistence API using Hibernate as the JPA provider. It covers everything from basic entity mapping to advanced features like relationships, JPQL, Criteria API, caching, and transactions.
---

## Technologies Used

- Java 21
- Spring Boot 3.5.3
- Hibernate ORM (5.x or 6.x)
- JPA (Java Persistence API)
- Maven or Gradle (build tools)
- H2 / MySQL / PostgreSQL (databases)
- Lombok (optional)
- Postman (for API testing)

---


## Project Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/shreyamahalle/hibernate-jpa-examples.git
   cd hibernate-jpa-examples
   ```

1. Import the project into your favorite IDE (IntelliJ IDEA, Eclipse).

2. Configure the database connection in application.properties or application.yml.

3. Build the project with Maven:

   ```bash
   mvn clean install
   ```

4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

## Examples Included
Basic Examples
Entity mapping (@Entity, @Table)

Primary key strategies (@Id, @GeneratedValue)

Basic CRUD operations with JpaRepository

Relationships
One-to-One (@OneToOne)

One-to-Many / Many-to-One (@OneToMany, @ManyToOne)

Many-to-Many (@ManyToMany)

Cascade types and fetch strategies

JPQL and Native Queries
Writing JPQL queries

Named queries

Native SQL queries

Criteria API
Building dynamic queries programmatically

Transaction Management
@Transactional usage

Propagation and isolation levels

Advanced Mapping
Inheritance strategies (@Inheritance)

Embeddable types (@Embeddable, @Embedded)

Lifecycle callbacks (@PrePersist, @PostLoad, etc.)

How to Run
Start the application (default port 8080).

Use Postman or any REST client to test REST APIs (if included).

Check console logs for SQL queries executed.

Modify entities or repository methods to test various scenarios.

Basic JPA Concepts
Entities represent tables.

Use EntityManager or Spring Data JPA repositories for DB operations.

Relationships between entities define foreign keys.

JPQL is an object-oriented query language.

Advanced JPA Examples
Use Criteria API for complex, dynamic queries.

Cascade types manage child entity persistence.

Inheritance strategies map Java inheritance to DB tables.

Lifecycle callbacks handle entity state changes.

Additional Resources
Official Hibernate Documentation

Spring Data JPA Reference

Baeldung JPA Tutorials

Contributing
Contributions are welcome! Please fork the repository and submit a pull request for improvements, new examples, or fixes.

License
This project is licensed under the MIT License - see the LICENSE file for details.
