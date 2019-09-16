<%--
  Created by IntelliJ IDEA.
  User: danielalves
  Date: 09/07/19
  Time: 21:25
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
    <link type="text/css" rel="stylesheet" href="css/busca.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body class="blue-grey darken-1">
    <c:import url="menu.jsp"></c:import>

    <div class="container white" style="border-radius: 10px; padding: 20px;">

    <%--        Elemento fixo ao centro do slide        --%>
    <form class="col s8 offset-s2 white row" action="buscar" id="formSearch">
        <input class="col s10" id="search" type="text" placeholder="Cidades, Hoteis, ..." name="search">
        <button href="#" id="btnSearch" name="action" class="col s2 btn-flat"><i class="Small material-icons black-text">search</i></button>
    </form>

    <c:if test="${empty imoveis}">
        <h5 class="center">Resultados</h5>
        <h2 class="center">Nenhum resultado encontrado...</h2>
    </c:if>

    <c:if test="${not empty imoveis}">
        <h5 class="center">Resultados</h5>
        <c:forEach items="${imoveis}" var="imovel">
            <div class="col s12 m7">
                <div class="card horizontal z-depth-4">
                    <div class="card-image">
                        <img src="imagem/${imovel.foto}" id="CardImage">
                    </div>
                    <div class="card-stacked">
                        <div class="card-content">
                            <h5 id="nomeImovel">${imovel.nome}</h5>
                            <p>${imovel.cidade}-${imovel.estado}</p>
                            <p>${imovel.rua}</p>
                            <p>Valor da Diária - R$:${imovel.valor}</p>
                        </div>
                        <div class="card-action">
                            <a href="perfilImovel?id=${imovel.id}" class="btn-floating waves-effect waves-light black" style="float: right"><i class="material-icons">navigate_next</i></a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
    </div>
    <c:import url="rodape.jsp"></c:import>

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="js/materialize.js"/>
<script src="js/materialize.min.js"></script>
</body>
</html>
