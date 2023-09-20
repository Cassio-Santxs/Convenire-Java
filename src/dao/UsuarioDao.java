/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Models.Usuario;
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
    
    public boolean insert(Usuario usuario) {
        String sql = String.format(
                "INSERT INTO tbUsuarios (dsEmail, dsSenha, nmUsuario, nrDoc) VALUES ('%s', '%s', '%s', '%s')",
                usuario.getDsEmail(),
                usuario.getDsSenha(),
                usuario.getNmUsuario(),
                usuario.getNrDoc());
        
        try 
        {
            if(conexao.conectar()) {
                if(validaUsuario(usuario)) {
                    PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                
                    sentenca.execute();
                    
                    sentenca.close();
                    this.conexao.getConnection().close();
                } else {
                    throw new RuntimeException("Já existe um usuário com este e-mail ou número de documento!");
                }
            }
            
            return true;
        } 
        catch(SQLException ex) 
        {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean validaUsuario(Usuario usuario) {
        String sql = String.format("SELECT * FROM tbUsuarios WHERE dsEmail = '%s' || nrDoc = '%s'", usuario.getDsEmail(), usuario.getNrDoc());
        boolean flUsuarioValido = true;
        
        try 
        {
            if(conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                
                ResultSet rs = sentenca.executeQuery();
                
                if(rs.next())
                    flUsuarioValido = false;
            }
            
            return flUsuarioValido;
        }
        catch(SQLException ex) 
        {
            throw new RuntimeException(ex);
        }
    }
}
