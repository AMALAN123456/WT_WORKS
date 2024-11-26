import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Map the servlet to "MatchScheduleServlet"
@WebServlet("/MatchScheduleServlet")
public class MatchScheduleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the content type to HTML
        response.setContentType("text/html");

        // Get the output writer to write the response
        PrintWriter out = response.getWriter();

        // Write a dynamic HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cricket Match Schedules</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Upcoming Cricket Matches</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Match</th><th>Date</th><th>Venue</th></tr>");
        out.println("<tr><td>Team A vs Team B</td><td>2024-12-01</td><td>Stadium 1</td></tr>");
        out.println("<tr><td>Team C vs Team D</td><td>2024-12-05</td><td>Stadium 2</td></tr>");
        out.println("<tr><td>Team E vs Team F</td><td>2024-12-10</td><td>Stadium 3</td></tr>");
        out.println("</table>");
        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
