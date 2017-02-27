<%-- 
    Document   : index
    Created on : 13-lug-2016, 0.46.25
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cheladocs -  Gestão de expediente e documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>

        <div class="jumbotron text-center">
            <img src="../imagens/toga.png" alt="" width="300" height="200"/>
            <h1>Cheladocs</h1>
            <p>Sistema de gestao de expediente e documentos</p> 
        </div>

        <div class="container">
            <h2>Panel Group</h2>

            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">Documentos</div>
                    <div class="panel-body">
                        <a href="../paginas/documento_guardar.jsp" class="btn btn-info" role="button">Novo Documento</a>
                        <a href="../paginas/documento_listar.jsp" class="btn btn-info" role="button">Listar Documentos</a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Movimentos</div>
                    <div class="panel-body">
                        <a href="../paginas/movimentoDocumento_guardar.jsp" class="btn btn-info" role="button">Novo</a>
                        <a href="../paginas/movimentoDocumento_listar.jsp" class="btn btn-info" role="button">Listar</a>
                    </div>
                </div> 
                <div class="panel panel-default">
                    <div class="panel-heading">Expediente</div>
                    <div class="panel-body">
                        <a href="../paginas/tipoExpediente_guardar.jsp" class="btn btn-info" role="button">Novo</a>
                        <a href="../paginas/tipoExpediente_listar.jsp" class="btn btn-info" role="button">Listar</a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Natureza Assunto</div>
                    <div class="panel-body">
                        <a href="../paginas/naturezaAssunto_guardar.jsp" class="btn btn-info" role="button">Nova</a>
                        <a href="../paginas/naturezaAssunto_listar.jsp" class="btn btn-info" role="button">Listar</a>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Geral</div>
                    <div class="panel-body">
                        <a href="../paginas/pais_listar.jsp" class="btn btn-info" role="button">Países</a>
                        <a href="../paginas/provincia_listar.jsp" class="btn btn-info" role="button">Provincias</a>
                        <a href="../paginas/municipio_listar.jsp" class="btn btn-info" role="button">Municipios</a>
                        <a href="#" class="btn btn-info" role="button">Profissôes</a>
                        <a href="../paginas/departamento_listar.jsp" class="btn btn-info" role="button">Departamentos</a>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
