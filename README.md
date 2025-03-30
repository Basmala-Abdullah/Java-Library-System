# Library Management System  

**A Java-based console application for managing library items and clients.**  

## 📌 Overview  
This **Library Management System** is a command-line application built with **Java** that allows librarians to:  
- Manage **books** and **magazines** (add, update, remove, display)  
- Manage **clients** (add, update, remove, display)  
- Track **borrowed items** (borrow, return, view borrowed items)  

It demonstrates **object-oriented programming (OOP)**, **exception handling**, **collections**, and **input validation** in Java.  

---

## 🛠️ Features  

### 📚 **Item Management**  
- Add **books** (ID, title, author)  
- Add **magazines** (ID, title, release number)  
- View all items  
- Retrieve, update, or delete items by ID  

### 👥 **Client Management**  
- Add clients (ID, name, email)  
- View all clients  
- Retrieve, update, or delete clients by ID  

### 🔄 **Borrowing System**  
- Borrow an item (links item ID to client ID)  
- Return an item (checks valid client-item pairing)  
- View all borrowed items  

### ⚠️ **Error Handling**  
- Custom exceptions (`ItemNotExistException`, `ClientNotExistException`)  
- Input validation (numbers, strings, email format)  

---

## 🚀 **Technologies Used**  
✔ **Core Java** (OOP, Collections, Exception Handling)  
✔ **Java Stream API** (for filtering items/clients)  
✔ **HashMap** (to track borrowed items)  
✔ **Input Validation** (preventing invalid user inputs)  

---

## 📥 **How to Run**  

1. **Prerequisites**:  
   - Java JDK (8 or higher) installed  
   - A Java IDE (IntelliJ, Eclipse) or command-line compiler  

2. **Steps**:  
   - Clone/download the project.  
   - Open `LibrarySystem.java` (main class).  
   - Compile & run the program.  
   - Follow the on-screen menu options.  

---

## 📝 **Code Structure**  
```
📁 LibrarySystem/  
├── 📄 LibrarySystem.java          (Main driver class)  
├── 📁 taskPkg/  
│   ├── 📄 Book.java               (Book class, extends LibraryItem)  
│   ├── 📄 Client.java             (Client data model)  
│   ├── 📄 Library.java            (Core logic for items & clients)  
│   ├── 📄 LibraryItem.java        (Abstract base class for items)  
│   ├── 📄 Magazine.java           (Magazine class, extends LibraryItem)  
│   ├── 📄 Validation.java         (Input validation methods)  
│   └── 📁 myExceptions/  
│       ├── 📄 ClientNotExistException.java  
│       └── 📄 ItemNotExistException.java  
```
---  

### 💡 **Why This Project?**  
This project is a great addition to a **Java developer's portfolio**, showcasing:  
✅ **OOP principles** (inheritance, polymorphism)  
✅ **Data management** (CRUD operations)  
✅ **Error handling & input validation**  
✅ **Real-world application** (library system logic)  
