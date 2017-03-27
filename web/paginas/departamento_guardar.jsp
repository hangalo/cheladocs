<%-- 
    Document   : departamento_editar
    Created on : 8-feb-2017, 1.04.49
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title> Guardar Departamento </title>  
    </head>
    <body>
        <!-- Inicio Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <form class="form-horizontal" role="form" action="../DepartamentoServlet?comando=guardar" method="POST">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Registar Novo Departamento</h4>
                        </div>
                        <div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Departamento </label>
                                    <div class="col-xs-5">
                                        <input type="text" class="form-control" name="nome_departamento" placeholder="Nome do Departamento"/>
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
    </body>
</html>
