import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Map the servlet to "CricketServlet"
@WebServlet("/CricketServlet")
public class CricketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the content type to HTML
        response.setContentType("text/html");

        // Get the output writer to write the response
        PrintWriter out = response.getWriter();

        // Write the HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Response</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cricket Servlet Called!</h1>");
        out.println("<p>This is a response from the CricketServlet.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
