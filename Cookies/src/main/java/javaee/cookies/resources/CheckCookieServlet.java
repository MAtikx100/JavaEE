
import java.io.IOException;
import java.time.Instant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CheckCookieServlet")
public class CheckCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        long currentTime = Instant.now().getEpochSecond();
        long remainingTime = -1;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("expiryTime".equals(cookie.getName())) {
                    long expiryTime = Long.parseLong(cookie.getValue());
                    remainingTime = expiryTime - currentTime;
                    break;
                }
            }
        }

        response.setContentType("text/plain");
        if (remainingTime > 0) {
            response.getWriter().println("Time left: " + remainingTime + " seconds");
        } else {
            response.getWriter().println("Cookie expired or not found.");
        }
    }
}
