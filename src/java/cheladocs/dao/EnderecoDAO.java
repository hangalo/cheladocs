/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Endereco;
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
public class EnderecoDAO implements GenericoDAO<Endereco>{
    private static final String INSERIR = "insert into endereco (caixa_postal,rua_endereco,casa_endereco,bairro_endereco,cidade_endereco,"
                                        + "id_requerente,flag_activo,id_municipio) "
                                        + "values (?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "update endereco set caixa_postal = ?,rua_endereco = ?,casa_endereco = ?,bairro_endereco = ?,"
                                           + "cidade_endereco = ?,id_requerente = ?,flag_activo = ?,id_municipio = ? where id_endereco = ?";
    private static final String ELIMINAR = "delete from endereco where id_endereco = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from endereco where id_endereco = ?";
    private static final String LISTAR_TUDO = "select * from endereco";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private MunicipioDAO muniDAO = new MunicipioDAO();
    private RequerenteDAO requerenteDAO = new RequerenteDAO();

    @Override
    public void save(Endereco endereco) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, endereco.getCaixaPostal());
            ps.setString(2, endereco.getRuaEndereco());
            ps.setString(3, endereco.getCasaEndereco());
            ps.setString(4, endereco.getBairroEndereco());
            ps.setString(5, endereco.getCidadeEndereco());
            ps.setInt(6, endereco.getRequerente().getIdRequerente());
            ps.setInt(7, endereco.getFlagActivo());
            ps.setInt(8, endereco.getMunicipio().getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void update(Endereco endereco) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, endereco.getCaixaPostal());
            ps.setString(2, endereco.getRuaEndereco());
            ps.setString(3, endereco.getCasaEndereco());
            ps.setString(4, endereco.getBairroEndereco());
            ps.setString(5, endereco.getCidadeEndereco());
            ps.setInt(6, endereco.getRequerente().getIdRequerente());
            ps.setInt(7, endereco.getFlagActivo());
            ps.setInt(8, endereco.getMunicipio().getIdMunicipio());
            ps.setInt(9, endereco.getIdEndereco());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void delete(Endereco endereco) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, endereco.getIdEndereco());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public Endereco findById(Integer idEndereco) {
        Endereco endereco =  new Endereco();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idEndereco);
            rs = ps.executeQuery();
            if(rs.next()){
                popularComDados(endereco,rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
        return endereco;
    }

    @Override
    public List<Endereco> findAll() {
        ArrayList<Endereco> listaEndereco = new ArrayList<>();
        Endereco endereco =  null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            if(rs.next()){
                endereco =  new Endereco();
                popularComDados(endereco,rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
        return listaEndereco;
    }

    @Override
    public void popularComDados(Endereco endereco, ResultSet rs) {
        try {
            endereco.setBairroEndereco(rs.getString("bairro_endereco"));
            endereco.setCaixaPostal(rs.getString("caixa_postal"));
            endereco.setCasaEndereco(rs.getString("casa_endereco"));
            endereco.setCidadeEndereco(rs.getString("cidade_endereco"));
            endereco.setFlagActivo(rs.getInt("flag_activo"));
            endereco.setIdEndereco(rs.getInt("id_endereco"));
            endereco.setMunicipio(muniDAO.findById(rs.getInt("id_municipio")));
            endereco.setRequerente(requerenteDAO.findById(rs.getInt("id_requerente")));
            endereco.setRuaEndereco(rs.getString("rua_endereco"));
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
