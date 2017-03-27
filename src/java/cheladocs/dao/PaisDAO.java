/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Pais;
import cheladocs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adelino Eduardo
 */
public class PaisDAO implements GenericoDAO<Pais>{
    private static final String INSERIR = "insert into pais (pais) values (?)";
    private static final String ACTUALIZAR = "update pais set pais = ? where id_pais = ?";
    private static final String ELIMINAR = "delete from pais where id_pais = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from pais where id_pais = ?";
    private static final String BUSCAR_POR_NOME = "SELECT * FROM pais WHERE pais LIKE ?";
    private static final String LISTAR_TUDO ="select * from pais ";
    
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    @Override
    public void save(Pais pais) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, pais.getNomePais());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void update(Pais pais) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, pais.getNomePais());
            ps.setInt(2, pais.getIdPais());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void delete(Pais pais) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, pais.getIdPais());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public Pais findById(Integer idPais) {
        Pais pais = null;
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idPais);
            rs = ps.executeQuery();
            if(rs.next()){
                pais = new Pais();
                popularComDados(pais, rs);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return pais;
    }

    @Override
    public List<Pais> findAll() {
        Pais pais = null;
        ArrayList<Pais> listaPais = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while(rs.next()){
                pais = new Pais();
                popularComDados(pais, rs);
                listaPais.add(pais);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaPais;
    }

    @Override
    public void popularComDados(Pais pais, ResultSet rs) {
        try{
            pais.setIdPais(rs.getInt("id_pais"));
            pais.setNomePais(rs.getString("nome_pais"));
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
    }

    @Override
    public List<Pais> findByName(String nomePais) {
        Pais pais = null;
        ArrayList<Pais> listaPais = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_NOME);
            ps.setString(1, nomePais + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                pais = new Pais();
                popularComDados(pais, rs);
                listaPais.add(pais);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaPais;
    }
    
    public ArrayList<String> findByPais(String nomePais) {
        Pais pais = null;
        ArrayList<String> listaPais = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_NOME);
            ps.setString(1, nomePais + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                pais = new Pais();
                popularComDados(pais, rs);
                listaPais.add(pais.getNomePais());
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaPais;
    }
    
}
