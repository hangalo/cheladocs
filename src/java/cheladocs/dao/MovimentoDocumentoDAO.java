/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.MovimentoDocumento;
import cheladocs.util.Conexao;
import java.sql.Connection;
import java.util.Date;
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
public class MovimentoDocumentoDAO implements GenericoDAO<MovimentoDocumento> {

    private static final String INSERIR = "insert into movimento_documento (data_recepcao,data_reenvio,id_departamento,notas,numero_protocolo) values (?,?,?,?,?)";

    private static final String ACTUALIZAR = "update movimento_documento set data_recepcao = ?, data_reenvio = ?, id_departamento = ?, notas = ?, "
            + "numero_protocolo = ? where id_movimento_progressivo = ?";

    private static final String ELIMINAR = "delete from movimento_documento where id_movimento_progressivo = ?";

    private static final String LISTAR_TUDO = "select id_movimento_progressivo, data_recepcao, data_reenvio, dep.id_departamento, departamento, notas, doc.numero_protocolo,"
            + " descricao_assunto, origem from movimento_documento as MD "
            + " INNER JOIN documento as doc ON MD.numero_protocolo = doc.numero_protocolo "
            + " INNER JOIN departamento as dep ON MD.id_departamento = dep.id_departamento";

    private static final String BUSCAR_POR_CODIGO = LISTAR_TUDO + " where id_movimento_progressivo = ?";

    //private static final String BUSCAR_POR_MOVIMENTO = "SELECT * FROM pais  WHERE pais LIKE ?";
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    private DepartamentoDAO depDAO = new DepartamentoDAO();
    private DocumentoDAO docDAO = new DocumentoDAO();

    @Override
    public void save(MovimentoDocumento mDocumento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setDate(1, mDocumento.getDataRecepcao());
            ps.setDate(2, mDocumento.getDataReenvio());
            ps.setInt(3, mDocumento.getDepartamento().getIdDepartamento());
            ps.setString(4, mDocumento.getNotas());
            ps.setInt(5, mDocumento.getDocumento().getNumeroProtocolo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(MovimentoDocumento mDocumento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setDate(1, new java.sql.Date(mDocumento.getDataRecepcao().getTime()));
            ps.setDate(2, new java.sql.Date(mDocumento.getDataReenvio().getTime()));
            ps.setInt(3, mDocumento.getDepartamento().getIdDepartamento());
            ps.setString(4, mDocumento.getNotas());
            ps.setInt(5, mDocumento.getDocumento().getNumeroProtocolo());
            ps.setInt(6, mDocumento.getIdMovimentoProgressivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(MovimentoDocumento mDocumento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, mDocumento.getIdMovimentoProgressivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public MovimentoDocumento findById(Integer idMovimentoDocumento) {
        MovimentoDocumento mDocumento = new MovimentoDocumento();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idMovimentoDocumento);
            rs = ps.executeQuery();
            if (rs.next()) {
                popularComDados(mDocumento, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return mDocumento;
    }

    @Override
    public List<MovimentoDocumento> findAll() {
        ArrayList<MovimentoDocumento> listaDocumento = new ArrayList<>();
        MovimentoDocumento mDocumento = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                mDocumento = new MovimentoDocumento();
                popularComDados(mDocumento, rs);
                listaDocumento.add(mDocumento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return listaDocumento;
    }

    @Override
    public void popularComDados(MovimentoDocumento mDocumento, ResultSet rs) {
        try {
            mDocumento.setDataRecepcao(rs.getDate("data_recepcao"));
            mDocumento.setDataReenvio(rs.getDate("data_reenvio"));
            mDocumento.getDepartamento().setIdDepartamento(rs.getInt("id_departamento"));
            mDocumento.getDepartamento().setDepartamento(rs.getString("departamento"));
            mDocumento.setIdMovimentoProgressivo(rs.getInt("id_movimento_progressivo"));
            mDocumento.setNotas(rs.getString("notas"));
            mDocumento.getDocumento().setNumeroProtocolo(rs.getInt("numero_protocolo"));
            mDocumento.getDocumento().setDescricaoAssunto(rs.getString("descricao_assunto"));
            mDocumento.getDocumento().setOrigem(rs.getString("origem"));
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    select id_movimento_progressivo, data_recepcao, data_reenvio, dep.id_departamento, departamento, notas, doc.numero_protocolo,
    descricao_assunto, origem, from movimento_documento as MD 
    INNER JOIN documento as doc ON MD.numero_protocolo = doc.numero_protocolo
    INNER JOIN departamento as dep ON MD.id_departamento = dep.id_departamento
     */
    @Override
    public List<MovimentoDocumento> findByName(String s) {
        return null;
    }
}
