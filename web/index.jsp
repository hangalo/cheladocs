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
        <title>Cheladocs -  Gestão de Documentos</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.12.3.min.js"></script>
    </head>
    <body>

        <div class="jumbotron text-center">
            <img src="imagens/folderdocuments.png" alt="" width="300" height="200"/>

            <h1>FenixDocs</h1>
            <p>Sistema de Gestão expediente e documentos</p> 
        </div>

        <div class="container">
            <div class="row">

                <div class="col-sm-4">
                    <center>
                        <h3>Documentos</h3>
                        <a href="paginas/gerir_documento.jsp">
                            <img src="imagens/gestao_docs.png" alt="" width="140" height="120"/>
                        </a>
                    </center>
                </div>
                <div class="col-sm-4">
                    <center>
                        <h3>Expediente</h3>
                        <a href="paginas/gerir_tipoExpediente.jsp">
                            <img src="imagens/paper-plane.png" alt="" width="140" height="120"/>
                        </a>
                    </center>
                </div>

                <div class="col-sm-4">
                    <center>
                        <h3>Requerentes</h3> 
                        <a href="paginas/gerir_requente.jsp">
                            <img src="imagens/requerente.png" alt=""/>
                        </a>
                    </center>
                </div>
            </div>
        </div>
        <div class="jumbotron text-center">
            <h3>Administrator</h3>
            <a href="administracaosistema/administracao-sistema.jsp" class="btn btn-info" role="button">
                <img src="imagens/lock.png" alt="" width="30" height="30"/>
            </a>
        </div>
    </body>
</html>
