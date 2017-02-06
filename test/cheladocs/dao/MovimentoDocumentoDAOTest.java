/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.MovimentoDocumento;
import cheladocs.util.DateUtil;
import java.sql.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adelino Eduardo
 */
public class MovimentoDocumentoDAOTest {
    
    public MovimentoDocumentoDAOTest() {
    }
    
    /**
     * Test of save method, of class MovimentoDocumentoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        MovimentoDocumento mDocumento = new MovimentoDocumento();
        mDocumento.setDataRecepcao(new Date(DateUtil.strToDate("10/02/2017").getTime()));
        mDocumento.setDataReenvio(new Date(DateUtil.strToDate("20/02/2017").getTime()));
        mDocumento.getDepartamento().setIdDepartamento(12);
        mDocumento.getDocumento().setNumeroProtocolo(1);
        mDocumento.setNotas("N1");
        MovimentoDocumentoDAO instance = new MovimentoDocumentoDAO();
        //instance.save(mDocumento);
    }

    /**
     * Test of update method, of class MovimentoDocumentoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        MovimentoDocumento mDocumento = new MovimentoDocumento();
        mDocumento.setDataRecepcao(new Date(DateUtil.strToDate("5/02/2017").getTime()));
        mDocumento.setDataReenvio(new Date(DateUtil.strToDate("12/02/2017").getTime()));
        mDocumento.getDepartamento().setIdDepartamento(12);
        mDocumento.getDocumento().setNumeroProtocolo(1);
        mDocumento.setNotas("N1");
        mDocumento.setIdMovimentoProgressivo(2);
        MovimentoDocumentoDAO instance = new MovimentoDocumentoDAO();
        instance.update(mDocumento);
    }

    /**
     * Test of delete method, of class MovimentoDocumentoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        MovimentoDocumento mDocumento = new MovimentoDocumento();
        mDocumento.setIdMovimentoProgressivo(3);
        MovimentoDocumentoDAO instance = new MovimentoDocumentoDAO();
        instance.delete(mDocumento);
    }

    /**
     * Test of findById method, of class MovimentoDocumentoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idMovimentoDocumento = 1;
        MovimentoDocumentoDAO instance = new MovimentoDocumentoDAO();
        MovimentoDocumento result = instance.findById(idMovimentoDocumento);
        assertTrue(result != null);
    }

    /**
     * Test of findAll method, of class MovimentoDocumentoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MovimentoDocumentoDAO instance = new MovimentoDocumentoDAO();
        List<MovimentoDocumento> result = instance.findAll();
        assertTrue(result != null);
    }

}
