<%-- 
    Document   : gerir_naturezaAssunto
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
        <title>Natureza do Assunto</title>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery-1.12.3.min.js" type="text/javascript"></script>
        <script src="../js/modalLink.js" type="text/javascript"></script>

        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css.map" rel="stylesheet">
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap.css.map" rel="stylesheet">
        <link href="../css/bootstrap.min.css.map" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
        <script src="../js/bootstrap.js"></script>
        <script src="../js/npm.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                NaturezaAssuntoDAO naturezaAssuntoDAO = new NaturezaAssuntoDAO();
                List<NaturezaAssunto> naturezaAssuntoes = naturezaAssuntoDAO.findAll();
                int cont = 1;
            %>
            <%@include file="../cabecalho_rodape/cabecalho.jsp" %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Gerir Natureza Assunto</h1>
                </div>
                <div id="conteudo">
                    <div id="top" class="row">
                        <div class="col-md-9">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Natureza Assunto">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <!-- Trigger the modal with a button -->
                            <button type="button" class="btn btn-primary pull-right h2" data-toggle="modal" data-target="#myModal" id="modal_link">Nova Natureza Assunto</button>
                            <div class="modal-container">

                            </div>
                        </div>
                    </div> 
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>N/O</th>
                                <th>Natureza Assunto</th>
                                <th colspan="1">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (NaturezaAssunto naturezaAssunto : naturezaAssuntoes) {%>
                            <tr>
                                <td><%=cont%></td>
                                <td><%=naturezaAssunto.getNaturezaAssunto()%></td>
                                <td><a href="../NaturezaAssuntoServlet?comando=prepara_editar&id_natureza_assunto=<%=naturezaAssunto.getIdNaturezaAssunto()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../NaturezaAssuntoServlet?comando=eliminar&id_natureza_assunto=<%=naturezaAssunto.getIdNaturezaAssunto()%>"><img src="../imagens/delete.png"/></a></td>
                            </tr>
                            <% cont++; }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            apresentarModal('naturezaAssunto_guardar.jsp');
        </script>
    </body>
    <%@include file="../cabecalho_rodape/rodape.jsp" %>
</html>
