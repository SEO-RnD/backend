# Seo Guides Backend

This is the backend service for the **Seo Guides** application.
It is built with **Java 21**, **Spring Boot 3.5**, and **PostgreSQL**.

---

## 📦 Requirements

- Java 21+
- Maven 4+
- Docker & Docker Compose (optional, for local dev DB)
- Git

---

## 🚀 Development

### 1. Clone the repository
```bash
git clone https://github.com/SEO-RnD/backend.git
cd backend
```

### 2. Build the project
```bash
mvn clean install
```

This will:
- Compile the code
- Run unit/integration tests
- Package a runnable JAR into `target/backend-0.0.1-SNAPSHOT.jar`

---

## 🐳 Running with Docker Compose

A local PostgreSQL + pgAdmin environment is provided via Docker Compose.

```bash
docker compose up -d
```

## 🛠 Running Locally (without Docker)

You can run the application directly from Maven:

```bash
mvn spring-boot:run
```

By default, it will try to connect to a PostgreSQL database.
For testing without PostgreSQL, configure H2 or disable Flyway.

---

- Database: `jdbc:postgresql://db:5432/seo_guides`
- Username: `seo`
- Password: `seo`
- PgAdmin: http://localhost:8081 (admin@local / admin)

---

## ▶️ Run the App in Docker

First build the JAR:

```bash
mvn clean package -DskipTests
```

Then build the Docker image:

```bash
docker build . -f Dockerfile.prod -t backend:prod .
```

A local PostgreSQL + pgAdmin environment is provided via Docker Compose.

```bash
docker compose up -d
```

Run the backend

```bash
docker run -d --name seo-guides-app\
  --network "$NET" \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e SPRING_DATASOURCE_URL='jdbc:postgresql://db:5432/seo_guides' \
  -e SPRING_DATASOURCE_USERNAME=seo \
  -e SPRING_DATASOURCE_PASSWORD=seo \
  -e SPRING_JPA_HIBERNATE_DDL_AUTO=none \
  -e SPRING_FLYWAY_ENABLED=false \
  backend:prod
```

---

## 🔍 Endpoints

Common endpoints (depending on configuration):

- Health check:
  ```
  http://localhost:8080/actuator/health
  ```

---

## 🧪 Running Tests

```bash
mvn test
```

Tests include health checks and integration tests.

---
