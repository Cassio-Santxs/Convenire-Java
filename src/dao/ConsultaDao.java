/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Models.Consulta;
import Models.Usuario;
import dao.ConexaoBanco;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aluno 63
 */
public class ConsultaDao {
    private ConexaoBanco conexao;
    
    public ConsultaDao() {
        this.conexao = new ConexaoBanco();
    }
    
    public boolean insert(Consulta consulta) {
        String sql = "INSERT INTO tbConsultas (idUsuario, dtConsulta) VALUES (?, ?)";

        try {
            if (conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);

                sentenca.setInt(1, consulta.getIdUsuario());
                sentenca.setTimestamp(2, new java.sql.Timestamp(consulta.getDtConsulta().getTime()));

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
    
    public void alterar(Consulta consulta) {
        String sql = "UPDATE tbConsultas SET dtConsulta = ? WHERE idConsulta = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setTimestamp(1, new java.sql.Timestamp(consulta.getDtConsulta().getTime()));
                sentenca.setInt(2, consulta.getIdConsulta());
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public void excluirById(int id) {
        String sql = "DELETE FROM tbConsultas WHERE idConsulta = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1, id);
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Consulta> consultar(int idUsuario) {
        ArrayList<Consulta> listaConsulta = new ArrayList<Consulta>();
        String sql = "SELECT idConsulta, dtConsulta FROM tbConsultas WHERE idUsuario = ? ORDER BY dtConsulta";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, idUsuario); // Use 1 em vez de 0 para definir o parâmetro

                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    Consulta consulta = new Consulta();
                    consulta.setIdConsulta(resultadoSentenca.getInt("idConsulta"));
                    consulta.setDtConsulta(resultadoSentenca.getTimestamp("dtConsulta")); // Use getTimestamp para obter a data e hora

                    listaConsulta.add(consulta);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaConsulta;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
