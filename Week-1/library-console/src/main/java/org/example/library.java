package org.example;

import java.util.Scanner;


abstract class LibraryItem {
    abstract void displayBook();
}


class Book extends LibraryItem {

    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }


    @Override
    public void displayBook() {
        System.out.println("Book Name : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Available : " + available);
        System.out.println("------------------------");
    }
}


class StudentBook extends Book {

    public StudentBook(String title, String author) {
        super(title, author);
    }


    @Override
    public void displayBook() {
        System.out.println("Student Library Book");
        super.displayBook();
    }
}


public class library {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Book[] books = new Book[3];

        books[0] = new Book("Java", "James Gosling");
        books[1] = new Book("Python", "Guido van Rossum");
        books[2] = new StudentBook("C++", "Bjarne ");

        int choice;

        do {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nLibrary Books");

                    for (int i = 0; i < books.length; i++) {
                        System.out.println("Book " + (i + 1));
                        books[i].displayBook();
                    }

                    break;

                case 2:

                    System.out.print("Enter Book Number (1-3): ");
                    int borrow = input.nextInt();

                    if (borrow >= 1 && borrow <= 3) {

                        if (books[borrow - 1].isAvailable()) {
                            books[borrow - 1].borrowBook();
                            System.out.println("Book Borrowed Successfully.");
                        } else {
                            System.out.println("Book Already Borrowed.");
                        }

                    } else {
                        System.out.println("Invalid Book Number.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Book Number (1-3): ");
                    int ret = input.nextInt();

                    if (ret >= 1 && ret <= 3) {
                        books[ret - 1].returnBook();
                        System.out.println("Book Returned Successfully.");
                    } else {
                        System.out.println("Invalid Book Number.");
                    }

                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        } while (choice != 4);


    }
}
