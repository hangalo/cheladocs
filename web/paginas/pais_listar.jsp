<%-- 
    Document   : pais_listar
    Created on : 8-feb-2017, 1.03.12
    Author     : informatica
--%>

<%@page import="cheladocs.dao.PaisDAO"%>
<%@page import="cheladocs.modelo.Pais"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paises</title>
        <title>Cheladocs -  Gestão de Documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
        <script src="../js/dataTables.bootstrap.min.js"></script>
        <script src="../js/jquery.dataTables.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                PaisDAO paisDAO = new PaisDAO();
                List<Pais> paises = paisDAO.findAll();
            %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Cheladocs -  Gestão de Documentos</h1>
                </div>
                <div id="conteudo">

                    <h2>Lista - Paises</h2>
                    <table id="example" class=" table display table-responsive">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>País</th>
                                <th colspan="2">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Pais pais : paises) {%>
                            <tr>
                                <td><%=pais.getIdPais()%></td>
                                <td><%=pais.getNomePais()%></td>
                                <td><a href="../paisServlet?comando=prepara_editar&id_pais=<%=pais.getIdPais()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../paisServlet?comando=eliminar&id_pais=<%=pais.getIdPais()%>"><img src="../imagens/delete.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
