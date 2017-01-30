/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Requerente;
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
public class RequerenteDAO implements GenericoDAO<Requerente> {
    
    private static final String INSERIR = "insert into requerente (categoria_juridica,nome_requerente,sobrenome_requerente,telefone_principal,"
                                        + "telefone_alternativo_requerente,email_principal_requerente,email_alternativo_requerente,home_page_requerente) "
                                        + "values (?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "update requerente set categoria_juridica = ?,nome_requerente = ?,sobrenome_requerente = ?,telefone_principal = ?,"
                                           + "telefone_alternativo_requerente = ?,email_principal_requerente = ?,email_alternativo_requerente = ?,home_page_requerente = ?";
    private static final String ELIMINAR = "delete from requerente where id_requerente = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from requerente where id_requerente = ?";
    private static final String LISTAR_TUDO = "select * from requerente";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    @Override
    public void save(Requerente requerente) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, requerente.getCategoriaJuridica());
            ps.setString(2, requerente.getNomeRequerente());
            ps.setString(3, requerente.getSobrenomeRequerente());
            ps.setString(4, requerente.getTelefonePrincipal());
            ps.setString(5, requerente.getTelefoneAlternativo());
            ps.setString(6, requerente.getEmailPrincipal());
            ps.setString(7, requerente.getEmailAlternativo());
            ps.setString(8, requerente.getHomePage());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void update(Requerente requerente) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, requerente.getCategoriaJuridica());
            ps.setString(2, requerente.getNomeRequerente());
            ps.setString(3, requerente.getSobrenomeRequerente());
            ps.setString(4, requerente.getTelefonePrincipal());
            ps.setString(5, requerente.getTelefoneAlternativo());
            ps.setString(6, requerente.getEmailPrincipal());
            ps.setString(7, requerente.getEmailAlternativo());
            ps.setString(8, requerente.getHomePage());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void delete(Requerente requerente) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, requerente.getIdRequerente());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public Requerente findById(Integer idRequerente) {
        Requerente requerente = new Requerente();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idRequerente);
            rs = ps.executeQuery();
            if(rs.next()){
                popularComDados(requerente, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return requerente;
    }

    @Override
    public List<Requerente> findAll() {
        ArrayList<Requerente> listaRequerente = new ArrayList<>();
        Requerente requerente = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while(rs.next()){
                requerente = new Requerente();
                popularComDados(requerente, rs);
                listaRequerente.add(requerente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return listaRequerente;
    }

    @Override
    public void popularComDados(Requerente r, ResultSet rs) {
        try {
            r.setIdRequerente(rs.getInt("id_requerente"));
            r.setCategoriaJuridica(rs.getString("categoria_juridica"));
            r.setEmailAlternativo(rs.getString("email_alternativo_requerente"));
            r.setEmailPrincipal(rs.getString("email_principal_requerente"));
            r.setHomePage(rs.getString("home_page_requerente"));
            r.setNomeRequerente(rs.getString("nome_requerente"));
            r.setSobrenomeRequerente(rs.getString("sobrenome_requerente"));
            r.setTelefoneAlternativo(rs.getString("telefone_alternativo_requerente"));
            r.setTelefonePrincipal(rs.getString("telefone_principal"));
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
