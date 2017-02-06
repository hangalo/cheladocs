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
        TipoExpedienteDAO tipoExpedienteDAO = new TipoExpedienteDAO();
        
        String comando = request.getParameter("comando");
        
        if (comando == null) comando = "salvar";
        
        if (comando.equalsIgnoreCase("salvar"))
            salvar(request, response, tipoExpedienteDAO);
        else if (comando.equalsIgnoreCase("update"))
            update(request, response, tipoExpedienteDAO);
        else if (comando.equalsIgnoreCase("delete"))
            delete(request, response, tipoExpedienteDAO);
    }
    
    private void salvar(HttpServletRequest request, HttpServletResponse response, TipoExpedienteDAO tipoExpedienteDAO) throws IOException{
        TipoExpediente departamento = new TipoExpediente();
        departamento.setTipoExpediente(request.getParameter("tipoExpediente"));
        tipoExpedienteDAO.save(departamento);
        response.sendRedirect("TipoExpedienteInserir.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response, TipoExpedienteDAO tipoExpedienteDAO) throws IOException{
        TipoExpediente departamento = new TipoExpediente();
        departamento.setTipoExpediente(request.getParameter("tipoExpediente"));
        departamento.setIdTipoExpediente(Integer.parseInt(request.getParameter("codigoTipoExpediente")));
        tipoExpedienteDAO.update(departamento);
        response.sendRedirect("TipoExpedienteListar.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response, TipoExpedienteDAO tipoExpedienteDAO) throws IOException{
        TipoExpediente departamento = new TipoExpediente();
        departamento.setIdTipoExpediente(Integer.parseInt(request.getParameter("codigoTipoExpediente")));
        tipoExpedienteDAO.delete(departamento);
        response.sendRedirect("TipoExpedienteListar.jsp");
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
