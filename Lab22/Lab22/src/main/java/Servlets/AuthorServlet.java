package Servlets;

import javaee.lab22.Author;
import jakarta.persistence.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.annotation.Resource;
import jakarta.transaction.UserTransaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {
    @PersistenceUnit(unitName = "MyPU")
    private EntityManagerFactory emf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();

        try {
            if ("add".equals(action)) {
                String name = request.getParameter("name");
                Author author = new Author();
                author.setName(name);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(author);
                transaction.commit();

                // Notify all connected WebSocket clients
                NotificationEndpoint.sendNotification("New author added: " + name);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Author author = em.find(Author.class, id);

                if (author != null) {
                    EntityTransaction transaction = em.getTransaction();
                    transaction.begin();
                    em.remove(author);
                    transaction.commit();

                    // Notify all connected WebSocket clients
                    NotificationEndpoint.sendNotification("Author deleted: " + author.getName());
                }
            }


        } catch (Exception e) {
            throw new ServletException("Error processing request", e);
        } finally {
            em.close();
        }

        response.sendRedirect("authors.jsp");
    }
}



