<%-- 
    Document   : gerir_documento
    Created on : 8-feb-2017, 1.01.31
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.Documento"%>
<%@page import="java.util.List"%>
<%@page import="cheladocs.dao.DocumentoDAO"%>
<%@page import="cheladocs.util.DateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documentos</title>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/modalLink.js" type="text/javascript"></script>

        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-theme.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-theme.css.map" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap.css.map" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css.map" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/estilos.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/layout_paginas.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
        <script src="<%=request.getContextPath()%>/js/npm.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                DocumentoDAO docDAO = new DocumentoDAO();
                List<Documento> listaDoc = docDAO.findAll();
                int cont = 0;
            %>
            <%@include file="../cabecalho_rodape/cabecalho.jsp" %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <a href="<%=request.getContextPath()%>/documentoServlet?comando=imprimir_todos" class="btn btn-info" role="button">Gerar Relatório</a>
                    <h1 style="text-align: center">Lista de Documentos</h1>
                </div>
                <div id="conteudo">
                    <div id="top" class="row">
                        <div class="col-md-10">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Documento">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!-- Trigger the modal with a button -->
                            <button type="button" class="btn btn-primary pull-right h2" data-toggle="modal" data-target="#myModal" id="modal_link">Novo Documento</button>
                            <div class="modal-container">

                            </div>
                        </div>
                    </div> 

                    <table id="minhaTabela" class="table table-hover table-responsive">
                        <thead>
                            <tr>
                                <th>N/O</th>
                                <th>Assunto</th>
                                <th>Origem</th>
                                <th>Data Entrada</th>
                                <th>Natureza Assunto</th>
                                <th>Tipo Expediente</th>
                                <th>Requerente</th>
                                <th colspan="3">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Documento doc : listaDoc) {%>
                            <% cont = cont + 1;%>
                            <tr>
                                <td><%=cont%></td>
                                <td><%=doc.getDescricaoAssunto()%></td>
                                <td><%=doc.getOrigem()%></td>
                                <td><%=DateUtil.formataData(doc.getDataEntrada())%></td>
                                <td><%=doc.getNaturezaAssunto().getNaturezaAssunto()%></td>
                                <td><%=doc.getTipoExpediente().getTipoExpediente()%></td>
                                <td><%=doc.getRequerente().getNomeRequerente() + " " + doc.getRequerente().getSobrenomeRequerente()%></td>
                               
                                <td><a href="<%=request.getContextPath()%>/documentoServlet?comando=prepara_editar&numero_protocolo=<%=doc.getNumeroProtocolo()%>"><img src="<%=request.getContextPath()%>/imagens/edit.png" /></a></td>
                                              
                                <td><a href="<%=request.getContextPath()%>/documentoServlet?comando=eliminar&numero_protocolo=<%=doc.getNumeroProtocolo()%>"><img src="<%=request.getContextPath()%>/imagens/delete.png"/></a></td>
                                <td><a href="<%=request.getContextPath()%>/documentoServlet?comando=imprimir_by_id&numero_protocolo=<%=doc.getNumeroProtocolo()%>"><img src="<%=request.getContextPath()%>/imagens/print.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            apresentarModal('documento_guardar.jsp');
        </script>
    </body>
</html>
