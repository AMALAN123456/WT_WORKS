import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCookieServlet")
public class LoginCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        // Create a cookie for the username
        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60 * 60); // 1-hour expiry
        response.addCookie(userCookie);

        response.sendRedirect("WelcomeServlet");
    }
}
