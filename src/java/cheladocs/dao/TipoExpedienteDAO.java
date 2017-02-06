/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.TipoExpediente;
import cheladocs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void save(TipoExpediente tipoExpediente) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, tipoExpediente.getTipoExpediente());
            ps.executeUpdate();
        }
        catch(SQLException ex){ Logger.getLogger(TipoExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void update(TipoExpediente tipoExpediente) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, tipoExpediente.getTipoExpediente());
            ps.setInt(2, tipoExpediente.getIdTipoExpediente());
            ps.executeUpdate();
        }
        catch(SQLException ex){ Logger.getLogger(TipoExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void delete(TipoExpediente tipoExpediente) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, tipoExpediente.getIdTipoExpediente());
            ps.executeUpdate();
        }
        catch(SQLException ex){ Logger.getLogger(TipoExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public TipoExpediente findById(Integer idTipoExpediente) {
        TipoExpediente tipoExpediente = null;
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idTipoExpediente);
            rs = ps.executeQuery();
            if(rs.next()){
                tipoExpediente = new TipoExpediente();
                popularComDados(tipoExpediente, rs);
            }
        }
        catch(SQLException ex){ Logger.getLogger(TipoExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return tipoExpediente;
    }

    @Override
    public List<TipoExpediente> findAll() {
        TipoExpediente tipoExpediente = null;
        ArrayList<TipoExpediente> listaTipoExpediente = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while(rs.next()){
                tipoExpediente = new TipoExpediente();
                popularComDados(tipoExpediente, rs);
                listaTipoExpediente.add(tipoExpediente);
            }
        }
        catch(SQLException ex){ Logger.getLogger(TipoExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaTipoExpediente;
    }

    @Override
    public void popularComDados(TipoExpediente tipoExpediente, ResultSet rs) {
        try{
            tipoExpediente.setIdTipoExpediente(rs.getInt("id_tipo_expediente"));
            tipoExpediente.setTipoExpediente(rs.getString("tipo_expediente"));
        }
        catch(SQLException ex){ Logger.getLogger(TipoExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex); }
    }
    
}
