package main.java.JDBC;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        try {
            CrudOperator crud = new CrudOperator();
            try {
                crud.selectRecord();
                crud.insertRecord();
                crud.updateRecord();
                crud.deleteRecord();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                crud.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}