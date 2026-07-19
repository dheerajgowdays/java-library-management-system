# 📚 Library Management System

A console-based **Library Management System** developed in **Java** following object-oriented programming principles. This project provides role-based access for librarians and members, allowing efficient management of books, borrowing, returns, and fines.

---

## 🚀 Features

### 📖 Book Management

* Add new books (Librarian only)
* Search books by:

    * Book ID
    * Book Name
    * Author Name
    * Book Type
* View all books

### 👤 Member Management

* Register new members (Librarian only)
* Search member by ID
* View all registered members
* Remove members

### 📚 Borrow & Return

* Borrow available books
* Return borrowed books
* Track borrowed books for each member
* Update book availability automatically

### 💰 Fine Management

* Calculate overdue fines
* Prevent borrowing if outstanding fines exist

### 👨‍🏫 Librarian Management

* Assign librarians (Officials only)
* Librarian authentication before privileged operations

### 🔐 Authentication

* Librarian authentication
* Member authentication
* Official code validation for librarian assignment

---

# 🛠️ Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections Framework

    * HashMap
    * ArrayList
* Java Time API (`LocalDate`)
* Scanner (Console Input)

---

# 📂 Project Structure

```text
Library-Management-System
│
├── Model
│   ├── Book.java
│   ├── BorrowBook.java
│   ├── Librarian.java
│   └── Member.java
│
├── Repository
│   ├── BookRepository.java
│   ├── BorrowRecordRepository.java
│   ├── LibrarianRepository.java
│   └── MemberRepository.java
│
├── Service
│   └── Service.java
│
├── Util
│   ├── IdGenerator.java
│   └── Validation.java
│
└── Main.java
```

---

# 📌 Concepts Demonstrated

## Core Java

* Classes and Objects
* Constructors
* Encapsulation
* Method Overloading
* Packages

## Object-Oriented Programming

* Inheritance
* Composition
* Abstraction
* Polymorphism

## Collections

* HashMap
* ArrayList

## Date & Time

* LocalDate

## Exception Handling

* Input validation
* Authentication validation

---

# 📋 Menu

```text
============= Library System ================

1. Add Book
2. Borrow Book
3. Return Book
4. Search
5. Fine Calculation
6. Member Management
7. Assign Librarian
8. Exit
```

---

# 🔄 Workflow

### Librarian

* Login
* Add books
* Register members
* Remove members
* View members

### Member

* Login
* Borrow books
* Return books
* Search books
* View fines

### Official

* Assign librarians

---

# 📚 Data Structures Used

| Data Structure | Purpose                                                    |
| -------------- | ---------------------------------------------------------- |
| HashMap        | Store and retrieve books and members efficiently using IDs |
| ArrayList      | Maintain borrow records for each member                    |

---

# 🔮 Future Improvements

* Waiting list using `Queue< Member >`
* Duplicate prevention using `HashSet`
* Sorting books using `Comparable` and `Comparator`
* Generic Repository implementation
* File-based persistence
* Database integration (MySQL/PostgreSQL)
* Spring Boot REST API
* JWT Authentication
* Admin Dashboard
* Unit Testing with JUnit

---

# 🎯 Learning Outcomes

This project demonstrates:

* Java object-oriented design
* Layered architecture (Model, Repository, Service, Util)
* Repository pattern
* Collection framework usage
* Authentication and validation
* Console application development
* Business logic implementation

---

# 👨‍💻 Author

**Dheeraj Gowda**

* Fourth Year Computer Science Engineering Student
* Passionate about Java, Backend Development, and Software Engineering
* Building projects to strengthen core Java fundamentals and prepare for advanced software engineering studies.
