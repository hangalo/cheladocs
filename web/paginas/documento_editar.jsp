<%-- 
    Document   : documento_editar
    Created on : 8-feb-2017, 1.05.13
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.Documento"%>
<%@page import="cheladocs.modelo.TipoExpediente"%>
<%@page import="cheladocs.modelo.Requerente"%>
<%@page import="cheladocs.modelo.NaturezaAssunto"%>
<%@page import="cheladocs.dao.RequerenteDAO"%>
<%@page import="cheladocs.dao.TipoExpedienteDAO"%>
<%@page import="cheladocs.dao.NaturezaAssuntoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Documento</title>
         <title>Cheladocs -  Gestão de Documentos</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                Documento doc = (Documento)request.getAttribute("documento");
                NaturezaAssuntoDAO naturezaDAO = new NaturezaAssuntoDAO();
                RequerenteDAO requerenteDAO = new RequerenteDAO();
                TipoExpedienteDAO tipoDAO = new TipoExpedienteDAO();
            %>
            <div id="banner">
                <a href="index.jsp" class="btn btn-info" role="button">Home</a>
                <h1 style="text-align: center">Cheladocs -  Gestão de Documentos</h1>
            </div>
            <div id="conteudo">
                <form class="form-horizontal" role="form" action="DocumentoServlet?comando=editar" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Número Protocolo: </label>
                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="numero_protocolo" value="<%=doc.getNumeroProtocolo()%>" placeholder="Número Protocolo" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Assunto: </label>
                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="descricao_assunto" value="<%=doc.getDescricaoAssunto()%>" placeholder="Assunto do Documento"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Origem: </label>
                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="origem_documento" value="<%=doc.getOrigem()%>" placeholder="Origem do Documento"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Data Entrada: </label>
                        <div class="col-xs-5">
                            <input type="date" class="form-control" name="data_entrada" value="<%=doc.getDataEntrada()%>" placeholder="data_entrada"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Natureza Assunto: </label>
                        <div class="col-xs-5">
                            <select class="form-control" name="natureza_assunto">
                                <% for (NaturezaAssunto NA : naturezaDAO.findAll()) {%>
                                    <option value="<%=NA.getIdNaturezaAssunto() %>"><%=NA.getNaturezaAssunto() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Requerente: </label>
                        <div class="col-xs-5">
                            <select class="form-control" name="requerente">
                                <% for (Requerente req : requerenteDAO.findAll()) {%>
                                    <option value="<%=req.getIdRequerente() %>"><%=req.getNomeRequerente() + " " + req.getSobrenomeRequerente() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Tipo Expediente: </label>
                        <div class="col-xs-5">
                            <select class="form-control" name="tipo_expediente">
                                <% for (TipoExpediente TE : tipoDAO.findAll()) {%>
                                    <option value="<%=TE.getIdTipoExpediente() %>"><%=TE.getTipoExpediente() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Ficheiro: </label>
                        <div class="col-xs-5">
                            <input type="file" class="form-control" value="<%=doc.getUrlFicheiroDocumento()%>" name="ficheiro" />
                        </div>
                    </div>
                    <div class="col-md-4 col-md-offset-2">
                        <button	type="submit" class="btn btn-primary">Guardar</button>
                        <button	type="reset" class="btn btn-primary">Limpar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
