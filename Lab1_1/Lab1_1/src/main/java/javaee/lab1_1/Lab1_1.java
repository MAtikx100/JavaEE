
package javaee.lab1_1;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author matik
 */
public class Lab1_1 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Database Interaction Menu ===");
            System.out.println("1. Add Author and Books");
            System.out.println("2. View All Authors and Books");
            System.out.println("3. Update an Author's Name");
            System.out.println("4. Delete an Author");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addAuthorWithBooks();
                case 2 -> viewAuthorsAndBooks();
                case 3 -> updateAuthorName();
                case 4 -> deleteAuthor();
                case 5 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        JpaUtil.close();
    }
    
    private static void addAuthorWithBooks() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            System.out.print("Enter author name: ");
            String authorName = scanner.nextLine();

            Author author = new Author();
            author.setName(authorName);

            System.out.print("How many books does the author have? ");
            int bookCount = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < bookCount; i++) {
                System.out.print("Enter title of book " + (i + 1) + ": ");
                String bookTitle = scanner.nextLine();
                Book book = new Book();
                book.setTitle(bookTitle);
                author.addBook(book);
            }

            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();

            System.out.println("Author and books added successfully!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void viewAuthorsAndBooks() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();

            if (authors.isEmpty()) {
                System.out.println("No authors found.");
                return;
            }

            for (Author author : authors) {
                System.out.println("\nAuthor ID: " + author.getId());
                System.out.println("Author Name: " + author.getName());
                for (Book book : author.getBooks()) {
                    System.out.println("\tBook ID: " + book.getId() + ", Title: " + book.getTitle());
                }
            }
        } finally {
            em.close();
        }
    }

    private static void updateAuthorName() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            System.out.print("Enter the ID of the author to update: ");
            Long authorId = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            em.getTransaction().begin();
            Author author = em.find(Author.class, authorId);

            if (author == null) {
                System.out.println("Author not found.");
                return;
            }

            System.out.print("Enter the new name for the author: ");
            String newName = scanner.nextLine();
            author.setName(newName);

            em.getTransaction().commit();
            System.out.println("Author name updated successfully!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void deleteAuthor() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            System.out.print("Enter the ID of the author to delete: ");
            Long authorId = scanner.nextLong();

            em.getTransaction().begin();
            Author author = em.find(Author.class, authorId);

            if (author == null) {
                System.out.println("Author not found.");
                return;
            }

            em.remove(author);
            em.getTransaction().commit();
            System.out.println("Author deleted successfully!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

