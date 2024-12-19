# Market Checkout Component

This project implements a **market checkout system** using Spring Boot, with a REST API to handle item scanning, calculating totals, applying discounts, and generating receipts.

## Features
- **Stateful checkout:** Track scanned items and dynamically calculate the total.
- **Discounts:** Supports multi-price (e.g., buy 3 for 90 cents) and combo discounts (e.g., buy item X with item Y to save).
- **Receipt generation:** Generates a receipt with itemized pricing and discounts applied.
- **REST API:** Provides endpoints for scanning items, retrieving totals, and completing the checkout process.

## Technology Stack
- **Java**: Programming language.
- **Spring Boot**: Framework for building the service.
- **Maven**: Build automation tool.
- **JUnit**: Testing framework.
- **MockMvc**: Used for API integration testing.

## Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/gplayer777/CheckoutComponent.git
   cd checkoutcomponent
   ```

2. **Build the Project**:
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```
   The service will start at `http://localhost:8080`.

4. **Run Tests**:
   To run unit and integration tests:
   ```bash
   mvn test
   ```

## API Endpoints

### 1. **Scan Item**
   **POST** `/checkout/scan`
   - **Request Body**:
     ```json
     {
       "name": "A",
       "price": 50,
       "multiPriceThreshold": 3,
       "multiPriceValue": 30
     }
     ```
   - **Response**:
     ```text
     Item scanned: A
     ```

### 2. **Get Total**
   **GET** `/checkout/total`
   - **Response**:
     ```json
     {
       "cart": {
         "A": 3,
         "B": 1
       },
       "total": 160
     }
     ```

### 3. **Complete Checkout**
   **POST** `/checkout/complete`
   - **Response** (Example):
     ```text
     Receipt:
     3 x A @ 50 cents each
     1 x B @ 30 cents each
     Total: 180.0 cents
     ```



## Configuration
Default configurations (e.g., server port) can be modified in `src/main/resources/application.yml`:
```yaml
server:
  port: 8080
```

## Testing
- **Unit Tests:** Verify the logic of services like CheckoutService and PricingEngine.
- **Integration Tests:** Ensure API endpoints are functioning as expected.
- Run all tests with:
  ```bash
  mvn test
  ```

## Example Usage
1. Scan items using the `POST /checkout/scan` endpoint.
2. Retrieve the total using the `GET /checkout/total` endpoint.
3. Complete the checkout using the `POST /checkout/complete` endpoint to generate a receipt.




