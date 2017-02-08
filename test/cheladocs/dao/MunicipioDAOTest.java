/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Municipio;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class MunicipioDAOTest {
    
    public MunicipioDAOTest() {
    }
    
    /**
     * Test of save method, of class MunicipioDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Municipio municipio = new Municipio();
        municipio.setNomeMunicipio("Luanda");
         municipio.setNomeMunicipio("Bengo");
        municipio.getProvinciaMunicipio().setIdProvincia(1);
        MunicipioDAO instance = new MunicipioDAO();
        instance.save(municipio);
    }

    /**
     * Test of update method, of class MunicipioDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Municipio municipio = new Municipio();
        municipio.setNomeMunicipio("Luanda");
        municipio.setIdMunicipio(2);
        municipio.getProvinciaMunicipio().setIdProvincia(2);
        MunicipioDAO instance = new MunicipioDAO();
        instance.update(municipio);
    }

    /**
     * Test of delete method, of class MunicipioDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Municipio municipio = new Municipio();
        municipio.setIdMunicipio(3);
        MunicipioDAO instance = new MunicipioDAO();
        instance.delete(municipio);
    }

    /**
     * Test of findById method, of class MunicipioDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idMunicipio = 1;
        MunicipioDAO instance = new MunicipioDAO();
        Municipio result = instance.findById(idMunicipio);
        assertTrue(result!= null);
    }

    /**
     * Test of findAll method, of class MunicipioDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MunicipioDAO instance = new MunicipioDAO();
        List<Municipio> result = instance.findAll();
        assertTrue(result != null);
    }

    /**
     * Test of findProvinciaPais method, of class MunicipioDAO.
     */
    @Test
    public void testFindMunicipioProvincia() {
        System.out.println("findMunicipioProvincia");
        int idProvincia = 1;
        MunicipioDAO instance = new MunicipioDAO();
        List<Municipio> result = instance.findMunicipioProvincia(idProvincia);
        assertTrue(result != null);
    }
    
}
