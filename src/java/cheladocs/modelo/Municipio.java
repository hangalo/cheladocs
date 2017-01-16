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
public class Municipio {
    private Integer codigoMunicipio;
    private String nomeMunicipio;
    private Provincia provinciaMunicipio;

    public Municipio() {
    }

    public Municipio(Integer codigoMunicipio, String nomeMunicipio, Provincia provinciaMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.provinciaMunicipio = provinciaMunicipio;
    }

    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Provincia getProvinciaMunicipio() {
        return provinciaMunicipio;
    }

    public void setProvinciaMunicipio(Provincia provinciaMunicipio) {
        this.provinciaMunicipio = provinciaMunicipio;
    }
    
    
}
