<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/login.css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <meta charset="UTF-8"/>
        <title>Need Hotel</title>
    </head>
    <body class="blue-grey darken-1">
        <main class="container center row">
            <div class="col s6 offset-s3 white" style="margin-top: 10%; padding: 15px; border-radius: 15px">
                <h3>Login</h3>
                <c:if test="${statusAutenticacao eq 'Erro'}">
                    <h6 id="erro" class="red-text"><i class="material-icons tiny">info</i>Email ou senha inválidos!</h6>
                </c:if>
                <form action="login" method="post">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">email</i>
                        <input id="lognome" type="email" class="validate" name="logEmail">
                        <label for="lognome">Email</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock</i>
                        <input id="logsenha" type="password" class="validate" name="logSenha" >
                        <label for="logsenha">Senha</label>
                    </div>
                    <button id="entrar" type="submited" name="action" class="btn waves-effect waves-teal btn-flat blue lighten-4">Entrar</button>
                </form>
                <label class="black-text center">Ainda não possui uma conta? <a href="cadastrar" id="register">Cadastre-se!</a></label>
            </div>
        </main>
        <c:import url="rodape.jsp"></c:import>


        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="js/materialize.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <script src="js/login.js"></script>
    </body>
</html>
