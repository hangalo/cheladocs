/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Departamento;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class DepartamentoDAOTest {
    
    public DepartamentoDAOTest() {
    }
    
    /**
     * Test of save method, of class DepartamentoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Departamento departamento = new Departamento();
        departamento.setDepartamento("A3");
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.save(departamento);
    }

    /**
     * Test of update method, of class DepartamentoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Departamento departamento = new Departamento();
        departamento.setDepartamento("Recursos Humanos");
        departamento.setIdDepartamento(1);
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.update(departamento);
    }

    /**
     * Test of delete method, of class DepartamentoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(2);
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.delete(departamento);
    }

    /**
     * Test of findById method, of class DepartamentoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id_departamento = 1;
        DepartamentoDAO instance = new DepartamentoDAO();
        Departamento result = instance.findById(id_departamento);
        assertTrue(result!=null);
    }

    /**
     * Test of findAll method, of class DepartamentoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DepartamentoDAO instance = new DepartamentoDAO();
        List<Departamento> result = instance.findAll();
        assertTrue(result.size()>0);
    }

  
    
}
