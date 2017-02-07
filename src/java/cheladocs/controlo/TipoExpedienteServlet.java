/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.TipoExpedienteDAO;
import cheladocs.modelo.TipoExpediente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adelino Eduardo
 */
public class TipoExpedienteServlet extends HttpServlet {

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

        TipoExpedienteDAO tipoExpedienteDAO;
        TipoExpediente tipoExpediente = new TipoExpediente();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            try {
                String idTipoExpediente = request.getParameter("id_tipoExpediente");
                if (idTipoExpediente != null) {
                    tipoExpediente.setIdTipoExpediente(Integer.parseInt(idTipoExpediente));
                }

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            tipoExpedienteDAO = new TipoExpedienteDAO();

            if (comando.equalsIgnoreCase("guardar") || comando.equalsIgnoreCase("editar")) {
                tipoExpediente.setTipoExpediente(request.getParameter("tipo_expediente"));
                
                if (comando.equalsIgnoreCase("guardar"))
                    tipoExpedienteDAO.save(tipoExpediente);
                else
                    tipoExpedienteDAO.update(tipoExpediente);
                response.sendRedirect("paginas/tipoExpediente_listar.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                tipoExpedienteDAO.delete(tipoExpediente);
                response.sendRedirect("paginas/tipoExpediente_listar.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                tipoExpediente = tipoExpedienteDAO.findById(tipoExpediente.getIdTipoExpediente());
                request.setAttribute("tipoExpediente", tipoExpediente);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/tipoExpediente_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/tipoExpediente_listar.jsp");
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
