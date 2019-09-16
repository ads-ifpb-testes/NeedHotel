<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 28/05/2019
  Time: 23:31
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

        <c:import url="menu.jsp"></c:import>


        <div class="carousel carousel-slider center row">
            <div class="carousel-fixed-item center">

                <%--        Elemento fixo ao centro do slide        --%>
                <form class="col s8 offset-s2 white row" action="buscar" style="border-radius: 10px; height: 45px;">
                    <input class="col s10" id="search" type="text" placeholder="Cidades, Hoteis, ..." name="search">
                    <button name="action" class="col s2 btn-flat" style="height: 45px;"><i class="Small material-icons black-text">search</i></button>
                </form>

            </div>
            <a class="carousel-item">
                <img src="imagem/natal.jpg">
            </a>
            <a class="carousel-item">
                <img src="imagem/riodejaneiro.jpg">
            </a>
            <a class="carousel-item">
                <img src="imagem/curitiba.jpg">
            </a>
            <a class="carousel-item">
                <img src="imagem/recife.jpg">
            </a>
        </div>


        <%--    div dos slides do cabeçário    --%>

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
            $('.carousel.carousel-slider').carousel({
                fullWidth: true,
                indicators: true
            });
        </script>
        <c:import url="rodape.jsp"></c:import>

    </body>
</html>
