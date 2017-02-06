/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.NaturezaAssuntoDAO;
import cheladocs.modelo.NaturezaAssunto;
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
public class NaturezaAssuntoServlet extends HttpServlet {

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
        NaturezaAssuntoDAO naturezaAssuntoDAO = new NaturezaAssuntoDAO();
        
        String comando = request.getParameter("comando");
        
        if (comando == null) comando = "salvar";
        
        if (comando.equalsIgnoreCase("salvar"))
            salvar(request, response, naturezaAssuntoDAO);
        else if (comando.equalsIgnoreCase("update"))
            update(request, response, naturezaAssuntoDAO);
        else if (comando.equalsIgnoreCase("delete"))
            delete(request, response, naturezaAssuntoDAO);
    }
    
    private void salvar(HttpServletRequest request, HttpServletResponse response, NaturezaAssuntoDAO naturezaAssuntoDAO) throws IOException{
        NaturezaAssunto departamento = new NaturezaAssunto();
        departamento.setNaturezaAssunto(request.getParameter("nomeNaturezaAssunto"));
        naturezaAssuntoDAO.save(departamento);
        response.sendRedirect("NaturezaAssuntoInserir.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response, NaturezaAssuntoDAO naturezaAssuntoDAO) throws IOException{
        NaturezaAssunto departamento = new NaturezaAssunto();
        departamento.setNaturezaAssunto(request.getParameter("nomeNaturezaAssunto"));
        departamento.setIdNaturezaAssunto(Integer.parseInt(request.getParameter("codigoNaturezaAssunto")));
        naturezaAssuntoDAO.update(departamento);
        response.sendRedirect("NaturezaAssuntoListar.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response, NaturezaAssuntoDAO naturezaAssuntoDAO) throws IOException{
        NaturezaAssunto departamento = new NaturezaAssunto();
        departamento.setIdNaturezaAssunto(Integer.parseInt(request.getParameter("codigoNaturezaAssunto")));
        naturezaAssuntoDAO.delete(departamento);
        response.sendRedirect("NaturezaAssuntoListar.jsp");
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
