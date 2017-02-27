<%-- 
    Document   : movimentoDocumento_editar
    Created on : 8-feb-2017, 1.05.33
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.MovimentoDocumento"%>
<%@page import="cheladocs.modelo.Departamento"%>
<%@page import="cheladocs.modelo.Documento"%>
<%@page import="cheladocs.dao.DepartamentoDAO"%>
<%@page import="cheladocs.dao.DocumentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Movimento</title>
        <title>Cheladocs -  Gestão de Documentos</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                MovimentoDocumento movDoc = (MovimentoDocumento) request.getAttribute("mDocumento");
                DocumentoDAO docDAO = new DocumentoDAO();
                DepartamentoDAO depDAO = new DepartamentoDAO();
            %>
            <div id="banner">
                <a href="index.jsp" class="btn btn-info" role="button">Home</a>
                <h1 style="text-align: center">Cheladocs -  Gestão de Documentos</h1>
            </div>
            <div id="conteudo">
                <form class="form-horizontal" role="form" action="MovimentoDocumentoServlet?comando=editar" method="POST">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Código: </label> 
                        <div class="col-xs-5">
                            <input type="text" class="form-control" value="<%=movDoc.getIdMovimentoProgressivo()%>" name="id_movimento_progressivo" readonly="true"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Documento: </label>
                        <div class="col-xs-5">
                            <select class="form-control" name="documento">
                                <% for (Documento doc : docDAO.findAll()) {%>
                                <option value="<%=doc.getNumeroProtocolo()%>"><%=doc.getDescricaoAssunto()%></option>
                                <% }%>
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
                            <input type="date" class="form-control" value="<%=movDoc.getDataRecepcao()%>" name="data_recepcao" placeholder="Data Recepção"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Data Reenvio: </label>
                        <div class="col-xs-5">
                            <input type="date" class="form-control" value="<%=movDoc.getDataReenvio()%>" name="data_reenvio" placeholder="Data Reenvio"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Notas: </label>
                        <div class="col-xs-5">
                            <textarea class="form-control" name="notas" value="<%=movDoc.getNotas()%>" placeholder="Notas" rows="5"> </textarea>
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
