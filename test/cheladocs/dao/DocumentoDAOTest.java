/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Documento;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class DocumentoDAOTest {
    
    public DocumentoDAOTest() {
    }
    
    /**
     * Test of save method, of class DocumentoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Documento documento = new Documento();
        documento.setConteudoDocumento("A1");
        documento.setDataEntrada(new Date(Calendar.getInstance().getTime().getTime()));
        documento.setDescricaoAssunto("D1");
        documento.getNaturezaAssunto().setIdNaturezaAssunto(2);
        documento.setOrigem("O1");
        documento.getRequerente().setIdRequerente(1);
        documento.getTipoExpediente().setIdTipoExpediente(1);
        //documento.setUrlFicheiroDocumento("aaa");
        DocumentoDAO instance = new DocumentoDAO();
        instance.save(documento);
    }

    /**
     * Test of update method, of class DocumentoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Documento documento = new Documento();
        documento.setConteudoDocumento("A1");
        documento.setDataEntrada(new Date(Calendar.getInstance().getTime().getTime()));
        documento.setDescricaoAssunto("D1");
        documento.getNaturezaAssunto().setIdNaturezaAssunto(1);
        documento.setOrigem("O1");
        documento.getRequerente().setIdRequerente(1);
        documento.getTipoExpediente().setIdTipoExpediente(1);
        //documento.setUrlFicheiroDocumento("aaa");
        documento.setNumeroProtocolo(2);
        DocumentoDAO instance = new DocumentoDAO();
        instance.update(documento);
    }

    /**
     * Test of delete method, of class DocumentoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Documento documento = new Documento();
        documento.setNumeroProtocolo(3);
        DocumentoDAO instance = new DocumentoDAO();
        instance.delete(documento);
    }

    /**
     * Test of findById method, of class DocumentoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idDocumento = 1;
        DocumentoDAO instance = new DocumentoDAO();
        Documento result = instance.findById(idDocumento);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class DocumentoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DocumentoDAO instance = new DocumentoDAO();
        List<Documento> result = instance.findAll();
        assertTrue(result != null);
    }

}
