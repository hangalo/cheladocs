<%-- 
    Document   : provincia_listar
    Created on : 8-feb-2017, 1.03.26
    Author     : informatica
--%>

<%@page import="cheladocs.dao.ProvinciaDAO"%>
<%@page import="cheladocs.modelo.Provincia"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Provincias</title>
         <title>Cheladocs -  Gestão de Documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">

            <%
                ProvinciaDAO provinciaDAO = new ProvinciaDAO();
                List<Provincia> provincias = provinciaDAO.findAll();
            %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Cheladocs -  Gestão de Documentos</h1>
                </div>

                <div id="conteudo">

                    <h2>Lista - Provincias</h2>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Provincia</th>
                                <th>País</th>
                                <th colspan="2">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Provincia provincia : provincias) {%>
                            <tr>
                                <td><%=provincia.getIdProvincia()%></td>
                                <td><%=provincia.getNomeProvincia()%></td>
                                <td><%=provincia.getPaisProvincia().getNomePais()%></td>
                                <td><a href="../provinciaServlet?comando=prepara_editar&id_provincia=<%=provincia.getIdProvincia()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../provinciaServlet?comando=eliminar&id_provincia=<%=provincia.getIdProvincia()%>"><img src="../imagens/delete.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>

            </div>


        </div>
    </body>
</html>
