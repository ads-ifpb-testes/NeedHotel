<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 15/07/2019
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Need Hotel</title>
        <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/listarImoveis.css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body class="blue-grey darken-1 row">
        <c:import url="menu.jsp"></c:import>
        <div id="divMeusImoveis" class="container white">
            <h3>Meus Imóveis</h3>
            <div class="divider"></div>
            <div class="col 12 row white">
                <c:if test="${empty imoveis}">
                    <h5>Nenhum Imóvel Cadastro</h5>
                </c:if>
                <c:if test="${not empty imoveis}">
                    <c:forEach items="${imoveis}" var="imovel">
                        <div class="col s6 row">
                            <div class="col s12">
                                <div class="card horizontal">
                                    <div class="card-image">
                                        <img src="imagem/${imovel.foto}">
                                        <span class="card-title"><c:out value="${imovel.nome}" /></span>
                                    </div>
                                    <div class="card-stacked">
                                        <div class="card-content">
                                            <p><i class="material-icons black-text">location_on</i> <c:out value="${imovel.cidade}"/>, <c:out value="${imovel.estado}"/></p>
                                            <p><i class="material-icons black-text">attach_money</i> <c:out value="${imovel.valor}"/></p>
                                        </div>
                                        <div class="card-action">
                                            <a href="perfilImovel?id=${imovel.id}">Ver mais</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <c:import url="rodape.jsp"></c:import>
    </body>
</html>
