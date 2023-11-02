package dao;

import Models.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PagamentoDao {
    private ConexaoBanco conexao;

    public PagamentoDao() {
        this.conexao = new ConexaoBanco();
    }

    public boolean inserir(Pagamento pagamento) {
        String sql = "INSERT INTO tbPagamentos (idUsuario, idConsulta, flStatus, dtInclusao, idFormaPagto) VALUES (?, ?, ?, ?, ?)";
        
        try {
            if (conexao.conectar()) {
                Connection connection = conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                
                statement.setInt(1, pagamento.getIdUsuario());
                statement.setInt(2, pagamento.getIdConsulta());
                statement.setString(3, pagamento.getFlStatus());
                statement.setTimestamp(4, new java.sql.Timestamp(pagamento.getDtInclusao().getTime()));
                statement.setInt(5, pagamento.getIdFormaPagto());
                
                int linhasAfetadas = statement.executeUpdate();
                
                statement.close();
                this.conexao.getConnection().close();
                
                return linhasAfetadas > 0;
            }
            
            return false;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void alterar(Pagamento pagamento) {
        String sql = "UPDATE tbPagamentos SET flStatus=? WHERE idPagamento=?";
        
        try {
            if (conexao.conectar()) {
                Connection connection = conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                
                statement.setString(1, pagamento.getFlStatus());
                statement.setInt(2, pagamento.getIdPagamento());
                
                statement.executeUpdate();
                
                statement.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluirPorId(int idPagamento) {
        String sql = "DELETE FROM tbPagamentos WHERE idPagamento=?";
        
        try {
            if (conexao.conectar()) {
                Connection connection = conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                
                statement.setInt(1, idPagamento);
                
                statement.executeUpdate();
                
                statement.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<Pagamento> getTodosRegistros() {
        ArrayList<Pagamento> listaPagamentos = new ArrayList<Pagamento>();
        String sql = "SELECT idPagamento, idUsuario, idConsulta, flStatus, dtInclusao, idFormaPagto FROM tbPagamentos";
        
        try {
            if (conexao.conectar()) {
                Connection connection = conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                
                ResultSet resultado = statement.executeQuery();
                
                while (resultado.next()) {
                    Pagamento pagamento = new Pagamento();
                    pagamento.setIdPagamento(resultado.getInt("idPagamento"));
                    pagamento.setIdUsuario(resultado.getInt("idUsuario"));
                    pagamento.setIdConsulta(resultado.getInt("idConsulta"));
                    pagamento.setFlStatus(resultado.getString("flStatus"));
                    pagamento.setDtInclusao(resultado.getTimestamp("dtInclusao"));
                    pagamento.setIdFormaPagto(resultado.getInt("idFormaPagto"));
                    
                    listaPagamentos.add(pagamento);
                }
                
                statement.close();
                this.conexao.getConnection().close();
            }
            
            return listaPagamentos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
