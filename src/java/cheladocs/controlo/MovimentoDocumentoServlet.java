/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.MovimentoDocumentoDAO;
import cheladocs.modelo.MovimentoDocumento;
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
public class MovimentoDocumentoServlet extends HttpServlet {

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
        MovimentoDocumentoDAO mDocumentoDAO = new MovimentoDocumentoDAO();
        
        String comando = request.getParameter("comando");
        
        if (comando == null) comando = "salvar";
        
        if (comando.equalsIgnoreCase("salvar"))
            salvar(request, response, mDocumentoDAO);
        else if (comando.equalsIgnoreCase("update"))
            update(request, response, mDocumentoDAO);
        else if (comando.equalsIgnoreCase("delete"))
            delete(request, response, mDocumentoDAO);
    }
    
    private void salvar(HttpServletRequest request, HttpServletResponse response, MovimentoDocumentoDAO mDocumentoDAO) throws IOException{
        MovimentoDocumento mDocumento = new MovimentoDocumento();
        mDocumento.setDataRecepcao(new Date(DateUtil.strToDate(request.getParameter("dataRecepcao")).getTime()));
        mDocumento.setDataReenvio(new Date(DateUtil.strToDate(request.getParameter("dataReenvio")).getTime()));
        mDocumento.getDepartamento().setIdDepartamento(Integer.parseInt(request.getParameter("idDepartamento")));
        mDocumento.setNotas(request.getParameter("notas"));
        mDocumento.getDocumento().setNumeroProtocolo(Integer.parseInt(request.getParameter("documento")));
        mDocumentoDAO.save(mDocumento);
        response.sendRedirect("MovimentoDocumentoInserir.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response, MovimentoDocumentoDAO mDocumentoDAO) throws IOException{
        MovimentoDocumento mDocumento = new MovimentoDocumento();
        mDocumento.setDataRecepcao(new Date(DateUtil.strToDate(request.getParameter("dataRecepcao")).getTime()));
        mDocumento.setDataReenvio(new Date(DateUtil.strToDate(request.getParameter("dataReenvio")).getTime()));
        mDocumento.getDepartamento().setIdDepartamento(Integer.parseInt(request.getParameter("idDepartamento")));
        mDocumento.setNotas(request.getParameter("notas"));
        mDocumento.getDocumento().setNumeroProtocolo(Integer.parseInt(request.getParameter("documento")));
        mDocumento.setIdMovimentoProgressivo(Integer.parseInt(request.getParameter("idMovimentoProgressivo")));
        mDocumentoDAO.save(mDocumento);
        response.sendRedirect("MovimentoDocumentoListar.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response, MovimentoDocumentoDAO mDocumentoDAO) throws IOException{
        MovimentoDocumento mDocumento = new MovimentoDocumento();
        mDocumento.setIdMovimentoProgressivo(Integer.parseInt(request.getParameter("idMovimentoProgressivo")));
        mDocumentoDAO.delete(mDocumento);
        response.sendRedirect("MovimentoDocumentoListar.jsp");
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
