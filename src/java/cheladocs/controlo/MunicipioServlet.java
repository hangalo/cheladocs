/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.MunicipioDAO;
import cheladocs.modelo.Municipio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author informatica
 */
@WebServlet(name = "municipioServlet", urlPatterns = {"/municipioServlet"})
public class MunicipioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MunicipioDAO municipioDAO = new MunicipioDAO();
        
        String comando = request.getParameter("comando");
        
        if (comando == null) comando = "salvar";
        
        if (comando.equalsIgnoreCase("salvar"))
            salvar(request, response, municipioDAO);
        else if (comando.equalsIgnoreCase("update"))
            update(request, response, municipioDAO);
        else if (comando.equalsIgnoreCase("delete"))
            delete(request, response, municipioDAO);
    }
    
    private void salvar(HttpServletRequest request, HttpServletResponse response, MunicipioDAO municipioDAO) throws IOException{
        Municipio municipio = new Municipio();
        municipio.setNomeMunicipio(request.getParameter("nomeMunicipio"));
        municipio.getProvinciaMunicipio().setIdProvincia(Integer.parseInt(request.getParameter("codigoProvincia")));
        municipioDAO.save(municipio);
        response.sendRedirect("MunicipioInserir.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response, MunicipioDAO municipioDAO) throws IOException{
        Municipio municipio = new Municipio();
        municipio.setNomeMunicipio(request.getParameter("nomeMunicipio"));
        municipio.setIdMunicipio(Integer.parseInt(request.getParameter("codigoMunicipio")));
        municipio.getProvinciaMunicipio().setIdProvincia(Integer.parseInt(request.getParameter("codigoProvincia")));
        municipioDAO.update(municipio);
        response.sendRedirect("MunicipioListar.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response, MunicipioDAO municipioDAO) throws IOException{
        Municipio municipio = new Municipio();
        municipio.getProvinciaMunicipio().setIdProvincia(Integer.parseInt(request.getParameter("codigoProvincia")));
        municipioDAO.delete(municipio);
        response.sendRedirect("MunicipioListar.jsp");
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
