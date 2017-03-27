/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.DocumentoDAO;
import cheladocs.modelo.Documento;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Adelino Eduardo
 */
@MultipartConfig
public class DocumentoServlet extends HttpServlet {

    private String PASTA_DOC = null;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        PASTA_DOC = getServletContext().getInitParameter("PastaArquivos");
    }

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

        DocumentoDAO documentoDAO;
        Documento documento = new Documento();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            try {
                String idDocumento = request.getParameter("numero_protocolo");
                if (idDocumento != null) {
                    documento.setNumeroProtocolo(Integer.parseInt(idDocumento));
                }

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            documentoDAO = new DocumentoDAO();

            if (comando.equalsIgnoreCase("guardar") || comando.equalsIgnoreCase("editar")) {
                documento.getRequerente().setIdRequerente(Integer.parseInt(request.getParameter("requerente")));
                documento.setDataEntrada(new Date(Calendar.getInstance().getTime().getTime()));
                documento.setOrigem(request.getParameter("origem_documento"));
                documento.setDescricaoAssunto(request.getParameter("descricao_assunto"));
                documento.getNaturezaAssunto().setIdNaturezaAssunto(Integer.parseInt(request.getParameter("natureza_assunto")));
                documento.getTipoExpediente().setIdTipoExpediente(Integer.parseInt(request.getParameter("tipo_expediente")));
                
                //Pegar a pasta do projecto
                String pastaProjecto = getServletContext().getRealPath("");

                //Definir caminho completo da pasta dos arquivos
                String caminhoCompleto = pastaProjecto + File.separator + "imagens" + File.separator + PASTA_DOC;
                System.out.println("Salvar em: " + caminhoCompleto);
                
                //Pegar o arquivo selecionado
                Part ficheiro = request.getPart("ficheiro");
                System.out.println("Nome arquivo: " + ficheiro.getSubmittedFileName());

                InputStream in = ficheiro.getInputStream();

                File file = new File(caminhoCompleto + "\\" + ficheiro.getSubmittedFileName());
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(file);

                byte[] buffer = new byte[1024 * 1024 * 100];

                int length;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                out.close();
                in.close();

                //Conteudo para a o campo ficheiro da tabela aluno. Carrega uma string com o nome e extensao do ficheiro
                documento.setUrlFicheiroDocumento(ficheiro.getSubmittedFileName());

                //Conteudo em byte do ficheiro. Guarda o conteudo em bytes num campo da tabela.            
                byte[] content = IOUtils.toByteArray(ficheiro.getInputStream());
                documento.setConteudoDocumento(new String(content));

                if (comando.equalsIgnoreCase("guardar")) {
                    documentoDAO.save(documento);
                } else {
                    documentoDAO.update(documento);
                }
                response.sendRedirect("paginas/gerir_documento.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                documentoDAO.delete(documento);
                response.sendRedirect("paginas/gerir_documento.jsp");

            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                documento = documentoDAO.findById(documento.getNumeroProtocolo());
                request.setAttribute("documento", documento);
                //RequestDispatcher rd = request.getRequestDispatcher("paginas/documento_editar.jsp");
                //rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/gerir_documento.jsp");
            } else if (comando.equalsIgnoreCase("principla")) {
                response.sendRedirect("/index.jsp");
            }

        } catch (IOException | ServletException ex) {
            //System.err.println("Erro na leitura dos dados: " + ex.getMessage());
            ex.printStackTrace();
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
