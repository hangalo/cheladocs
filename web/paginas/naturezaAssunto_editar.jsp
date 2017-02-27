<%-- 
    Document   : naturezaAssunto_editar
    Created on : 8-feb-2017, 1.06.34
    Author     : informatica
--%>

<%@page import="cheladocs.dao.NaturezaAssuntoDAO"%>
<%@page import="cheladocs.modelo.NaturezaAssunto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar natureza do assunto</title>
         <title>Cheladocs -  Gestão de Documentos</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                NaturezaAssunto naturezaAssunto = (NaturezaAssunto)request.getAttribute("naturezaAssunto");
            %>
            <div id="banner">
                <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                <h1 style="text-align: center">Cheladocs -  Gestão de Documentos</h1>
            </div>
            <div id="conteudo">
                <form class="form-horizontal" role="form" action="NaturezaAssuntoServlet?comando=editar" method="POST">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Código: </label>
                        <div class="col-xs-5">
                            <input type="text" class="form-control" value="<%=naturezaAssunto.getIdNaturezaAssunto()%>" name="id_natureza_assunto" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Natureza Assunto: </label>
                        <div class="col-xs-5">
                            <input type="text" class="form-control" value="<%=naturezaAssunto.getNaturezaAssunto()%>" name="natureza_assunto"/>
                        </div>
                    </div>
                    <div class="col-md-4 col-md-offset-2">
                        <button	type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
