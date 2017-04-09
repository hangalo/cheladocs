<%-- 
    Document   : documento_editar
    Created on : 9-apr-2017, 1.22.39
    Author     : informatica
--%>
<%@page import="cheladocs.modelo.Documento"%>
<%@page import="cheladocs.modelo.TipoExpediente"%>
<%@page import="cheladocs.modelo.Requerente"%>
<%@page import="cheladocs.modelo.NaturezaAssunto"%>
<%@page import="cheladocs.dao.RequerenteDAO"%>
<%@page import="cheladocs.dao.TipoExpedienteDAO"%>
<%@page import="cheladocs.dao.NaturezaAssuntoDAO"%>
<%@page import="cheladocs.util.DateUtil"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Documento</title>
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
    Documento doc = (Documento) request.getAttribute("documento");
    NaturezaAssuntoDAO naturezaDAO = new NaturezaAssuntoDAO();
    RequerenteDAO requerenteDAO = new RequerenteDAO();
    TipoExpedienteDAO tipoDAO = new TipoExpedienteDAO();
%>

            
            
            
         <form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/documentoServlet?comando=editar"  method="POST" enctype="multipart/form-data">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Editar Documento</h4>
                </div>

                <div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label class="col-xs-2 control-label">Número Protocolo: </label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" name="numero_protocolo" value="<%=doc.getNumeroProtocolo()%>" readonly/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Assunto: </label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" name="descricao_assunto" value="<%=doc.getDescricaoAssunto()%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Origem: </label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" name="origem_documento" value="<%=doc.getOrigem()%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Data Entrada: </label>
                            <div class="col-xs-5">
                                <input type="date" class="form-control" name="data_entrada" value="<%=DateUtil.formataData(doc.getDataEntrada())%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Natureza Assunto: </label>
                            <div class="col-xs-5">
                                <select class="form-control" name="natureza_assunto">
                                    <% for (NaturezaAssunto n : naturezaDAO.findAll()) {%>
                                    <option value="<%=n.getIdNaturezaAssunto()%>"><%=n.getNaturezaAssunto()%></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Requerente: </label>
                            <div class="col-xs-5">
                                <select class="form-control" name="requerente">
                                    <% for (Requerente req : requerenteDAO.findAll()) {%>
                                    <option value="<%=req.getIdRequerente()%>"><%=req.getNomeRequerente() + " " + req.getSobrenomeRequerente()%></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Tipo Expediente: </label>
                            <div class="col-xs-5">
                                <select class="form-control" name="tipo_expediente">
                                    <% for (TipoExpediente t : tipoDAO.findAll()) {%>
                                    <option value="<%=t.getIdTipoExpediente()%>"><%=t.getTipoExpediente()%></option>
                                    <% }%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Ficheiro: </label>
                            <div class="col-xs-5">
                                <input type="file" class="form-control" name="ficheiro" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button	type="submit" class="btn btn-primary">Guardar</button>
                    <button	type="reset" class="btn btn-primary">Limpar</button>
                    
                </div>
            </div>
        </form>
        
        </div>
    </body>
</html>
