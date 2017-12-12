<%-- 
    Document   : registro
    Created on : 05-nov-2017, 11:20:46
    Author     : chepoluis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <script src="js/main.js" ></script>
        <link rel="stylesheet" href="css/login.css">
    </head>
    
    <body style="background-image:url('images/demo/gallery/udc05.jpg'); background-size: 1400px 700px;">
        
        <div class="login-page">
            <div class="form">
                <form action="nuevousuario" method="post">
                    <input type="text" name="idusuario" placeholder="Id Usuario"/><br>
                    <input type="password" name="pass" placeholder="Contraseña"/><br>
                    <input type="text" name="nombre" placeholder="Nombre"/><br>
                    <input type="text" name="correo" placeholder="Correo electronico"/><br>    
                    <select name="campus">
                    <option name="campus" selected>Seleccione su campus</option>
                    <option value="Campus_Colima">Campus Colima</option>
                    <option value="Campus_Villa">Campus Villa de Álvarez</option>
                    <option value="Campus_Colima">Campus Coquimatlán</option>
                    </select>
                    <br>
                    <br>
                    <select name="escuela">
                    <option name="escuela" selected>Seleccione su escuela</option>
                    <option value="BACHILLERATO #1">Bachillerato #1</option>
                    <option value="BACHILLERATO #2">Bachillerato #2</option>
                    <option value="BACHILLERATO #3">Bachillerato #3</option>
                    <option value="BACHILLERATO #4">Bachillerato #4</option>
                    <option value="BACHILLERATO #16">Bachillerato #16</option>
                    <option value="BACHILLERATO # 18">Bachillerato #18</option>
                    <option value="FACULTAD DE TELEMATICA">Facultad de telemática</option>
                    <option value="FACULTAD DE TURISMO">Facultad de turismo</option>
                    <option value="FACULTAD DE MEDICINA">Facultad de medicina</option>
                    <option value="FACULTAD DE ENFERMERIA">Facultad de enfermeria</option>
                    <option value="FACULTAD DE MERCADOTECNIA">Facultad de mercadotecnia</option>
                    <option value="FACULTAD DE PSICOLOGIA">Facultad de psicología</option>
                    </select>
                    <br>
                    <br>
                    <select name="tipousuario">
                    <option name="tipousuario" selected>Tipo de usuario</option>
                    <option value="Alumno">Alumno</option>
                    </select>
                    <br>
                    <br>
                    <button type="submit" value="Registrarme">Registrarme</button>
                    
                </form>
            </div>
        </div>    
        
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script  src="js/index.js"></script>
           
    </body>
    <!--
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Formulario de registro</h1>
        <form action="nuevousuario" method="post">
            
            <label>ID Usuario</label>
            <input type="text" name="idusuario"/><br>
            
            <label>Contraseña</label>
            <input type="password" name="pass"/><br>
            
            <label>Nombre</label>
            <input type="text" name="nombre"/><br>
            
            <label>Correo electronico</label>
            <input type="text" name="correo"/><br>    
            
            <label>Campus</label>
            <input type="text" name="campus"/><br>  
            
            <label>Tipo de usuario</label>
            <input type="text" name="tipousuario"/><br>  
            
            <label>Escuela</label>
            <input type="text" name="escuela"/><br>  
            
            <input type="submit" value="Registrarme"/>
            
        </form>
    </body>
    -->
</html>
