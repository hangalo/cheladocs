/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Provincia;
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
public class ProvinciaDAO implements GenericoDAO<Provincia>{
    private static final String INSERIR = "insert into provincia (provincia, id_pais) values (?,?)";
    private static final String ACTUALIZAR = "update provincia set provincia = ?, id_pais = ? where id_provincia = ?";
    private static final String ELIMINAR = "delete from provincia where id_provincia = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from provincia where id_provincia = ?";
    private static final String BUSCAR_POR_CODIGO_PAIS = "select * from provincia where id_pais = ?";
    private static final String LISTAR_TUDO ="select * from provincia order by provincia";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    @Override
    public void save(Provincia provincia) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, provincia.getNomeProvincia());
            ps.setInt(2, provincia.getPaisProvincia().getIdPais());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void update(Provincia provincia) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, provincia.getNomeProvincia());
            ps.setInt(2, provincia.getPaisProvincia().getIdPais());
            ps.setInt(3, provincia.getIdProvincia());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void delete(Provincia provincia) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, provincia.getIdProvincia());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public Provincia findById(Integer idProvincia) {
        Provincia provincia = null;
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idProvincia);
            rs = ps.executeQuery();
            if(rs.next()){
                provincia = new Provincia();
                popularComDados(provincia, rs);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return provincia;
    }

    @Override
    public List<Provincia> findAll() {
        Provincia provincia = null;
        ArrayList<Provincia> listaProvincia = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            if(rs.next()){
                provincia = new Provincia();
                popularComDados(provincia, rs);
                listaProvincia.add(provincia);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaProvincia;
    }
    
    public List<Provincia> findProvinciaPais(int idPais) {
        Provincia provincia = null;
        ArrayList<Provincia> listaProvinciaPais = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO_PAIS);
            ps.setInt(1, idPais);
            rs = ps.executeQuery();
            while(rs.next()){
                provincia = new Provincia();
                popularComDados(provincia, rs);
                listaProvinciaPais.add(provincia);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaProvinciaPais;
    }

    @Override
    public void popularComDados(Provincia provincia, ResultSet rs) {
        try {
            PaisDAO paisDAO = new PaisDAO();
            provincia.setIdProvincia(rs.getInt("id_provincia"));
            provincia.setNomeProvincia(rs.getString("provincia"));
            provincia.setPaisProvincia(paisDAO.findById(rs.getInt("id_pais")));
        } catch (SQLException ex) {
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
