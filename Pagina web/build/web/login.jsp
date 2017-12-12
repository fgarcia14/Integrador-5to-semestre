<%-- 
    Document   : login
    Created on : 05-nov-2017, 15:29:30
    Author     : chepoluis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="images/demo/gallery/help.png" type="gallery/help.png" rel="shortcut icon" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
        <script src="js/main.js" ></script>
        <link rel="stylesheet" href="css/login.css">
    </head>
    
    <body style="background-image:url('images/demo/gallery/udc05.jpg'); background-size: 1400px 700px;">
        
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="iniciar" method="post" id="formInicio">
                    <input type="text" name="usuario" id="txtUsuario" placeholder="Usuario"/>
                    <input type="password" name="pass" id="txtPass" placeholder="Contraseña"/>
                    <button value="Iniciar sesión" id="btnIniciar" >login</button>
                </form>
            </div>
        </div>    
        
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script  src="js/index.js"></script>
           
    </body>
</html>
