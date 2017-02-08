<%-- 
    Document   : municipio_listar
    Created on : 8-feb-2017, 1.02.20
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cheladocs.dao.*" %>
<%@page import="cheladocs.modelo.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Municipios</title>
         <title>Cheladocs -  Gestão de Documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
       
        
         <div class="container">

            <%

                MunicipioDAO municipioDAO = new MunicipioDAO();
                List<Municipio> municipios = municipioDAO.findAll();

            %>




            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Cheladocs -  Gestão de Documentos</h1>
                </div>

                <div id="conteudo">
                   
                    <h2>Lista - Municípios</h2>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Município</th>
                                <th>Provincia</th>
                                <th colspan="2">Operações</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%for (Municipio municipio : municipios) {%>
                            <tr>
                                <td><%=municipio.getIdMunicipio()%></td>
                                <td><%=municipio.getNomeMunicipio()%></td>
                                <td><%=municipio.getProvinciaMunicipio()%></td>

                                <td><a href="../municipioServlet?comando=prepara_editar&id_municipio=<%=municipio.getIdMunicipio()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../municipioServlet?comando=eliminar&id_municipio=<%=municipio.getIdMunicipio()%>"><img src="../imagens/delete.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>

            </div>

            
        </div>
        
    </body>
</html>
