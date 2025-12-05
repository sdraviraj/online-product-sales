# Online Product Sales

The project uses:

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 in-memory database
- Liquibase (with SQL-based changelogs)
- JUnit 5 + MockMvc for tests

---

## How to Run

### 📄 API Documentation (Swagger / OpenAPI)

This project includes **interactive API documentation** using `springdoc-openapi`.

Once the application is running, you can access:

### Swagger UI
A browser-based interface to explore and test the API: http://localhost:8080/swagger-ui/index.html
### OpenAPI JSON Specification
Useful for front-end teams, Postman import, or API gateways: http://localhost:8080/v3/api-docs

### 1. Build

```bash
mvn clean install
```

### 2. Run

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## API

### POST `/api/cart/total`

Request body example (individual client):

```json
{
  "client": {
    "type": "INDIVIDUAL",
    "clientId": "C001",
    "firstName": "Ravi",
    "lastName": "Kumar"
  },
  "quantities": {
    "HIGH_END_PHONE": 1,
    "MID_RANGE_PHONE": 2,
    "LAPTOP": 1
  }
}
```

Request body example (professional client):

```json
{
  "client": {
    "type": "PROFESSIONAL",
    "clientId": "P001",
    "companyName": "Tech Corp",
    "registrationNumber": "REG123",
    "annualRevenue": 12000000
  },
  "quantities": {
    "HIGH_END_PHONE": 2,
    "LAPTOP": 1
  }
}
```

Response example:

```json
{
  "totalPrice": 2900
}
```

---

## Liquibase & Database

The project uses Liquibase with SQL-based changelog files:

- `db/changelog/db.changelog-master.xml`
- `db/changelog/sql/001-create-tables.sql`
- `db/changelog/sql/002-seed-products.sql`
- `db/changelog/sql/003-seed-clients.sql`

The schema is created and seed data is loaded automatically on application startup against an H2 in-memory database.

You can inspect the database using the H2 console:

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:productsalesdb`
- User: `sa`
- Password: *(empty)*

---cl

## Tests

Run all tests:

```bash
mvn test
```

This will run:

- `PriceServiceTest` – unit tests for price calculation rules
- `ShoppingCartServiceTest` – unit tests for cart total logic
- `ShoppingCartControllerTest` – MockMvc tests for the REST API

---

## Postman Collection

A Postman collection is included at the project root:

- `OnlineProductSales.postman_collection.json`

Import it into Postman to quickly test the API endpoints.
