/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.modelo;

import java.util.Date;

/**
 *
 * @author Adelino Eduardo
 */
public class MovimentoDocumento {
    private int idMovimentoProgressivo;
    private Date dataRecepcao;
    private Date dataReenvio;
    private Departamento departamento;
    private String notas;
    private Documento documento;

    public MovimentoDocumento(){
        departamento = new Departamento();
        documento = new Documento();
    }
    
    public int getIdMovimentoProgressivo() {
        return idMovimentoProgressivo;
    }

    public void setIdMovimentoProgressivo(int idMovimentoProgressivo) {
        this.idMovimentoProgressivo = idMovimentoProgressivo;
    }

    public Date getDataRecepcao() {
        return dataRecepcao;
    }

    public void setDataRecepcao(Date dataRecepcao) {
        this.dataRecepcao = dataRecepcao;
    }

    public Date getDataReenvio() {
        return dataReenvio;
    }

    public void setDataReenvio(Date dataReenvio) {
        this.dataReenvio = dataReenvio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    
}
