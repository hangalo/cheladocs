<%-- 
    Document   : gerir_requerente
    Created on : 8-feb-2017, 1.01.31
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.*"%>
<%@page import="java.util.List"%>
<%@page import="cheladocs.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    RequerenteDAO reqDao = new RequerenteDAO();
    List<Requerente> listaReq = reqDao.findAll();
    int cont = 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requerente</title>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery-1.12.3.min.js" type="text/javascript"></script>
        <script src="../js/modalLink.js" type="text/javascript"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
        <script src="../js/bootstrap.js"></script>
        <script src="../js/npm.js"></script>

        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css.map" rel="stylesheet">
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap.css.map" rel="stylesheet">
        <link href="../css/bootstrap.min.css.map" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <%@include file="../cabecalho_rodape/cabecalho.jsp" %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Gerir Requerente</h1>
                </div>

                <div id="conteudo">
                    <div id="top" class="row">

                        <div class="col-md-10">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Requerente">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <!-- Trigger the modal with a button -->
                            <button type="button" class="btn btn-primary pull-right h2" data-toggle="modal" data-target="#myModal" id="modal_link">Novo Requente</button>
                            <div class="modal-container">

                            </div>
                        </div>
                    </div> 

                    <table id="minhaTabela" class="table table-hover">
                        <thead>
                            <tr>
                                <th>N/O</th>
                                <th>Nome Requerente</th>
                                <th>Data Nascimento</th>
                                <th>Sexo</th>
                                <th>Categoria Juridica</th>
                                <th>Telefone </th>
                                <th>Email </th>
                                <th>Home Page</th>
                                <th colspan="3">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Requerente r : listaReq) { %>
                            <tr>
                                <td> <%= cont %> </td>
                                <td> <%= r.getNomeRequerente() + " " + r.getSobrenomeRequerente() %></td>
                                <td> <%= r.getDataNascimento() %></td>
                                <td> <%= r.getSexoRequerente() %></td>
                                <td> <%= r.getCategoriaJuridica() %></td>
                                <td> <%= r.getTelefonePrincipal() %> </td>
                                <td> <%= r.getEmailPrincipal() %> </td>
                                <td> <%= r.getHomePage() %> </td>
                                <td> <a href="requerente_editar.jsp" data-target="#myModal" data-toggle="modal"><img src="../imagens/edit.png"/></a> </td>
                                <td><a href="../DocumentoServlet?comando=eliminar&numero_protocolo=<%=r.getIdRequerente()%>"><img src="../imagens/delete.png"/></a></td>
                            <% cont = cont + 1; } %>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script>
        apresentarModal('requerente_guardar.jsp');
    </script>
    <%@include file="../cabecalho_rodape/rodape.jsp" %>
</html>
