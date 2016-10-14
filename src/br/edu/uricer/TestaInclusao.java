package br.edu.uricer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInclusao {
    
    public static void main(String[] args) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "insert into from Pessoas(nome) values(?)";
        PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stm.setString(1,"Mancuda");
        stm.execute();
        
        ResultSet resultSet = stm.getGeneratedKeys();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
        }
       
        stm.close();
        resultSet.close();
        con.close();
    }
}
