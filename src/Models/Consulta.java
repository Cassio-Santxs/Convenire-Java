/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Adm
 */
import java.util.Date;

public class Consulta {
    private int idConsulta;
    private int idUsuario;
    private Date dtConsulta;
    private Date hrConsulta;
    private boolean flSituacao;
    private float vlConsulta;
    private Pagamento pagamento;

    public Consulta() {
      
    }

    public Consulta(int idConsulta, int idUsuario, Date dtConsulta, Date hrConsulta, boolean flSituacao) {
        this.idConsulta = idConsulta;
        this.idUsuario = idUsuario;
        this.dtConsulta = dtConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Date dtConsulta) {
        this.dtConsulta = dtConsulta;
    }
    
    public float getVlConsulta() {
        return vlConsulta;
    }

    public void setVlConsulta(float dtConsulta) {
        this.vlConsulta = dtConsulta;
    }
    
    public Pagamento getPagamento() {
    return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
