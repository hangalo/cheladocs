<%-- 
    Document   : departamento_listar
    Created on : 8-feb-2017, 0.56.57
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.Departamento"%>
<%@page import="cheladocs.dao.DepartamentoDAO"%>
<%@page import="cheladocs.modelo.Documento"%>
<%@page import="java.util.List"%>
<%@page import="cheladocs.dao.DocumentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamentos</title>

        <title>Cheladocs -  Gestão de Documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                DepartamentoDAO depDAO = new DepartamentoDAO();
                List<Departamento> lista_departamento = depDAO.findAll();
                int cont = 1;
            %>
            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Lista de Movimento de Documentos</h1>
                </div>

                <div id="conteudo">
                    <div id="top" class="row">
                        <div class="col-md-10">
                            <div class="input-group h2">
                                <input class="form-control" type="search" placeholder="Pesquisar Departamento">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <a href="departamento_guardar.jsp" class="btn btn-primary pull-right h2">Novo Departamento</a>
                        </div>
                    </div> 
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>País</th>
                                <th colspan="2">Operações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Departamento dep : lista_departamento) {%>
                            <tr>
                                <td><%=cont%></td>
                                <td><%=dep.getDepartamento()%></td>
                                <td><a href="../DepartamentoServlet?comando=prepara_editar&id_departamento=<%=dep.getIdDepartamento()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../DepartamentoServlet?comando=eliminar&id_departamento=<%=dep.getIdDepartamento()%>"><img src="../imagens/delete.png"/></a></td>
                                        <% cont = cont + 1; %>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
