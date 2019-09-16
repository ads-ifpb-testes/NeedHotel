<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 29/06/2019
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Need Hotel</title>
    <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/cadastroImovel.css" rel="stylesheet">
    <meta charset="UTF-8"/>
</head>
<body class="blue-grey darken-1">

    <div id="divCadastro" class="container white" >
        <h4>Cadastro</h4>
        <c:if test="${param.etapaForm eq '1'}">
            <h6>Dados Gerais</h6>
            <form class="center continer row" action="cadastrarImovel?etapaForm=1" method="post" onsubmit="return validaFormImovel(this);">

                <%--          Input nome do imovel          --%>
                <div class="input-field col s12">
                    <input required  value="${dadosEtapa1.nome}" name="nomeImovel" id="nomeImovel" class="validate inputs words" type="text" placeholder="Ex.: ED. Rozana Soares">
                    <label for="nomeImovel">Nome do Imóvel</label>
                </div>

                <%--          Input rua          --%>
                <div class="input-field col s12">
                    <input required value="${dadosEtapa1.rua}"name="ruaImovel" id="nomeRua" class="validate inputs words" type="text" placeholder="Ex.: rua Santa Cecilia">
                    <label for="nomeRua">Rua do Imóvel</label>
                </div>

                <%--          Input número do imovel          --%>
                <div class="input-field col s6">
                    <input required value="${dadosEtapa1.numero}" name="numeroImovel" id="numImovel" class="validate inputs numero" type="text" placeholder="Ex.: 123">
                    <label for="numImovel">Número</label>
                </div>

                <%--          Input CEP          --%>
                <div class="input-field col s6">
                    <input required value="${dadosEtapa1.cep}" name="cepImovel" id="cepImovel" class="validate inputs" type="text" placeholder="Ex.: 55555-333">
                    <label for="cepImovel">CEP</label>
                </div>

                <%--          Input bairro          --%>
                <div class="input-field col s12">
                    <input required value="${dadosEtapa1.bairro}"  name="bairroImovel" id="nomeBairro" class="validate inputs words" type="text" placeholder="Ex.: Centro">
                    <label for="nomeBairro">Bairro</label>
                </div>

                <%--          Input cidade          --%>
                <div class="input-field col s6">
                    <input required value="${dadosEtapa1.cidade}"  name="cidadeImovel" id="nomeCidades" class="validate inputs words" type="text" placeholder="Ex.: Cidadopólis">
                    <label for="nomeCidades">Cidade</label>
                </div>

                <%--          Input estado          --%>
                <div class="input-field col s6">
                    <select required name="estadoImovel" id="selectEstado" class="selects validate">
                        <option value="" disabled selected>Selecione seu estado</option>
                        <optgroup label="Centro-Oeste">
                            <option value="GO" <c:if test="${dadosEtapa1.estado eq 'GO'}">selected</c:if>>Goiais</option>
                            <option value="MT" <c:if test="${dadosEtapa1.estado eq 'MT'}">selected</c:if>>Mato Grosso</option>
                            <option value="MS" <c:if test="${dadosEtapa1.estado eq 'MS'}">selected</c:if>>Mato Grosso do Sul</option>
                        </optgroup>
                        <optgroup label="Nordeste">
                            <option value="AL" <c:if test="${dadosEtapa1.estado eq 'AL'}">selected</c:if>>Alagoas</option>
                            <option value="BA" <c:if test="${dadosEtapa1.estado eq 'BA'}">selected</c:if>>Bahia</option>
                            <option value="CE" <c:if test="${dadosEtapa1.estado eq 'CE'}">selected</c:if>>Ceará</option>
                            <option value="MA" <c:if test="${dadosEtapa1.estado eq 'MA'}">selected</c:if>>Maranhão</option>
                            <option value="PB" <c:if test="${dadosEtapa1.estado eq 'PB'}">selected</c:if>>Paraíba</option>
                            <option value="PE" <c:if test="${dadosEtapa1.estado eq 'PE'}">selected</c:if>>Pernambuco</option>
                            <option value="PI" <c:if test="${dadosEtapa1.estado eq 'PI'}">selected</c:if>>Piauí</option>
                            <option value="RN" <c:if test="${dadosEtapa1.estado eq 'RN'}">selected</c:if>>Rio Grande do Norte</option>
                            <option value="SE" <c:if test="${dadosEtapa1.estado eq 'SE'}">selected</c:if>>Sergipe</option>
                        </optgroup>
                        <optgroup label="Norte">
                            <option value="AC" <c:if test="${dadosEtapa1.estado eq 'AC'}">selected</c:if>>Acre</option>
                            <option value="AP" <c:if test="${dadosEtapa1.estado eq 'AP'}">selected</c:if>>Amapá</option>
                            <option value="AM" <c:if test="${dadosEtapa1.estado eq 'AM'}">selected</c:if>>Amazonas</option>
                            <option value="PA" <c:if test="${dadosEtapa1.estado eq 'PA'}">selected</c:if>>Pará</option>
                            <option value="RO" <c:if test="${dadosEtapa1.estado eq 'RO'}">selected</c:if>>Rondônia</option>
                            <option value="RR" <c:if test="${dadosEtapa1.estado eq 'RR'}">selected</c:if>>Roraima</option>
                            <option value="TO" <c:if test="${dadosEtapa1.estado eq 'TO'}">selected</c:if>>Tocantins</option>
                        </optgroup>
                        <optgroup label="Sudeste">
                            <option value="ES" <c:if test="${dadosEtapa1.estado eq 'ES'}">selected</c:if>>Espírito Santo</option>
                            <option value="MG" <c:if test="${dadosEtapa1.estado eq 'MG'}">selected</c:if>>Minas Gerais</option>
                            <option value="RJ" <c:if test="${dadosEtapa1.estado eq 'RJ'}">selected</c:if>>Rio de Janeiro</option>
                            <option value="SP" <c:if test="${dadosEtapa1.estado eq 'SP'}">selected</c:if>>São Paulo</option>
                        </optgroup>
                        <optgroup label="Sul">
                            <option value="PR" <c:if test="${dadosEtapa1.estado eq 'PR'}">selected</c:if>>Paraná</option>
                            <option value="RS" <c:if test="${dadosEtapa1.estado eq 'RS'}">selected</c:if>>Rio Grande do Sul</option>
                            <option value="SC" <c:if test="${dadosEtapa1.estado eq 'SC'}">selected</c:if>>Santa Catarina</option>
                        </optgroup>
                    </select>
                    <label for="selectEstado">Estados</label>
                </div>

                <%--          Input preço          --%>
                <div class="input-field col s12">
                    <input required value="${dadosEtapa1.valor}"  name="valorImovel" id="valorDiaria" class="validate inputs valor" type="text" placeholder="Ex.: 500,00">
                    <label for="valorDiaria">Diaria</label>
                </div>

                <div class="modal-footer center">
                    <a href="home.jsp" class="modal-close waves-effect waves-green btn-flat">Cancelar</a>
                    <button class="btn waves-effect waves-light" type="submit" name="action">Próximo</button>
                </div>

            </form>
        </c:if>
        <c:if test="${param.etapaForm eq '2'}">
            <h6>Comodidades</h6>
            <form class="center continer row" action="cadastrarImovel?etapaForm=2" method="post" enctype="multipart/form-data">

                    <%--         Select Comodidades          --%>
                <div class="input-field col s5">
                    <select multiple name="comidadesImovel">
                        <option value="" disabled selected>Escolha uma opção</option>
                        <option value="Aquecimento Central">Aquecimento Central</option>
                        <option value="Elevador">Elevador</option>
                        <option value="Wifi">Wifi</option>
                        <option value="TV">TV</option>
                        <option value="Cozinha">Cozinha</option>
                        <option value="Ar-Condiciondo">Ar-Condiciondo</option>
                    </select>
                    <label>Comodidades</label>
                </div>

                <div class="input-field col s12">
                    <textarea maxlength="500" required name="descricaoImovel" id="descricaoImovel" class="materialize-textarea" type="text"></textarea>
                    <label for="nomeImovel">Descrição do Imóvel</label>
                </div>

                    <%--          Input fotos            --%>
                <div class="file-field input-field col s12">
                    <div class="btn">
                        <span>Foto</span>
                        <input type="file" name="fotosImovel" accept="image/*">
                    </div>
                    <div class="file-path-wrapper">
                        <input required class="file-path validate" type="text" placeholder="Faça o upload das fotos do imóvel aqui">
                    </div>
                </div>
                <div class="modal-footer center col s12">
                    <a href="cadastrarImovel?voltar=2" class="modal-close waves-effect waves-green btn-flat">Voltar</a>
                    <button class="btn waves-effect waves-light" type="submit" name="action">Concluir</button>
                </div>

            </form>
        </c:if>
    </div>
    <c:import url="rodape.jsp"></c:import>

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="js/materialize.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
    <script src="js/jquery.mask.min.js"></script>
    <script src="js/validacao.js"></script>

    <script>
        $(document).ready(function(){
            $('select').formSelect();
        });
    </script>
</body>
</html>
