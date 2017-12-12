<%-- 
    Document   : crearTicket
    Created on : 05-nov-2017, 15:37:55
    Author     : chepoluis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Código Java-->
<%
    HttpSession objSesion = request.getSession(false);
    String usuario = (String)objSesion.getAttribute("usuario");
    
    //Si la variable usuario esta vacia(no existe sesión), redirecciona al index
    if(usuario.equals("")){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="images/demo/gallery/help.png" type="gallery/help.png" rel="shortcut icon" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/crear-ticket.js"></script>
        <script type="text/javascript" src="js/date.js"></script>
                    <a href="menu.jsp">Menu principal</a>
        <title>Crear ticket</title>
        <link rel="stylesheet" href="css/formulario.css">
    </head>
    <body style="background-image:url('images/demo/gallery/udc06.jpg'); background-size: 1400px 700px;"> 
        <div class="container">  
            <form action="ticket" name="frmNuevo" method="post" id="frm_nuevoTicket">
                
                <h3>Nuevo ticket</h3>
            <input type="text" name="nombre" id="nombre" value="<% out.println(usuario); %>" hidden>       
            
            <fieldset>
                <input type="text" value="Domingo-26-Noviembre-2017 Hora: 8:54:37" name="fecha" id="fecha" tabindex="1" required autofocus readonly="readonly">
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
        
        <!--
        <form action="ticket" name="frmNuevo" method="post" id="frm_nuevoTicket">
            <table>
                
                <tr>
                    <td><label for=""></label></td>
                    <td><input type="text" name="nombre" id="nombre" value="<% out.println(usuario); %>" hidden></td>
                </tr> 
                
                <tr>
                    <td><label for="">Fecha:</label></td>
                    <td><input type="text" name="fecha" id="fecha" placeholder="yyyy-mm-dd"></td>
                </tr>
                
                <tr>
                    <td><label for="">Departamento:</label></td>
                    <td>
                        <select name="departamento" id="departamento">
                            <option value='opcion'>Seleccione una opcion</option>
                            <option value='programacion'>Programacion</option>
                            <option value='redes'>Redes</option>
                            
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td><label for="">Asunto:</label></td>
                    <td><input type="text" name="asunto" id="asunto"></td>
                </tr>
                
                <tr>
                    <td><label for="">Mensaje:</label></td>
                    <td><textarea cols="30" rows="6" name="mensaje" id="mensaje"></textarea></td>
                </tr>
                
                <tr>
                    <td><label for="">Contacto:</label></td>
                    <td><input type="text" name="contacto" id="contacto"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar ticket" id="btnEnviarTicket"></td>
                </tr>
                
            </table>
        </form>
        
        
        <form action="ticket" method="post">
           
            <label>Id Usuario</label>
            <input type="text" name="idusuario"/><br>
            
            <label>Fecha</label>
            <input type="date" name="fecha"><br>
            
            <label>Departamento</label>
            <input type="text" name="departamento"/><br>
            
            <label>Asunto</label>
            <input type="text" name="asunto"/><br>    
            
            <label>Mensaje</label>
            <input type="text" name="mensaje"/><br>
            
            <label>Contacto</label>
            <input type="text" name="contacto"/><br>    
            
            <label>Estado</label>
            <input type="text" name="estado"/><br>    
            
            <label>Especialista</label>
            <input type="text" name="especialista"/><br>    
            
            <label>Prioridad</label>
            <input type="text" name="prioridad"/><br>    
            
            <input type="submit" value="Enviar ticket"/>
        </form>
        -->
        
    </body>
</html>
