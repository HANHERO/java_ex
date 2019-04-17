package main.java.JDBC;

import java.sql.*;

public class CrudOperator {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testBD?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "123321";
    private Connection conn;
    private Statement stmt;

    CrudOperator() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
    }

    void selectRecord() throws SQLException {
        String sql = "SELECT * FROM mock_data";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int ID = rs.getInt("ID");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String ip_address = rs.getString("ip_address");

            System.out.println("ID: " + ID + ", First_name: " + first_name + ", Last_name: " + last_name + ", Email: " + email + ", Gender: " + gender + ", Ip_address: " + ip_address);
        }
        rs.close();
    }

    void insertRecord() throws SQLException {
        stmt.execute("INSERT INTO mock_data VALUES (1001, 'Alex', 'Cuper', 'asdas@sdafa.sa', 'Male', '192.168.125.113');");
    }

    void updateRecord() throws SQLException {
        stmt.execute("UPDATE mock_data SET ip_address = '8.8.8.8' WHERE gender = 'Female';");
    }

    void deleteRecord() throws SQLException {
        stmt.execute("DELETE FROM mock_data WHERE ip_address = '8.8.8.8';");
    }

    void close() throws SQLException {
        conn.close();
    }
}