/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.dao;

import cheladocs.modelo.Documento;
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
public class DocumentoDAO implements GenericoDAO<Documento>{
    private static final String INSERIR = "insert into documento (id_requerente,data_entrada,origem,descricao_assunto,id_natureza_assunto,"
                                        + "id_tipo_expediente,url_ficheiro_documento,conteudo_documento) values (?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "update documento set id_requerente = ?,data_entrada = ?,origem = ?,descricao_assunto = ?,"
                                           + "id_natureza_assunto = ?,id_tipo_expediente = ?,url_ficheiro_documento = ?,conteudo_documento = ? "
                                           + "where numero_protocolo = ?";
    private static final String ELIMINAR = "delete from documento where numero_protocolo = ?";
    private static final String BUSCAR_POR_CODIGO = "select * from documento where numero_protocolo = ?";
    private static final String LISTAR_TUDO = "select * from documento";

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private RequerenteDAO reqDAO = new RequerenteDAO();
    private NaturezaAssuntoDAO natAssuntoDAO = new NaturezaAssuntoDAO();
    private TipoExpedienteDAO tipoExpedienteDAO = new TipoExpedienteDAO();

    @Override
    public void save(Documento documento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, documento.getRequerente().getIdRequerente());
            ps.setDate(2, documento.getDataEntrada());
            ps.setString(3, documento.getOrigem());
            ps.setString(4, documento.getDescricaoAssunto());
            ps.setInt(5, documento.getNaturezaAssunto().getIdNaturezaAssunto());
            ps.setInt(6, documento.getTipoExpediente().getIdTipoExpediente());
            ps.setString(7, documento.getUrlFicheiroDocumento());
            ps.setString(8, documento.getConteudoDocumento());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void update(Documento documento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setInt(1, documento.getRequerente().getIdRequerente());
            ps.setDate(2, documento.getDataEntrada());
            ps.setString(3, documento.getOrigem());
            ps.setString(4, documento.getDescricaoAssunto());
            ps.setInt(5, documento.getNaturezaAssunto().getIdNaturezaAssunto());
            ps.setInt(6, documento.getTipoExpediente().getIdTipoExpediente());
            ps.setString(7, documento.getUrlFicheiroDocumento());
            ps.setString(8, documento.getConteudoDocumento());
            ps.setInt(9, documento.getNumeroProtocolo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public void delete(Documento documento) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, documento.getNumeroProtocolo());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps); }
    }

    @Override
    public Documento findById(Integer idDocumento) {
        Documento documento = new Documento();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idDocumento);
            rs = ps.executeQuery();
            if(rs.next()){
                popularComDados(documento, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return documento;
    }

    @Override
    public List<Documento> findAll() {
        Documento documento = null;
        ArrayList<Documento> listaDocumento = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while(rs.next()){
                documento = new Documento();
                popularComDados(documento, rs);
                listaDocumento.add(documento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ Conexao.closeConnection(conn, ps, rs); }
        return listaDocumento;
    }

    @Override
    public void popularComDados(Documento doc, ResultSet rs) {
        try {
            doc.setConteudoDocumento(rs.getString("conteudo_documento"));
            doc.setDataEntrada(rs.getDate("data_entrada"));
            doc.setDescricaoAssunto(rs.getString("descricao_assunto"));
            doc.setNaturezaAssunto(natAssuntoDAO.findById(rs.getInt("id_natureza_assunto")));
            doc.setNumeroProtocolo(rs.getInt("numero_protocolo"));
            doc.setOrigem(rs.getString("origem"));
            doc.setRequerente(reqDAO.findById(rs.getInt("id_requerente")));
            doc.setTipoExpediente(tipoExpedienteDAO.findById(rs.getInt("id_tipo_expediente")));
            doc.setUrlFicheiroDocumento(rs.getString("url_ficheiro_documento"));
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
