/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package javaee.cookie1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Instant;

@WebServlet("/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long expiryTime = Instant.now().getEpochSecond() + 30;
        Cookie cookie = new Cookie("expiryTime", String.valueOf(expiryTime));
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        
        response.sendRedirect("CheckCookieServlet");
    }
}