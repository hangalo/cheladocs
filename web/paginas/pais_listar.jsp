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
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/auto-complete.js"></script>
        <script src="../js/jquery-1.12.4.js"></script>
        <script src="../js/jquery-ui-1.12.1.js"></script>
        <script src="../js/autocompleter.js"></script>        

        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/jquery-themes-1.12.1-ui.css" rel="stylesheet">


    </head>
    <body onload="init()">
        <div class="container formDiv">
            <%@include file="../cabecalho_rodape/cabecalho.jsp" %>
            <%
                PaisDAO paisDAO = new PaisDAO();
                List<Pais> paises = paisDAO.findAll();
            %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Lista de Paises</h1>
                </div>
                <div id="conteudo">
                    <div id="top" class="row">
                        <div class="col-md-10">
                            <div class="input-group h2">
                                <input name="search" class="form-control search" id="search" type="text">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!-- Trigger the modal with a button -->
                            <button type="button" class="btn btn-primary pull-right h2" data-toggle="modal" data-target="#myModal" id="modal_link">Novo Pais</button>
                            <div class="modal-container">

                            </div>
                        </div>
                    </div>
                    <table border="0" margin="0" padding="0" width="100%" class="table table-responsive" id="lista_pais">
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
                                <td><a href="paisServlet?comando=prepara_editar&id_pais=<%=pais.getIdPais()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="paisServlet?comando=eliminar&id_pais=<%=pais.getIdPais()%>"><img src="../imagens/delete.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
    </body>
</html>
