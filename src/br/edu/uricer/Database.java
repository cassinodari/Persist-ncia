package br.edu.uricer;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class Database {

    public static Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Cassi", "usuario", "senha");
        return con;
    }
}

