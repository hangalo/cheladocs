/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Pais;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class PaisDAOTest {
    
    /**
     * Test of save method, of class PaisDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Pais pais = new Pais();
        pais.setNomePais("Angola");
        PaisDAO instance = new PaisDAO();
        instance.save(pais);
    }

    /**
     * Test of update method, of class PaisDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Pais pais = new Pais();
        pais.setNomePais("África do Sul");
        pais.setIdPais(2);
        PaisDAO instance = new PaisDAO();
        instance.update(pais);
        
    }

    /**
     * Test of delete method, of class PaisDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Pais pais = new Pais();
        pais.setIdPais(2);
        PaisDAO instance = new PaisDAO();
        instance.delete(pais);
    }

    /**
     * Test of findById method, of class PaisDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idPais = 1;
        PaisDAO instance = new PaisDAO();
        Pais result = instance.findById(idPais);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class PaisDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        PaisDAO instance = new PaisDAO();
        List<Pais> result = instance.findAll();
        assertTrue(result != null);
    }
    
}
