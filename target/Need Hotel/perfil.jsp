<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 30/06/2019
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Need Hotel</title>
        <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/perfil.css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body class="blue-grey darken-1">
        <c:import url="menu.jsp"></c:import>

        <div class="container white row center">
            <div class="col s12"
                 style="background-image: url(imagem/background.jpg);
                  height: 40%;
                   background-repeat: no-repeat;
                    background-size: cover;
                     background-position: center">

                <div class="col s4 offset-s4 row"
                     style="position: relative;
                            top: 5vw;">
                    <div class="col s12">
                        <img src="imagem/${usuarioLogado.fotoPerfil}"
                             class="circle responsive-img"
                             style="border-radius: 50%;
                             width: 100%;
                              height: 100%;">
                    </div>
                    <div class="col s12">
                        <span class="black-text name userNome">
                            <c:out value="${usuarioLogado.nome}"/>
                            <c:out value="${usuarioLogado.sobreNome}"/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="col s12 row" style="margin-top: 5vw;">
                <h4 class="left-align">Gerenciar Imóveis</h4>
                <div class="s12">
                    <%--         Adicionar atalhos para gerenciamento (ver, criar e editar)           --%>
                </div>
            </div>
        </div>
        <c:import url="rodape.jsp"></c:import>

        
    </body>
</html>
