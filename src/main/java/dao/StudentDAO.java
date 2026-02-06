package dao;

import Model.Student;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Connection conn = DBConnection.getConnection();

        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("cne"),
                        rs.getString("adresse"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Connection conn = DBConnection.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("cne"),
                        rs.getString("adresse"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Student student) {
        String sql = "INSERT INTO students (fullName, cne, adresse) VALUES (?, ?, ?)";
        Connection conn = DBConnection.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getFullName());
            stmt.setString(2, student.getCne());
            stmt.setString(3, student.getAdresse());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        String sql = "UPDATE students SET fullName = ?, cne = ?, adresse = ? WHERE id = ?";
        Connection conn = DBConnection.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getFullName());
            stmt.setString(2, student.getCne());
            stmt.setString(3, student.getAdresse());
            stmt.setInt(4, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        Connection conn = DBConnection.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}