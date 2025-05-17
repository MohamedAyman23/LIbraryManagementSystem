# Library Management System

A comprehensive console-based Library Management System developed in Java. This application facilitates efficient management of library operations by providing distinct roles for users and administrators. Users can browse, search, and borrow books, while administrators have enhanced control to add, update, or remove books and manage users.

## Project Overview

This system simulates a real-world library environment where multiple users interact with the catalog and manage book loans. The project is designed with modular Java classes that separate concerns such as user management, book inventory, and system operations. It features a simple and user-friendly text-based interface for easy navigation and interaction.

## Key Features

- **User Authentication:**  
  Secure login system differentiates between regular users and administrators, ensuring role-based access control.

- **User Role:**  
  - Browse and search for books by title, author, or ISBN.  
  - Borrow and return books with validation to prevent multiple borrowings of the same copy.  
  - View personal borrowing history and current loan status.

- **Administrator Role:**  
  - Add new books with full metadata including title, author, ISBN, and quantity.  
  - Update existing book information and inventory count.  
  - Remove books from the catalog when necessary.  
  - Manage user accounts and their borrowing privileges.  

- **Book Management:**  
  Efficient handling of book data with appropriate validations for inventory counts and user transactions.

- **Data Persistence:**  
  (If implemented) Save and load data from files or databases to preserve library state between sessions.

- **Robust Error Handling:**  
  Ensures smooth user experience by managing invalid inputs and exceptional cases gracefully.

## Project Structure

LibraryManagementSystem/            Project root directory  
├── src/                          Contains all Java source code files  
│   ├── Main.java                 Entry point of the application that handles the main program loop  
│   ├── User.java                 Represents library users with properties and methods related to user actions  
│   ├── Admin.java                Extends User with administrative capabilities  
│   ├── Book.java                 Defines the Book object with attributes like title, author, ISBN, and quantity  
│   ├── Library.java              Core class managing collections of books and users, and handling operations  
│   └── ...                      Additional utility or helper classes as needed  

├── .gitignore                   Lists files and folders to be excluded from Git tracking (e.g., build artifacts, IDE configs)  
├── README.md                    Project documentation file  
└── LICENSE                     MIT License document  

## Getting Started

To run this project:

1. Clone the repository to your local machine.
2. Open the project in your favorite Java IDE (e.g., NetBeans, IntelliJ IDEA, Eclipse).
3. Compile and run the `Main.java` class.
4. Follow on-screen prompts to log in as a user or admin and interact with the system.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
