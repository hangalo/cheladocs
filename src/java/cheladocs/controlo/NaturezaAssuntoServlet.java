/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.NaturezaAssuntoDAO;
import cheladocs.modelo.NaturezaAssunto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }

        NaturezaAssuntoDAO naturezaAssuntoDAO;
        NaturezaAssunto naturezaAssunto = new NaturezaAssunto();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            try {
                String idNaturezaAssunto = request.getParameter("id_natureza_assunto");
                if (idNaturezaAssunto != null) {
                    naturezaAssunto.setIdNaturezaAssunto(Integer.parseInt(idNaturezaAssunto));
                }

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            naturezaAssuntoDAO = new NaturezaAssuntoDAO();

            if (comando.equalsIgnoreCase("guardar")) {

                naturezaAssunto.setNaturezaAssunto(request.getParameter("natureza_assunto"));
                naturezaAssuntoDAO.save(naturezaAssunto);
                response.sendRedirect("paginas/gerir_naturezaAssunto.jsp");

            } else if (comando.equalsIgnoreCase("editar")) {
                naturezaAssunto.setIdNaturezaAssunto(Integer.parseInt(request.getParameter("id_natureza_assunto")));
                naturezaAssunto.setNaturezaAssunto(request.getParameter("natureza_assunto"));
                 System.out.println("NA: " + naturezaAssunto.getNaturezaAssunto());
                naturezaAssuntoDAO.update(naturezaAssunto);
                response.sendRedirect("paginas/gerir_naturezaAssunto.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                naturezaAssuntoDAO.delete(naturezaAssunto);
                response.sendRedirect("paginas/gerir_naturezaAssunto.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                naturezaAssunto = naturezaAssuntoDAO.findById(naturezaAssunto.getIdNaturezaAssunto());
                request.setAttribute("naturezaAssunto", naturezaAssunto);
                RequestDispatcher rd = request.getRequestDispatcher("paginas/naturezaAssunto_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/gerir_naturezaAssunto.jsp");
            } else if (comando.equalsIgnoreCase("principal")) {
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
