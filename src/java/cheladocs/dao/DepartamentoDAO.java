/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Departamento;
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
public class DepartamentoDAO implements GenericoDAO<Departamento>{
    
    private static final String INSERIR = "insert into departamento (departamento) values (?)";
    private static final String ACTUALIZAR = "update departamento set departamento = ? where id_departamento = ?";
    private static final String ELIMINAR = "delete from departamento where id_departamento = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from departamento where id_departamento = ?";
    private static final String LISTAR_TUDO ="select * from departamento order by departamento";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
            
    @Override
    public void save(Departamento departamento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, departamento.getDepartamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void update(Departamento departamento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, departamento.getDepartamento());
            ps.setInt(2, departamento.getIdDepartamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void delete(Departamento departamento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, departamento.getIdDepartamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public Departamento findById(Integer id_departamento) {
        Departamento departamento = new Departamento();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id_departamento);
            rs = ps.executeQuery();
            if(rs.next()){
                popularComDados(departamento, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return departamento;
    }

    @Override
    public List<Departamento> findAll() {
        ArrayList<Departamento> listaDepartamento = new ArrayList<>();
        Departamento departamento = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while(rs.next()){
                departamento = new Departamento();
                popularComDados(departamento, rs);
                listaDepartamento.add(departamento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return listaDepartamento;
    }

    @Override
    public void popularComDados(Departamento documento, ResultSet rs) {
        try {
            documento.setIdDepartamento(rs.getInt("id_departamento"));
            documento.setDepartamento(rs.getString("departamento"));
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
