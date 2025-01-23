
# Demo Spring Boot Application for Kafka and Avro

This Spring Boot application consumes product events from a Kafka topic, processes them, and stores the data in a PostgreSQL database. It also demonstrates publishing Avro schemas to a schema registry.

---

## Prerequisites

Ensure the following are installed on your system:
- **Docker** and **Docker Compose** (for PostgreSQL and Kafka setup)
- **Java 21+** (for Spring Boot)
- **Maven** (for building the application)

---

## Getting Started

### 1. Clone the Repository
Clone the repository and navigate to the project directory:
```bash
git clone https://github.com/minarashidi/spring-kafka-avro-demo.git
cd spring-kafka-avro-demo
```

---

### 2. Kafka and PostgreSQL Setup

1. Navigate to `/scripts`
2. run `./start-services.sh`
3. Run `./create-database.sh`
4. Launch the application using: `mvn spring-boot:run`
5. To interact with the database, you can run:
    - `docker ps` to obtain the Container ID for the postgres image, then execute:
    - `docker exec -it <CONTAINER_ID> psql product_catalog -U postgres`
    - While in the container, run `\dt product_catalog.` to view the list of created tables.
      `select * product_catalog.product;`


This will start the following:
- **Kafka Broker** on `localhost:9091`
- **Zookeeper** on `localhost:2181`
- **PostgreSQL** on `localhost:5432`

---

### 3. Build the Application

Build the application using Maven:
```bash
mvn clean package
```

---

### 4. Configure Application Properties

The application is pre-configured to connect to Kafka and PostgreSQL. Ensure the following configuration in `application.yml` matches your setup:

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9091
    consumer:
      group-id: product-events
  datasource:
    url: jdbc:postgresql://localhost:5432/product_catalog
    username: user
    password: password
```

---

### 5. Run the Application

#### Using Maven
You can run the application using Maven:
```bash
mvn spring-boot:run
```

---

### 6. Testing the Application

## Testing the Application

1. Publish a test product event to Kafka:
   Use a Kafka producer or a CLI tool to send data to the configured topic. For example:
   
``` json
{
"id": "12345",
"name": "Wireless Mouse",
"price": 29.99,
"currency": "USD",
"category": "Electronics",
"subCategory": "Accessories",
"createdAt": "2023-12-01T10:00:00Z",
"updatedAt": "2023-12-10T15:30:00Z"
}
 ```

2. Verify the following:
- The consumer processes the event successfully without errors.
- Product details are stored correctly in the PostgreSQL `product` table.
