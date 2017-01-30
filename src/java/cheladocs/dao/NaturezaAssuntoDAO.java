/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.NaturezaAssunto;
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
public class NaturezaAssuntoDAO implements GenericoDAO<NaturezaAssunto>{
    
    private static final String INSERIR = "insert into natureza_assunto (natureza_assunto) values (?)";
    private static final String ACTUALIZAR = "update natureza_assunto set natureza_assunto = ? where id_natureza_assunto = ?";
    private static final String ELIMINAR = "delete from natureza_assunto where id_natureza_assunto = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from natureza_assunto where id_natureza_assunto = ?";
    private static final String LISTAR_TUDO ="select * from natureza_assunto order by natureza_assunto";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
            
    @Override
    public void save(NaturezaAssunto natureza_assunto) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, natureza_assunto.getNaturezaAssunto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NaturezaAssuntoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void update(NaturezaAssunto natureza_assunto) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, natureza_assunto.getNaturezaAssunto());
            ps.setInt(2, natureza_assunto.getIdNaturezaAssunto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NaturezaAssuntoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void delete(NaturezaAssunto natureza_assunto) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, natureza_assunto.getIdNaturezaAssunto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NaturezaAssuntoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public NaturezaAssunto findById(Integer id_natureza_assunto) {
        NaturezaAssunto natureza_assunto = new NaturezaAssunto();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id_natureza_assunto);
            rs = ps.executeQuery();
            if(rs.next()){
                popularComDados(natureza_assunto, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NaturezaAssuntoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return natureza_assunto;
    }

    @Override
    public List<NaturezaAssunto> findAll() {
        ArrayList<NaturezaAssunto> listaNaturezaAssunto = new ArrayList<>();
        NaturezaAssunto natureza_assunto = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while(rs.next()){
                natureza_assunto = new NaturezaAssunto();
                popularComDados(natureza_assunto, rs);
                listaNaturezaAssunto.add(natureza_assunto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NaturezaAssuntoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return listaNaturezaAssunto;
    }

    @Override
    public void popularComDados(NaturezaAssunto documento, ResultSet rs) {
        try {
            documento.setIdNaturezaAssunto(rs.getInt("id_natureza_assunto"));
            documento.setNaturezaAssunto(rs.getString("natureza_assunto"));
        } catch (SQLException ex) {
            Logger.getLogger(NaturezaAssuntoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
