/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Adelino Eduardo
 */
public class ReporteUtil {

    private Connection conn;

    public void geraRelatorio(String caminhoJasper, HashMap hashMap, HttpServletResponse response) throws IOException {
        byte[] bytes;
        
        try {
                conn = Conexao.getConnection();
                ServletOutputStream servletOutputStream = response.getOutputStream();
                bytes = JasperRunManager.runReportToPdf(caminhoJasper, hashMap, conn);
                conn.close();
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                servletOutputStream.write(bytes, 0, bytes.length);
                servletOutputStream.flush();
                servletOutputStream.close();

            } catch (IOException | JRException | SQLException ex) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ex.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());
            }
    }

}
