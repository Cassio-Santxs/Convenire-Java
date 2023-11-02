/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Adm
 */
public class Usuario {
    private int idUsuario;
    private String nmUsuario;
    private String nrDoc;
    private String dsEmail;
    private String dsSenha;
    private String nrTelefone;
    private boolean flAdmin;
    
    public Usuario() {
      
    } 
    
    public Usuario(int idUsuario, String nmUsuario, String nrDoc, String dsEmail, String dsSenha, boolean flAdmin) {
        this.idUsuario = idUsuario;     
        this.nmUsuario = nmUsuario;
        this.nrDoc = nrDoc;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.flAdmin = flAdmin;
    } 
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getNrDoc() {
        return nrDoc;
    }

    public void setNrDoc(String nrDoc) {
        this.nrDoc = nrDoc;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }  
    
    public boolean getFlAdmin() {
        return flAdmin;
    }

    public void setFlAdmin(boolean flAdmin) {
        this.flAdmin = flAdmin;
    } 
    
    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    } 
    
}
