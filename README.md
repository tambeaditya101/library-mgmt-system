# Library Management System

## Overview

This project implements a simple **Library Management System in Java** designed to demonstrate core **Object-Oriented Programming (OOP)** principles, **SOLID design principles**, and the use of **design patterns**.

The system allows librarians to manage books, patrons, and lending operations without relying on a database or external APIs. All data is stored in memory using Java collections.

---

## Features

### Book Management
- Add new books to the library
- Remove books from the inventory
- Update book information
- Search books by:
    - Title
    - Author
    - ISBN

### Patron Management
- Register new patrons
- Maintain patron borrowing history

### Lending System
- Checkout books
- Return books
- Track active and past loans

### Reservation System
- Patrons can reserve books that are currently borrowed
- When the book becomes available, reserved patrons are notified

---

## Technologies Used

- Java
- Java Collections (`Map`, `List`)
- `java.time` for date management

---

## Project Structure
```
src
├── models
│ ├── Book.java
│ ├── Patron.java
│ └── Loan.java
│
├── services
│ ├── BookService.java
│ ├── PatronService.java
│ └── LoanService.java
│
├── strategies
│ ├── SearchStrategy.java
│ ├── TitleSearchStrategy.java
│ ├── AuthorSearchStrategy.java
│ └── IsbnSearchStrategy.java
│
├── observer
│ └── Observer.java
│
└── Main.java
```


---

## System Design

### Core Entities

- **Book**  
  Represents a book in the library with attributes such as title, author, ISBN, publication year, and availability status.

- **Patron**  
  Represents a library member and tracks their borrowing history.

- **Loan**  
  Represents a borrowing transaction between a patron and a book.

---

## Design Patterns Used

### Strategy Pattern

Used for implementing flexible search functionality.

Instead of hardcoding search logic inside the service, the system uses different search strategies:

- `TitleSearchStrategy`
- `AuthorSearchStrategy`
- `IsbnSearchStrategy`

This allows new search methods to be added without modifying existing code.

---

### Observer Pattern

Used to implement the **book reservation system**.

Patrons can subscribe to a book when it is currently unavailable. When the book becomes available again, all subscribed patrons are notified.

Components:

- `Observer` interface
- `Patron` implements `Observer`
- `Book` maintains a list of observers and notifies them when returned.

---

## SOLID Principles Applied

**Single Responsibility Principle**  
Each class has a clear responsibility:
- `BookService` manages books
- `PatronService` manages patrons
- `LoanService` manages lending operations

**Open/Closed Principle**  
Search functionality is implemented using the **Strategy Pattern**, allowing new search methods without modifying existing code.

**Encapsulation**  
Domain objects protect their internal state and expose controlled methods.

---

## Example Flow

1. Add books to the system
2. Register patrons
3. Patron borrows a book
4. Another patron reserves the book
5. When the book is returned, the reserved patron receives a notification

---

## Possible Improvements

Future improvements could include:

- Multi-branch library support
- Persistent storage (database)
- REST API layer
- Logging framework
- Factory pattern for entity creation
- Recommendation system based on borrowing history

---

## How to Run

1. Clone the repository

```
git clone <repository-link>
```

2. Compile the project

```
javac Main.java
```

3. Run the program

```
java Main
```

## Simple UML diagram

```
## Simplified Class Diagram

Book -------- Loan -------- Patron
  |
  | notifies
  v
Observer
  ^
  |
Patron


SearchStrategy
   ├── TitleSearchStrategy
   ├── AuthorSearchStrategy
   └── IsbnSearchStrategy


Services
--------
BookService
PatronService
LoanService
```

---