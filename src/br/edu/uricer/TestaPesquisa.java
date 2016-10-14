
package br.edu.uricer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class TestaPesquisa {
    
    public static void main(String[] args) throws SQLException {
        Connection con = Database.getConnection();
        

        String sql = "select * from Pessoas";
        Statement stm = con.createStatement();
        boolean resultado = stm.execute(sql);
        System.out.println("Resultado: " + resultado);

        ResultSet resultSet = stm.getResultSet();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            System.out.println(nome);
        }
        
        con.close();
        stm.close();
        resultSet.close();
    }
}
