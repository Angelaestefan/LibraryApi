# Library Management API

A RESTful API for managing a library system built with Spring Boot and Oracle Database.

## Features

* Book Management (CRUD operations)
* Patron Management (CRUD operations)
* Database persistence with Oracle
* Input validation
* Connection pooling
* RESTful API endpoints

## Setup

1. Clone the repository:
```bash
git clone https://github.com/Angelaestefan/LibraryApi.git
cd LibraryApi
```

2. Configure Oracle Wallet:
   * Place your Oracle Wallet files in the specified directory
   * Update the `TNS_ADMIN` path in `application.properties`

3. Update Database Configuration:
   * Modify `application.properties` with your database credentials
   * Ensure Oracle connection settings are correct

4. Build the project:
```bash
mvn clean install
```

5. Run the application:
```bash
mvn spring-boot:run
```

## API Endpoints

### Books

* `GET /api/books` - Get all books
* `GET /api/books/{id}` - Get book by ID
* `POST /api/books` - Create new book
* `PUT /api/books/{id}` - Update existing book
* `DELETE /api/books/{id}` - Delete book

### Patrons

* `GET /api/patrons` - Get all patrons
* `GET /api/patrons/{id}` - Get patron by ID
* `POST /api/patrons` - Create new patron
* `PUT /api/patrons/{id}` - Update existing patron
* `DELETE /api/patrons/{id}` - Delete patron

## Sample Requests

### GET Book
![image](https://github.com/user-attachments/assets/4ffd206d-1235-4bc0-81c9-55247c1cecc0)

### GET Patron By ID
![image](https://github.com/user-attachments/assets/ee8a5a5f-2848-4454-b566-0ba0f3c0a44d)

### Create a Book
```json
POST /api/books
{
    "title": "1984",
    "author": "George Orwell",
    "isbn": "9780451524935",
    "publicationYear": 1949,
    "genre": "Dystopian",
    "pages": 328
}
```

### Create a Patron
```json
POST /api/patrons
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "123-456-7890"
}
```
![image](https://github.com/user-attachments/assets/fe6c67a1-d06d-44dd-b130-8b4e7398dcb7)

