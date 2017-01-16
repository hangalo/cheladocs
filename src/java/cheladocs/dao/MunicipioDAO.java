/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Municipio;
import java.util.List;

/**
 *
 * @author informatica
 */
public class MunicipioDAO implements GenericoDAO<Municipio>{
    
    private static final String INSERIR = "";
    private static final String ACTUALIZAR = "";
    private static final String ELIMINAR = "";
    private static final String BUSCAR_POR_CODIGO = "";
    private static final String LISTAR_TUDO ="";

    public MunicipioDAO() {
    }

    @Override
    public void save(Municipio municipio) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Municipio municipio) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Municipio municipio) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio findById(Integer id) {
        //To change body of generated methods, choose Tools | Templates.
         return null;
    }

    @Override
    public List<Municipio> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        return null;
    }
   
    
}
