/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.MovimentoDocumentoDAO;
import cheladocs.modelo.MovimentoDocumento;
import cheladocs.util.DateUtil;
import cheladocs.util.ReporteUtil;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
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

        if (!comando.equalsIgnoreCase("principal")) {
            try {
                String idMovimentoDocumento = request.getParameter("id_movimento_progressivo");
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
                mDocumento.setDataRecepcao(Date.valueOf(request.getParameter("data_recepcao").trim()));
                //mDocumento.setDataRecepcao( DateUtil.strToDate(request.getParameter("")));
                mDocumento.setDataReenvio(Date.valueOf(request.getParameter("data_reenvio").trim()));
                mDocumento.getDocumento().setNumeroProtocolo(Integer.parseInt(request.getParameter("documento")));
                mDocumento.getDepartamento().setIdDepartamento(Integer.parseInt(request.getParameter("departamento")));
                mDocumento.setNotas(request.getParameter("notas"));

                if (mDocumento.getDataReenvio().after(mDocumento.getDataRecepcao())) {
                    if (comando.equalsIgnoreCase("guardar")) {
                        mDocumentoDAO.save(mDocumento);
                    } else {
                        mDocumentoDAO.update(mDocumento);
                    }
                    response.sendRedirect("paginas/gerir_movimento_documento.jsp");
                } else {
                    request.setAttribute("erro", "ERRO! A data de reenvio tem que ser maior ou igual que a de recepção");
                }

            } else if (comando.equalsIgnoreCase("eliminar")) {
                mDocumentoDAO.delete(mDocumento);
                response.sendRedirect("paginas/gerir_movimento_documento.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                mDocumento = mDocumentoDAO.findById(mDocumento.getIdMovimentoProgressivo());
                request.setAttribute("mDocumento", mDocumento);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/movimento_documento_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/gerir_movimento_documento.jsp");
            } else if (comando.equalsIgnoreCase("imprimir_todos") || comando.equalsIgnoreCase("imprimir_by_id")) {
                ReporteUtil reporte = new ReporteUtil();
                File caminhoRelatorio = null;
                HashMap hashMap = new HashMap();
                
                if (comando.equalsIgnoreCase("imprimir_todos")){
                    caminhoRelatorio = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/relatorios/ExpedienteListar.jasper"));
                    reporte.geraRelatorio(caminhoRelatorio.getPath(), hashMap, response);
                }
                else{
                    hashMap.put("id_movimento_progressivo", mDocumento.getIdMovimentoProgressivo());
                    caminhoRelatorio = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/relatorios/Ficha_Expediente.jasper"));
                    reporte.geraRelatorio(caminhoRelatorio.getPath(), hashMap, response);
                }
            }

        } catch (NumberFormatException | ServletException ex) {
            //System.err.println("Erro na leitura dos dados: " + ex.getMessage());
            ex.printStackTrace();
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
