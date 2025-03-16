/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package javaee.employeesjsp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author mysza
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            HttpSession session = request.getSession(true);
            ArrayList list;
            if ((ArrayList) session.getAttribute("lista") != null) {
                list = (ArrayList) session.getAttribute("lista");
            }else { 
                list = new ArrayList();
            }
            Person p = new Person(name, surname, address);
            list.add(p);
            session.setAttribute("lista", list);
            request.getRequestDispatcher("display.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input! Please enter integers.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

   

}
