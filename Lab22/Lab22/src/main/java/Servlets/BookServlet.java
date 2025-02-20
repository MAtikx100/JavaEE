/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import jakarta.persistence.*;
import javaee.lab22.Author;
import javaee.lab22.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author matik
 */
@WebServlet("/books")
public class BookServlet extends HttpServlet {
    @PersistenceUnit(unitName = "MyPU")
    private EntityManagerFactory emf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();

        try {
            if ("add".equals(action)) {
                String title = request.getParameter("title");
                int authorId = Integer.parseInt(request.getParameter("authorId"));

                Author author = em.find(Author.class, authorId);
                if (author != null) {
                    // Create new book and set the author
                    Book book = new Book();
                    book.setTitle(title);
                    book.setAuthor(author);

                    // Begin transaction and persist the new book
                    EntityTransaction transaction = em.getTransaction();
                    transaction.begin();
                    em.persist(book);
                    transaction.commit();
                }

            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Book book = em.find(Book.class, id);

                if (book != null) {
                    // Begin transaction and remove the book
                    EntityTransaction transaction = em.getTransaction();
                    transaction.begin();
                    em.remove(book);
                    transaction.commit();
                }
            }

        } catch (Exception e) {
            throw new ServletException("Error processing request", e);
        } finally {
            em.close();
        }

        // Redirect back to books page
        response.sendRedirect("books.jsp");
    }
}
