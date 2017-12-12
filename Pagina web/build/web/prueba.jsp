<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Código Java-->
<%
    HttpSession objSesion = request.getSession(false);
    String usuario = (String)objSesion.getAttribute("usuario");
    
    //Si la variable usuario esta vacia(no existe sesión), redirecciona al index
    if(usuario.equals("")){
        response.sendRedirect("index.jsp");
    }
    
    //Faltaria cerrar sesion
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/crear-ticket.js"></script>
        <script type="text/javascript" src="js/date.js"></script>
        <title>Crear ticket</title>
        <link rel="stylesheet" href="css/formulario.css">
    </head>
    <body style="background-image:url('images/demo/backgrounds/playa-colima.png');"> 
        <div class="container">  
            <form action="ticket" name="frmNuevo" method="post" id="frm_nuevoTicket">
                
                <h3>Nuevo ticket</h3>
            <input type="text" name="nombre" id="nombre" value="<% out.println(usuario); %>" hidden>       
            
            <fieldset>
                <input placeholder="yyyy-mm-dd" type="text" name="fecha" id="fecha" tabindex="1" required autofocus>
            </fieldset>
            
            <fieldset>
              
               <select name="departamento">
                    <option name="departamento" selected>Seleccione departamento</option>
                    <option value="Redes">Redes</option>
                    <option value="Hardware">Hardware</option>
                    <option value="Programacion">Programación</option>
                </select>
            </fieldset>
                
            <fieldset>
              <input placeholder="Asunto" type="text" name="asunto" id="asunto" tabindex="3" required>
            </fieldset>
                
            <fieldset>
              <textarea placeholder="Escriba aquí su mensaje..." name="mensaje" id="mensaje" tabindex="5" required></textarea>
            </fieldset>
                
            <fieldset>
              <button name="submit" type="submit" id="btnEnviarTicket" data-submit="...Sending">Enviar ticket</button>
            </fieldset>
               
            </form>
        </div>
    </body>
</html>    