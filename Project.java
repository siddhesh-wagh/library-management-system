import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        char r;

        do {
            System.out.println();
            System.out.println("*******************************************");
            System.out.println("|   ||...LIBRARY MANAGEMENT SYSTEM...||   |");
            System.out.println("*******************************************");
            System.out.println();
            System.out.println("   1. ADD BOOK");
            System.out.println("   2. ISSUE A BOOK");
            System.out.println("   3. RETURN A BOOK");
            System.out.println("   4. ISSUE DETAILS");
            System.out.println("   5. EXIT");
            System.out.println();
            System.out.println("*******************************************");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.addBook(scanner);
                    break;
                case 2:
                    library.issueBook(scanner);
                    break;
                case 3:
                    library.returnBook(scanner);
                    break;
                case 4:
                    library.issueDetails();
                    break;
                case 5:
                    library.exit();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid number.");
            }

            System.out.print("Would you like to continue? (Y/N): ");
            r = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline
        } while (r == 'y' || r == 'Y');

        if (r == 'n' || r == 'N') {
            library.exit();
        }

        scanner.close();
    }
}

// Book class to store details of each book
class Book {
    private String name;
    private int id;
    private float price;
    private boolean issued;
    private String issueDate;
    private String returnDate;

    // Constructor
    public Book(String name, int id, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.issued = false;
    }

    // Methods to issue and return a book
    public void issue(String issueDate, String returnDate) {
        if (issued) {
            System.out.println("Book ID " + id + " is already issued.");
            return;
        }
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issued = true;
        System.out.println("Book ID " + id + " issued successfully.");
    }

    public void returnBook() {
        if (!issued) {
            System.out.println("Book ID " + id + " is not currently issued.");
            return;
        }
        System.out.println("Returning Book ID: " + id);
        System.out.println("Book returned successfully.");
        this.issued = false;
        this.issueDate = null;
        this.returnDate = null;
    }

    public boolean isIssued() {
        return issued;
    }

    public int getId() {
        return id;
    }

    public void printDetails() {
        System.out.println("Book Name: " + name);
        System.out.println("Book ID: " + id);
        System.out.println("Price: $" + price);
        if (issued) {
            System.out.println("Issue Date: " + issueDate);
            System.out.println("Return Date: " + returnDate);
        } else {
            System.out.println("Book is not currently issued.");
        }
    }
}

// Library class to manage multiple books
class Library {
    private List<Book> books = new ArrayList<>();

    // Add a new book
    void addBook(Scanner scanner) {
        System.out.println("Enter Book Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Book ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter Book Price: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        Book book = new Book(name, id, price);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Issue a book
    void issueBook(Scanner scanner) {
        System.out.println("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isIssued()) {
                    System.out.println("Book ID " + id + " is already issued.");
                } else {
                    System.out.println("Enter Issue Date (dd/mm/yyyy): ");
                    String issueDate = scanner.nextLine();
                    System.out.println("Enter Return Date (dd/mm/yyyy): ");
                    String returnDate = scanner.nextLine();
                    book.issue(issueDate, returnDate);
                }
                return;
            }
        }
        System.out.println("Book ID " + id + " not found.");
    }

    // Return a book
    void returnBook(Scanner scanner) {
        System.out.println("Enter Book ID to return: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : books) {
            if (book.getId() == id) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book ID " + id + " not found.");
    }

    // Show details of issued books
    void issueDetails() {
        System.out.println("Issued Books Details:");
        for (Book book : books) {
            if (book.isIssued()) {
                book.printDetails();
                System.out.println("------------------------------");
            }
        }
    }

    void exit() {
        System.out.println("Exiting the system. Thank you!");
        System.exit(0);
    }
}
