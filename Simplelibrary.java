import java.util.ArrayList;
import java.util.Scanner;

public class SimpleLibrary {
    static class Book {
        int id;
        String title;
        String author;
        boolean borrowed;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.borrowed = false;
        }

        public String toString() {
            return id + ". " + title + " by " + author + (borrowed ? " (Borrowed)" : "");
        }
    }

    static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return id + ". " + name;
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. List Books");
            System.out.println("4. List Users");
            System.out.println("5. Borrow Book");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    books.add(new Book(books.size() + 1, title, author));
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    users.add(new User(users.size() + 1, name));
                    System.out.println("User added!");
                    break;

                case 3:
                    System.out.println("\nBooks:");
                    for (Book b : books) System.out.println(b);
                    break;

                case 4:
                    System.out.println("\nUsers:");
                    for (User u : users) System.out.println(u);
                    break;

                case 5:
                    System.out.print("Enter book ID: ");
                    int bid = sc.nextInt();
                    if (bid <= 0 || bid > books.size()) {
                        System.out.println("Invalid book ID!");
                        break;
                    }
                    Book b = books.get(bid - 1);
                    if (b.borrowed) {
                        System.out.println("Book already borrowed!");
                    } else {
                        b.borrowed = true;
                        System.out.println("Book borrowed!");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}