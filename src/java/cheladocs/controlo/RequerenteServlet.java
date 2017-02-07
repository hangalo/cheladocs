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
import javax.servlet.RequestDispatcher;
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
        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }

        RequerenteDAO requerenteDAO;
        Requerente requerente = new Requerente();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            try {
                String idRequerente = request.getParameter("id_requerente");
                if (idRequerente != null) {
                    requerente.setIdRequerente(Integer.parseInt(idRequerente));
                }

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            requerenteDAO = new RequerenteDAO();

            if (comando.equalsIgnoreCase("guardar") || comando.equalsIgnoreCase("editar")) {

                requerente.setCategoriaJuridica(request.getParameter("categoria_Juridica"));
                requerente.setNomeRequerente(request.getParameter("nome_Requerente"));
                requerente.setSobrenomeRequerente(request.getParameter("sobrenome_Requerente"));
                requerente.setTelefonePrincipal(request.getParameter("telefone_Principal"));
                requerente.setTelefoneAlternativo(request.getParameter("telefone_Alternativo"));
                requerente.setEmailPrincipal(request.getParameter("email_Principal"));
                requerente.setEmailAlternativo(request.getParameter("email_Alternativo"));
                requerente.setHomePage(request.getParameter("home_Page"));
                
                if (comando.equalsIgnoreCase("guardar"))
                    requerenteDAO.save(requerente);
                else
                    requerenteDAO.update(requerente);
            
                response.sendRedirect("paginas/requerente_listar.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                requerenteDAO.delete(requerente);
                response.sendRedirect("paginas/requerente_listar.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                requerente = requerenteDAO.findById(requerente.getIdRequerente());
                request.setAttribute("requerente", requerente);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/requerente_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/requerente_listar.jsp");
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
