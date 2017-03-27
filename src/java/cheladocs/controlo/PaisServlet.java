/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheladocs.controlo;

import cheladocs.dao.PaisDAO;
import cheladocs.modelo.Pais;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adelino Eduardo
 */
@WebServlet(name = "PaisServlet", urlPatterns = {"/PaisServlet"})
public class PaisServlet extends HttpServlet {

    
   protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        try {
            String term = request.getParameter("term");

            PaisDAO paisDAO = new PaisDAO();
            ArrayList<String> paises = paisDAO.findByPais(term);            
            
            String searchList = new Gson().toJson(paises);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
