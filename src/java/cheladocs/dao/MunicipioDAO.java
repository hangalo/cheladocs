/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Municipio;
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
 * @author informatica
 */
public class MunicipioDAO implements GenericoDAO<Municipio>{
    private static final String INSERIR = "insert into municipio (municipio, id_provincia) values (?,?)";
    private static final String ACTUALIZAR = "update municipio set municipio = ?, id_provincia = ? where id_municipio = ?";
    private static final String ELIMINAR = "delete from municipio where id_municipio = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from municipio where id_municipio = ?";
    private static final String BUSCAR_POR_CODIGO_PROVINCIA = "select * from municipio where id_provincia = ?";
    private static final String LISTAR_TUDO ="select * from municipio order by municipio";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
    
    @Override
    public void save(Municipio municipio) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvinciaMunicipio().getIdProvincia());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void update(Municipio municipio) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvinciaMunicipio().getIdProvincia());
            ps.setInt(3, municipio.getIdMunicipio());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public void delete(Municipio municipio) {
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, municipio.getIdMunicipio());
            ps.execute();        
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps);}
    }

    @Override
    public Municipio findById(Integer idMunicipio) {
        Municipio municipio = null;
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idMunicipio);
            rs = ps.executeQuery();
            if (rs.next()){
                municipio = new Municipio();
                popularComDados(municipio, rs);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return municipio;
    }

    @Override
    public List<Municipio> findAll() {
        Municipio municipio = null;
        ArrayList<Municipio> listaMunicipio = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()){
                municipio = new Municipio();
                popularComDados(municipio, rs);
                listaMunicipio.add(municipio);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaMunicipio;
    }
    
    public List<Municipio> findMunicipioProvincia(int idProvincia) {
        Municipio municipio = null;
        ArrayList<Municipio> listaMunicipioProvincia = new ArrayList<>();
        try{
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO_PROVINCIA);
            ps.setInt(1, idProvincia);
            rs = ps.executeQuery();
            while (rs.next()){
                municipio = new Municipio();
                popularComDados(municipio, rs);
                listaMunicipioProvincia.add(municipio);
            }
        }
        catch(SQLException ex){ System.err.print(ex.getMessage()); }
        finally{ Conexao.closeConnection(conn, ps, rs);}
        return listaMunicipioProvincia;
    }

    @Override
    public void popularComDados(Municipio municipio, ResultSet rs) {
        try {
            ProvinciaDAO provDAO = new ProvinciaDAO();
            municipio.setIdMunicipio(rs.getInt("id_municipio"));
            municipio.setNomeMunicipio(rs.getString("municipio"));
            municipio.setProvinciaMunicipio(provDAO.findById(rs.getInt("id_provincia")));
        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
