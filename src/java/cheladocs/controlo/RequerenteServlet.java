/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.RequerenteDAO;
import cheladocs.modelo.Requerente;
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
public class RequerenteServlet extends HttpServlet {

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
        RequerenteDAO requerenteDAO = new RequerenteDAO();
        
        String comando = request.getParameter("comando");
        
        if (comando == null) comando = "salvar";
        
        if (comando.equalsIgnoreCase("salvar"))
            salvar(request, response, requerenteDAO);
        else if (comando.equalsIgnoreCase("update"))
            update(request, response, requerenteDAO);
        else if (comando.equalsIgnoreCase("delete"))
            delete(request, response, requerenteDAO);
    }
    
    private void salvar(HttpServletRequest request, HttpServletResponse response, RequerenteDAO requerenteDAO) throws IOException{
        Requerente requerente = new Requerente();
        requerente.setCategoriaJuridica(request.getParameter("categoriaJuridica"));
        requerente.setNomeRequerente(request.getParameter("nomeRequerente"));
        requerente.setSobrenomeRequerente(request.getParameter("sobrenomeRequerente"));
        requerente.setTelefonePrincipal(request.getParameter("telefonePrincipal"));
        requerente.setTelefoneAlternativo(request.getParameter("telefoneAlternativo"));
        requerente.setEmailPrincipal(request.getParameter("emailPrincipal"));
        requerente.setEmailAlternativo(request.getParameter("emailAlternativo"));
        requerente.setHomePage(request.getParameter("homePage"));        
        requerenteDAO.save(requerente);
        response.sendRedirect("RequerenteInserir.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response, RequerenteDAO requerenteDAO) throws IOException{
        Requerente requerente = new Requerente();
        requerente.setIdRequerente(Integer.parseInt(request.getParameter("idRequerente")));
        requerente.setCategoriaJuridica(request.getParameter("categoriaJuridica"));
        requerente.setNomeRequerente(request.getParameter("nomeRequerente"));
        requerente.setSobrenomeRequerente(request.getParameter("sobrenomeRequerente"));
        requerente.setTelefonePrincipal(request.getParameter("telefonePrincipal"));
        requerente.setTelefoneAlternativo(request.getParameter("telefoneAlternativo"));
        requerente.setEmailPrincipal(request.getParameter("emailPrincipal"));
        requerente.setEmailAlternativo(request.getParameter("emailAlternativo"));
        requerente.setHomePage(request.getParameter("homePage"));
        requerente.setIdRequerente(Integer.parseInt(request.getParameter("codigoRequerente")));
        requerenteDAO.update(requerente);
        response.sendRedirect("RequerenteListar.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response, RequerenteDAO requerenteDAO) throws IOException{
        Requerente requerente = new Requerente();
        requerente.setIdRequerente(Integer.parseInt(request.getParameter("idRequerente")));
        requerenteDAO.delete(requerente);
        response.sendRedirect("RequerenteListar.jsp");
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
