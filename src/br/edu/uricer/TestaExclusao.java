
package br.edu.uricer;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    stm.execute();
    int count = stm.getUpdateCount();
    System.out.println(count + " registros excluídos");
    
    stm.close();
    con.close();
    
    }
}
