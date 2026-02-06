# Student CRUD Application

A simple **Student Management System** built with **Java, Servlets, JSP, and MySQL**. This mini-project demonstrates the fundamentals of web development using Jakarta EE technologies.

## 🎯 Learning Goals

This project is designed for learning:
- **Servlet-based MVC architecture**
- **CRUD operations** (Create, Read, Update, Delete)
- **Database connectivity** with JDBC
- **JSP views** with JSTL
- **Action-based routing** in servlets
- **Singleton pattern** for database connection
- **Context-aware navigation** (redirect based on source page)

## 🛠️ Technologies Used

- **Java 21**
- **Jakarta Servlet API 6.0**
- **Jakarta JSP 3.1**
- **JSTL 3.0**
- **MySQL 8.0**
- **Maven** (build tool)
- **Apache Tomcat 11** (servlet container)
- **Tailwind CSS** (CDN for styling)

## 📁 Project Structure

```
StudentCRUD/
├── src/
│   ├── main/
│       ├── java/
│       │   ├── Controller/
│       │   │   └── StudentServlet.java      # Main controller
│       │   ├── Model/
│       │   │   └── Student.java             # Entity class
│       │   └── dao/
│       │       ├── DBConnection.java        # Database connection (Singleton)
│       │       └── StudentDAO.java          # Data Access Object
│       └── webapp/
│           ├── index.jsp                    # List all students
│           ├── show.jsp                     # Show one student
│           ├── create.jsp                   # Create new student
│           ├── edit.jsp                     # Edit student
│           └── WEB-INF/
│               └── web.xml                  # Web deployment descriptor
├── pom.xml                                  # Maven configuration
└── README.md
```

## 🚀 Getting Started

### Prerequisites

Before running this project, make sure you have:

1. **Java 21** installed
   ```bash
   java -version
   ```

2. **Apache Maven** installed
   ```bash
   mvn -version
   ```

3. **MySQL Server** running (via XAMPP, standalone, or Homebrew)
   ```bash
   # Check if MySQL is running
   ps aux | grep mysql
   ```

4. **Apache Tomcat 11** installed
   - Download from: https://tomcat.apache.org/download-11.cgi

5. **Git** installed
   ```bash
   git --version
   ```

### Installation Steps

#### 1. Clone the Repository

```bash
git clone https://github.com/EnnMan/student-crud-jee.git
cd student-crud-jee
```

#### 2. Setup MySQL Database

**Connect to MySQL:**
```bash
mysql -u root -p
```

**Create database and table:**
```sql
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(100) NOT NULL,
    cne VARCHAR(20) NOT NULL,
    adresse VARCHAR(255),
    UNIQUE KEY unique_cne (cne)
);

-- Insert sample data
INSERT INTO students (fullName, cne, adresse) VALUES 
('Ahmed El Mansouri', 'CNE12345', 'Casablanca'),
('Fatima Zahra', 'CNE67890', 'Rabat'),
('Omar Benjelloun', 'CNE11223', 'Marrakech');

EXIT;
```

#### 3. Configure Database Connection

Edit `src/main/java/dao/DBConnection.java` and update your MySQL credentials:

```java
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";  // Change this!
```

#### 4. Build the Project

```bash
mvn clean package
```

This creates `target/StudentCRUD.war`

#### 5. Deploy to Tomcat

**Option A: Manual Deployment**
```bash
cp target/StudentCRUD.war /path/to/tomcat/webapps/
```

**Option B: Using IntelliJ IDEA**
1. Open project in IntelliJ
2. Install **Smart Tomcat** plugin
3. Configure Tomcat run configuration:
   - Tomcat server: Apache Tomcat 11
   - Deployment directory: `src/main/webapp`
   - Context path: `/StudentCRUD`
   - **Important:** Add MySQL JAR to classpath:
     ```
     Extra JVM classpath: ~/.m2/repository/com/mysql/mysql-connector-j/8.0.33/mysql-connector-j-8.0.33.jar
     ```
4. Run the configuration

**Option C: Using Eclipse**
1. Import as Maven project
2. Add Tomcat 11 server
3. Deploy project to Tomcat
4. Start server

#### 6. Access the Application

Open your browser and visit:
```
http://localhost:8080/StudentCRUD/students
```

## 📖 Features & Usage

### 1. **List Students** (index.jsp)
- View all students in a table
- Actions: Show, Edit, Delete buttons per student
- Create new student button (top right)

### 2. **Show Student** (show.jsp)
- View detailed information of one student
- Edit and Delete buttons

### 3. **Create Student** (create.jsp)
- Form to add new student
- Required fields: Full Name, CNE
- Optional: Address

### 4. **Edit Student** (edit.jsp)
- Form to update student information
- Pre-filled with existing data
- Context-aware redirect (returns to source page)

### 5. **Delete Student**
- Confirmation dialog before deletion
- Redirects to student list

## 🔗 URL Patterns

| Action | HTTP Method | URL | Description |
|--------|-------------|-----|-------------|
| List all | GET | `/students` | Show all students |
| Show one | GET | `/students?action=show&id=1` | Show student details |
| New form | GET | `/students?action=new` | Show create form |
| Edit form | GET | `/students?action=edit&id=1` | Show edit form |
| Create | POST | `/students?action=insert` | Insert new student |
| Update | POST | `/students?action=update` | Update student |
| Delete | GET | `/students?action=delete&id=1` | Delete student |

## 🎨 Design Patterns Used

### 1. **MVC (Model-View-Controller)**
- **Model:** `Student.java`
- **View:** JSP files (index, show, create, edit)
- **Controller:** `StudentServlet.java`

### 2. **DAO (Data Access Object)**
- Separates business logic from data access
- `StudentDAO.java` handles all database operations

### 3. **Singleton Pattern**
- `DBConnection.java` uses singleton for connection reuse
- Only one database connection throughout application lifecycle

### 4. **Front Controller Pattern**
- Single servlet handles all requests
- Action parameter determines routing

## 🛡️ Security Features

- **PreparedStatement** for SQL injection prevention
- **JSTL Expression Language** for XSS protection
- **Confirmation dialogs** for destructive actions

## 🐛 Troubleshooting

### Issue: 404 Error

**Solution:**
- Verify Tomcat is running
- Check URL is correct: `http://localhost:8080/StudentCRUD/students`
- Ensure WAR is deployed in Tomcat webapps folder

### Issue: "No suitable driver found"

**Solution:**
- Add MySQL connector to Tomcat classpath
- For IntelliJ Smart Tomcat, add to "Extra JVM classpath"
- Or copy JAR to `$TOMCAT_HOME/lib/`

### Issue: "Connection is null"

**Solution:**
- Check MySQL is running: `ps aux | grep mysql`
- Verify database `studentdb` exists
- Update password in `DBConnection.java`
- Check MySQL is on port 3306

### Issue: Blank page or no data

**Solution:**
- Check Tomcat console for errors
- Verify JSTL taglib in JSP: `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`
- Check servlet is passing data: `request.setAttribute("students", students)`

## 📚 Learning Resources

- [Jakarta Servlet Documentation](https://jakarta.ee/specifications/servlet/)
- [Jakarta JSP Documentation](https://jakarta.ee/specifications/pages/)
- [JSTL Tutorial](https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm)
- [JDBC Tutorial](https://docs.oracle.com/javase/tutorial/jdbc/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

## 🤝 Contributing

This is a learning project. Feel free to:
- Fork the repository
- Add new features
- Improve error handling
- Add input validation
- Implement pagination
- Add search functionality

## 📝 License

This project is for educational purposes.

## 👨‍💻 Author

Created as a learning project to understand:
- Jakarta EE web development
- Servlet/JSP architecture
- JDBC and database connectivity
- Maven build system
- MVC pattern implementation

## 🎓 Next Steps for Learning

After completing this project, try:
1. Add **pagination** to the student list
2. Implement **search** by name or CNE
3. Add **input validation** (client and server-side)
4. Implement **authentication** (login/logout)
5. Add **session management**
6. Use **connection pooling** (Apache DBCP)
7. Implement **logging** (Log4j or SLF4J)
8. Add **unit tests** (JUnit)
9. Migrate to **Spring Boot** framework
10. Create **RESTful API** instead of JSP views

---

**Happy Learning! 🚀**
