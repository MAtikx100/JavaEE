/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package javaee.movierating;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mysza
 */
@WebServlet(name = "RatingServlet", urlPatterns = {"/RatingServlet"})
public class RatingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RatingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RatingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ServletContext context = getServletContext();
            List<Movie> lista = (List<Movie>) context.getAttribute("results");
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RatingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>");
            for (Movie m : lista){
                List<Movie> shown = new ArrayList<>(); 
                float count=0;
                float sum=0;
                for (Movie n : lista){
                    
                    if (m.name == null ? n.name == null : m.name.equals(n.name)){
                        count++;
                        sum += n.rating;
                    }
                }
                float avg = sum/count;
                
                if(shown.isEmpty()){
                    shown.add(m);
                    out.println("<li>" + m.name + ":" + m.genre + ":" + avg + "</li>");
                }else{
                
                    for (Movie n : shown){
                        if (!m.name.equals(n.name)){
                            out.println("<li>" + m.name + ":" + m.genre + ":" + avg + "</li>");
                        }    
                    }
                    shown.add(m);

                }
    
                
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = getServletContext();
        List<Movie> lista = (List<Movie>) context.getAttribute("results");
        if (lista == null){
            lista = new ArrayList<>();
            context.setAttribute("results", lista);
        }
        
        String name = request.getParameter("name");
        String genre = request.getParameter("genre");
        int rating = Integer.parseInt(request.getParameter("rating"));
        Movie m = new Movie(name, genre, rating);
        lista.add(m);
        context.setAttribute("results", lista);
        doGet(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
