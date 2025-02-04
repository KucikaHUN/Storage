/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kucik
 */
class SqlConnection {

    private static Connection connection;
    private static String connectionString;

    static {
        connectionString = "jdbc:mysql://localhost:3306/storage";
    }

    static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(connectionString, "root",
                    "Valami123");

        }

        return connection;
    }

    static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            connection = null;
        }
    }
}

