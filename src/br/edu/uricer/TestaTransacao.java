package br.edu.uricer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class TestaTransacao {
    public static void main(String[] args) throws SQLException {
        try (Connection con = Database.getConnection()){
           con.setAutoCommit(false);   //aqui será interrompido 
        
        String sql = "insert into from Pessoas(nome) values(?)";
        
        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            adicionar(stm, "Nome1");
            adicionar(stm, "Nome2");
        } catch (Exception Ex){
            System.out.println("Executando rollback...deu ruim");
            con.rollback();
        }
      }
    }
    
    
    public static void adiconar(PreparedStatement stm, String nome) throws SQLException {
     
        if(nome.equals("Nome2")){
            throw new IllegalArgumentException("Deu PT");
        }
        
        stm.setString(1,"Mancuda");
        stm.execute();
        
        ResultSet resultSet = stm.getGeneratedKeys();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
        }
    }

    private static void adicionar(PreparedStatement stm, String nome2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
