import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String VALID_USER = "admin";
    private static final String VALID_PASS = "12345";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (VALID_USER.equals(username) && VALID_PASS.equals(password)) {
            out.println("<h2>Welcome, " + username + "!</h2>");
        } else {
            out.println("<h2>Login Failed. Invalid username or password.</h2>");
        }
    }
}
