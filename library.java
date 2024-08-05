package LibrarySystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Library {
    private ArrayList<String> bookTitles;

    public Library() {
        bookTitles = new ArrayList<>();
    }

    public void addBook(String title) {
        bookTitles.add(title);
        System.out.println("Book \"" + title + "\" added successfully.");
    }

    public void removeBook(String title) {
        if (bookTitles.remove(title)) {
            System.out.println("Book \"" + title + "\" removed successfully.");
        } else {
            System.out.println("Book \"" + title + "\" not found.");
        }
    }

    public int searchBook(String title) {
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            System.out.println("Book \"" + title + "\" found at index " + index + ".");
        } else {
            System.out.println("Book \"" + title + "\" not found.");
        }
        return index;
    }

    public void listBooks() {
        if (bookTitles.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Listing all book titles:");
            for (int i = 0; i < bookTitles.size(); i++) {
                System.out.println((i + 1) + ". " + bookTitles.get(i));
            }
        }
    }

    public void sortBooks() {
        Collections.sort(bookTitles);
        System.out.println("Book titles sorted alphabetically.");
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary System:");
            System.out.println("1. Add a Book Title");
            System.out.println("2. Remove a Book Title");
            System.out.println("3. Search for a Book Title");
            System.out.println("4. List All Book Titles");
            System.out.println("5. Sort Book Titles");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter the book title to add: ");
                    String addTitle = scanner.nextLine();
                    library.addBook(addTitle);
                    break;
                case 2:
                    System.out.print("Enter the book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter the book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    library.listBooks();
                    break;
                case 5:
                    library.sortBooks();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
