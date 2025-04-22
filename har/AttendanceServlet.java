import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/markAttendance")
public class AttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate date = LocalDate.now();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM students");

            while (rs.next()) {
                int studentId = rs.getInt("id");
                String status = request.getParameter("status" + studentId);
                if (status != null) {
                    PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)");
                    ps.setInt(1, studentId);
                    ps.setDate(2, Date.valueOf(date));
                    ps.setString(3, status);
                    ps.executeUpdate();
                }
            }
            conn.close();
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            throw new ServletException("DB error", e);
        }
    }
}
