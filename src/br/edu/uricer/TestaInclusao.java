package br.edu.uricer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInclusao {
    
    public static void main(String[] args) throws SQLException {
        Connection con = Database.getConnection();
        

        String sql = "insert into from Pessoas(nome) values('Cassi')";
        Statement stm = con.createStatement();
        boolean resultado = stm.execute(sql,Statement.RETURN_GENERATED_KEYS);
        System.out.println("Resultado: " + resultado);

        ResultSet resultSet = stm.getGeneratedKeys();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            System.out.println(id);
        }
       
        stm.close();
        resultSet.close();
        con.close();
    }
}
