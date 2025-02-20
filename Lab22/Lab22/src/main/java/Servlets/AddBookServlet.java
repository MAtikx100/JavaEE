/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import javaee.lab22.Author;
import jakarta.persistence.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import javaee.lab22.Book;

/**
 *
 * @author matik
 */
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    @PersistenceUnit(unitName = "MyPU")
    private EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        try {
            // Get the list of authors
            List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();

            if (authors == null || authors.isEmpty()) {
                request.setAttribute("error", "No authors found.");
            } else {
                // Pass authors to the JSP page
                request.setAttribute("authors", authors);
            }

            // Forward the request to the book.jsp page
            request.getRequestDispatcher("book.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error fetching authors", e);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        try {
            // Get form data (book title and author ID)
            String title = request.getParameter("title");
            String authorId = request.getParameter("authorId");

            // Get the selected author from the database
            Author author = em.find(Author.class, Long.parseLong(authorId));

            // Create new book
            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);

            // Begin transaction, persist the new book
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();

            // Redirect to the main page after adding the book
            response.sendRedirect("main");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ServletException("Error adding book", e);
        } finally {
            em.close();
        }
    }
}
