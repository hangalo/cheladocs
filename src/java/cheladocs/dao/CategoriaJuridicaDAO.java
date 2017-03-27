/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.CategoriaJuridica;
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
public class CategoriaJuridicaDAO implements GenericoDAO<CategoriaJuridica>{
    private static final String INSERIR = "insert into categoria_juridica (categoria_juridica) values (?)";
    private static final String ACTUALIZAR = "update categoria_juridica set categoria_juridica = ? where id_categoria_juridica = ?";
    private static final String ELIMINAR = "delete from categoria_juridica where id_categoria_juridica = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from categoria_juridica where id_categoria_juridica = ?";
    private static final String BUSCAR_POR_CATEGORIA_JURIDICA = "SELECT * FROM categoria_juridica WHERE categoria_juridica LIKE ?";
    private static final String LISTAR_TUDO ="select * from categoria_juridica order by categoria_juridica";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
            
    @Override
    public void save(CategoriaJuridica categoria_juridica) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, categoria_juridica.getCategoriaJuridica());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaJuridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void update(CategoriaJuridica categoria_juridica) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, categoria_juridica.getCategoriaJuridica());
            ps.setInt(2, categoria_juridica.getIdCategoriaJuridica());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaJuridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void delete(CategoriaJuridica categoria_juridica) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, categoria_juridica.getIdCategoriaJuridica());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaJuridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public CategoriaJuridica findById(Integer id_categoria_juridica) {
        CategoriaJuridica categoria_juridica = new CategoriaJuridica();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id_categoria_juridica);
            rs = ps.executeQuery();
            if(rs.next()){
                popularComDados(categoria_juridica, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaJuridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return categoria_juridica;
    }

    @Override
    public List<CategoriaJuridica> findAll() {
        ArrayList<CategoriaJuridica> listaCategoriaJuridica = new ArrayList<>();
        CategoriaJuridica categoria_juridica = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while(rs.next()){
                categoria_juridica = new CategoriaJuridica();
                popularComDados(categoria_juridica, rs);
                listaCategoriaJuridica.add(categoria_juridica);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaJuridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return listaCategoriaJuridica;
    }

    @Override
    public void popularComDados(CategoriaJuridica categoria_juridica, ResultSet rs) {
        try {
            categoria_juridica.setIdCategoriaJuridica(rs.getInt("id_categoria_juridica"));
            categoria_juridica.setCategoriaJuridica(rs.getString("categoria_juridica"));
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaJuridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<CategoriaJuridica> findByName(String nomeCategoriaJuridica) {
        CategoriaJuridica categoria_juridica = null;
        ArrayList<CategoriaJuridica> listaCategoriaJuridica = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CATEGORIA_JURIDICA);
            ps.setString(1, nomeCategoriaJuridica + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                categoria_juridica = new CategoriaJuridica();
                popularComDados(categoria_juridica, rs);
                listaCategoriaJuridica.add(categoria_juridica);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaCategoriaJuridica;
    }
}
