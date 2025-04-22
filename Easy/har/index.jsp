<%@ page import="java.sql.*, java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Mark Attendance</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Student Attendance Form</h1>
    <form method="post" action="markAttendance">
        <table border="1">
            <tr><th>Student Name</th><th>Status</th></tr>
            <%
                try {
                    Connection conn = DBConnection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM students");

                    while (rs.next()) {
                        int studentId = rs.getInt("id");
                        String name = rs.getString("name");
            %>
                <tr>
                    <td><%= name %></td>
                    <td>
                        <input type="hidden" name="studentId" value="<%= studentId %>">
                        <label><input type="radio" name="status<%= studentId %>" value="Present" required> Present</label>
                        <label><input type="radio" name="status<%= studentId %>" value="Absent" required> Absent</label>
                    </td>
                </tr>
            <%
                    }
                    conn.close();
                } catch (Exception e) {
                    out.println("<tr><td colspan='2'>Error: " + e.getMessage() + "</td></tr>");
                }
            %>
        </table>
        <br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
