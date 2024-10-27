# Library Management System

## Project Overview

The **Library Management System** is a Java-based application designed to automate and manage the fundamental operations of a library. This console-based application enables users to add new books, issue books to borrowers, return issued books, and display issue details. Built with simplicity and functionality in mind, this system can be a valuable learning project for beginners and a practical tool for small libraries.

## Features

- **Add New Books**: Capture and store information for each book, including book name, ID, and price.
- **Issue Books**: Issue available books to borrowers with details on issue and return dates.
- **Return Books**: Return issued books to make them available for future borrowing.
- **View Issue Details**: Display details of books that are currently issued, including their issue and return dates.
- **Exit**: Terminate the program.

## Tech Stack

- **Language**: Java
- **Platform**: Console-based

## Project Structure

The project consists of two main classes:
1. **Project** (Main class): Contains the main loop and menu interface, handling user input and directing actions.
2. **Library**: Manages the collection of books, including adding, issuing, returning, and displaying book details.

Additionally, a **Book** class encapsulates individual book properties and actions, supporting the `Library` class for organized book management.

## Classes and Methods

### 1. `Project` (Main Class)

- **Purpose**: Drives the main menu loop for user interaction and directs to relevant actions in the `Library` class.
- **Key Methods**:
  - `main()`: Provides the interactive console menu, capturing and handling user input.

### 2. `Library`

- **Purpose**: Manages a list of `Book` objects and provides methods for adding, issuing, and returning books.
- **Key Methods**:
  - `addBook(Scanner scanner)`: Adds a new book to the library collection.
  - `issueBook(Scanner scanner)`: Issues an available book, setting issue and return dates.
  - `returnBook(Scanner scanner)`: Returns an issued book by book ID.
  - `issueDetails()`: Displays details of books currently issued.
  - `exit()`: Exits the program.

### 3. `Book`

- **Purpose**: Encapsulates properties of a single book and provides methods to issue or return the book.
- **Key Methods**:
  - `issue(String issueDate, String returnDate)`: Issues the book with specific dates.
  - `returnBook()`: Returns the book, clearing issue details.
  - `printDetails()`: Prints book details, including issue information if applicable.

## How to Use

1. Clone the repository:
   ```bash
   git clone https://github.com/siddhesh-wagh/library-management-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd library-management-system
   ```
3. Compile and run the project:
   ```bash
   javac Project.java
   java Project
   ```
4. Follow the menu prompts in the console to add, issue, return, and view details of books.

## Sample Usage

- **Add Book**: Enter book details, including name, price, and unique book ID.
- **Issue Book**: Enter the book ID and specify the issue and return dates.
- **Return Book**: Provide the book ID to mark it as returned.
- **Issue Details**: View details of currently issued books.

## Future Enhancements

- **Database Integration**: Add a database layer (e.g., MySQL) for persistent storage.
- **User Authentication**: Introduce user roles (e.g., admin, borrower) for secure access.
- **Graphical User Interface**: Transition to a GUI-based system for easier usability.
- **Enhanced Search and Sort**: Implement search and sorting features for efficient book management.

## Contributing

Contributions to the project are welcome! Feel free to open issues or submit pull requests to improve functionality or add new features.

---
