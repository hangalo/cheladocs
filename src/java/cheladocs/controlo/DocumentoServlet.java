/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.DocumentoDAO;
import cheladocs.modelo.Documento;
import cheladocs.util.DateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adelino Eduardo
 */
public class DocumentoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DocumentoDAO documentoDAO = new DocumentoDAO();
        
        String comando = request.getParameter("comando");
        
        if (comando == null) comando = "salvar";
        
        if (comando.equalsIgnoreCase("salvar"))
            salvar(request, response, documentoDAO);
        else if (comando.equalsIgnoreCase("update"))
            update(request, response, documentoDAO);
        else if (comando.equalsIgnoreCase("delete"))
            delete(request, response, documentoDAO);
    }
    
    private void salvar(HttpServletRequest request, HttpServletResponse response, DocumentoDAO documentoDAO) throws IOException{
        Documento documento = new Documento();
        documento.getRequerente().setIdRequerente(Integer.parseInt(request.getParameter("idRequerente")));
        documento.setDataEntrada(new Date(DateUtil.strToDate(request.getParameter("dataEntrada")).getTime()));
        documento.setOrigem(request.getParameter("origemDocumento"));
        documento.setDescricaoAssunto(request.getParameter("descricaoAssunto"));
        documento.getNaturezaAssunto().setIdNaturezaAssunto(Integer.parseInt(request.getParameter("idNaturezaAssunto")));
        documento.getTipoExpediente().setIdTipoExpediente(Integer.parseInt(request.getParameter("tipoExpediente")));
        documento.setUrlFicheiroDocumento(request.getParameter("urlFicheiroDocumento"));
        documento.setConteudoDocumento(request.getParameter("conteudoDocumento"));        
        documentoDAO.save(documento);
        response.sendRedirect("DocumentoInserir.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response, DocumentoDAO documentoDAO) throws IOException{
        Documento documento = new Documento();
        documento.setNumeroProtocolo(Integer.parseInt(request.getParameter("numeroProtocolo")));
        documento.getRequerente().setIdRequerente(Integer.parseInt(request.getParameter("idRequerente")));
        documento.setDataEntrada(new Date(DateUtil.strToDate(request.getParameter("dataEntrada")).getTime()));
        documento.setOrigem(request.getParameter("origemDocumento"));
        documento.setDescricaoAssunto(request.getParameter("descricaoAssunto"));
        documento.getNaturezaAssunto().setIdNaturezaAssunto(Integer.parseInt(request.getParameter("idNaturezaAssunto")));
        documento.getTipoExpediente().setIdTipoExpediente(Integer.parseInt(request.getParameter("tipoExpediente")));
        documento.setUrlFicheiroDocumento(request.getParameter("urlFicheiroDocumento"));
        documento.setConteudoDocumento(request.getParameter("conteudoDocumento"));        
        documentoDAO.save(documento);
        response.sendRedirect("DocumentoListar.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response, DocumentoDAO documentoDAO) throws IOException{
        Documento documento = new Documento();
        documento.setNumeroProtocolo(Integer.parseInt(request.getParameter("numeroProtocolo")));
        documentoDAO.delete(documento);
        response.sendRedirect("DocumentoListar.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
