/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.ProvinciaDAO;
import cheladocs.modelo.Provincia;
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
public class ProvinciaServlet extends HttpServlet {

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
        ProvinciaDAO provDAO = new ProvinciaDAO();
        
        String comando = request.getParameter("comando");
        
        if (comando == null) comando = "salvar";
        
        if (comando.equalsIgnoreCase("salvar"))
            salvar(request, response, provDAO);
        else if (comando.equalsIgnoreCase("update"))
            update(request, response, provDAO);
        else if (comando.equalsIgnoreCase("delete"))
            delete(request, response, provDAO);
    }
    
    private void salvar(HttpServletRequest request, HttpServletResponse response, ProvinciaDAO provDAO) throws IOException{
        Provincia provincia = new Provincia();
        provincia.setNomeProvincia(request.getParameter("nomeProvincia"));
        provincia.getPaisProvincia().setIdPais(Integer.parseInt(request.getParameter("codigoPais")));
        provDAO.save(provincia);
        response.sendRedirect("ProvinciaInserir.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response, ProvinciaDAO provDAO) throws IOException{
        Provincia provincia = new Provincia();
        provincia.setNomeProvincia(request.getParameter("nomeProvincia"));
        provincia.setIdProvincia(Integer.parseInt(request.getParameter("codigoProvincia")));
        provincia.getPaisProvincia().setIdPais(Integer.parseInt(request.getParameter("codigoPais")));
        provDAO.update(provincia);
        response.sendRedirect("ProvinciaListar.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response, ProvinciaDAO provDAO) throws IOException{
        Provincia provincia = new Provincia();
        provincia.setIdProvincia(Integer.parseInt(request.getParameter("codigoProvincia")));
        provDAO.delete(provincia);
        response.sendRedirect("ProvinciaListar.jsp");
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
