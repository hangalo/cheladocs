/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.TipoExpediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Adelino Eduardo
 */
public class TipoExpedienteDAO implements GenericoDAO<TipoExpediente>{
    private static final String INSERIR = "insert into tipo_expediente (tipo_expediente) values (?)";
    private static final String ACTUALIZAR = "update tipo_expediente set tipo_expediente = ? where id_tipo_expediente = ?";
    private static final String ELIMINAR = "delete from tipo_expediente where id_tipo_expediente = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from tipo_expediente where id_tipo_expediente = ?";
    private static final String LISTAR_TUDO ="select * from tipo_expediente order by tipo_expediente";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    @Override
    public void save(TipoExpediente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TipoExpediente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TipoExpediente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoExpediente findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoExpediente> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularComDados(TipoExpediente t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
