package javaee.pweb.resources;


import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")  // Apply filter to all URLs; you can adjust the mapping as needed.
public class CookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Cast to HTTP-specific classes.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        // Determine the requested path.
        String path = req.getRequestURI().substring(req.getContextPath().length());
        
        // Allow requests to the login page and the login servlet to pass through.
        if (path.equals("/login.jsp") || path.equals("/LoginServlet") || path.startsWith("/resources/")) {
            chain.doFilter(request, response);
            return;
        }

        // Check for the "username" cookie.
        boolean validCookie = false;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    // Check if the cookie has a non-empty value.
                    if (cookie.getValue() != null && !cookie.getValue().trim().isEmpty()) {
                        validCookie = true;
                        break;
                    }
                }
            }
        }

        // If the cookie is missing or empty, redirect to the login page.
        if (!validCookie) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        // Otherwise, continue processing the request.
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code if needed.
    }
}

