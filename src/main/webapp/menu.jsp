<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 30/06/2019
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Need Hotel</title>
    <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/home.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
    <body>

        <div style="position: absolute; z-index: 999;">
            <a href="#" data-target="slide-out" class="sidenav-trigger">
                <i class="medium material-icons white-text">menu</i>
            </a>
            <ul id="slide-out" class="sidenav">
                <li>
                    <div class="user-view">
                        <div class="background grey darken-3">
                            <img src="imagem/background.jpg">
                        </div>
                        <a href="#user"><img class="circle" src="imagem/${usuarioLogado.fotoPerfil}"></a>
                        <a href="#name"><span class="white-text name userNome">
                                    <c:out value="${usuarioLogado.nome}"/>
                                    <c:out value="${usuarioLogado.sobreNome}"/>
                                </span></a>
                        <a href="#email"><span class="white-text email"><c:out value="${usuarioLogado.email}"></c:out></span></a>
                    </div>
                </li>
                <li><a href="perfil.jsp" class="no-padding"><i class="material-icons black-text">account_circle</i>Perfil</a></li>

                <li>
                    <ul class="collapsible collapsible-accordion">
                        <li>
                            <a class="collapsible-header no-padding"><i class="material-icons black-text">location_city</i>Imóveis</a>
                            <div class="collapsible-body">
                                <ul>
                                    <li><a href="cadastroImovel.jsp?etapaForm=1"><i class="material-icons black-text">add_circle</i>Cadastrar Imóvel</a></li>
                                    <li><a href="meus-imoveis"><i class="material-icons black-text">view_module</i>Meus Imóveis</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </li>

                <li><a href="logout" class="no-padding"><i class="material-icons black-text">exit_to_app</i>Logout</a></li>
                <li><div class="divider"></div></li>
                <li><a href="home.jsp" class="no-padding"><i class="material-icons black-text">home</i>Home</a></li>
                <li><a href="#!" class="no-padding"><i class="material-icons black-text">info</i>Sobre</a></li>
            </ul>
        </div>

        <nav>
            <div class="nav-wrapper black">
                <a href="#" class="brand-logo center">Need Hotel</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down userNome">
                    <li><a href="#">Olá, <c:out value="${usuarioLogado.nome}"/> <c:out value="${usuarioLogado.sobreNome}"/></a></li>
                </ul>
            </div>
        </nav>

        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/materialize.js"/>
        <script src="js/materialize.min.js"></script>
        <script src="js/validacao.js"></script>
        <script>
            $(document).ready(function(){
                $('.sidenav').sidenav();
            });
        </script>
        <script>
            $(document).ready(function(){
                $('.collapsible').collapsible();
            });
        </script>
    </body>
</html>
