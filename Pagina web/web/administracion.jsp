<%-- 
    Document   : administracion
    Created on : 07-nov-2017, 22:58:37
    Author     : chepoluis
--%>

<%@page import="Controlador.ControladorTicket"%>
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
        <title>Administrar tickets</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/paneladministracion.js"></script>
    </head>
    <body style="background-image:url('images/demo/gallery/udc05.jpg'); background-size: 1400px 700px;">
        <h1 align="center" >Panel de administración de tickets</h1>
        <% ControladorTicket ct = new ControladorTicket();%>
        <%=ct.getPanelView(Integer.parseInt(usuario)) %>
        
        <br>
        <div><a href="crearTicket.jsp">Nuevo ticket</a></div>
        <a href="menu.jsp">Menu principal</a>
    </body>
</html>
