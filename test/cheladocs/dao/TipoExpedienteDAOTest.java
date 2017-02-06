/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.TipoExpediente;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class TipoExpedienteDAOTest {
    
    public TipoExpedienteDAOTest() {
    }

    /**
     * Test of save method, of class TipoExpedienteDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        TipoExpediente tipoExpediente = new TipoExpediente();
        tipoExpediente.setTipoExpediente("TE1");
        TipoExpedienteDAO instance = new TipoExpedienteDAO();
        instance.save(tipoExpediente);
    }

    /**
     * Test of update method, of class TipoExpedienteDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        TipoExpediente tipoExpediente = new TipoExpediente();
        tipoExpediente.setTipoExpediente("TE1.1");
        tipoExpediente.setIdTipoExpediente(1);
        TipoExpedienteDAO instance = new TipoExpedienteDAO();
        instance.update(tipoExpediente);
    }

    /**
     * Test of delete method, of class TipoExpedienteDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        TipoExpediente tipoExpediente = new TipoExpediente();
        tipoExpediente.setIdTipoExpediente(1);
        TipoExpedienteDAO instance = new TipoExpedienteDAO();
        instance.delete(tipoExpediente);
    }

    /**
     * Test of findById method, of class TipoExpedienteDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idTipoExpediente = 1;
        TipoExpedienteDAO instance = new TipoExpedienteDAO();
        TipoExpediente result = instance.findById(idTipoExpediente);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class TipoExpedienteDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        TipoExpedienteDAO instance = new TipoExpedienteDAO();
        List<TipoExpediente> result = instance.findAll();
        assertTrue(result.size() > 0);
    }
    
}
