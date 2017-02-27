<%-- 
    Document   : documento_listar
    Created on : 8-feb-2017, 1.01.31
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.Documento"%>
<%@page import="java.util.List"%>
<%@page import="cheladocs.dao.DocumentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documentos</title>
        <title>Cheladocs -  Gestão de Documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery-1.12.3.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">

            <%
                DocumentoDAO docDAO = new DocumentoDAO();
                List<Documento> listaDoc = docDAO.findAll();
                int cont = 0;
            %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Lista de Documentos</h1>
                </div>

                <div id="conteudo">
                    <div id="top" class="row">
                        <!--<div class="col-md-3">
                            <h2>Itens</h2>
                        </div> -->

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
                            <a href="documento_guardar.jsp" class="btn btn-primary pull-right h2">Novo Documento</a>
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
                                <td><%=doc.getOrigem()%></td>
                                <td><%=doc.getDescricaoAssunto()%></td>
                                <td><%=doc.getDataEntrada()%></td>
                                <td><%=doc.getNaturezaAssunto().getNaturezaAssunto()%></td>
                                <td><%=doc.getTipoExpediente().getTipoExpediente()%></td>
                                <td><%=doc.getRequerente().getNomeRequerente() + " " + doc.getRequerente().getSobrenomeRequerente()%></td>
                                <td><a href="../DocumentoServlet?comando=prepara_editar&numero_protocolo=<%=doc.getNumeroProtocolo()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../DocumentoServlet?comando=eliminar&numero_protocolo=<%=doc.getNumeroProtocolo()%>"><img src="../imagens/delete.png"/></a></td>
                                <td><a href="../DocumentoServlet?comando=listar&numero_protocolo=<%=doc.getNumeroProtocolo()%>"><img src="../imagens/print.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
