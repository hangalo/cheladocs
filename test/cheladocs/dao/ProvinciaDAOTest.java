/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Provincia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class ProvinciaDAOTest {
    
    public ProvinciaDAOTest() {
    }
    
    /**
     * Test of save method, of class ProvinciaDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Provincia provincia = new Provincia();
        provincia.getPaisProvincia().setIdPais(1);
        provincia.setNomeProvincia("Huila");
        ProvinciaDAO instance = new ProvinciaDAO();
        instance.save(provincia);
    }

    /**
     * Test of update method, of class ProvinciaDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Provincia provincia = new Provincia();
        provincia.getPaisProvincia().setIdPais(1);
        provincia.setNomeProvincia("Huambo");
        provincia.setIdProvincia(2);
        ProvinciaDAO instance = new ProvinciaDAO();
        instance.update(provincia);
    }

    /**
     * Test of delete method, of class ProvinciaDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Provincia provincia = new Provincia();
        provincia.setIdProvincia(3);
        ProvinciaDAO instance = new ProvinciaDAO();
        instance.delete(provincia);
    }

    /**
     * Test of findById method, of class ProvinciaDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idProvincia = 1;
        ProvinciaDAO instance = new ProvinciaDAO();
        Provincia result = instance.findById(idProvincia);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class ProvinciaDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ProvinciaDAO instance = new ProvinciaDAO();
        List<Provincia> result = instance.findAll();
        assertTrue(result != null);
    }

    /**
     * Test of findProvinciaPais method, of class ProvinciaDAO.
     */
    @Test
    public void testFindProvinciaPais() {
        System.out.println("findProvinciaPais");
        int idPais = 1;
        ProvinciaDAO instance = new ProvinciaDAO();
        List<Provincia> result = instance.findProvinciaPais(idPais);
        assertTrue(result != null);
    }
    
}
