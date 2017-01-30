/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.NaturezaAssunto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class NaturezaAssuntoDAOTest {
    
    /**
     * Test of save method, of class NaturezaAssuntoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        NaturezaAssunto natureza_assunto = new NaturezaAssunto();
        natureza_assunto.setNaturezaAssunto("A1");
        NaturezaAssuntoDAO instance = new NaturezaAssuntoDAO();
        instance.save(natureza_assunto);
    }

    /**
     * Test of update method, of class NaturezaAssuntoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        NaturezaAssunto natureza_assunto = new NaturezaAssunto();
        natureza_assunto.setNaturezaAssunto("A1.1");
        natureza_assunto.setIdNaturezaAssunto(1);
        NaturezaAssuntoDAO instance = new NaturezaAssuntoDAO();
        instance.update(natureza_assunto);
    }

    /**
     * Test of delete method, of class NaturezaAssuntoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        NaturezaAssunto natureza_assunto = new NaturezaAssunto();
        natureza_assunto.setIdNaturezaAssunto(1);
        NaturezaAssuntoDAO instance = new NaturezaAssuntoDAO();
        instance.delete(natureza_assunto);
    }

    /**
     * Test of findById method, of class NaturezaAssuntoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id_natureza_assunto = 1;
        NaturezaAssuntoDAO instance = new NaturezaAssuntoDAO();
        NaturezaAssunto result = instance.findById(id_natureza_assunto);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class NaturezaAssuntoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        NaturezaAssuntoDAO instance = new NaturezaAssuntoDAO();
        List<NaturezaAssunto> result = instance.findAll();
        assertTrue(result != null);
    }
    
}
