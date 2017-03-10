<%-- 
    Document   : documento_listar
    Created on : 8-feb-2017, 1.01.31
    Author     : informatica
--%>

<%@page import="cheladocs.modelo.*"%>
<%@page import="java.util.List"%>
<%@page import="cheladocs.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documentos</title>
        <title>Cheladocs -  Gestão de Documentos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery-1.12.3.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">

            
             <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
            
            

            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    
                    <h1 style="text-align: center">Gerir Requerente</h1>
                </div>

                <div id="conteudo">
                    <div id="top" class="row">
                        <!--<div class="col-md-3">
                            <h2>Itens</h2>
                        </div> -->

                        <div class="col-md-10">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Requerente">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <!-- Trigger the modal with a button -->
                            <button type="button" class="btn btn-primary pull-right h2" data-toggle="modal" data-target="#myModal">Novo Requente</button>
                        </div>
                    </div> 

                    <table id="minhaTabela" class="table table-hover table-responsive">
                        <thead>
                            <tr>
                                <th>Categoria:</th>
                                <th>Nome</th>
                                <th>Sobrenome</th>
                                <th>Sexo</th>
                                <th colspan="3">Operações</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>





                </div>

                <!-- Modal -->
                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <form class="form-horizontal" role="form" action="../RequerenteServlet?comando=guardar" method="POST" enctype="multipart/form-data">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Registar Novo Requerente</h4>
                                </div>
                                <div class="modal-body">


                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">Categoria Juridica: </label>
                                        <div class="col-xs-5">
                                            <select class="form-control" id="categoria_juridica" name="categoria_juridica">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">Nome: </label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="nome" placeholder="Nome do Requerente" size="200" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">Nome: </label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="nome" placeholder="Nome do Requerente" size="200" />
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">Sobrenome: </label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="sobrenome" placeholder="Sobrenome do Requerente" size="200" />
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-xs-3 control-label">Data de Nascimento: </label>
                                        <div class="col-xs-5">
                                            <input type="date" class="form-control" name="data_nascimento"/>
                                        </div>
                                    </div>
                                    
                                        <div class="form-group">
                                        <label class="col-xs-3 control-label">Municipio: </label>
                                        <div class="col-xs-5">
                                            <select class="form-control" id="municipio" name="municipio">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-xs-3 control-label"> Telefone Principal: </label>
                                        <div class="col-xs-5">
                                            <input type="text" class="form-control" name="telefone_principal" placeholder="Nº de Telefone Principal"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">Telefone alternativo: </label>
                                        <div class="col-xs-5">
                                            <input type="text" class="form-control" name="telefone_alternatico" placeholder="Nº de telefone alternativo"/>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-xs-3 control-label">Email principal: </label>
                                        <div class="col-xs-5">
                                            <input type="text" class="form-control" name="email_principal" placeholder="Email principal"/>
                                        </div>
                                    </div>
                                    
                                    
                                      <div class="form-group">
                                        <label class="col-xs-3 control-label">Email alternativo: </label>
                                        <div class="col-xs-5">
                                            <input type="text" class="form-control" name="email_alternativo" placeholder="Email principal"/>
                                        </div>
                                    </div>
                                    
                                    

                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">Sexo: </label>
                                        <div class="col-xs-5">
                                           <label class="radio-inline"><input type="radio" name="sexo">Option 1</label>
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

            </div>
        </div>
    </body>
</html>
