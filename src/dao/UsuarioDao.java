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
    
    public Usuario loginUsuario(String dsEmail, String dsSenha) {
        String sql = String.format("SELECT * FROM tbUsuarios WHERE dsEmail ='%s' AND dsSenha ='%s'", dsEmail, dsSenha);
        
        try 
        {
            if(conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                
                ResultSet rs = sentenca.executeQuery();
                
                if (rs.next()) {
                
                Usuario usuario = new Usuario();
                
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNmUsuario(rs.getString("nmUsuario")); 
                usuario.setNrDoc(rs.getString("nrDoc")); 
                usuario.setDsEmail(rs.getString("dsEmail"));
                usuario.setDsSenha(rs.getString("dsSenha"));
                usuario.setFlAdmin(rs.getBoolean("flAdmin"));
                
                sentenca.close();
                this.conexao.getConnection().close();
                
                return usuario;
            }
                
                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return null;
        }
        catch(SQLException ex) 
        {
             throw new RuntimeException(ex);
        }
    }
    
    public boolean insert(Usuario usuario) {
        if (!validaUsuario(usuario)) {
            return false;
        }

        String sql = "INSERT INTO tbUsuarios (dsEmail, dsSenha, nmUsuario, nrDoc) VALUES (?, ?, ?, ?)";

        try {
            if (conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1, usuario.getDsEmail());
                sentenca.setString(2, usuario.getDsSenha());
                sentenca.setString(3, usuario.getNmUsuario());
                sentenca.setString(4, usuario.getNrDoc());

                int linhasAfetadas = sentenca.executeUpdate();

                sentenca.close();
                this.conexao.getConnection().close();

                return linhasAfetadas > 0;
            }

            return false; 
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean validaUsuario(Usuario usuario) {
        String sql = "SELECT * FROM tbUsuarios WHERE dsEmail = ? OR nrDoc = ?";
        boolean flUsuarioValido = true;

        try {
            if (conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1, usuario.getDsEmail());
                sentenca.setString(2, usuario.getNrDoc());

                ResultSet rs = sentenca.executeQuery();

                if (rs.next()) {
                    flUsuarioValido = false;
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return flUsuarioValido;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Usuario getUsuarioById(int idUsuario) {
        String sql = "SELECT * FROM tbUsuarios WHERE idUsuario = ?";

        try {
            if (conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, idUsuario); 

                ResultSet rs = sentenca.executeQuery();

                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNmUsuario(rs.getString("nmUsuario"));
                    usuario.setNrDoc(rs.getString("nrDoc"));
                    usuario.setDsEmail(rs.getString("dsEmail"));
                    usuario.setDsSenha(rs.getString("dsSenha"));

                    sentenca.close();
                    this.conexao.getConnection().close();

                    return usuario;
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return null; 
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
