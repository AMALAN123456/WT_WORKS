import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlayerStatsServlet")
public class PlayerStatsServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cricket";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Player Stats</title></head><body>");
        out.println("<h1>Player Statistics</h1>");

        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Query the database
            String sql = "SELECT name, team, runs, wickets FROM players";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Display the results
            out.println("<table border='1'>");
            out.println("<tr><th>Name</th><th>Team</th><th>Runs</th><th>Wickets</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("team") + "</td>");
                out.println("<td>" + rs.getInt("runs") + "</td>");
                out.println("<td>" + rs.getInt("wickets") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace(out);
        }

        out.println("</body></html>");
    }
}
