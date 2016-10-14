
package br.edu.uricer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class TestaExclusao {
    
    public static void main(String[] args) throws SQLException {
        
    
    Connection con = Database.getConnection();
    
    String sql = "delete from Pessoas where id > 2";
    Statement stm = con.createStatement();
    stm.execute(sql);
    int count = stm.getUpdateCount();
    System.out.println(count + " registros excluídos");
    
    stm.close();
    con.close();
    
    }
}
