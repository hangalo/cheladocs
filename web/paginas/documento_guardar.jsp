<%-- 
    Document   : documento_guardar
    Created on : 8-feb-2017, 1.07.27
    Author     : informatica
--%>
<%@page import="cheladocs.modelo.TipoExpediente"%>
<%@page import="cheladocs.modelo.Requerente"%>
<%@page import="cheladocs.modelo.NaturezaAssunto"%>
<%@page import="cheladocs.dao.TipoExpedienteDAO"%>
<%@page import="cheladocs.dao.RequerenteDAO"%>
<%@page import="cheladocs.dao.NaturezaAssuntoDAO"%>
<%
    NaturezaAssuntoDAO naturezaDAO = new NaturezaAssuntoDAO();
    RequerenteDAO requerenteDAO = new RequerenteDAO();
    TipoExpedienteDAO tipoDAO = new TipoExpedienteDAO();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title> Guardar Documento </title>  
    </head>
    <body>
        <!-- Inicio Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/documentoServlet?comando=guardar" method="POST" enctype="multipart/form-data">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Registar Novo Documento</h4>
                        </div>

                        <div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Assunto: </label>
                                    <div class="col-xs-5">
                                        <input type="text" class="form-control" name="descricao_assunto" placeholder="Assunto do Documento"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Origem: </label>
                                    <div class="col-xs-5">
                                        <input type="text" class="form-control" name="origem_documento" placeholder="Origem do Documento"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Data Entrada: </label>
                                    <div class="col-xs-5">
                                        <input type="date" class="form-control" name="data_entrada" placeholder="data_entrada"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Natureza Assunto: </label>
                                    <div class="col-xs-5">
                                        <select class="form-control" name="natureza_assunto">
                                            <% for (NaturezaAssunto NA : naturezaDAO.findAll()) {%>
                                            <option value="<%=NA.getIdNaturezaAssunto()%>"><%=NA.getNaturezaAssunto()%></option>
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
                                            <% for (TipoExpediente TE : tipoDAO.findAll()) {%>
                                            <option value="<%=TE.getIdTipoExpediente()%>"><%=TE.getTipoExpediente()%></option>
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
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- Fim Modal dialog -->
    </body>
</html>
