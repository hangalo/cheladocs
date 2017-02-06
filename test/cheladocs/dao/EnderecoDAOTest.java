/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Endereco;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class EnderecoDAOTest {
    
    public EnderecoDAOTest() {
    }
    
    /**
     * Test of save method, of class EnderecoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Endereco endereco = new Endereco();
        endereco.setBairroEndereco("B1");
        endereco.setCaixaPostal("123456");
        endereco.setCasaEndereco("12");
        endereco.setCidadeEndereco("Luanda");
        endereco.setFlagActivo(1);
        endereco.getMunicipio().setIdMunicipio(1);
        endereco.getRequerente().setIdRequerente(1);
        endereco.setRuaEndereco("R1");
        EnderecoDAO instance = new EnderecoDAO();
        instance.save(endereco);
    }

    /**
     * Test of update method, of class EnderecoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Endereco endereco = new Endereco();
        endereco.setBairroEndereco("B1.1");
        endereco.setCaixaPostal("123456789");
        endereco.setCasaEndereco("123");
        endereco.setCidadeEndereco("Viana");
        endereco.setFlagActivo(1);
        endereco.getMunicipio().setIdMunicipio(2);
        endereco.getRequerente().setIdRequerente(2);
        endereco.setRuaEndereco("R7");
        endereco.setIdEndereco(2);
        EnderecoDAO instance = new EnderecoDAO();
        instance.update(endereco);
    }

    /**
     * Test of delete method, of class EnderecoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(3);
        EnderecoDAO instance = new EnderecoDAO();
        instance.delete(endereco);
    }

    /**
     * Test of findById method, of class EnderecoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idEndereco = 1;
        EnderecoDAO instance = new EnderecoDAO();
        Endereco result = instance.findById(idEndereco);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class EnderecoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        EnderecoDAO instance = new EnderecoDAO();
        List<Endereco> result = instance.findAll();
        assertTrue(result != null);
    }
    
}
