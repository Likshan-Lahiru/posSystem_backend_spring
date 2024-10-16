---

# **POS System Spring API Project**

## **Project Overview**

This project is a fully functional **API** built using **Spring**, **Spring Data JPA**, and **Hibernate** for database management with **MySQL**. The API provides endpoints for managing customers, orders, and other resources in a POS (Point of Sale) system.

The project includes:
- **Spring Web MVC** for building the web interface.
- **Spring Data JPA** for ORM (Object-Relational Mapping).
- **AJAX (or Fetch API)** for client-side requests and responses.
- **Logging** to track application events at appropriate levels.
- Complete **API documentation** linked below for reference.

## **Tech Stack**
- **Backend**: Spring Boot (Spring Web MVC)
- **ORM**: Spring Data JPA with Hibernate
- **Database**: MySQL
- **Frontend**: AJAX (or Fetch API)
- **Logging**: SLF4J with Logback
- **Testing**: JUnit and Mockito

## **Frontend**

The frontend application provides a user-friendly interface to interact with the RESTful API. It communicates with the backend using AJAX (or Fetch API) to perform asynchronous operations, ensuring a smooth and responsive user experience.

- **Frontend Repository URL**: [GitHub Frontend Repository](https://github.com/Likshan-Lahiru/pos_system.git)
- **Features**:
  - Responsive design for various devices.
  - Real-time data updates without full page reloads.
  - User authentication and authorization (if applicable).
  - Interactive forms for creating and updating resources.

**Note**: Ensure that the frontend is configured to communicate with the backend API's base URL. You might need to update environment variables or configuration files in the frontend project to point to the correct API endpoints.

## **Backend API**

- **API Documentation**: You can view the full API documentation on Postman [here](https://www.postman.com/supply-engineer-31331527/possystem-spring/collection/vc5wb07/possystem-spring?action=share&creator=36186170).

## **Logging**

The application uses **SLF4J** with **Logback** for efficient logging management. Each log entry is categorized by levels such as:
- **INFO**: Tracks general information about the application's state.
- **DEBUG**: Provides detailed output for debugging purposes.
- **ERROR**: Logs critical failures and exceptions.

Log files are stored in the `logs/` directory and can be configured through the `logback.xml` file.

## **Project Structure**

```
src/
├── main/
│   ├── java/
│   │   ├── com.example.possystem/
│   │   │   ├── config/        # Spring configuration
│   │   │   ├── controller/    # Controllers handling API requests
│   │   │   ├── dao/           # Data Access Objects
│   │   │   ├── dto/           # Data Transfer Objects
│   │   │   ├── entity/        # Entity classes
│   │   │   ├── exception/     # Custom exceptions
│   │   │   ├── filter/        # Request filters
│   │   │   ├── service/       # Business logic
│   │   │   ├── util/          # Utility classes
│   │   │   ├── repository/    # Database interactions (Spring Data JPA)
│   ├── resources/
│   │   ├── logback.xml        # Logging configuration
│   │   ├── application.properties  # Application configuration
├── test/                        # Unit and integration tests
```

## **API Endpoints Overview**

The API supports basic CRUD operations for resources. Below is a quick overview of key endpoints:

- **Customers**
  - `GET /api/customers`: Fetch all customers.
  - `GET /api/customers/{id}`: Fetch a customer by ID.
  - `POST /api/customers`: Create a new customer.
  - `PUT /api/customers/{id}`: Update an existing customer by ID.
  - `DELETE /api/customers/{id}`: Delete a customer by ID.

- **Orders**
  - `GET /api/orders`: Fetch all orders.
  - `GET /api/orders/{id}`: Fetch an order by ID.
  - `POST /api/orders`: Create a new order.
  - `PUT /api/orders/{id}`: Update an existing order by ID.
  - `DELETE /api/orders/{id}`: Delete an order by ID.

- **Item**
  - `GET /api/products`: Fetch all products.
  - `GET /api/products/{id}`: Fetch a product by ID.
  - `POST /api/products`: Create a new product.
  - `PUT /api/products/{id}`: Update an existing product by ID.
  - `DELETE /api/products/{id}`: Delete a product by ID.

*Note: Replace `{id}` with the actual resource ID.*

## **Getting Started**

### **Prerequisites**

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK)**: Version 21.
- **Maven**: For building the project.
- **MySQL Database**: Ensure MySQL is installed and running.
- **Git**: For cloning the repository.

### **Installation**

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Likshan-Lahiru/posSystem_backend_spring.git
   ```

2. **Navigate to the Project Directory**

   ```bash
   cd pos_system
   ```

3. **Configure the Database**

   - Create a new MySQL database for the project.
   - Update the `` file located in `src/main/resources/` with your database credentials:

   

4. **Build the Project**

   ```bash
   mvn clean install
   ```

### **Running the Application**

After successfully building the project, you can run the application using the following command:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080/` by default.

### **Accessing the API Documentation**

Access the comprehensive API documentation via Postman:

- **Postman Collection**: [POS System API Documentation](https://www.postman.com/supply-engineer-31331527/possystem-spring/collection/vc5wb07/possystem-spring?action=share&creator=36186170)

### **Testing**

The project includes unit and integration tests using **JUnit** and **Mockito**.

- **Run Tests**

  ```bash
  mvn test
  ```

## **Configuration**



The `application.properties` file located in `src/main/resources/` contains configuration settings for the application. Key configurations include:

- **Database Configuration**

 
- **Server Port**

  To change the default server port (8080):



- **Logging Configuration**

  Logging is configured via `logback.xml` in the same directory.

### **Environment Variables**



## **Deployment**

To deploy the application to a production environment:

1. **Build the Project**

   ```bash
   mvn clean package
   ```

   This will generate a JAR file in the `target/` directory.

2. **Run the JAR**

   ```bash
   java -jar target/pos_system-0.0.1-SNAPSHOT.jar
   ```

3. **Configure Environment**

   Ensure that the production database is properly configured and accessible by the application. Update the `application.properties` or use environment variables to set production-specific configurations.



## **License**

This project is licensed under the [MIT License](LICENSE).

## **Acknowledgments**

- **Spring **: For providing a robust framework for building Java applications.
- **Hibernate**: For simplifying ORM and database interactions.
- **MySQL**: For being a reliable and widely-used database system.
- **JUnit & Mockito**: For facilitating effective testing.
- **SLF4J & Logback**: For efficient logging management.
- **Open Source Contributors**: For their invaluable contributions to the tools and libraries used in this project.

## **Contact**

For any inquiries or feedback, please contact:

- **Name**: Likshan Lahiru
- **Email**: [your.email@example.com](mailto:lahiru212001email@example.com)
- **GitHub**: [https://github.com/Likshan-Lahiru](https://github.com/Likshan-Lahiru)

---

*Happy Coding!*
