import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PageCounterServlet")
public class PageCounterServlet extends HttpServlet {
    private int totalVisits = 0; // Tracks total visits across all users (application-wide)

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Increment the total visit counter
        totalVisits++;

        // Retrieve the user's session
        HttpSession session = request.getSession();
        Integer userVisits = (Integer) session.getAttribute("userVisits");

        // Increment the user's visit count
        if (userVisits == null) {
            userVisits = 1;
        } else {
            userVisits++;
        }
        session.setAttribute("userVisits", userVisits);

        // Generate the HTML response
        out.println("<html><head><title>Page Counter</title></head><body>");
        out.println("<h1>Welcome to the Cricket Stats Page!</h1>");
        out.println("<p><strong>Your Visits:</strong> " + userVisits + "</p>");
        out.println("<p><strong>Total Visits to this Page:</strong> " + totalVisits + "</p>");
        out.println("</body></html>");
    }
}
