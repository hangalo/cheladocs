/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.modelo;

/**
 *
 * @author informatica
 */
public class Provincia {
    private Integer idProvincia;
    private String nomeProvincia;
    private Pais paisProvincia;

    public Provincia() {
    }

    public Provincia(Integer idProvincia, String nomeProvincia, Pais paisProvincia) {
        this.idProvincia = idProvincia;
        this.nomeProvincia = nomeProvincia;
        this.paisProvincia = paisProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    public Pais getPaisProvincia() {
        return paisProvincia;
    }

    public void setPaisProvincia(Pais paisProvincia) {
        this.paisProvincia = paisProvincia;
    }

   
}
