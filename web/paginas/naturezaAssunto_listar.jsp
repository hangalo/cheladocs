<%-- 
    Document   : naturezaAssunto_listar
    Created on : 8-feb-2017, 1.02.44
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.NaturezaAssunto"%>
<%@page import="java.util.List"%>
<%@page import="cheladocs.dao.NaturezaAssuntoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Natureza do assunto</title>
         <title>Cheladocs -  Gestão de Documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">

            <%
                NaturezaAssuntoDAO naturezaAssuntoDAO = new NaturezaAssuntoDAO();
                List<NaturezaAssunto> naturezaAssuntoes = naturezaAssuntoDAO.findAll();
            %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Cheladocs -  Gestão de Documentos</h1>
                </div>

                <div id="conteudo">

                    <h2>Lista - Natureza Assunto</h2>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>País</th>
                                <th colspan="2">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (NaturezaAssunto naturezaAssunto : naturezaAssuntoes) {%>
                            <tr>
                                <td><%=naturezaAssunto.getIdNaturezaAssunto()%></td>
                                <td><%=naturezaAssunto.getNaturezaAssunto()%></td>
                                <td><a href="../NaturezaAssuntoServlet?comando=prepara_editar&id_natureza_assunto=<%=naturezaAssunto.getIdNaturezaAssunto()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../NaturezaAssuntoServlet?comando=eliminar&id_natureza_assunto=<%=naturezaAssunto.getIdNaturezaAssunto()%>"><img src="../imagens/delete.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>

            </div>
                        
        </div>
    </body>
</html>
