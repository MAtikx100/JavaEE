/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;


import jakarta.persistence.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javaee.lab22.Author;
import javaee.lab22.Book;

@WebServlet("/viewDatabase")
public class DatabaseViewerServlet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("MyPU");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager em = emf.createEntityManager();

        // Retrieve authors and books from the database
        List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();

        // Set up the HTML response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body><h1>Database Viewer</h1>");

        // Display authors
        out.println("<h2>Authors</h2><ul>");
        for (Author author : authors) {
            out.println("<li>ID: " + author.getId() + ", Name: " + author.getName() + "</li>");
        }
        out.println("</ul>");

        // Display books with their authors' names
        out.println("<h2>Books</h2><ul>");
        for (Book book : books) {
            String authorName = (book.getAuthor() != null) ? book.getAuthor().getName() : "Unknown Author";
            out.println("<li>ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + authorName + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
        
    }

    @Override
    public void destroy() {
        emf.close();
    }
}
