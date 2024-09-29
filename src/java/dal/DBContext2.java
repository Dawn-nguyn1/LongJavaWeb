package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FPT University - PRJ301
 */
public class DBContext2 {

    protected Connection connection;

    public DBContext2() {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration 
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {
            String user = "sa";
            String pass = "duclongks1";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Student";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=ToDoApp;";
//        Connection connection = DriverManager.getConnection(url, "sa", "duclongks1");
//        return connection;
//    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(DBContext2.makeConnection());
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBContext2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
