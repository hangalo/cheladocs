/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.modelo;

/**
 *
 * @author Adelino Eduardo
 */
public class Requerente {
    private int idRequerente;
    private String categoriaJuridica;
    private String nomeRequerente;
    private String sobrenomeRequerente;
    private String telefonePrincipal;
    private String telefoneAlternativo;
    private String emailPrincipal;
    private String emailAlternativo;
    private String homePage;

    public int getIdRequerente() {
        return idRequerente;
    }

    public void setIdRequerente(int idRequerente) {
        this.idRequerente = idRequerente;
    }

    public String getCategoriaJuridica() {
        return categoriaJuridica;
    }

    public void setCategoriaJuridica(String categoriaJuridica) {
        this.categoriaJuridica = categoriaJuridica;
    }

    public String getNomeRequerente() {
        return nomeRequerente;
    }

    public void setNomeRequerente(String nomeRequerente) {
        this.nomeRequerente = nomeRequerente;
    }

    public String getSobrenomeRequerente() {
        return sobrenomeRequerente;
    }

    public void setSobrenomeRequerente(String sobrenomeRequerente) {
        this.sobrenomeRequerente = sobrenomeRequerente;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public String getTelefoneAlternativo() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternativo(String telefoneAlternativo) {
        this.telefoneAlternativo = telefoneAlternativo;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
    
    
}
