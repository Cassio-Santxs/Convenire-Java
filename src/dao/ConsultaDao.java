/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Models.Consulta;
import Models.Pagamento;
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
    String sqlConsulta = "INSERT INTO tbConsultas (idUsuario, dtConsulta, vlConsulta) VALUES (?, ?, 100)";
    String sqlPagamento = "INSERT INTO tbPagamentos (dtInclusao, flStatus, idFormaPagto, idUsuario, vlPagamento) VALUES (?, 'Pendente', 1, ?, 100)";

    try {
        if (conexao.conectar()) {
                PreparedStatement sentencaConsulta = conexao.getConnection().prepareStatement(sqlConsulta);
                sentencaConsulta.setInt(1, consulta.getIdUsuario());
                sentencaConsulta.setTimestamp(2, new java.sql.Timestamp(consulta.getDtConsulta().getTime()));
                int linhasAfetadasConsulta = sentencaConsulta.executeUpdate();
                sentencaConsulta.close();

                PreparedStatement sentencaPagamento = conexao.getConnection().prepareStatement(sqlPagamento);
                sentencaPagamento.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
                sentencaPagamento.setInt(2, consulta.getIdUsuario());
                int linhasAfetadasPagamento = sentencaPagamento.executeUpdate();
                sentencaPagamento.close();

                conexao.getConnection().close();

                return (linhasAfetadasConsulta > 0) && (linhasAfetadasPagamento > 0);
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
    String sql = "SELECT C.idConsulta, C.dtConsulta, P.idPagamento, P.flStatus, P.dtInclusao, C.vlConsulta " +
                 "FROM tbConsultas C " +
                 "LEFT JOIN tbPagamentos P ON C.idConsulta = P.idConsulta " +
                 "WHERE C.idUsuario = ? " +
                 "ORDER BY C.dtConsulta";

    try {
        if (this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setInt(1, idUsuario);

            ResultSet resultadoSentenca = sentenca.executeQuery();

            while (resultadoSentenca.next()) {
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(resultadoSentenca.getInt("idConsulta"));
                consulta.setDtConsulta(resultadoSentenca.getTimestamp("dtConsulta"));
                consulta.setVlConsulta(resultadoSentenca.getFloat("vlConsulta"));

                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(resultadoSentenca.getInt("idPagamento"));
                pagamento.setFlStatus(resultadoSentenca.getString("flStatus"));
                pagamento.setDtInclusao(resultadoSentenca.getTimestamp("dtInclusao"));

                consulta.setPagamento(pagamento);

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
    
    public ArrayList<Consulta> getTodosRegistros() {
        String sql = "SELECT * FROM tbConsultas";
        ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
        
        try {
            if (conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);

                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while (resultadoSentenca.next()) {
                    Consulta consulta = new Consulta();
                    consulta.setIdConsulta(resultadoSentenca.getInt("idConsulta"));
                    consulta.setDtConsulta(resultadoSentenca.getTimestamp("dtConsulta"));
                    consulta.setVlConsulta(resultadoSentenca.getFloat("vlConsulta"));

                    listaConsultas.add(consulta);
                }
                
                sentenca.close();
                this.conexao.getConnection().close();
                
                return listaConsultas;
            }

            return null; 
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
