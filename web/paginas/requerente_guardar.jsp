<%-- 
    Document   : requerente_guardar
    Created on : 8-feb-2017, 1.07.27
    Author     : informatica
--%>
<%@page import="cheladocs.modelo.CategoriaJuridica"%>
<%@page import="java.util.List"%>
<%@page import="cheladocs.dao.CategoriaJuridicaDAO"%>
<%
    CategoriaJuridicaDAO categoriaJuridicaDao = new CategoriaJuridicaDAO();
    List<CategoriaJuridica> listaCategoriaJuridica = categoriaJuridicaDao.findAll();
    
    
%>
<!-- Inicio Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <form class="form-horizontal" role="form" action="../RequerenteServlet?comando=guardar" method="POST">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Registar Novo Requerente</h4>
                </div>
                <div>
                    <div class="modal-body">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#dados_pessoais" aria-controls="dados_pessoais" role="tab" data-toggle="tab">Dados Pessoais</a></li>
                            <li role="presentation"><a href="#contacto" aria-controls="contacto" role="tab" data-toggle="tab">Contacto</a></li>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="dados_pessoais">
                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Nome: </label>
                                    <div class="col-xs-8">
                                        <input type="text" class="form-control" name="nome_requerente" placeholder="Nome do Requerente" size="200" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Sobrenome: </label>
                                    <div class="col-xs-8">
                                        <input type="text" class="form-control" name="sobrenome_requerente" placeholder="Sobrenome do Requerente" size="200" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Data de Nascimento: </label>
                                    <div class="col-xs-5">
                                        <input type="date" class="form-control" name="data_nascimento"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Sexo: </label>
                                    <div class="col-xs-5">
                                        <label class="radio-inline"><input type="radio" name="sexo_requerente" value="Masculino">Masculino</label>
                                        <label class="radio-inline"><input type="radio" name="sexo_requerente" value="Feminino">Feminino</label>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Categoria Juridica: </label>
                                    <div class="col-xs-5">
                                        <input type="text" class="form-control" name="categoria_juridica" placeholder="Categoria Jurídica"/>
                                    </div>
                                </div>
                            </div>

                            <div role="tabpanel" class="tab-pane" id="contacto">
                                <div class="form-group">
                                    <label class="col-xs-3 control-label"> Telefone Principal: </label>
                                    <div class="col-xs-5">
                                        <input type="text" class="form-control" name="telefone_principal" placeholder="Nº de Telefone Principal"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Telefone alternativo: </label>
                                    <div class="col-xs-5">
                                        <input type="text" class="form-control" name="telefone_alternativo" placeholder="Nº de telefone alternativo"/>
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
                                    <label class="col-xs-3 control-label">Home Page: </label>
                                    <div class="col-xs-5">
                                        <input type="text" class="form-control" name="home_page" placeholder="Home Page"/>
                                    </div>
                                </div>
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
