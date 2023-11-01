package Models;

import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private int idUsuario;
    private int idConsulta;
    private String flStatus;
    private Date dtInclusao;
    private int idFormaPagto;
    private Date dtExclusao;
    private Date dtAlteracao;

    public Pagamento() {
        // Construtor padrão
    }

    public Pagamento(int idUsuario, int idConsulta, String flStatus, Date dtInclusao, int idFormaPagto) {
        this.idUsuario = idUsuario;
        this.idConsulta = idConsulta;
        this.flStatus = flStatus;
        this.dtInclusao = dtInclusao;
        this.idFormaPagto = idFormaPagto;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getFlStatus() {
        return flStatus;
    }

    public void setFlStatus(String flStatus) {
        this.flStatus = flStatus;
    }

    public Date getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public int getIdFormaPagto() {
        return idFormaPagto;
    }

    public void setIdFormaPagto(int idFormaPagto) {
        this.idFormaPagto = idFormaPagto;
    }

    public Date getDtExclusao() {
        return dtExclusao;
    }

    public void setDtExclusao(Date dtExclusao) {
        this.dtExclusao = dtExclusao;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }
}
