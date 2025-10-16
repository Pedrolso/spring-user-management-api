# 🧩 User Management API (Spring Boot)

## 📖 Description
A simple REST API built with **Spring Boot** for managing users.  
Supports creating, retrieving, updating, and deleting users — with validation,  
custom exception handling, and use of **DTOs** for cleaner communication.

Developed following good Java practices and layered architecture  
(**Controller → Service → Repository → Entity → Exception Handling**).

---

## ⚙️ Features
- ➕ Create users (`POST /users`)
- 🔍 Find users by email (`GET /users?email=example@mail.com`)
- 🗑️ Delete users by email (`DELETE /users?email=example@mail.com`)
- 🔄 Update users by ID (`PUT /users?id=1`)
- 🧱 Uses **DTOs** to separate input (request) and output (response)
- ⚠️ Custom exceptions with a **GlobalExceptionHandler**
- 💾 Integrated with **Spring Data JPA** and an **H2 in-memory database**
- 🧩 Clean code with **Lombok** annotations

---

## 🧱 Technologies
- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **Maven**

---

## 🚀 Endpoints

| Method | Endpoint | Description | Request Body | Response |
|--------|-----------|--------------|---------------|-----------|
| **POST** | `/users` | Create a new user | `{ "email": "user@mail.com", "name": "Anna" }` | User created |
| **GET** | `/users?email=user@mail.com` | Find user by email | - | Returns user |
| **PUT** | `/users?id=1` | Update user by ID | `{ "name": "Anna Updated" }` | 200 OK |
| **DELETE** | `/users?email=user@mail.com` | Delete user by email | - | Deleted user info |

---

## 🧠 Exception Handling

All exceptions are handled globally by `GlobalExceptionHandler`.

| Exception | HTTP Status | Example Message |
|------------|--------------|------------------|
| `UserNotFound` | 404 Not Found | `"User not found with email: test@mail.com"` |
| `UserConflictException` | 409 Conflict | `"Email already exists: test@mail.com"` |
| `UserException` | 500 Internal Server Error | `"Internal Server Error"` |

## Response structure example:
```json
{
  "error": "User Not found. ----GLOBAL",
  "message": "Email not found. service--- user@mail.com",
  "timestamp": "2025-10-15T14:35:27.3185508",
  "status": 404
}
```
🧩 Project Structure
```text
src/main/java/com/exercise/spring001
│
├── controller/
│   └── UserController.java
│
├── DTO/
│   ├── UserRequestDTO.java
│   └── UserResponseDTO.java
│
├── entity/
│   └── User.java
│
├── exception/
│   ├── ErrorResponse.java
│   ├── GlobalExceptionHandler.java
│   ├── UserException.java
│   ├── UserNotFound.java
│   └── UserConflictException.java
│
├── repository/
│   └── UserRepository.java
│
├── service/
│   └── UserService.java
│
└── Spring001Application.java
```

## 🧪 Example Request (POST)
```json
Request:
{
  "email": "anna@live.com",
  "name": "Anna"
}

Response:
{
  "id": 1,
  "email": "anna@live.com",
  "name": "Anna"
}
```
## 🧰 How to Run

1. Clone the repository:
```bash
https://github.com/Pedrolso/spring-user-management-api.git
```
2. Open in your IDE (IntelliJ / Eclipse / VS Code)
3. Run the project (it uses H2 in-memory database by default)
4. Test endpoints via Postman or cURL

## 🧠 Extra Notes
- Built without frameworks beyond Spring Boot itself.
- Uses DTOs to prevent exposing entities directly to the client.
- Exception handling centralized via @ControllerAdvice.
