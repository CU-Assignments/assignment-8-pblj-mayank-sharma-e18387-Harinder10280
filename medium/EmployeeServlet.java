import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("search".equals(action)) {
            // Search employee by ID
            String empId = request.getParameter("empId");
            if (empId != null && !empId.isEmpty()) {
                try {
                    Employee employee = getEmployeeById(empId);
                    if (employee != null) {
                        out.println("<h2>Employee Details</h2>");
                        out.println("<p>ID: " + employee.getId() + "</p>");
                        out.println("<p>Name: " + employee.getName() + "</p>");
                        out.println("<p>Position: " + employee.getPosition() + "</p>");
                        out.println("<p>Salary: " + employee.getSalary() + "</p>");
                    } else {
                        out.println("<p>No employee found with ID " + empId + "</p>");
                    }
                } catch (SQLException e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                }
            }
        } else {
            // List all employees
            try {
                out.println("<h2>All Employees</h2>");
                out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Position</th><th>Salary</th></tr>");
                getAllEmployees(out);
                out.println("</table>");
            } catch (SQLException e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
        }
    }

    private Employee getEmployeeById(String empId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, Integer.parseInt(empId));
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Employee(resultSet.getInt("id"), resultSet.getString("name"), 
                    resultSet.getString("position"), resultSet.getDouble("salary"));
        }
        return null;
    }

    private void getAllEmployees(PrintWriter out) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM employees";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            out.println("<tr>");
            out.println("<td>" + resultSet.getInt("id") + "</td>");
            out.println("<td>" + resultSet.getString("name") + "</td>");
            out.println("<td>" + resultSet.getString("position") + "</td>");
            out.println("<td>" + resultSet.getDouble("salary") + "</td>");
            out.println("</tr>");
        }
    }

    class Employee {
        private int id;
        private String name;
        private String position;
        private double salary;

        public Employee(int id, String name, String position, double salary) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getPosition() { return position; }
        public double getSalary() { return salary; }
    }
}
