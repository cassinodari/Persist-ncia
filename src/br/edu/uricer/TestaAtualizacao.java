package br.edu.uricer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaAtualizacao {
    public static void main(String[] args) throws SQLException {
        Connection con = Database.getConnection();
        

        String sql = "update Pessoas set nome = ? where id = ?";
        PreparedStatement stm = con.PrepareStatement(sql);
        stm.setString(1, "XXXXX");
        stm.setInt(2, 3);

        stm.executeUpdate();
        int updateCount = stm.getUpdateCount();
        System.out.println(updateCount);
        
        stm.close();
        con.close();
    }
}
