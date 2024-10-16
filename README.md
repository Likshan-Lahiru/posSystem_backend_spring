
---

# **POS System Spring Boot RESTful API Project**

## **Project Overview**

This project is a fully functional **RESTful API** built using **Spring Boot**, **Spring Data JPA**, and **Hibernate** for database management with **MySQL**. The API provides endpoints for managing customers, orders, and other resources in a POS system.

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
│   │   │   ├── controller/    # Controllers handling API requests
│   │   │   ├── service/       # Business logic
│   │   │   ├── repository/    # Database interactions (Spring Data JPA)
│   │   │   ├── entity/        # Entity classes
│   │   │   ├── dto/           # Data Transfer Objects
│   ├── resources/
│   │   ├── logback.xml        # Logging configuration
├── test/                        # Unit and integration tests
```

## **API Endpoints Overview**

The API supports basic CRUD operations for resources. Below is a quick overview of key endpoints:

- `GET /api/customers`: Fetch all customers.
- `GET /api/customers/{id}`: Fetch a customer by ID.
- `POST /api/customers`: Create a new customer.
- `PUT /api/customers/{id}`: Update an existing customer by ID.
- `DELETE /api/customers/{id}`: Delete a customer by ID.

## **Accessing the Frontend**

You can access the frontend application by navigating to the following URL in your browser:

- [Frontend URL](https://github.com/Likshan-Lahiru/pos_system.git)

