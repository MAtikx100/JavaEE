/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import jakarta.persistence.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import javaee.lab22.Author;

/**
 *
 * @author matik
 */
@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

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
                // Set the authors list as an attribute for the JSP
                request.setAttribute("authors", authors);
            }

            // Forward the request to the main.jsp page
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error fetching authors", e);
        } finally {
            em.close();
        }
    }
}
