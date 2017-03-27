<%-- 
    Document   : movimentoDocumento_guardar
    Created on : 8-feb-2017, 1.05.33
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.Departamento"%>
<%@page import="cheladocs.modelo.Documento"%>
<%@page import="cheladocs.dao.DepartamentoDAO"%>
<%@page import="cheladocs.dao.DocumentoDAO"%>

<%
    DocumentoDAO docDAO = new DocumentoDAO();
    DepartamentoDAO depDAO = new DepartamentoDAO();
%>
<!-- Inicio Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <form class="form-horizontal" role="form" action="../MovimentoDocumentoServlet?comando=guardar" method="POST">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Registar Novo Documento</h4>
                </div>

                <div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Documento: </label>
                            <div class="col-xs-5">
                                <select class="form-control" name="documento">
                                    <% for (Documento doc : docDAO.findAll()) {%>
                                    <option value="<%=doc.getNumeroProtocolo()%>"><%=doc.getDescricaoAssunto()%></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Departamento: </label>
                            <div class="col-xs-5">
                                <select class="form-control" name="departamento">
                                    <% for (Departamento dep : depDAO.findAll()) {%>
                                    <option value="<%=dep.getIdDepartamento()%>"><%=dep.getDepartamento()%></option>
                                    <% }%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Data Recepção: </label>
                            <div class="col-xs-5">
                                <input type="date" class="form-control" name="data_recepcao" placeholder="Data Recepção"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Data Reenvio: </label>
                            <div class="col-xs-5">
                                <input type="date" class="form-control" name="data_reenvio" placeholder="Data Reenvio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Notas: </label>
                            <div class="col-xs-5">
                                <textarea class="form-control" name="notas" placeholder="Notas" rows="5"> </textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="reset" class="btn btn-primary">Limpar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- Fim Modal dialog -->