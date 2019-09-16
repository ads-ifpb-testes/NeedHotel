<%--
  Created by IntelliJ IDEA.
  User: danielalves
  Date: 13/07/19
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/perfilImovel.css">
</head>
<body>
    <c:import url="menu.jsp"></c:import>

    <div class="row">
        <div class="col s6">
            <div class="row">
                <h3 class="col s9">${imovel.nome}</h3>
                <span class="avatar col s3 center">
                    <img id="userImage" class="circle" src="imagem/${usuario.fotoPerfil}">
                    <br><label>${usuario.nome}</label>
                </span>
            </div>

            <div class="divider"></div>
            <div class="section">
                <h5>Descrição</h5>
                <p id="descricaoImovel">${imovel.descricao}</p>
            </div>
            <div class="divider"></div>
            <div class="section">
                <h5>Comodidades</h5>
                <ul class="collection">
                <c:forEach items="${imovel.comodidades}" var="comodidade">
                    <li class="collection-item">${comodidade}</li>
                </c:forEach>
                </ul>
            </div>
            <div class="divider"></div>
            <div class="section">
                <h5>Localização</h5>
                <p>Endereço: ${imovel.rua}, ${imovel.numero}</p>
                <p>Bairro: ${imovel.bairro}</p>
                <p>Cidade: ${imovel.cidade}-${imovel.estado} ${imovel.cep}</p>
            </div>
        </div>
        <div class="col s6" id="divImage">
            <img src="imagem/${imovel.foto}" id="imageImovel">
            <div class="container" id="divReserva">
                <span id="valorImovel">R$${imovel.valor}</span><label>/Dia</label>
                <div class="divider"></div>
                <label><p>Datas</p></label>
                <input type="text" id="checkin" class="datepicker col s5" placeholder="Check-in">
                <i class="material-icons col s2 center">navigate_next</i>
                <input type="text" id="checkout" class="datepicker col s5" placeholder="Check-out">
                <a class="waves-effect waves-light btn-large col s12">Reservar Imovel</a>
            </div>
        </div>
    </div>
    <c:import url="rodape.jsp"></c:import>



<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="js/materialize.min.js"></script>
<script src="js/perfilImovel.js"></script>
</body>
</html>