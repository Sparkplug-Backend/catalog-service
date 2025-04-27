# Sparkplug Catalog Service

Vehicle catalog management service for the Sparkplug platform. Built with Spring Boot 3 and Java 21.

## Features

- Vehicle catalog management (manufacturers, models, generations)
- JWT-based authentication and authorization
- Role-based access control (ADMIN_BASIC, ADMIN_MANAGER, ADMIN_GOD)
- Swagger/OpenAPI documentation
- Eureka client integration
- PostgreSQL database with Flyway migrations
- Caching support
- Feign client integration with Auth service

## Prerequisites

- Java 21
- Docker and Docker Compose
- Maven 3.9.9

## Configuration

### Environment Variables

Create a `.env` file in the root directory with the following variables:

```properties
POSTGRES_DB=your_db_name
POSTGRES_USER=your_db_user
POSTGRES_PASSWORD=your_db_password
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5402/your_db_name
SPRING_DATASOURCE_USERNAME=your_db_user
SPRING_DATASOURCE_PASSWORD=your_db_password
```

## Running the Service

1. Start the database:
```bash
docker compose up -d
```

2. Run the application:
```bash
mvn spring-boot:run
```

The application will start on port 8082.

## API Documentation

Once the service is running, access the Swagger UI at:
```
http://localhost:8082/swagger-ui/index.html
```

## Testing

Run tests with:
```bash
mvn clean test
```

Note: Tests use TestContainers for database integration testing.

## Security

- JWT-based authentication
- Role-based access control
- Public access for GET endpoints
- Admin roles required for POST, PUT, DELETE operations
- Bearer token authorization

## Dependencies

- Spring Boot 3.4.5
- Spring Security
- Spring Cloud Netflix Eureka Client
- Spring Cloud OpenFeign
- PostgreSQL
- Flyway
- MapStruct
- Lombok
- SpringDoc OpenAPI (Swagger)