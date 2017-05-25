<%-- 
    Document   : movimentoMovimentoDocumento_listar
    Created on : 8-feb-2017, 1.01.56
    Author     : informatica
--%>

<%@page import="cheladocs.dao.MovimentoDocumentoDAO"%>
<%@page import="cheladocs.modelo.MovimentoDocumento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movimentos</title>
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
                MovimentoDocumentoDAO movDocumentoDAO = new MovimentoDocumentoDAO();
                List<MovimentoDocumento> listaMovimentos = movDocumentoDAO.findAll();
                int cont = 0;
            %>
            <%@include file="../cabecalho_rodape/cabecalho.jsp" %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <a href="<%=request.getContextPath()%>/MovimentoDocumentoServlet?comando=imprimir_todos" class="btn btn-info" role="button">Gerar Relatório</a>
                    <h1 style="text-align: center">Lista de Movimento de Documentos</h1>
                </div>

                <div id="conteudo">
                    <div id="top" class="row">
                        <div class="col-md-10">
                            <div class="input-group h2">
                                <input class="form-control" type="search" placeholder="Pesquisar Movimento de Documento">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <!-- Trigger the modal with a button -->
                            <button type="button" class="btn btn-primary pull-right h2" data-toggle="modal" data-target="#myModal" id="modal_link">Novo Movimento</button>
                            <div class="modal-container">

                            </div>
                        </div>
                    </div> 

                    <table id="tabela_movimento" class="table table-hover table-responsive table-striped">
                        <thead>
                            <tr>
                                <th>N/O</th>
                                <th>Assunto</th>
                                <th>Origem</th>
                                <th>Departamento</th>
                                <th>Data Recepcao</th>
                                <th>Data Reenvio</th>
                                <th colspan="3">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (MovimentoDocumento movDoc : listaMovimentos) {%>
                            <% cont = cont + 1;%>
                            <tr>
                                <td><%=cont%></td>
                                <td><%=movDoc.getDocumento().getDescricaoAssunto()%></td>
                                <td><%=movDoc.getDocumento().getOrigem()%></td>
                                <td><%=movDoc.getDepartamento().getDepartamento()%></td>
                                <td><%=movDoc.getDataRecepcao()%></td>
                                <td><%=movDoc.getDataReenvio()%></td>
                                <td><a href="../MovimentoDocumentoServlet?comando=prepara_editar&id_movimento_progressivo=<%=movDoc.getIdMovimentoProgressivo()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../MovimentoDocumentoServlet?comando=eliminar&id_movimento_progressivo=<%=movDoc.getIdMovimentoProgressivo()%>"><img src="../imagens/delete.png"/></a></td>
                                <td><a href="../MovimentoDocumentoServlet?comando=imprimir_by_id&id_movimento_progressivo=<%=movDoc.getIdMovimentoProgressivo()%>"><img src="../imagens/print.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            apresentarModal('movimentoDocumento_guardar.jsp');
        </script>
    </body>
</html>
