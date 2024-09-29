/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class StudentDAO extends DBContext2 {

    public Student getStudentByUserAndPassword(String username, String password) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (connection != null) {
                String sql = "SELECT * FROM Student WHERE username = ? AND password = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Student student = new Student(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("name")
                    );
                    return student;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
}
