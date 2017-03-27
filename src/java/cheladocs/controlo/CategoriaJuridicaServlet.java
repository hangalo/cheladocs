/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.CategoriaJuridicaDAO;
import cheladocs.modelo.CategoriaJuridica;
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
public class CategoriaJuridicaServlet extends HttpServlet {

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

        CategoriaJuridicaDAO categoriaJuridicaDAO;
        CategoriaJuridica categoriaJuridica = new CategoriaJuridica();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            try {
                String idCategoriaJuridica = request.getParameter("id_categoriaJuridica");
                if (idCategoriaJuridica != null) {
                    categoriaJuridica.setIdCategoriaJuridica(Integer.parseInt(idCategoriaJuridica));
                }

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            categoriaJuridicaDAO = new CategoriaJuridicaDAO();

            if (comando.equalsIgnoreCase("guardar")) {

                categoriaJuridica.setCategoriaJuridica(request.getParameter("nome_categoriaJuridica"));
                categoriaJuridicaDAO.save(categoriaJuridica);
                response.sendRedirect("paginas/gerir_categoriaJuridica.jsp");

            } else if (comando.equalsIgnoreCase("editar")) {
                //categoriaJuridica.setIdCategoriaJuridica(Integer.parseInt(request.getParameter("id_categoriaJuridica")));
                categoriaJuridica.setCategoriaJuridica(request.getParameter("nome_categoriaJuridica"));
                categoriaJuridicaDAO.update(categoriaJuridica);
                response.sendRedirect("paginas/gerir_categoriaJuridica.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                categoriaJuridicaDAO.delete(categoriaJuridica);
                response.sendRedirect("paginas/gerir_categoriaJuridica.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                categoriaJuridica = categoriaJuridicaDAO.findById(categoriaJuridica.getIdCategoriaJuridica());
                request.setAttribute("categoriaJuridica", categoriaJuridica);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/categoriaJuridica_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/gerir_categoriaJuridica.jsp");
            } else if (comando.equalsIgnoreCase("principla")) {
                response.sendRedirect("/index.jsp");
            }

        } catch (IOException ex) {
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
