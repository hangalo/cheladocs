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
import javax.servlet.RequestDispatcher;
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
        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }

        MovimentoDocumentoDAO mDocumentoDAO;
        MovimentoDocumento mDocumento = new MovimentoDocumento();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            try {
                String idMovimentoDocumento = request.getParameter("id_mDocumento");
                if (idMovimentoDocumento != null) {
                    mDocumento.setIdMovimentoProgressivo(Integer.parseInt(idMovimentoDocumento));
                }

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            mDocumentoDAO = new MovimentoDocumentoDAO();

            if (comando.equalsIgnoreCase("guardar") || comando.equalsIgnoreCase("editar")) {
                mDocumento.setDataRecepcao(new Date(DateUtil.strToDate(request.getParameter("dataRecepcao")).getTime()));
                mDocumento.setDataReenvio(new Date(DateUtil.strToDate(request.getParameter("dataReenvio")).getTime()));
                mDocumento.getDepartamento().setIdDepartamento(Integer.parseInt(request.getParameter("idDepartamento")));
                mDocumento.setNotas(request.getParameter("notas"));
                mDocumento.getDocumento().setNumeroProtocolo(Integer.parseInt(request.getParameter("documento")));
                if (comando.equalsIgnoreCase("guardar"))
                    mDocumentoDAO.save(mDocumento);
                else
                    mDocumentoDAO.update(mDocumento);
                response.sendRedirect("paginas/movimentoDocumento_listar.jsp");
                
            } else if (comando.equalsIgnoreCase("eliminar")) {
                mDocumentoDAO.delete(mDocumento);
                response.sendRedirect("paginas/movimentoDocumento_listar.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                mDocumento = mDocumentoDAO.findById(mDocumento.getIdMovimentoProgressivo());
                request.setAttribute("mDocumento", mDocumento);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/movimentoDocumento_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/movimentoDocumento_listar.jsp");
            } else if (comando.equalsIgnoreCase("principla")) {
                response.sendRedirect("/index.jsp");
            }

        } catch (IOException | ServletException ex) {
            System.err.println("Erro na leitura dos dados: " + ex.getMessage());
        }
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
