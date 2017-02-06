/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Requerente;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class RequerenteDAOTest {
    
    /**
     * Test of save method, of class RequerenteDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Requerente requerente = new Requerente();
        requerente.setCategoriaJuridica("A1");
        requerente.setNomeRequerente("André");
        requerente.setSobrenomeRequerente("José");
        requerente.setTelefonePrincipal("123456");
        requerente.setEmailPrincipal("andre@gmail.com");
        RequerenteDAO instance = new RequerenteDAO();
        //instance.save(requerente);
    }

    /**
     * Test of update method, of class RequerenteDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Requerente requerente = new Requerente();
        requerente.setCategoriaJuridica("A1");
        requerente.setNomeRequerente("Marilia");
        requerente.setSobrenomeRequerente("Bernardo");
        requerente.setTelefonePrincipal("123456");
        requerente.setTelefoneAlternativo("456789");
        requerente.setEmailPrincipal("mari@gmail.com");
        requerente.setEmailAlternativo("123@hotmail.com");
        requerente.setHomePage("www.marilia.co.ao");
        requerente.setIdRequerente(2);
        RequerenteDAO instance = new RequerenteDAO();
        instance.update(requerente);
    }

    /**
     * Test of delete method, of class RequerenteDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Requerente requerente = new Requerente();
        requerente.setIdRequerente(3);
        RequerenteDAO instance = new RequerenteDAO();
        instance.delete(requerente);
    }

    /**
     * Test of findById method, of class RequerenteDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idRequerente = 1;
        RequerenteDAO instance = new RequerenteDAO();
        Requerente result = instance.findById(idRequerente);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class RequerenteDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        RequerenteDAO instance = new RequerenteDAO();
        List<Requerente> result = instance.findAll();
        assertTrue(result != null);
    }

}
