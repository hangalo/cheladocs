/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.modelo;

import java.sql.Date;

/**
 *
 * @author Adelino Eduardo
 */
public class Documento {
    private int numeroProtocolo;
    private Requerente requerente;
    private Date dataEntrada;
    private String origem;
    private String descricaoAssunto;
    private NaturezaAssunto naturezaAssunto;
    private TipoExpediente tipoExpediente;
    private String urlFicheiroDocumento;
    private String conteudoDocumento;

    public int getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(int numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public Requerente getRequerente() {
        return requerente;
    }

    public void setRequerente(Requerente requerente) {
        this.requerente = requerente;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDescricaoAssunto() {
        return descricaoAssunto;
    }

    public void setDescricaoAssunto(String descricaoAssunto) {
        this.descricaoAssunto = descricaoAssunto;
    }

    public NaturezaAssunto getNaturezaAssunto() {
        return naturezaAssunto;
    }

    public void setNaturezaAssunto(NaturezaAssunto naturezaAssunto) {
        this.naturezaAssunto = naturezaAssunto;
    }

    public TipoExpediente getTipoExpediente() {
        return tipoExpediente;
    }

    public void setTipoExpediente(TipoExpediente tipoExpediente) {
        this.tipoExpediente = tipoExpediente;
    }

    public String getUrlFicheiroDocumento() {
        return urlFicheiroDocumento;
    }

    public void setUrlFicheiroDocumento(String urlFicheiroDocumento) {
        this.urlFicheiroDocumento = urlFicheiroDocumento;
    }

    public String getConteudoDocumento() {
        return conteudoDocumento;
    }

    public void setConteudoDocumento(String conteudoDocumento) {
        this.conteudoDocumento = conteudoDocumento;
    }
    
}
