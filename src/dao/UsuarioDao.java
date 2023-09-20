/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.ConexaoBanco;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aluno 63
 */
public class UsuarioDao {
    private ConexaoBanco conexao;
    
    public UsuarioDao() {
        this.conexao = new ConexaoBanco();
    }
    
    public boolean loginUsuario(String dsLogin, String dsSenha) {
        String sql = String.format("SELECT * FROM tbUsuarios WHERE dsLogin =? AND dsSenha =?", dsLogin, dsSenha);
        
        boolean flUsuarioExiste = false;
        
        try 
        {
            if(conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                
                ResultSet rs = sentenca.executeQuery();
                
                if(rs.next()) {
                    flUsuarioExiste = true;
                }
                
                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return flUsuarioExiste;
        }
        catch(SQLException ex) 
        {
             throw new RuntimeException(ex);
        }
    }
}
