/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.DocumentoDAO;
import cheladocs.modelo.Documento;
import cheladocs.util.ReporteUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author informatica
 */
@WebServlet(name = "DocumentoServlet", urlPatterns = {"/documentoServlet"})
@MultipartConfig(maxFileSize = 16177215) // tamanho maximo do ficheiro 16 MB
public class DocumentoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String idDocumento;

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        response.setContentType("application/pdf; application/msword; application/excel");

        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }

        DocumentoDAO documentoDAO;
        Documento documento = new Documento();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            try {
                idDocumento = request.getParameter("numero_protocolo");
                if (idDocumento != null) {
                    documento.setNumeroProtocolo(Integer.parseInt(idDocumento));
                }

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            documentoDAO = new DocumentoDAO();

            if (comando.equalsIgnoreCase("guardar")) {

                documento.getRequerente().setIdRequerente(Integer.parseInt(request.getParameter("requerente")));
                documento.setDataEntrada(Date.valueOf(request.getParameter("data_entrada")));
                documento.setOrigem(request.getParameter("origem_documento"));
                documento.setDescricaoAssunto(request.getParameter("descricao_assunto"));
                documento.getNaturezaAssunto().setIdNaturezaAssunto(Integer.parseInt(request.getParameter("natureza_assunto")));
                documento.getTipoExpediente().setIdTipoExpediente(Integer.parseInt(request.getParameter("tipo_expediente")));
                Part ficheiro = request.getPart("ficheiro");
                if (ficheiro != null) {
                    byte[] ficheiroDados = IOUtils.toByteArray(ficheiro.getInputStream());
                    documento.setConteudoDocumento(ficheiroDados);
                    documento.setUrlFicheiroDocumento(ficheiro.getSubmittedFileName());
                    doUpload(ficheiro, request);
                }
                documentoDAO.save(documento);
                response.sendRedirect("paginas/gerir_documento.jsp");

            } else if (comando.equalsIgnoreCase("editar")) {

                documento.setNumeroProtocolo(Integer.parseInt(request.getParameter("requerente")));

                documento.getRequerente().setIdRequerente(Integer.parseInt(request.getParameter("requerente")));
                documento.setDataEntrada(Date.valueOf(request.getParameter("data_entrada")));
                documento.setOrigem(request.getParameter("origem_documento"));
                documento.setDescricaoAssunto(request.getParameter("descricao_assunto"));
                documento.getNaturezaAssunto().setIdNaturezaAssunto(Integer.parseInt(request.getParameter("natureza_assunto")));
                documento.getTipoExpediente().setIdTipoExpediente(Integer.parseInt(request.getParameter("tipo_expediente")));
                Part ficheiro = request.getPart("ficheiro");
                if (ficheiro != null) {
                    byte[] ficheiroDados = IOUtils.toByteArray(ficheiro.getInputStream());
                    documento.setConteudoDocumento(ficheiroDados);
                    documento.setUrlFicheiroDocumento(ficheiro.getSubmittedFileName());
                    doUpload(ficheiro, request);
                }

                documentoDAO.update(documento);
                response.sendRedirect("paginas/gerir_documento.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                documentoDAO.delete(documento);
                response.sendRedirect("paginas/gerir_documento.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                documento = documentoDAO.findById(documento.getNumeroProtocolo());
                request.setAttribute("documento", documento);

                RequestDispatcher rd = request.getRequestDispatcher("paginas/documento_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/gerir_documento.jsp");
            } else if (comando.equalsIgnoreCase("imprimir_todos") || comando.equalsIgnoreCase("imprimir_by_id")) {
                ReporteUtil reporte = new ReporteUtil();
                File caminhoRelatorio = null;
                HashMap hashMap = new HashMap();
                
                if (comando.equalsIgnoreCase("imprimir_todos")){
                    caminhoRelatorio = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/relatorios/DocumentoListar.jasper"));
                    reporte.geraRelatorio(caminhoRelatorio.getPath(), hashMap, response);
                }
                else{
                    hashMap.put("codigo_documento", Integer.parseInt(idDocumento));
                    caminhoRelatorio = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/relatorios/Ficha_Documento.jasper"));
                    reporte.geraRelatorio(caminhoRelatorio.getPath(), hashMap, response);
                }
            }
        } catch (IOException ex) { ex.printStackTrace(); }
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

    private void doUpload(Part part, HttpServletRequest request) {
        try {

            InputStream in = part.getInputStream();
                       
            File f = new File("c:\\ficheiros_docs\\" + part.getSubmittedFileName());
        
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024 * 1024 * 100];

            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
