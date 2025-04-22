[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/M_ZGEHCa)
# Assignment-8-PBLJ

# 🧑‍💻 Servlets & JSP Interactive Assignment

Welcome to the **Servlets & JSP Web Application Assignment**! This project is designed to help you understand how to build dynamic web applications using **Java Servlets**, **JSP (JavaServer Pages)**, and **JDBC** for database interaction. Each level progressively introduces new concepts to strengthen your web development skills.

---

## 📚 Project Structure

The project is divided into three difficulty levels:

### ✅ Easy Level: Login System

**Objective:**  
Create a simple login form that sends user credentials to a servlet. If the username and password match hardcoded values, display a personalized welcome message.

📁 Features:
- HTML form for username & password
- Servlet validation
- Personalized greeting on success

🛠 Tech Stack:
- HTML
- Java Servlet

---

### 🔍 Medium Level: Employee Directory

**Objective:**  
Integrate JDBC to fetch employee data from a database and display it. Add a search option to get employee details by ID.

📁 Features:
- JDBC connection setup
- List all employees
- Search employee by ID

🛠 Tech Stack:
- Java Servlet
- JDBC
- MySQL (or any RDBMS)
- HTML & CSS

---

### 🎓 Hard Level: Student Attendance Portal

**Objective:**  
Develop a mini-portal using JSP to enter student attendance. Save the attendance to the database using a Servlet.

📁 Features:
- JSP form for attendance entry
- Servlet for saving data to DB
- Database schema for students & attendance

🛠 Tech Stack:
- JSP
- Java Servlet
- JDBC
- MySQL
- HTML & CSS

---

## 🚀 Getting Started

### Prerequisites

- Java (JDK 8+)
- Apache Tomcat Server
- MySQL or any relational database
- Maven (optional)
- Any IDE (Eclipse/IntelliJ)

### Database Setup

```sql
-- For Medium Level
CREATE DATABASE company;

USE company;

CREATE TABLE employee (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  department VARCHAR(100)
);

-- For Hard Level
CREATE DATABASE student_portal;

USE student_portal;

CREATE TABLE students (
  id INT PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE attendance (
  id INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT,
  date DATE,
  status VARCHAR(10),
  FOREIGN KEY (student_id) REFERENCES students(id)
);
```

---

## 💡 How to Run

1. Clone the repository
2. Import the project into your IDE
3. Configure Tomcat server
4. Setup your DB credentials in the `DBConnection.java` or `web.xml`
5. Deploy and test the application via browser

---

## 📌 Folder Structure

```
├── src/
│   ├── EasyServlet.java
│   ├── EmployeeServlet.java
│   ├── SaveAttendanceServlet.java
│
├── WebContent/
│   ├── index.html
│   ├── employee.jsp
│   ├── attendanceForm.jsp
│
├── WEB-INF/
│   ├── web.xml
```

---

## 🙌 Contribution Guide

- Fork this repo
- Create a branch: `git checkout -b feature-name`
- Commit your changes
- Push and create a PR

---

## 🧠 Learning Outcomes

By the end of this assignment, you will:

- Understand request/response flow using Servlets
- Use JDBC for real-time DB communication
- Implement forms using HTML and JSP
- Handle user data and database interaction securely

---

## 📬 Feedback

Feel free to open issues or share feedback via pull requests or comments!

---

**Happy Coding 👨‍💻**
